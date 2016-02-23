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
		 Rule rul = api.getRule(1); 
		 Assert.assertEquals("ABCD", rul.getRuleName());
        
	} 
	
	@Test
	public void testAddRule() {
		RuleAPI api = new RuleAPI();
		int i = api.addRule("ABCD", "EFGH","XYZ","PQRS","MNOP");
		Assert.assertNotNull(i);
		Rule rul = api.getRule(i);
		Assert.assertEquals("ABCD", rul.getRuleName());
	}

	@Test
	public void testCreateRule() {
		RuleAPI api = new RuleAPI();
		Rule r = new Rule();
		
		r.setRuleName("ABCD");
		r.setDescription("EFGH");
		r.setRuleType("XYZ");
		r.setRulesConnectedas("PQRS");
		r.setListofRules("MNOP");
	    api.createRule(r);
	    Rule ru = api.getRule(r.getId());
	    Assert.assertEquals("ABCD", ru.getRuleName());
	     
	}
}
