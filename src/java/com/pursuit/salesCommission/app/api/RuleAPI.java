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

import com.pursuit.salesCommission.app.model.Employee;
import com.pursuit.salesCommission.app.model.QualifyingClause;
import com.pursuit.salesCommission.app.model.Rule;
import com.pursuit.salesCommission.app.model.RuleParameter;
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
			//if (rule.getId() == 0) 
			//{
				newRule.setRuleName(rule.getRuleName());
				newRule.setDescription(rule.getDescription());
				newRule.setRuleDetails(rule.getRuleDetails());
				newRule.setCompensationType(rule.getCompensationType());
				newRule.setFixedCompValue(rule.getFixedCompValue());
				newRule.setCompensationFormula(rule.getCompensationFormula());
				newRule.setCompensationParameter(rule.getCompensationParameter());
				if (rule.getRuleType().equals("c")) 
				{
					newRule.setConnectionType(rule.getConnectionType());
					newRule.setRuleComposite(rule.getRuleComposite());
					newRule.setRuleType("Composite");
				} else if (rule.getRuleType().equals("s") && rule.getRuleSimple().getCalculationMode().equals("r")) 
				{

					newRule.setRuleType("Simple");
					RuleSimple simpleRule = createSimpleRuleRank(rule.getRuleSimple());
					newRule.setRuleSimple(simpleRule);
				} else if (rule.getRuleType().equals("s") && rule.getRuleSimple().getCalculationMode().equals("i")) 
				{
					newRule.setRuleType("Simple");
					RuleSimple simpleRule = createSimpleRuleIndivdual(rule.getRuleSimple());
					newRule.setRuleSimple(simpleRule);
				}
				else if (rule.getRuleType().equals("s")) 
				{
					newRule.setRuleType("Simple");
					RuleSimple simpleRule = createSimpleRuleIndivdual(rule.getRuleSimple());
					newRule.setRuleSimple(simpleRule);
				}
		
			session.saveOrUpdate(newRule);
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
	 * Method for Create rule simple individual
	 * 
	 * @param simpRule
	 * @return
	 */
/*	private RuleSimple createSimpleRuleIndivdual(RuleSimple simpRule) {
		RuleSimple newRuleSimple = new RuleSimple();
		newRuleSimple.setCalculationMode("individual");
		newRuleSimple.setRuleParameter(simpRule.getRuleParameter());
		List<RuleParameter> rparam = simpRule.getRuleParameter();
		for (Iterator iterator = rparam.iterator(); iterator.hasNext();) {
			RuleParameter rparam1 = (RuleParameter) iterator.next();
			newRuleSimple.getRuleParameter().add(rparam1);
			}  
		
		newRuleSimple.setAggregateFunctions(simpRule.getAggregateFunctions());
		newRuleSimple.setFieldList(simpRule.getFieldList());
		newRuleSimple.setQualifyingClause(simpRule.getQualifyingClause());

		return newRuleSimple;
	} */
	private RuleSimple createSimpleRuleIndivdual(RuleSimple simpRule) {
		RuleSimple newRuleSimple = new RuleSimple();
		newRuleSimple.setCalculationMode("individual");
		newRuleSimple.setRuleParameter(simpRule.getRuleParameter());
		newRuleSimple.setAggregateFunctions(simpRule.getAggregateFunctions());
		newRuleSimple.setFieldList(simpRule.getFieldList());
		newRuleSimple.setQualifyingClause(simpRule.getQualifyingClause());

		return newRuleSimple;
	}

	/**
	 * Method for Create rule simple rank
	 * 
	 * @param simpRule
	 * @return
	 */
/*	private RuleSimple createSimpleRuleRank(RuleSimple simpRule) {
		RuleSimple newRuleSimple = new RuleSimple();
		newRuleSimple.setCalculationMode("rank");
		newRuleSimple.setAggregateFunctions(simpRule.getAggregateFunctions());
		newRuleSimple.setFieldList(simpRule.getFieldList());
		newRuleSimple.setPopulationType(simpRule.getPopulationType());
		newRuleSimple.setPopulationUpto(simpRule.getPopulationUpto());
		newRuleSimple.setQualifyingClause(simpRule.getQualifyingClause());
		List<QualifyingClause> qclause = simpRule.getQualifyingClause();
		//QualifyingClause qclause1 = new QualifyingClause();
		//List<QualifyingClause> qclause2 = new ArrayList<>();
		
		for (Iterator iterator = qclause.iterator(); iterator.hasNext();) {
			QualifyingClause qclause1 = (QualifyingClause) iterator.next();
			newRuleSimple.getQualifyingClause().add(qclause1);
			}  
		
		newRuleSimple.setRankCount(simpRule.getRankCount());
		newRuleSimple.setRankingType(simpRule.getRankingType());
		newRuleSimple.setRuleParameter(simpRule.getRuleParameter());
		List<RuleParameter> rparam = simpRule.getRuleParameter();
		for (Iterator iterator = rparam.iterator(); iterator.hasNext();) {
			RuleParameter rparam1 = (RuleParameter) iterator.next();
			newRuleSimple.getRuleParameter().add(rparam1);
			}  
		return newRuleSimple;

	}*/
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
	 * Method for delete rule
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