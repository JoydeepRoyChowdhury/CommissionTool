package com.pursuit.salesCommission.app.api;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pursuit.salesCommission.app.model.QualifyingClause;
import com.pursuit.salesCommission.app.model.RuleSimple;

@Component
public class RuleSimpleAPI {

	
	@Autowired
	private static SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory factory) {
		sessionFactory = factory;
	}
	
	/**
	 * Method for create simple rule
	 * @param rule
	 */
	public void createSimpleRule(RuleSimple ruleSimple) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			RuleSimple ruleSmpl = new RuleSimple();
			//ruleSmpl.setRule(ruleSimple.getRule());
			//ruleSmpl.setCalculationMode(ruleSimple.getCalculationMode());
			//ruleSmpl.setRankCount(ruleSimple.getRankCount());
			//ruleSmpl.setRankingType(ruleSimple.getRankingType());
			//ruleSmpl.setPopulationType(ruleSimple.getPopulationType());
			//ruleSmpl.setPopulationUpto(ruleSimple.getPopulationUpto());
			//ruleSmpl.setCompensationType(ruleSimple.getCompensationType());
			//ruleSmpl.setFixedCompValue(ruleSimple.getFixedCompValue());
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
	
	public RuleSimple getRuleSimple(long l) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		return (RuleSimple) session.get(RuleSimple.class, l);
	}

	public void createQualifyingClause(QualifyingClause qClause) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			QualifyingClause qfyClause = new QualifyingClause();
			qfyClause.setValue(qClause.getValue());
			//qfyClause.setFieldList(qClause.getFieldList());
			//qfyClause.setConditionList(qClause.getConditionList());
			session.save(qfyClause);
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
