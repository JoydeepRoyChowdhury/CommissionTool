package com.pursuit.salesCommission.app.api.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.hibernate.Criteria;
import org.hibernate.Session;
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
	 public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
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

	/*public Collection<Employee> searchEmployee(Employee e) {
		return (Collection<Employee>) template.find("from Employee e");
	} */
	 @SuppressWarnings("unchecked")
	    public List<Employee> listEmployee() {
	       // Session session = this.sessionFactory.getCurrentSession();
	       // List<Employee> empList = session.createQuery("from Employee").list();
		 List<Employee> empList = (List<Employee>) template.find("from Employee e");
	        return empList;
	    }
}
