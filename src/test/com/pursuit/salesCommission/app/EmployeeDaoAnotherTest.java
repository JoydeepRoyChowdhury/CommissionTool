/*package com.pursuit.salesCommission.app;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pursuit.salesCommission.app.model.Employee;
import com.pursuit.salesCommission.app.api.dao.EmployeeDaoAnother;


public class EmployeeDaoAnotherTest {

	@Test
	public void testCreateEmployee() throws SQLException{
		 EmployeeDaoAnother dao = new EmployeeDaoAnother();
		 Employee employee = dao.getEmployee(19);
        Assert.assertEquals("John", employee.getName());
	}

	@Test
	public void testGetEmployee() throws Exception{
		/* EmployeeDao dao = new EmployeeDao();
        Employee employee = dao.createEmployee(901, "hh");
        assertNotNull(employee);
       // System.out.print(employee.getId());
        //Assert.assertEquals(3, employee.getId());
        //assertEquals("hh", user.getName());
    } */
/*	EmployeeDaoAnother dao = new EmployeeDaoAnother();
	 Employee emp = new Employee();
     emp.setId(202);
     emp.setName("John");

     dao.createEmployee(emp.getId(), emp.getName());
     int id = emp.getId();
     Assert.assertNotNull(id);
     Employee newMember = dao.getEmployee(id);
     Assert.assertEquals("John", newMember.getName());
	}

}*/
