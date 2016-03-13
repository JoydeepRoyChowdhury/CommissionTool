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

import com.pursuit.salesCommission.app.model.Employee;
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
		RuleSimple newRuleSimple = new RuleSimple();
		try {
			tx = session.beginTransaction();
			if (rule.getId() == 0) {
				newRule.setRuleName(rule.getRuleName());
				newRule.setDescription(rule.getDescription());
				newRule.setRuleDetails(rule.getRuleDetails());
				newRule.setCompensationType(rule.getCompensationType());
				newRule.setFixedCompValue(rule.getFixedCompValue());
				newRule.setCompensationFormula(rule.getCompensationFormula());
				newRule.setCompensationParameter(rule.getCompensationParameter());
				if (rule.getRuleType() == "c") {
					newRule.setConnectionType(rule.getConnectionType());
					newRule.setRuleComposite(rule.getRuleComposite());
					newRule.setRuleType("Composite");
				} else if (rule.getRuleType() == "s" && rule.getRuleSimple().getCalculationMode() == "r") {

					newRule.setRuleType("Simple");
					newRuleSimple.setCalculationMode("Rank");
					newRuleSimple.setAggregateFunctions(rule.getRuleSimple().getAggregateFunctions());
					newRuleSimple.setFieldList(rule.getRuleSimple().getFieldList());
					newRuleSimple.setPopulationType(rule.getRuleSimple().getPopulationType());
					newRuleSimple.setPopulationUpto(rule.getRuleSimple().getPopulationUpto());
					newRuleSimple.setQualifyingClause(rule.getRuleSimple().getQualifyingClause());
					newRuleSimple.setRankCount(rule.getRuleSimple().getRankCount());
					newRuleSimple.setRankingType(rule.getRuleSimple().getRankingType());
					newRuleSimple.setRuleParameter(rule.getRuleSimple().getRuleParameter());
					newRule.setRuleSimple(newRuleSimple);

				} else if (rule.getRuleType() == "s" && rule.getRuleSimple().getCalculationMode() == "i") {
					newRule.setRuleType("Simple");
					newRuleSimple.setCalculationMode("Individual");
					newRuleSimple.setAggregateFunctions(rule.getRuleSimple().getAggregateFunctions());
					newRuleSimple.setFieldList(rule.getRuleSimple().getFieldList());
					newRuleSimple.setPopulationType(rule.getRuleSimple().getPopulationType());
					newRuleSimple.setPopulationUpto(rule.getRuleSimple().getPopulationUpto());
					newRuleSimple.setQualifyingClause(rule.getRuleSimple().getQualifyingClause());
					newRuleSimple.setRankCount(rule.getRuleSimple().getRankCount());
					newRuleSimple.setRankingType(rule.getRuleSimple().getRankingType());
					newRuleSimple.setRuleParameter(rule.getRuleSimple().getRuleParameter());
					newRule.setRuleSimple(newRuleSimple);
				}
			} else {
				newRule.setId(rule.getId());
				newRule.setRuleName(rule.getRuleName());
				newRule.setDescription(rule.getDescription());
				newRule.setRuleDetails(rule.getRuleDetails());
				newRule.setCompensationType(rule.getCompensationType());
				newRule.setFixedCompValue(rule.getFixedCompValue());
				newRule.setCompensationFormula(rule.getCompensationFormula());
				newRule.setCompensationParameter(rule.getCompensationParameter());
				if (rule.getRuleType() == "c") {
					newRule.setConnectionType(rule.getConnectionType());
					newRule.setRuleComposite(rule.getRuleComposite());
					newRule.setRuleType("Composite");
				} else if (rule.getRuleType() == "s" && rule.getRuleSimple().getCalculationMode() == "r") {

					newRule.setRuleType("Simple");
					newRuleSimple.setCalculationMode("Rank");
					newRuleSimple.setAggregateFunctions(rule.getRuleSimple().getAggregateFunctions());
					newRuleSimple.setFieldList(rule.getRuleSimple().getFieldList());
					newRuleSimple.setPopulationType(rule.getRuleSimple().getPopulationType());
					newRuleSimple.setPopulationUpto(rule.getRuleSimple().getPopulationUpto());
					newRuleSimple.setQualifyingClause(rule.getRuleSimple().getQualifyingClause());
					newRuleSimple.setRankCount(rule.getRuleSimple().getRankCount());
					newRuleSimple.setRankingType(rule.getRuleSimple().getRankingType());
					newRuleSimple.setRuleParameter(rule.getRuleSimple().getRuleParameter());
					newRule.setRuleSimple(newRuleSimple);

				} else if (rule.getRuleType() == "s" && rule.getRuleSimple().getCalculationMode() == "i") {
					newRule.setRuleType("Simple");
					newRuleSimple.setCalculationMode("Individual");
					newRuleSimple.setAggregateFunctions(rule.getRuleSimple().getAggregateFunctions());
					newRuleSimple.setFieldList(rule.getRuleSimple().getFieldList());
					newRuleSimple.setPopulationType(rule.getRuleSimple().getPopulationType());
					newRuleSimple.setPopulationUpto(rule.getRuleSimple().getPopulationUpto());
					newRuleSimple.setQualifyingClause(rule.getRuleSimple().getQualifyingClause());
					newRuleSimple.setRankCount(rule.getRuleSimple().getRankCount());
					newRuleSimple.setRankingType(rule.getRuleSimple().getRankingType());
					newRuleSimple.setRuleParameter(rule.getRuleSimple().getRuleParameter());
					newRule.setRuleSimple(newRuleSimple);
				}
			}
			session.save(newRule);
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
	 * @param l
	 * @return
	 */
	public Rule getRule(long ruleID) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		return (Rule) session.get(Rule.class, ruleID);
	}
/**
 * 
 * @param ruleID
 */
	public void deleteRule(Integer ruleID) {
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