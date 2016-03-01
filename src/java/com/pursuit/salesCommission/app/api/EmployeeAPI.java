package com.pursuit.salesCommission.app.api;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pursuit.salesCommission.app.model.Employee;

/**
 * Class for database operations on Employee 
 * @author NEW2
 *
 */
@Component
public class EmployeeAPI {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger = Logger.getLogger(EmployeeAPI.class);

	public void setSessionFactory(SessionFactory factory) {
		sessionFactory = factory;
	}

	/**
	 * Method for Create an Employee in database
	 * This method is used to create new employee record in database table.
	 * 
	 * @param employee
	 *            the object that taking all parameters of employee from
	 *            controller
	 */
	public void createEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee1 = new Employee();
			employee1.setFirstName(employee.getFirstName());
			employee1.setLastName(employee.getLastName());
			employee1.setSalary(employee.getSalary());
			session.save(employee);
			tx.commit();
			logger.debug("CREATED AN EMPLOYEE INTO DATABASE" + employee);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	/**
	 * Method for getting employee by employeeId from database
	 * 
	 * @param EmployeeID
	 *            the Id of the employee for whom the details searching for
	 * @return the complete employee details of whom the Id has entered
	 */
	public Employee getEmployee(Integer EmployeeID) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		logger.debug("GET THE EMPLOYEE DETAILS FROM DATABASE");
		return (Employee) session.get(Employee.class, EmployeeID);
	}

	/**
	 * Method for getting list of employees in database
	 * 
	 * @return the complete employee details of all employees in database
	 */
	public List<Employee> listEmployees() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List employees = session.createQuery("FROM Employee").list();
		
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			logger.debug("GET THE EMPLOYEE DETAILS FROM DATABASE" +  employee.getFirstName()+ employee.getLastName() +employee.getSalary() );
			
		}
		return employees;
	}

	/**
	 * Method for delete an employee from database
	 * 
	 * @param EmployeeID
	 *            the Id of the employee whom to be delete
	 */
	public void deleteEmployee(Integer EmployeeID) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, EmployeeID);
			session.delete(employee);
			logger.debug("DELETE THE EMPLOYEE DETAILS FROM DATABASE" + employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * Method for edit an employee in database
	 * 
	 * @param employee
	 *            the Id of the employee for whom to be edit
	 */
	public void editEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee1 = (Employee) session.get(Employee.class, employee.getId());
			employee1.setId(employee.getId());
			employee1.setFirstName(employee.getFirstName());
			employee1.setLastName(employee.getLastName());
			employee1.setSalary(employee.getSalary());
			session.save(employee1);
			logger.debug("EDIT THE EMPLOYEE DETAILS FROM DATABASE" + employee1);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}