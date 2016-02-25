package com.pursuit.salesCommission.app.api;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pursuit.salesCommission.app.model.Employee;

@Component
public class EmployeeAPI {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory factory) {
		sessionFactory = factory;
	}

	/* Method to CREATE an employee in the database */
	public Integer addEmployee(String fname, String lname, int salary) {

		Session session = sessionFactory.openSession();
		Integer employeeID = null;
		Transaction tx = null;
		try {
			tx  = session.beginTransaction();
			Employee employee = new Employee();
			employee.setFirstName(fname);
			employee.setLastName(lname);
			employee.setSalary(salary);
			employeeID = (Integer) session.save(employee);
			 tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeID;
	}

	/* Method to READ all the employees */
	public List<Employee> listEmployees() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List employees = session.createQuery("FROM Employee").list();
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.print("First Name: " + employee.getFirstName());
			System.out.print("  Last Name: " + employee.getLastName());
			System.out.println("  Salary: " + employee.getSalary());
		}
		return employees;
	}

	/* Method to UPDATE salary for an employee */
	public Employee updateEmployee(Integer EmployeeID, int salary) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		tx = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, EmployeeID);
		employee.setSalary(salary);
		session.update(employee);
		return employee;

	}

	/* Method to DELETE an employee from the records */
	public void deleteEmployee(Integer EmployeeID) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, EmployeeID);
			session.delete(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public Employee getEmployee(Integer EmployeeID) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		return (Employee) session.get(Employee.class, EmployeeID);
	}

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
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
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