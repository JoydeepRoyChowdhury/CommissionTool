package com.pursuit.salesCommission.app.api;

import org.hibernate.SessionFactory;

public class RoleAPI {
	private static SessionFactory factory;

	/* ...............Add role in Database.................... */

	/*
	public int addRole(String rolename, String description, String reportTo) {
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

	* ........getRole...... /

	public Role getRole(Integer RoleID) {
		factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(Role.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		return (Role) session.get(Role.class, RoleID);
	}

	* .............create role............. *

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
	
	* Method to READ all the employees/
	public List<Role> listRoles() {
		factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(Role.class)
				.buildSessionFactory();
		Session session = factory.openSession();
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
*/
}