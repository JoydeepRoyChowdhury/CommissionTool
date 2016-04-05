package com.simpsoft.salesCommission.app.api;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RuleAssignmentAPI {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(EmployeeAPI.class);

	public void setSessionFactory(SessionFactory factory) {
		sessionFactory = factory;
	}

}
