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

import com.pursuit.salesCommission.app.model.AggregateFunctions;
import com.pursuit.salesCommission.app.model.ConditionList;
import com.pursuit.salesCommission.app.model.Employee;
import com.pursuit.salesCommission.app.model.FieldList;
import com.pursuit.salesCommission.app.model.RuleParameter;
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
	 * @return simpRules
	 */
	public List<RuleSimple> listOfSimpleRules() {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List simpRules = session.createQuery("FROM RuleSimple").list();
		//for (Iterator iterator = simpRules.iterator(); iterator.hasNext();) {
		//	RuleSimple ruleSimp = (RuleSimple) iterator.next();
		//	logger.debug("GET THE RULE DETAILS FROM DATABASE" + ruleSimp.getId() + ruleSimp.getCalculationMode());

		//}
		return simpRules;
	}

	/**
	 * Method for getting list of aggregate functions
	 * 
	 * @return aggregatetFunction
	 */
	public List<AggregateFunctions> listOfAggregateFunctions() {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List aggregatetFunction = session.createQuery("FROM AggregateFunctions").list();
		for (Iterator iterator = aggregatetFunction.iterator(); iterator.hasNext();) {
			AggregateFunctions agrFn = (AggregateFunctions) iterator.next();
			logger.debug("GET THE RULE DETAILS FROM DATABASE" + agrFn.getId() + agrFn.getFunctionName());

		}
		return aggregatetFunction;
	}
	/**
	 * Method for getting list of aggregate functions
	 * 
	 * @return aggregatetFunction
	 */
	public List<AggregateFunctions> listOfAggregateFunctionsByID(long ruleSimpID) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List aggregatetFunction = session.createQuery("FROM AggregateFunctions WHERE RULE_SIMP_ID =" + ruleSimpID).list();
		for (Iterator iterator = aggregatetFunction.iterator(); iterator.hasNext();) {
			AggregateFunctions agrFn = (AggregateFunctions) iterator.next();
			logger.debug("GET THE RULE DETAILS FROM DATABASE" + agrFn.getId() + agrFn.getFunctionName());

		}
		return aggregatetFunction;
	}
	/**
	 * Method for create Condition List
	 * @param conditionList
	 * @return
	 */
	public long createCondition(ConditionList conditionList) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		ConditionList cndList = new ConditionList();
		try {
			tx = session.beginTransaction();
			cndList.setConditionValue(conditionList.getConditionValue());
			session.save(cndList);
			tx.commit();
			logger.debug("CREATED AN CONDITION INTO DATABASE" + cndList);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cndList.getId();
	}
	/**
	 * Method for getting list of conditions
	 * 
	 * @return conditionList
	 */
	public List<ConditionList> listOfConditions() {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List conditionList = session.createQuery("FROM ConditionList").list();
		/*for (Iterator iterator = conditionList.iterator(); iterator.hasNext();) {
			ConditionList cdnLst = (ConditionList) iterator.next();
			logger.debug("GET THE RULE DETAILS FROM DATABASE" + cdnLst.getId() + cdnLst.getConditionValue());

		}*/
		return conditionList;
	}
	public ConditionList searchCondition(String conditionVal) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List conditions = session.createQuery("FROM ConditionList").list();
		ConditionList cnd = new ConditionList();
		for (Iterator iterator = conditions.iterator(); iterator.hasNext();) {
			
			ConditionList condition = (ConditionList) iterator.next();
			if(conditionVal.equals(condition.getConditionValue())){
				cnd.setId(condition.getId());
				cnd.setConditionValue(condition.getConditionValue());
				
			}  
			// logger.debug("GET THE EMPLOYEE DETAILS FROM DATABASE" +
			// employee.getFirstName()+ employee.getLastName()
			// +employee.getSalary() );
		}
		return cnd;
	}
	/**
	 * Method for getting list of fields
	 * 
	 * @return fieldList
	 */
	public List<FieldList> listOfFields() {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List fieldList = session.createQuery("FROM FieldList").list();
		/*for (Iterator iterator = fieldList.iterator(); iterator.hasNext();) {
			FieldList fldLst = (FieldList) iterator.next();
			logger.debug("GET THE RULE DETAILS FROM DATABASE" + fldLst.getId() + fldLst.getDisplayName());

		} */
		return fieldList;
	}
	
}
