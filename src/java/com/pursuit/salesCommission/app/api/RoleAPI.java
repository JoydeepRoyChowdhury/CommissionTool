package com.pursuit.salesCommission.app.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pursuit.salesCommission.app.model.Employee;
import com.pursuit.salesCommission.app.model.Role;
import com.pursuit.salesCommission.app.model.Rule;
import com.pursuit.salesCommission.app.model.RuleParameter;
import com.pursuit.salesCommission.app.model.Target;

@Component
public class RoleAPI {
	
	@Autowired
	private static SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(RoleAPI.class);
	public void setSessionFactory(SessionFactory factory) {
		sessionFactory = factory;
	}

	/* ........getRole...... */

	public Role getRole(Long RoleID) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		return (Role) session.get(Role.class, RoleID);
	}
/**
 * 
 * @param role
 */
	public void createRole(Role role) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Role newRole = new Role();
		try {
			tx = session.beginTransaction();
			//newRole.setRoleName(role.getRoleName());
			//newRole.setDescription(role.getDescription());
			//newRole.setReportsTo(role.getReportsTo());
			// emp.setManager(employee.getManager());
			session.save(role);
			tx.commit();
			logger.debug("CREATED AN ROLE INTO DATABASE" + newRole);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	/**
	 * Method for getting list of roles
	 * 
	 * @return
	 */
	public List<Role> listOfRoles() {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List roles = session.createQuery("FROM Role").list();
		for (Iterator iterator = roles.iterator(); iterator.hasNext();) {
			Role role = (Role) iterator.next();
			logger.debug("GET THE RULE DETAILS FROM DATABASE" + role.getRoleName() + role.getReportsTo());
					
		}
		return roles;
	}

	/* ............. delete role........ */

	public void deleteRole(Integer RoleID) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Role role = (Role) session.get(Role.class, RoleID);
			session.delete(role);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void editRole(Role role) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Role role1 = (Role) session.get(Role.class, role.getId());
			role1.setId(role.getId());
			role1.setRoleName(role.getRoleName());
			role1.setDescription(role.getDescription());
			//role1.setReportTo(role.getReportTo());
			session.save(role1);
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