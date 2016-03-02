package com.pursuit.salesCommission.app.api;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.pursuit.salesCommission.app.model.Rule;

@Component
public class RuleAPI {

	@Autowired
	private static SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory factory) {
		sessionFactory = factory;
	}

	/* ...............Add rule in Database.................... */

	public int addRule(String rulename, String description, String ruleType) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer ruleID = null;
		try {
			tx = session.beginTransaction();
			Rule rule1 = new Rule();
			rule1.setRuleName(rulename);
			rule1.setDescription(description);
			rule1.setRuleType(ruleType);
			ruleID = (int) session.save(rule1);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("Hello........" + rulename + " " + description + " " + ruleType);
		return ruleID;

	}

	/* ........getRule...... */

	public Rule getRule(Integer RuleID) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		return (Rule) session.get(Rule.class, RuleID);
	}

	/* .............create role............. */

	public void createRule(Rule rule) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Rule rule2 = new Rule();
			rule2.setRuleName(rule.getRuleName());
			rule2.setDescription(rule.getDescription());
			rule2.setRuleType(rule.getRuleType());
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

	/* Method to READ all rule */
	public List<Rule> listRules() {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List rules = session.createQuery("FROM Rule").list();
		for (Iterator iterator = rules.iterator(); iterator.hasNext();) {
			Rule rule = (Rule) iterator.next();
			System.out.print("RuleName: " + rule.getRuleName());
			System.out.print("  Description: " + rule.getDescription());
			System.out.println("  RuleType: " + rule.getRuleType());
		}
		return rules;
	}

	/* ............. delete rule........ */

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

	public void editRule(Rule rule) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Rule rule1 = (Rule) session.get(Rule.class, rule.getId());
			rule1.setId(rule.getId());
			rule1.setRuleName(rule.getRuleName());
			rule1.setDescription(rule.getDescription());
			rule1.setRuleType(rule.getRuleType());
			session.save(rule1);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

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