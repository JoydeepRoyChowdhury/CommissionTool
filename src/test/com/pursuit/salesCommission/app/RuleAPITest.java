package com.pursuit.salesCommission.app;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pursuit.salesCommission.app.api.EmployeeAPI;
import com.pursuit.salesCommission.app.api.RuleAPI;
import com.pursuit.salesCommission.app.model.Employee;
import com.pursuit.salesCommission.app.model.Rule;

public class RuleAPITest {

	@Test
	public void testGetRules() {
		RuleAPI api = new RuleAPI();
		Rule rul = api.getRule(30);
		Assert.assertEquals("ABCD", rul.getRuleName());

	}

	@Test
	public void testAddRule() {
		RuleAPI api = new RuleAPI();
		int i = api.addRule("ABCD", "EFGH", "XYZ");
		Assert.assertNotNull(i);
		Rule rul = api.getRule(i);
		Assert.assertEquals("ABCD", rul.getRuleName());
	}

	@Test
	public void testCreateRule() {
		RuleAPI api = new RuleAPI();
		Rule r = new Rule();

		r.setRuleName("dfdbf");
		r.setDescription("rgbrfbvfr");
		r.setRuleType("gftgnbgnm");
		/*
		 * r.setRulesConnectedas("PQRS"); r.setListofRules("MNOP");
		 */
		api.createRule(r);
		Rule ru = api.getRule(r.getId());
		Assert.assertEquals("dfdbf", ru.getRuleName());
	}
	@Test
	public void testDeleteRule() {
		RuleAPI api = new RuleAPI();
		int i = api.addRule("ABCD", "EFGH", "XYZ");
		Rule rul = api.getRule(i);
		api.deleteRule(i);
		Assert.assertNull(api.getRule(i));
	} 
	
	/*@Test
	public void testUpdateRule() {
		RuleAPI api = new RuleAPI();
		int i = api.addRule("ABCD", "EFGH", "XYZ");
		Rule rul= api.updateRule(i,"Rashid");
		 Assert.assertEquals("Rashid", rul.getRuleType());
		
	}*/
	
	@Test
 	public void testEditRule() {
	RuleAPI api = new RuleAPI();
 		Rule e = new Rule();
		e.setRuleName("rule 1234");
		e.setRuleType("simple");
		e.setDescription("vcdhfvhdvh");
	    api.createRule(e);
	    Rule emp = api.getRule(e.getId());
	    emp.setRuleName("rule 456");
 		api.editRule(emp);
 		 Rule emp1 = api.getRule(emp.getId());
 		 Assert.assertEquals("rule 456", emp1.getRuleName());
 		
 	}
	
	
}
