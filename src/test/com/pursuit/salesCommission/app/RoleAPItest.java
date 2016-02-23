package com.pursuit.salesCommission.app;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pursuit.salesCommission.app.api.EmployeeAPI;
//import com.pursuit.salesCommission.app.api.EmployeeAPI;
import com.pursuit.salesCommission.app.api.RoleAPI;
import com.pursuit.salesCommission.app.model.Employee;
import com.pursuit.salesCommission.app.model.Role;

public class RoleAPItest {
	
	
	@Test
	public void testAddRole() {
		RoleAPI api = new RoleAPI();
	     int i = api.addRole("gmanager","super", "peo");
	     Assert.assertNotNull(i);
	     Role emp = api.getRole(i);
	     Assert.assertEquals("gmanager", emp.getRoleName());
	}

	@Test
	public void testCreateRole() {
		RoleAPI api = new RoleAPI();
		Role e = new Role();
		e.setRoleName("tester");
		e.setDescription("good");
		e.setReportTo("deo");
		api.createRole(e);
		Role emp = api.getRole(e.getId());
		Assert.assertEquals("tester", emp.getRoleName());

	}
	
	@Test
	public void testGetRoles() {
		RoleAPI api = new RoleAPI();
		 Role role = api.getRole(2); 
        Assert.assertEquals("gmanager", role.getRoleName());
	} 

	
}
