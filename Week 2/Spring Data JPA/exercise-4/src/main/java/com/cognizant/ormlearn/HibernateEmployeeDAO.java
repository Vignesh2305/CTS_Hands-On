// Hands on 4 begins at line 445 in the document

package com.cognizant.ormlearn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import com.cognizant.ormlearn.model.Employee;

public class HibernateEmployeeDAO {
    private SessionFactory factory;

    public HibernateEmployeeDAO(SessionFactory factory) {
        this.factory = factory;
    }

    /* Method to CREATE an employee in the database */
    public Integer addEmployee(Employee employee){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }
}
