CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
        p_dept_id IN NUMBER,
        p_bonus_percentage IN NUMBER
    ) AS
    BEGIN
        IF p_bonus_percentage IS NULL OR p_bonus_percentage < 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Invalid bonus percentage.');
        END IF;

        UPDATE employees
        SET salary = salary + (salary * (p_bonus_percentage / 100))
        WHERE department_id = p_dept_id;
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            RAISE_APPLICATION_ERROR(-20003, 'Error: ' || SQLERRM);
    END UpdateEmployeeBonus;
    /