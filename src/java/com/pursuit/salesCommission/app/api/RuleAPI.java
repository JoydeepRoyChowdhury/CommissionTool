package com.pursuit.salesCommission.app.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.pursuit.salesCommission.app.model.Rule;
import com.pursuit.salesCommission.app.model.RuleSimple;

@Component
public class RuleAPI {

	@Autowired
	private static SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(RuleAPI.class);

	public void setSessionFactory(SessionFactory factory) {
		sessionFactory = factory;
	}

	public Rule getRule(long l) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		return (Rule) session.get(Rule.class, l);
	}

	/**
	 * 
	 * @param rule
	 */
/*	public void createRule1(Rule rule) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Rule rule2 = new Rule();
			rule2.setRuleName(rule.getRuleName());
			rule2.setDescription(rule.getDescription());
			// rule2.setRuleType(rule.getRuleType());
			// ArrayList<Employee> emplist1 = rule.getEmployees();
			// rule2.setEmployees(emplist1);
			session.save(rule2);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	} */
	/**
	 * Method for create simple rule
	 * @param rule
	 */
	public void createRule(RuleSimple ruleSimple) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			RuleSimple ruleSmpl = new RuleSimple();
			ruleSmpl.setRule(ruleSimple.getRule());
			ruleSmpl.setCalculationMode(ruleSimple.getCalculationMode());
			ruleSmpl.setRankCount(ruleSimple.getRankCount());
			ruleSmpl.setRankingType(ruleSimple.getRankingType());
			ruleSmpl.setPopulationType(ruleSimple.getPopulationType());
			ruleSmpl.setPopulationUpto(ruleSimple.getPopulationUpto());
			ruleSmpl.setCompensationType(ruleSimple.getCompensationType());
			ruleSmpl.setFixedCompValue(ruleSimple.getFixedCompValue());
			session.save(ruleSmpl);
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
	 * Method for getting list of roles for rule
	 * 
	 * @return
	 */
	public List<Rule> listRules() {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List rules = session.createQuery("FROM Rule").list();
		for (Iterator iterator = rules.iterator(); iterator.hasNext();) {
			Rule rule = (Rule) iterator.next();
			logger.debug("GET THE RULE DETAILS FROM DATABASE" + rule.getRuleName() + rule.getRuleDetails()
					+ rule.getRuleType());

		}
		return rules;
	}

}