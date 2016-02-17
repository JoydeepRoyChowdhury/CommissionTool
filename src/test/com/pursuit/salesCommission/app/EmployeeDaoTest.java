package com.pursuit.salesCommission.app;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.pursuit.salesCommission.app.api.dao.EmployeeDao;
import com.pursuit.salesCommission.app.model.Employee;
   
  
@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeDaoTest {
	 @Autowired
	    private EmployeeDao employeeDao;

	/*@Test
	public void testSetTemplate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEmployee() {
		fail("Not yet implemented");
	} */

	 @Test
	 @Transactional
	 @Rollback(true)
	public void testGetById() {
		 Employee employee = employeeDao.getById(1);
    //   Assert.assertEquals("PP", employee.getName());
	}

	/* @Test
	public void testSearchEmployee() {
		fail("Not yet implemented");
	}
*/
}
