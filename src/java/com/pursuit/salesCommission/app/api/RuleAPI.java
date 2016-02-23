package com.pursuit.salesCommission.app.api;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.pursuit.salesCommission.app.model.Rule;

public class RuleAPI {
	private static SessionFactory factory;

	/* Method to CREATE an rule in the database */
	public Integer addRule(String RuleName, String Description, String RuleType) {

		factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(Rule.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		Integer ruleID = null;
		try {
			tx = session.beginTransaction();
			Rule rule = new Rule(); 
			rule.setRuleName(RuleName);
			rule.setDescription(Description);
			rule.setRuleType(RuleType);
			/*rule.setRulesConnectedas(RulesConnectedas);
			rule.setListofRules(ListofRules);*/
			ruleID = (Integer) session.save(rule);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		//System.out.println("hiii...." +ruleName);
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

	/* Method to UPDATE Rule for Rule Details */
	/*public Rule updateRule(Integer RuleID, String RuleType) {
		factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(Rule.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;

		tx = session.beginTransaction();
		Rule rul = (Rule) session.get(Rule.class, RuleID);
		rul.setRuleType(RuleType);
		session.update(rul);
		return rul;

	}*/

	/* Method to DELETE an Rule from the records */
	public void deleteRule(Integer RuleID) {
		factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(Rule.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Rule rul = (Rule) session.get(Rule.class, RuleID);
			session.delete(rul);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

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
			/*rule1.setRulesConnectedas(rule.getRulesConnectedas());
			rule1.setListofRules(rule.getListofRules());*/
			
			session.save(rule);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	public void editRule(Rule rul) {
		factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(Rule.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
		tx = session.beginTransaction();
		Rule rul1 = (Rule) session.get(Rule.class, rul.getId());
		rul1.setId(rul.getId());
		rul1.setRuleName(rul.getRuleName());
		rul1.setDescription(rul.getDescription());
		rul1.setRuleType(rul.getRuleType());
		session.update(rul1);
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
