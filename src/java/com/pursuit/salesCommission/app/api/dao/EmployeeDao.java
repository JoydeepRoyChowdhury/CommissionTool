package com.pursuit.salesCommission.app.api.dao;

import java.util.Collection;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.pursuit.salesCommission.app.model.Employee;
@Repository
@Transactional
public class EmployeeDao {
	HibernateTemplate template;
	@Autowired
	 private SessionFactory sessionFactory;
	
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public void saveEmployee(Employee e) {
		template.save(e);
	}

	public void updateEmployee(Employee e) {
		template.update(e);
	}

	public void deleteEmployee(Employee e) {
		template.delete(e);
	}

	public Employee getById(int id)
	{
		return (Employee) template.get(Employee.class, id);
	}

	public Collection<Employee> searchEmployee(Employee e) {
		return (Collection<Employee>) template.find("from Employee e");
	}
}
