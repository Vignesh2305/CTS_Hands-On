DECLARE
        CURSOR c_vip_candidates IS
            SELECT customer_id, customer_name
            FROM customers
            WHERE balance > 10000
              AND is_vip != 'Y';
    BEGIN
        FOR r_cust IN c_vip_candidates LOOP
            UPDATE customers
            SET is_vip = 'Y'
            WHERE customer_id = r_cust.customer_id;

            DBMS_OUTPUT.PUT_LINE('Customer ' || r_cust.customer_name || ' (ID: ' || r_cust.customer_id || ') promoted
  to VIP.');
        END LOOP;
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END;
    /