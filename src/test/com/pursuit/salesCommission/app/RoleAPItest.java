package com.pursuit.salesCommission.app;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pursuit.salesCommission.app.api.RoleAPI;
import com.pursuit.salesCommission.app.model.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")

public class RoleAPItest {
	@Autowired
	private RoleAPI roleAPI;

	@Test
	public void testAddRole() {
		
		int i = roleAPI.addRole("gmanager", "super", "peo");
		Assert.assertNotNull(i);
		Role emp = roleAPI.getRole(i);
		Assert.assertEquals("gmanager", emp.getRoleName());
	}

	@Test
	public void testCreateRole() {
		Role e = new Role();
		e.setRoleName("tester");
		e.setDescription("good");
		e.setReportTo("deo");
		roleAPI.createRole(e);
		Role emp = roleAPI.getRole(e.getId());
		Assert.assertEquals("tester", emp.getRoleName());

	}

	@Test
	public void testGetRoles() {
		Role role = roleAPI.getRole(2);
		Assert.assertEquals("cc", role.getRoleName());
	}

	@Test
	public void testEditRole() {
		Role e = new Role();
		e.setRoleName("cc");
		e.setDescription("dd");
		e.setReportTo("ff");
		roleAPI.createRole(e);
		Role emp = roleAPI.getRole(e.getId());
		emp.setRoleName("joydeepda");
		roleAPI.editRole(emp);
		Role emp1 = roleAPI.getRole(emp.getId());
		Assert.assertEquals("joydeepda", emp1.getRoleName());

	}

}
