DECLARE
        CURSOR c_senior_loans IS
            SELECT l.loan_id, l.interest_rate, c.customer_name
            FROM loans l
            JOIN customers c ON l.customer_id = c.customer_id
            WHERE c.age > 60;
    BEGIN
        FOR r_loan IN c_senior_loans LOOP
            UPDATE loans
            SET interest_rate = interest_rate - 1
            WHERE loan_id = r_loan.loan_id;

            DBMS_OUTPUT.PUT_LINE('Applied 1% discount for Customer: ' || r_loan.customer_name || ' on Loan ID: ' ||
  r_loan.loan_id);
        END LOOP;
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END;
    /