package com.pursuit.salesCommission.app;

import java.util.Collection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.pursuit.salesCommission.app.api.dao.EmployeeDao;
import com.pursuit.salesCommission.app.model.Employee;

public class InsertTest {
public static void main(String[] args) {
	
	Resource r=new ClassPathResource("applicationContext.xml");
	BeanFactory factory=new XmlBeanFactory(r);
	
	EmployeeDao dao=(EmployeeDao)factory.getBean("d");
	
	Employee e=new Employee();
	e.setName("kumar");
	Collection employees = dao.searchEmployee(e);
	
	System.out.println("employee count =" + employees.size());
	// dao.updateEmployee(e);
}
}
