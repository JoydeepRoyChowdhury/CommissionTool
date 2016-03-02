package com.pursuit.salesCommission.app;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pursuit.salesCommission.app.api.RuleAPI;
import com.pursuit.salesCommission.app.model.Rule;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")

public class RuleAPItest {
	@Autowired
	private RuleAPI ruleAPI;

	@Test
	public void testAddRole() {
		
		int i =ruleAPI.addRule("ABCD", "EFGH", "XYZ");
		Assert.assertNotNull(i);
		Rule rul = ruleAPI.getRule(i);
		Assert.assertEquals("ABCD", rul.getRuleName());
	}

	@Test
	public void testCreateRule() {
		Rule r = new Rule();
		r.setRuleName("Rashid");
		r.setDescription("Reza");
		r.setRuleType("Simple");
		ruleAPI.createRule(r);
		Rule ru = ruleAPI.getRule(r.getId());
		Assert.assertEquals("Rashid", ru.getRuleName());

	}

	@Test
	public void testGetRules() {
		Rule rule = ruleAPI.getRule(45); 
        Assert.assertEquals("ABCD", rule.getRuleName());

	}

	@Test
	public void testDeleteRule() {
		int i = ruleAPI.addRule("ABCD", "EFGH", "XYZ");
		Rule rul = ruleAPI.getRule(i);
		ruleAPI.deleteRule(i);
		Assert.assertNull(ruleAPI.getRule(i));
	} 
	
	
	@Test
	 public void testUpdateRule() {
	  //RuleAPI ruleAPI = new RuleAPI();
	  int i = ruleAPI.addRule("ABC", "EFG", "XYZ");
	  Rule rul= ruleAPI.updateRule(i, "Rasid");
	   Assert.assertEquals("Rasid", rul.getRuleName());
	  
	 }
	

	@Test
 	public void testEditRule() {
 		Rule e = new Rule();
		e.setRuleName("rule 1234");
		e.setRuleType("simple");
		e.setDescription("vcdhfvhdvh");
		ruleAPI.createRule(e);
	    Rule emp = ruleAPI.getRule(e.getId());
	    emp.setRuleName("rule 456");
	    ruleAPI.editRule(emp);
 		 Rule emp1 = ruleAPI.getRule(emp.getId());
 		 Assert.assertEquals("rule 456", emp1.getRuleName());
 		
 	}
	
	
}
