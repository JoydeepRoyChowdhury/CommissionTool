package com.simpsoft.salesCommission.app;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simpsoft.salesCommission.app.api.EmployeeAPI;
import com.simpsoft.salesCommission.app.api.RoleAPI;
import com.simpsoft.salesCommission.app.api.RuleAPI;
import com.simpsoft.salesCommission.app.api.RuleAssignmentAPI;
import com.simpsoft.salesCommission.app.api.RuleSimpleAPI;
import com.simpsoft.salesCommission.app.model.Employee;
import com.simpsoft.salesCommission.app.model.Frequency;
import com.simpsoft.salesCommission.app.model.Role;
import com.simpsoft.salesCommission.app.model.Rule;
import com.simpsoft.salesCommission.app.model.RuleAssignment;
import com.simpsoft.salesCommission.app.model.RuleAssignmentDetails;
import com.simpsoft.salesCommission.app.model.RuleComposite;
import com.simpsoft.salesCommission.app.model.RuleParameter;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class RuleAssignmentAPITest {
	
	@Autowired
	private RuleAssignmentAPI ruleAssignmentApi;
	
	@Autowired
	private RoleAPI roleAPI;
	
	@Autowired
	private EmployeeAPI employeeApi;

	@Autowired
	private RuleAPI ruleAPI;
	
	@BeforeClass
	public static void oneTimeSetUp() {
		// one-time initialization code
		System.out.println("@BeforeClass - oneTimeSetUp");
	}

	@AfterClass
	public static void oneTimeTearDown() {
		// one-time cleanup code
		System.out.println("@AfterClass - oneTimeTearDown");
	}

	@Before
	public void setUp() throws Exception {

		System.out.println("Setting it up!");
		//ruleAss = new RuleAssignment();
		
		
	}

		 
	
	/**
	 * Test method for
	 * {@link com.simpsoft.salesCommission.app.api.RuleAPI#createRule(com.simpsoft.salesCommission.app.model.RuleAssignment)}
	 * .
	 */
	@Test
	public void testCreateRuleAssignmentToEmployee() {
	
	RuleAssignment ruleAss = new RuleAssignment();
	String empName = "Potter";
	Employee employee =	employeeApi.searchEmployee(empName);
	ruleAss.setEmployee(employee);
		long ruleId = ruleAssignmentApi.createRuleAssignment(ruleAss);
		ruleAss.setId(ruleId);
	RuleAssignment newRuleAss = ruleAssignmentApi.getRuleAssignment(ruleId);
	Assert.assertEquals("Potter", ruleAss.getEmployee().getEmployeeName());
	Assert.assertEquals("Potter", newRuleAss.getEmployee().getEmployeeName());
	Assert.assertEquals(2000, newRuleAss.getEmployee().getSalary());
	System.out.println("Running: testDummyRuleAssignment");
	
	} 

	/**
	 * Test method for
	 * {@link com.simpsoft.salesCommission.app.api.RuleAPI#createRule(com.simpsoft.salesCommission.app.model.RuleAssignment)}
	 * .
	 */
	@Test
	public void testCreateRuleAssignmentToRole() {
	
	RuleAssignment ruleAss = new RuleAssignment();
	String roleName = "VP Sales";  
	Role role =	roleAPI.searchRoleByName(roleName);
	ruleAss.setRole(role);
	List<RuleAssignmentDetails> rlAssDtlList = new ArrayList<RuleAssignmentDetails>();
	RuleAssignmentDetails rlAssDtl = new RuleAssignmentDetails();
	rlAssDtl.setValidityType("Fixed");
	String frequencyName = "monthly"; 
	Frequency frequency = ruleAssignmentApi.searchFrequency(frequencyName);
	rlAssDtl.setFrequency(frequency);
	Rule rule = ruleAPI.getRule(2);
	rlAssDtl.setRule(rule);
	rlAssDtlList.add(rlAssDtl);
	ruleAss.setRuleAssignmentDetails(rlAssDtlList);
	long ruleId = ruleAssignmentApi.createRuleAssignment(ruleAss);
	ruleAss.setId(ruleId);
	RuleAssignment newRuleAss = ruleAssignmentApi.getRuleAssignment(ruleId);
	Assert.assertEquals("VP Sales", ruleAss.getRole().getRoleName());
	Assert.assertEquals("Good", newRuleAss.getRole().getDescription());
	System.out.println("Running: testDummyRuleAssignment");
	
	} 
	
	
	/**
	 * @throws java.lang.Exception
	 */
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Running: tearDown");
		//ruleAPI.deleteRule(rule.getId());
		//Assert.assertNull(ruleAPI.getRule(rule.getId()));
	}
}