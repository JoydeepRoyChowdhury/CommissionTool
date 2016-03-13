package com.pursuit.salesCommission.app.api;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pursuit.salesCommission.app.model.AggregateFunctions;
import com.pursuit.salesCommission.app.model.ConditionList;
import com.pursuit.salesCommission.app.model.FieldList;
import com.pursuit.salesCommission.app.model.RuleSimple;

@Component
public class RuleSimpleAPI {

	@Autowired
	private static SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(RuleSimpleAPI.class);

	public void setSessionFactory(SessionFactory factory) {
		sessionFactory = factory;
	}

	/**
	 * 
	 * @param ruleSimpleID
	 * @return
	 */
	public RuleSimple getRuleSimple(long ruleSimpleID) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		return (RuleSimple) session.get(RuleSimple.class, ruleSimpleID);
	}

	/**
	 * Method for getting list of simple rules
	 * 
	 * @return
	 */
	public List<RuleSimple> listOfSimpleRules() {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List simpRules = session.createQuery("FROM RuleSimple").list();
		for (Iterator iterator = simpRules.iterator(); iterator.hasNext();) {
			RuleSimple ruleSimp = (RuleSimple) iterator.next();
			logger.debug("GET THE RULE DETAILS FROM DATABASE" + ruleSimp.getId() + ruleSimp.getCalculationMode());

		}
		return simpRules;
	}

	/**
	 * Method for getting list of aggregate functions
	 * 
	 * @return
	 */
	public List<AggregateFunctions> listOfAggregateFunctions() {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List aggregatetFunction = session.createQuery("FROM AggreagateFunction").list();
		for (Iterator iterator = aggregatetFunction.iterator(); iterator.hasNext();) {
			AggregateFunctions agrFn = (AggregateFunctions) iterator.next();
			logger.debug("GET THE RULE DETAILS FROM DATABASE" + agrFn.getId() + agrFn.getFunctionName());

		}
		return aggregatetFunction;
	}

	/**
	 * Method for getting list of conditions
	 * 
	 * @return
	 */
	public List<ConditionList> listOfConditions() {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List conditionList = session.createQuery("FROM ConditionList").list();
		for (Iterator iterator = conditionList.iterator(); iterator.hasNext();) {
			ConditionList cdnLst = (ConditionList) iterator.next();
			logger.debug("GET THE RULE DETAILS FROM DATABASE" + cdnLst.getId() + cdnLst.getConditionValue());

		}
		return conditionList;
	}

	/**
	 * Method for getting list of fields
	 * 
	 * @return
	 */
	public List<FieldList> listOfFields() {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List fieldList = session.createQuery("FROM FieldList").list();
		for (Iterator iterator = fieldList.iterator(); iterator.hasNext();) {
			FieldList fldLst = (FieldList) iterator.next();
			logger.debug("GET THE RULE DETAILS FROM DATABASE" + fldLst.getId() + fldLst.getDisplayName());

		}
		return fieldList;
	}
	
}
