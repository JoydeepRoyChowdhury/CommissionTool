package com.pursuit.salesCommission.app.api;

import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pursuit.salesCommission.app.model.Role;

public class RoleAPI {
	private static SessionFactory factory;

	public int addRole(String rolename, String description, String reportTo) {
		factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(Role.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		int role = (Integer) null;
		try {
			tx = session.beginTransaction();
			Role obj1 = new Role();
			obj1.setRoleName(rolename);
			obj1.setDescription(description);
			obj1.setReportTo(reportTo);
			role = (int) session.save(obj1);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("Hello........" + rolename+ " " +description+ " " +reportTo);
		return role;

	}
	
	/*public Integer addRole(String rolename, String description, String reportTo) {

		factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(Role.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		Integer roleID = null;
		try {
			tx = session.beginTransaction();
			Role obj1 = new Role();
			obj1.setRoleName(rolename);
			obj1.setDescription(description);
			obj1.setReportTo(reportTo);
			roleID = (Integer) session.save(role);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeID;
	}*/


	public Role getRole(Integer RoleID) {
		factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(Role.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		return (Role) session.get(Role.class, RoleID);
	}
	
	
	public void createRole(Role role) {

		factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(Role.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Role obj2 = new Role();
			obj2.setRoleName(role.getRoleName());
			obj2.setDescription(role.getDescription());
			obj2.setReportTo(role.getReportTo());
			session.update(role);
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