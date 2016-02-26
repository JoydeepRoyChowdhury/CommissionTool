package com.pursuit.salesCommission.app.api;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.pursuit.salesCommission.app.model.Role;

@Component
public class RoleAPI {
	
	@Autowired
	private static SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory factory) {
		sessionFactory = factory;
	}


	/* ...............Add role in Database.................... */

	public int addRole(String rolename, String description, String reportTo) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer roleID = null;
		try {
			tx = session.beginTransaction();
			Role obj1 = new Role();
			obj1.setRoleName(rolename);
			obj1.setDescription(description);
			obj1.setReportTo(reportTo);
			roleID = (int) session.save(obj1);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("Hello........" + rolename + " " + description + " " + reportTo);
		return roleID;

	}

	/* ........getRole...... */

	public Role getRole(Integer RoleID) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		return (Role) session.get(Role.class, RoleID);
	}

	/* .............create role............. */

	public void createRole(Role role) {

		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Role obj2 = new Role();
			obj2.setRoleName(role.getRoleName());
			obj2.setDescription(role.getDescription());
			obj2.setReportTo(role.getReportTo());
			session.save(role);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	/* Method to READ all role */
	public List<Role> listRoles() {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List roles = session.createQuery("FROM Role").list();
		for (Iterator iterator = roles.iterator(); iterator.hasNext();) {
			Role role = (Role) iterator.next();
			System.out.print("Role Name: " + role.getRoleName());
			System.out.print("  Description: " + role.getDescription());
			System.out.println("  Report To: " + role.getReportTo());
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
			role1.setReportTo(role.getReportTo());
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