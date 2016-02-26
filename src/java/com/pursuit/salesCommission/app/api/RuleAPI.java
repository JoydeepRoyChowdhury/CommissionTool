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
import com.pursuit.salesCommission.app.model.Rule;

@Component
public class RuleAPI {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory factory) {
		sessionFactory = factory;
	}
	/* Method to CREATE an rule in the database */
	public Integer addRule(String RuleName, String Description, String RuleType) {

		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer ruleID = null;
		try {
			tx = session.beginTransaction();
			Rule rule = new Rule();
			rule.setRuleName(RuleName);
			rule.setDescription(Description);
			rule.setRuleType(RuleType);
			/*
			 * rule.setRulesConnectedas(RulesConnectedas);
			 * rule.setListofRules(ListofRules);
			 */
			ruleID = (Integer) session.save(rule);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		// System.out.println("hiii...." +ruleName);
		return ruleID;

	}

	public Rule getRule(Integer ruleID) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		return (Rule) session.get(Rule.class, ruleID);

	}

	/* Method to DELETE an Rule from the records */
	public void deleteRule(Integer RuleID) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Rule rule = (Rule) session.get(Rule.class, RuleID);
			session.delete(rule);
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
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Rule rule1 = new Rule();
			rule1.setRuleName(rule.getRuleName());
			rule1.setDescription(rule.getDescription());
			rule1.setRuleType(rule.getRuleType());
			/*
			 * rule1.setRulesConnectedas(rule.getRulesConnectedas());
			 * rule1.setListofRules(rule.getListofRules());
			 */

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

	public void editRule(Rule rule) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Rule rul1 = (Rule) session.get(Rule.class, rule.getId());
			rul1.setId(rule.getId());
			rul1.setRuleName(rule.getRuleName());
			rul1.setDescription(rule.getDescription());
			rul1.setRuleType(rule.getRuleType());
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

	public List<Rule> listRules() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List rules = session.createQuery("FROM Rule").list();
		for (Iterator iterator = rules.iterator(); iterator.hasNext();) {
			Rule rule = (Rule) iterator.next();
			System.out.println("RuleName: " + rule.getRuleName());
			System.out.println("Description: " + rule.getDescription());
			System.out.println("RuleType: " + rule.getRuleType());
			System.out.println("........... working..........");
		}
		return rules;
	}
	
	/* Method to UPDATE Rule */
	public Rule updateRule(Integer RuleID, String RuleName) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		tx = session.beginTransaction();
		Rule rul = (Rule) session.get(Rule.class, RuleID);
		rul.setRuleName(RuleName);
		session.update(rul);
		return rul;

}

}