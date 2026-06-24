DECLARE
        CURSOR c_due_loans IS
            SELECT c.customer_name, l.loan_id, l.due_date, l.amount_due
            FROM loans l
            JOIN customers c ON l.customer_id = c.customer_id
            WHERE l.due_date BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE) + 30;
    BEGIN
        DBMS_OUTPUT.PUT_LINE('--- LOAN DUE DATE REMINDERS (NEXT 30 DAYS) ---');

        FOR r_loan IN c_due_loans LOOP
            DBMS_OUTPUT.PUT_LINE('Reminder: Customer "' || r_loan.customer_name ||
                                 '" has Loan ID: ' || r_loan.loan_id ||
                                 ' with an amount of $' || TO_CHAR(r_loan.amount_due, 'FM999,999.00') ||
                                 ' due on ' || TO_CHAR(r_loan.due_date, 'YYYY-MM-DD') || '.');
        END LOOP;
    END;
    /