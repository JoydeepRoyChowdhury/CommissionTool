/**
 * 
 */
package com.pursuit.salesCommission.app;


import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pursuit.salesCommission.app.api.RuleSimpleAPI;
import com.pursuit.salesCommission.app.model.AggregateFunctions;
import com.pursuit.salesCommission.app.model.ConditionList;
import com.pursuit.salesCommission.app.model.FieldList;
import com.pursuit.salesCommission.app.model.RuleSimple;

/**
 * @author User
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class RuleSimpleAPITest {

	@Autowired
	private RuleSimpleAPI ruleSimpleApi;

	/**
	 * Test method for
	 * {@link com.pursuit.salesCommission.app.api.RuleSimpleAPI#createSimpleRule(com.pursuit.salesCommission.app.model.RuleSimple)}
	 * .
	 */

	/*
	 * @Test public void testGetSimpleRule() {
	 * 
	 * RuleSimple rsimp = ruleSimpleApi.getRuleSimple(4);
	 * Assert.assertEquals("Individual",rsimp.getCalculationMode()); }
	 */

	@Test
	public void testlistOfSimpleRules() {

		List<RuleSimple> api = ruleSimpleApi.listOfSimpleRules();
		Assert.assertEquals(1, api.size());
	}

	@Test
	public void testlistOfAggregateFunctions() {

		List<AggregateFunctions> api = ruleSimpleApi.listOfAggregateFunctions();
		for (Iterator iterator = api.iterator(); iterator.hasNext();) {
			AggregateFunctions agrFn = (AggregateFunctions) iterator.next();
			System.out.println("GET THE RULE DETAILS FROM DATABASE     " + agrFn.getId() + agrFn.getFunctionName());

		}
		Assert.assertEquals(2, api.size());
	}

	@Test
	public void testlistOfConditions() {

		List<ConditionList> api = ruleSimpleApi.listOfConditions();
		Assert.assertEquals(1, api.size());
	}

	@Test
	public void testlistOfFields() {

		List<FieldList> api = ruleSimpleApi.listOfFields();
		Assert.assertEquals(3, api.size());
	}

}
