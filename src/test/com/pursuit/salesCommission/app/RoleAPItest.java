package com.pursuit.salesCommission.app;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pursuit.salesCommission.app.api.RoleAPI;
import com.pursuit.salesCommission.app.model.Employee;
import com.pursuit.salesCommission.app.model.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")

public class RoleAPItest {
	@Autowired
	private RoleAPI roleAPI;


	@Test
	public void testCreateRole() {
       
        Role role1 = new Role();
        role1.setRoleName("TESTER");
        role1.setDescription("Good");
      //  role1.setReportsTo("CEO");
       Long id = roleAPI.createRole(role1);
        Role role = roleAPI.getRole(id);
		Assert.assertEquals("TESTER", role.getRoleName());
	}
	
	@Test
	public void testListOfRoles() {
		List<Role> role= roleAPI.listOfRoles();
		  Assert.assertEquals(2, role.size());
	}
	/*		@Test
	public void testGetRoles() {
		Role role = roleAPI.getRole(2);
		Assert.assertEquals("cc", role.getRoleName());
	}

@Test
	public void testEditRole() {
		Role e = new Role();
		e.setRoleName("cc");
		e.setDescription("dd");
		// e.setReportTo("ff");
		roleAPI.createRole(e);
		Role emp = roleAPI.getRole(e.getId());
		emp.setRoleName("joydeepda");
		roleAPI.editRole(emp);
		Role emp1 = roleAPI.getRole(emp.getId());
		Assert.assertEquals("joydeepda", emp1.getRoleName());

	} */

}
