package com.simpsoft.salesCommission.app.api;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simpsoft.salesCommission.app.model.Frequency;
import com.simpsoft.salesCommission.app.model.RuleAssignment;


@Component
public class RuleAssignmentAPI {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(EmployeeAPI.class);

	public void setSessionFactory(SessionFactory factory) {
		sessionFactory = factory;
	}

	/**
	 * Create assignment of rule
	 * 
	 * @param ruleAss
	 * @return
	 */

	public long createRuleAssignment(RuleAssignment ruleAss) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		RuleAssignment newRuleAss = new RuleAssignment();
		try {
			tx = session.beginTransaction();
			newRuleAss.setEmployee(ruleAss.getEmployee());
			newRuleAss.setRole(ruleAss.getRole());
			newRuleAss.setRuleAssignmentDetails(ruleAss.getRuleAssignmentDetails());
			session.save(newRuleAss);
			tx.commit();
			logger.debug("CREATED AN RULE ASSIGNMENT INTO DATABASE" + newRuleAss);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newRuleAss.getId();
	}

	/**
	 * Method for getting one rule assignment based on ID
	 * 
	 * @param ruleID
	 * @return
	 */
	public RuleAssignment getRuleAssignment(long ruleAssID) {
		RuleAssignment newRuleAss = new RuleAssignment();

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			newRuleAss = (RuleAssignment) session.get(RuleAssignment.class, ruleAssID);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newRuleAss;
	}

	/**
	 * Method for create Frequency
	 * 
	 * @param conditionList
	 * @return
	 */
	public long createFrequency(Frequency frequency) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Frequency freq = new Frequency();
		try {
			tx = session.beginTransaction();
			freq.setFrequencyName(frequency.getFrequencyName());
			session.save(freq);
			tx.commit();
			logger.debug("CREATED AN FREQUENCY INTO DATABASE" + freq);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return freq.getId();
	}

	/**
	 * Method for searching frequency by name
	 * 
	 * @param freqName
	 * @return
	 */
	public Frequency searchFrequency(String freqName) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Frequency freq = new Frequency();
		try {
			tx = session.beginTransaction();
			List frequencies = session.createQuery("FROM Frequency").list();
			for (Iterator iterator = frequencies.iterator(); iterator.hasNext();) {

				Frequency frequency = (Frequency) iterator.next();
				if (freqName.equals(frequency.getFrequencyName())) {
					freq = frequency;
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return freq;
	}

}
