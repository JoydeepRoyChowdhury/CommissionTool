package com.simpsoft.salesCommission.app.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simpsoft.salesCommission.app.model.Address;
import com.simpsoft.salesCommission.app.model.AggregateFunctions;
import com.simpsoft.salesCommission.app.model.CustomerType;
import com.simpsoft.salesCommission.app.model.RuleAssignment;
import com.simpsoft.salesCommission.app.model.State;

@Component
public class OrderAPI {

	@Autowired
	private static SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(RuleAPI.class);

	public void setSessionFactory(SessionFactory factory) {
		sessionFactory = factory;
	}
	
	
	public Long createState(State state) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		State newState = new State();
		try {
			tx = session.beginTransaction();
			newState.setStateName(state.getStateName());
			newState.setStateCode(state.getStateCode());
			session.save(newState);
			tx.commit();
			logger.debug("CREATED AN AGGREGATE FUNCTION INTO DATABASE" + newState);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newState.getId();
	}
	
	public Long createAddress(Address address) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Address newAddress = new Address();
		try {
			tx = session.beginTransaction();
			newAddress.setAddrslinen1(address.getAddrslinen1());
			newAddress.setAddrslinen2(address.getAddrslinen2());
			newAddress.setState(address.getState());
			session.save(newAddress);
			tx.commit();
			logger.debug("CREATED AN AGGREGATE FUNCTION INTO DATABASE" + newAddress);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newAddress.getId();
	} 
	
	public State searchState(String stateName) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		State state1 = new State();
		List<State> stateList = new ArrayList<>();
		try {
		tx = session.beginTransaction();
		Criteria crit = session.createCriteria(State.class);
		crit.add(Restrictions.eq("stateName",stateName));
		stateList = crit.list();
				tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return stateList.get(0);
	}
	
	public Long createCustomerType(CustomerType customerType) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		CustomerType newCustomerType = new CustomerType();
		try {
			tx = session.beginTransaction();
			newCustomerType.setCustType(customerType.getCustType());
			session.save(newCustomerType);
			tx.commit();
			logger.debug("CREATED AN AGGREGATE FUNCTION INTO DATABASE" + newCustomerType);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newCustomerType.getId();
	}

}
