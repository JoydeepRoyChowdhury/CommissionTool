package com.simpsoft.salesCommission.app.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simpsoft.salesCommission.app.model.Employee;

/**
 * Class for database operations on Employee
 * 
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
	 * Method for Create an Employee in database This method is used to create
	 * new employee record in database table.
	 * 
	 * @param employee
	 *            the object that taking all parameters of employee from
	 *            controller
	 */
	public long createEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Employee emp = new Employee();
		try {
			tx = session.beginTransaction();
			emp.setEmployeeName(employee.getEmployeeName());
			emp.setStartDate(employee.getStartDate());
			emp.setTerminationDate(employee.getTerminationDate());
			emp.setEmployeeManagerMap(employee.getEmployeeManagerMap());
			emp.setEmployeeRoleMap(employee.getEmployeeRoleMap());
			emp.setTarget(employee.getTarget());
			emp.setSalary(employee.getSalary());
			session.save(emp);
			tx.commit();
			logger.debug("CREATED AN EMPLOYEE INTO DATABASE" + emp);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return emp.getId();
	}

	/**
	 * Method for getting employee by employeeId from database
	 * 
	 * @param employeeID
	 *            the Id of the employee for whom the details searching for
	 * @return the complete employee details of whom the Id has entered
	 */
	public Employee getEmployee(long employeeID) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		logger.debug("GET THE EMPLOYEE DETAILS FROM DATABASE");
		return (Employee) session.get(Employee.class, employeeID);
	}

	/**
	 * Method for getting list of employees from database
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
			// logger.debug("GET THE EMPLOYEE DETAILS FROM DATABASE" +
			// employee.getFirstName()+ employee.getLastName()
			// +employee.getSalary() );

		}
		return employees;
	}
	/**
	 * Method for getting list of employees from database search by employee name 
	 * 
	 * @return the complete employee details of all employees in database
	 */
	public List<Employee> searchEmployeesByName(String employeeName) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List employees = session.createQuery("FROM Employee").list();
		List empList = new ArrayList<>();
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			
			Employee employee = (Employee) iterator.next();
			if(employeeName.equals(employee.getEmployeeName())){
				empList.add(employee);
			}  
			// logger.debug("GET THE EMPLOYEE DETAILS FROM DATABASE" +
			// employee.getFirstName()+ employee.getLastName()
			// +employee.getSalary() );

		}
		return empList;
	}
	/**
	 * Method for search one employee by name
	 * @param empName
	 * @return
	 */
/*	public Employee searchEmployee1(String empName) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Employee employee = new Employee();
		try {
		tx = session.beginTransaction();
		List fields = session.createQuery("FROM Employee").list();
		for (Iterator iterator = fields.iterator(); iterator.hasNext();) {

			Employee emp = (Employee) iterator.next();
			if (empName.equals(emp.getEmployeeName())) {
				employee = emp;

			}

		}
		tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employee;
	} */
	
	public Employee searchEmployee(String empName) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Employee> empList = new ArrayList<>();
		try {
		tx = session.beginTransaction();
		Criteria crit = session.createCriteria(Employee.class);
		crit.add(Restrictions.eq("employeeName", empName));
		empList = crit.list();
				tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return empList.get(0);
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
			// employee1.setFirstName(employee.getFirstName());
			// employee1.setLastName(employee.getLastName());
			// employee1.setSalary(employee.getSalary());
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