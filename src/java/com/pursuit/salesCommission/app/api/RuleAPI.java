package com.pursuit.salesCommission.app.api;
import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pursuit.salesCommission.app.model.Employee;
import com.pursuit.salesCommission.app.model.Rule;

public class RuleAPI {
	private static SessionFactory factory;

	/* Method to CREATE an rule in the database */
	public Integer addRule(String ruleName, String description, String ruleType) {

		factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(Rule.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		Integer ruleID = null;
		try {
			tx = session.beginTransaction();
			Rule rule = new Rule();
			rule.setRuleName(ruleName);
			rule.setDescription(description);
			rule.setRuleType(ruleType);
			ruleID = (Integer) session.save(rule);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("hiii...." +ruleName);
		return ruleID;
		
	}
	
	public Rule getRule(Integer ruleID) {
		factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(Rule.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		return (Rule) session.get(Rule.class, ruleID);
		
	}

	/* Method to READ all the employees */
	/*public List<Employee> listEmployees() {
		factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.openSession();
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
	/*public Employee updateEmployee(Integer EmployeeID, int salary) {
		factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;

		tx = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, EmployeeID);
		employee.setSalary(salary);
		session.update(employee);
		return employee;

	}

	/* Method to DELETE an employee from the records */
	/*public void deleteEmployee(Integer EmployeeID) {
		factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.openSession();
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
		factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		return (Employee) session.get(Employee.class, EmployeeID);
	}
*/
	public void createRule(Rule rule) {

		factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(Rule.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Rule rule1 = new Rule();
			rule1.setRuleName(rule.getRuleName());
			rule.setDescription(rule.getDescription());
			rule1.setRuleType(rule.getRuleType());
			session.update(rule);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	/*public void editEmployee(Employee employee) {
		factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.openSession();
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

	}*/

	
	
	

}
