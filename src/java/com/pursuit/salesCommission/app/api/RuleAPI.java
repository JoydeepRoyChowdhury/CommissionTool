package com.pursuit.salesCommission.app.api;


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

	/**
	 * Method for creating rule in Database
	 * 
	 * @param rule
	 */
	public long createRule(Rule rule) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Rule newRule = new Rule();
		try {
			tx = session.beginTransaction();
			newRule.setRuleName(rule.getRuleName());
			newRule.setDescription(rule.getDescription());
			newRule.setRuleDetails(rule.getRuleDetails());
			newRule.setCompensationType(rule.getCompensationType());
			newRule.setFixedCompValue(rule.getFixedCompValue());
			newRule.setCompensationFormula(rule.getCompensationFormula());
			newRule.setCompensationParameter(rule.getCompensationParameter());
			if (rule.getRuleType().equals("c")) {
				newRule.setConnectionType(rule.getConnectionType());
				newRule.setRuleComposite(rule.getRuleComposite());
				newRule.setRuleType("Composite");
			} else if (rule.getRuleType().equals("s") && rule.getRuleSimple().getCalculationMode().equals("r")) {
				newRule.setRuleType("Simple");
				RuleSimple simpleRule = createSimpleRuleRank(rule.getRuleSimple());
				newRule.setRuleSimple(simpleRule);
			} else if (rule.getRuleType().equals("s") && rule.getRuleSimple().getCalculationMode().equals("i")) {
				newRule.setRuleType("Simple");
				RuleSimple simpleRule = createSimpleRuleIndivdual(rule.getRuleSimple());
				newRule.setRuleSimple(simpleRule);
			}

			session.save(newRule);
			session.flush();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return newRule.getId();
		
	}

	/**
	 * Private Method for Create rule simple individual
	 * 
	 * @param simpRule
	 * @return newRuleSimple
	 */
	private RuleSimple createSimpleRuleIndivdual(RuleSimple simpRule) {

		RuleSimple newRuleSimple = new RuleSimple();
		newRuleSimple.setCalculationMode("individual");
		newRuleSimple.setRuleParameter(simpRule.getRuleParameter());
		newRuleSimple.setFieldList(simpRule.getFieldList());
		newRuleSimple.setQualifyingClause(simpRule.getQualifyingClause());
		newRuleSimple.setAggregateFunctions(simpRule.getAggregateFunctions());

		return newRuleSimple;
	}

	/**
	 * Private Method for Create rule simple rank
	 * 
	 * @param simpRule
	 * @return newRuleSimple
	 */

	private RuleSimple createSimpleRuleRank(RuleSimple simpRule) {
		
		RuleSimple newRuleSimple = new RuleSimple();
		newRuleSimple.setCalculationMode("rank");
		newRuleSimple.setAggregateFunctions(simpRule.getAggregateFunctions());
		newRuleSimple.setFieldList(simpRule.getFieldList());
		newRuleSimple.setPopulationType(simpRule.getPopulationType());
		newRuleSimple.setPopulationUpto(simpRule.getPopulationUpto());
		newRuleSimple.setQualifyingClause(simpRule.getQualifyingClause());
		newRuleSimple.setRankCount(simpRule.getRankCount());
		newRuleSimple.setRankingType(simpRule.getRankingType());
		newRuleSimple.setRuleParameter(simpRule.getRuleParameter());
		
		return newRuleSimple;

	}

	/**
	 * Method for editing rule
	 * 
	 * @param rule
	 */
	public void editRule(Rule rule) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Rule newRule = (Rule) session.get(Rule.class, rule.getId());
			newRule.setRuleName(rule.getRuleName());
			newRule.setDescription(rule.getDescription());
			newRule.setRuleDetails(rule.getRuleDetails());
			newRule.setCompensationType(rule.getCompensationType());
			newRule.setFixedCompValue(rule.getFixedCompValue());
			newRule.setCompensationFormula(rule.getCompensationFormula());
			newRule.setCompensationParameter(rule.getCompensationParameter());
			if (rule.getRuleType().equals("Composite")) {
				newRule.setConnectionType(rule.getConnectionType());
				newRule.setRuleComposite(rule.getRuleComposite());
				newRule.setRuleType("Composite");
			} else if (rule.getRuleType().equals("Simple")
					&& rule.getRuleSimple().getCalculationMode().equals("rank")) {
				newRule.setRuleType("Simple");

				RuleSimple simp = editRuleSimpleRank(session, rule.getRuleSimple());
				newRule.setRuleSimple(simp);

			} else if (rule.getRuleType().equals("Simple")
					&& rule.getRuleSimple().getCalculationMode().equals("individual")) {
				newRule.setRuleType("Simple");

				RuleSimple simp = editRuleSimpleIndividual(session, rule.getRuleSimple());
				newRule.setRuleSimple(simp);

			}

			session.merge(newRule);
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
 * Private method for edit simple rule with rank
 * @param session
 * @param simpRule
 * @return newsimp
 */
	private RuleSimple editRuleSimpleRank(Session session, RuleSimple simpRule) {
		RuleSimple newsimp = new RuleSimple();
		newsimp = (RuleSimple) session.get(RuleSimple.class, simpRule.getId());
		newsimp.setCalculationMode("rank");
		newsimp.setPopulationType(simpRule.getPopulationType());
		newsimp.setPopulationUpto(simpRule.getPopulationUpto());
		newsimp.setRankCount(simpRule.getRankCount());
		newsimp.setRankingType(simpRule.getRankingType());
		newsimp.setRuleParameter(simpRule.getRuleParameter());
		newsimp.setFieldList(simpRule.getFieldList());
		newsimp.setQualifyingClause(simpRule.getQualifyingClause());
		newsimp.setAggregateFunctions(simpRule.getAggregateFunctions());

		session.merge(newsimp);

		return newsimp;
	}
/**
 * Private method for edit simple rule with individual
 * @param session
 * @param simpRule
 * @return newsimp
 */
	private RuleSimple editRuleSimpleIndividual(Session session, RuleSimple simpRule) {

		RuleSimple newsimp = new RuleSimple();

		newsimp = (RuleSimple) session.get(RuleSimple.class, simpRule.getId());
		newsimp.setCalculationMode("individual");
		newsimp.setRuleParameter(simpRule.getRuleParameter());
		newsimp.setFieldList(simpRule.getFieldList());
		newsimp.setQualifyingClause(simpRule.getQualifyingClause());
		newsimp.setAggregateFunctions(simpRule.getAggregateFunctions());

		session.merge(newsimp);

		return newsimp;
	}

	/**
	 * Method for getting list of rules
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

	/**
	 * Method for getting one rule details by ID
	 * 
	 * @param ruleID
	 * @return
	 */
	public Rule getRule(long ruleID) {
		Rule newRule = new Rule();

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			newRule = (Rule) session.get(Rule.class, ruleID);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newRule;
	}

	/**
	 * Method for delete rule
	 * 
	 * @param ruleID
	 */
	public void deleteRule(long ruleID) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Rule rule = (Rule) session.get(Rule.class, ruleID);
			session.delete(rule);
			logger.debug("DELETE THE RULE DETAILS FROM DATABASE" + rule);
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