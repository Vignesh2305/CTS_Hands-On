CREATE OR REPLACE PROCEDURE TransferFunds(
        p_source_acc_id IN NUMBER,
        p_dest_acc_id IN NUMBER,
        p_amount IN NUMBER
    ) AS
        v_source_balance NUMBER;
    BEGIN
        IF p_amount <= 0 OR p_source_acc_id = p_dest_acc_id THEN
            RAISE_APPLICATION_ERROR(-20004, 'Invalid inputs.');
        END IF;

        -- Lock row and fetch balance
        SELECT balance INTO v_source_balance
        FROM accounts WHERE account_id = p_source_acc_id FOR UPDATE;

        IF v_source_balance < p_amount THEN
            RAISE_APPLICATION_ERROR(-20006, 'Insufficient balance.');
        END IF;

        UPDATE accounts SET balance = balance - p_amount WHERE account_id = p_source_acc_id;
        UPDATE accounts SET balance = balance + p_amount WHERE account_id = p_dest_acc_id;
        COMMIT;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            ROLLBACK;
            RAISE_APPLICATION_ERROR(-20007, 'Account does not exist.');
        WHEN OTHERS THEN
            ROLLBACK;
            RAISE_APPLICATION_ERROR(-20008, 'Transfer failed: ' || SQLERRM);
    END TransferFunds;
    /