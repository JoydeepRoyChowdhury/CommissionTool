package com.pursuit.salesCommission.app;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pursuit.salesCommission.app.api.EmployeeAPI;
import com.pursuit.salesCommission.app.model.Employee;

public class EmployeeAPITest {
	
	
	@Test
	public void testGetEmployees() {
		EmployeeAPI api = new EmployeeAPI();
		 Employee employee = api.getEmployee(3); 
        Assert.assertEquals("John", employee.getFirstName());
	} 
	
 	@Test
	public void testAddEmployee() {
		EmployeeAPI api = new EmployeeAPI();
	     int i = api.addEmployee("Hari","Paul", 60000);
	     Assert.assertNotNull(i);
	     Employee emp = api.getEmployee(i);
	     Assert.assertEquals("Hari", emp.getFirstName());
	}

/*  @Test
	public void testListEmployees() {
		EmployeeAPI api = new EmployeeAPI();
		List<Employee> emp= api.listEmployees();
		Assert.assertEquals(33, emp.size());
	} */
 	 @Test
	public void testUpdateEmployee() {
		EmployeeAPI api = new EmployeeAPI();
		int i = api.addEmployee("Ram","Das", 60000);
		Employee emp= api.updateEmployee(i, 80000);
		 Assert.assertEquals(80000, emp.getSalary());
		
	}

	@Test
	public void testDeleteEmployee() {
		EmployeeAPI api = new EmployeeAPI();
		int i = api.addEmployee("Ram","Das", 60000);
		Employee emp = api.getEmployee(i);
		api.deleteEmployee(i);
		Assert.assertNull(api.getEmployee(i));
	} 

}
