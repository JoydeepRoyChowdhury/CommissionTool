package com.pursuit.salesCommission.app.api.dao;
import java.util.Collection;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.pursuit.salesCommission.app.model.Employee;

public class EmployeeDao {
HibernateTemplate template;
public void setTemplate(HibernateTemplate template) {
	this.template = template;
}

public void saveEmployee(Employee e){
	template.save(e);
}

public void updateEmployee(Employee e){
	template.update(e);
}

public void deleteEmployee(Employee e){
	template.delete(e);
}
public Collection<Employee> searchEmployee(Employee e){
	return (Collection<Employee>) template.find("from Employee e");
}
}
