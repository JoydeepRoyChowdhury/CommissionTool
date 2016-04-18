package com.simpsoft.salesCommission.app.api;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simpsoft.salesCommission.app.model.SplitRule;

@Component
public class SplitRuleAPI {

	@Autowired
	private static SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(SplitRuleAPI.class);

	public void setSessionFactory(SessionFactory factory) {
		sessionFactory = factory;
	}
	
	public SplitRule createSplitRule(SplitRule splitRule) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		SplitRule newSplitRule = new SplitRule();
		try {
			tx = session.beginTransaction();
			newSplitRule.setSplitRuleName(splitRule.getSplitRuleName());
			newSplitRule.setDescription(splitRule.getDescription());
			newSplitRule.setStartDate(splitRule.getStartDate());
			newSplitRule.setEndDate(splitRule.getEndDate());
			newSplitRule.setSplitQualifyingClause(splitRule.getSplitQualifyingClause());
			newSplitRule.setSplitRuleBeneficiary(splitRule.getSplitRuleBeneficiary());
			session.save(newSplitRule);
			tx.commit();
			logger.debug("CREATED AN SPLIT RULE INTO DATABASE" + newSplitRule);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newSplitRule;
	}

}
