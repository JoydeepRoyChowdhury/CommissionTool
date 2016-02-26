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
public class RuleAPITest {
	
	@Autowired
	private RuleAPI ruleAPI;
	
	@Test
	public void testGetRules() {
		Rule rule = ruleAPI.getRule(7); 
        Assert.assertEquals("ABCD", rule.getRuleName());

	}

	@Test
	public void testAddRule() {
		//RuleAPI api = new RuleAPI();
		int i =ruleAPI.addRule("ABCD", "EFGH", "XYZ");
		Assert.assertNotNull(i);
		Rule rul = ruleAPI.getRule(i);
		Assert.assertEquals("ABCD", rul.getRuleName());
	}

	@Test
	public void testCreateRule() {
		//RuleAPI api = new RuleAPI();
		Rule r = new Rule();

		r.setRuleName("Rashid");
		r.setDescription("Reza");
		r.setRuleType("Simple");
		/*
		 * r.setRulesConnectedas("PQRS"); r.setListofRules("MNOP");
		 */
		ruleAPI.createRule(r);
		Rule ru = ruleAPI.getRule(r.getId());
		Assert.assertEquals("Rashid", ru.getRuleName());
	}
	@Test
	public void testDeleteRule() {
		//RuleAPI api = new RuleAPI();
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
	//RuleAPI ruleAPI = new RuleAPI();
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
