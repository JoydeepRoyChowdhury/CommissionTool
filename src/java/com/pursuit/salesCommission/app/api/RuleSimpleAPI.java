package com.pursuit.salesCommission.app.api;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pursuit.salesCommission.app.model.Rule;
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
			RuleSimple ruleSimp = new RuleSimple();
			ruleSimp.setRule(ruleSimple.getRule());
			ruleSimp.setCalculationMode(ruleSimple.getCalculationMode());
			session.save(ruleSimp);
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


}
