package com.pursuit.salesCommission.app;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

//import com.pursuit.salesCommission.app.api.EmployeeAPI;
import com.pursuit.salesCommission.app.api.RoleAPI;
import com.pursuit.salesCommission.app.model.Role;

public class RoleAPItest {
	
	
	@Test
	public void testAddRole() {
		RoleAPI api = new RoleAPI();
	     int i = api.addRole("Manager","good", "ceo");
	     Assert.assertNotNull(i);
	     Role emp = api.getRole(i);
	     //Assert.assertEquals("Hari", emp.getRoleName());
	}

	@Test
	public void testCreateRole() {
		RoleAPI api = new RoleAPI();
		Role e = new Role();
		e.setRoleName("Tester");
		e.setDescription("testall");
		e.setReportTo("CEO");
		api.createRole(e);
		Role emp = api.getRole(e.getId());
		//Assert.assertEquals("Tester", emp.getRoleName());

	}

	
}
