package com.pursuit.salesCommission.app;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pursuit.salesCommission.app.api.EmployeeAPI;
import com.pursuit.salesCommission.app.model.Employee;
import com.pursuit.salesCommission.app.model.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class EmployeeAPITest {

	@Autowired
	private EmployeeAPI employeeAPI;

	@Test
	public void testCreateEmployee() {
		Employee e = new Employee();
		e.setFirstName("Rama");
		e.setLastName("Bagh");
		e.setSalary(60000);
		//Role role = new Role();
		//role.setRoleName("manager");
		//role.setDescription("hello");
		//role.setReportTo("CEO");
		//e.setRole(role);
		employeeAPI.createEmployee(e);
		Employee emp = employeeAPI.getEmployee(e.getId());
		Assert.assertEquals("Rama", emp.getFirstName());
	}

/*	@Test
	public void testGetEmployees() {
		Employee employee = employeeAPI.getEmployee(7);
		Assert.assertEquals("ss", employee.getFirstName());
	}

	/*
	  @Test public void testListEmployees() { EmployeeAPI api = new
	  EmployeeAPI(); List<Employee> emp= api.listEmployees();
	  Assert.assertEquals(33, emp.size()); }
	 */

/*	@Test
	public void testEditEmployee() {
		Employee e = new Employee();
		e.setFirstName("Rama");
		e.setLastName("Bagh");
		e.setSalary(60000);
		employeeAPI.createEmployee(e);
		Employee emp = employeeAPI.getEmployee(e.getId());
		emp.setSalary(18900);
		employeeAPI.editEmployee(emp);
		Employee emp1 = employeeAPI.getEmployee(emp.getId());
		Assert.assertEquals(18900, emp1.getSalary());

	}

	@Test
	public void testDeleteEmployee() {
		Employee e = new Employee();
		e.setFirstName("Rama");
		e.setLastName("Bagh");
		e.setSalary(60000);
		employeeAPI.createEmployee(e);
		employeeAPI.deleteEmployee(e.getId());
		Assert.assertNull(employeeAPI.getEmployee(e.getId()));
	}
*/
}
