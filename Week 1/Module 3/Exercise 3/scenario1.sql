CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
    BEGIN
        UPDATE accounts
        SET balance = balance * 1.01
        WHERE account_type = 'SAVINGS';
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            RAISE_APPLICATION_ERROR(-20001, 'Error: ' || SQLERRM);
    END ProcessMonthlyInterest;
    /