package com.pursuit.salesCommission.app.api.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pursuit.salesCommission.app.model.EmployeeOld;
@Repository
@Transactional
public class EmployeeDao {
	@Autowired
	HibernateTemplate template;
	@Autowired
	 private SessionFactory sessionFactory;
	
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	 public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	 
	public void saveEmployee(EmployeeOld e) {
		template.save(e);
	}

	public void updateEmployee(EmployeeOld e) {
		template.update(e);
	}

	public void deleteEmployee(EmployeeOld e) {
		template.delete(e);
	}

	public EmployeeOld getById(int id)
	{
		return (EmployeeOld) template.get(EmployeeOld.class, id);
	}

	/*public Collection<Employee> searchEmployee(Employee e) {
		return (Collection<Employee>) template.find("from Employee e");
	} */
	 @SuppressWarnings("unchecked")
	    public List<EmployeeOld> listEmployee() {
	       // Session session = this.sessionFactory.getCurrentSession();
	       // List<Employee> empList = session.createQuery("from Employee").list();
		 List<EmployeeOld> empList = (List<EmployeeOld>) template.find("from EmployeeOld e");
	        return empList;
	    }
}
