/**
 * 
 */
package com.pursuit.salesCommission.app;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import junit.framework.TestCase;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pursuit.salesCommission.app.api.RuleAPI;
import com.pursuit.salesCommission.app.model.AggregateFunctions;
import com.pursuit.salesCommission.app.model.FieldList;
import com.pursuit.salesCommission.app.model.Rule;
import com.pursuit.salesCommission.app.model.RuleComposite;
import com.pursuit.salesCommission.app.model.RuleParameter;
import com.pursuit.salesCommission.app.model.RuleSimple;

/**
 * @author NEW2
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class RuleAPITest extends TestCase {
	@Autowired
	private RuleAPI ruleAPI;

	private Rule rule;

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
		rule = new Rule();
		rule.setRuleName("abcd");
		rule.setDescription("efgh");
		rule.setRuleDetails("Details of Rule");
		rule.setCompensationFormula("Compensation formula");
		rule.setCompensationParameter("Compensation Parameter");
		rule.setCompensationType("fixed");
		rule.setFixedCompValue(10);
		
	}

	
	 
	/**
	 * Test method for
	 * {@link com.pursuit.salesCommission.app.api.RuleAPI#getRule(long)}.
	 */

	/*
	 * @Test public void testGetRule() { fail("Not yet implemented"); }
	 */
	/**
	 * Test method for
	 * {@link com.pursuit.salesCommission.app.api.RuleAPI#createRule(com.pursuit.salesCommission.app.model.Rule)}
	 * .
	 */
	@Test
	public void testCreateRuleSimpleRank() {
		
		rule.setRuleType("s");
		RuleSimple ruleSimple = new RuleSimple();
		ruleSimple.setCalculationMode("r");
		ruleSimple.setPopulationType("Population Type");
		ruleSimple.setPopulationUpto(4);
		ruleSimple.setRankCount(5);
		ruleSimple.setRankingType("number");
		ruleSimple.setRuleParameter(new ArrayList<RuleParameter>());
		RuleParameter rl1 = new RuleParameter();
		RuleParameter rl2 = new RuleParameter();
		rl1.setParameterName("Parameter 1");
		rl1.setParameterValue("value 1");
		rl2.setParameterName("Parameter 2");
		rl2.setParameterValue("value 2");
		ruleSimple.getRuleParameter().add(rl1);
		ruleSimple.getRuleParameter().add(rl2);

		ruleSimple.setFieldList(new ArrayList<FieldList>());
		FieldList fld1 = new FieldList();
		FieldList fld2 = new FieldList();
		fld1.setFieldName("fld 1");
		fld1.setDisplayName("hii");
		fld2.setFieldName("fld 2");
		fld2.setDisplayName("hello");
		ruleSimple.getFieldList().add(fld1);
		ruleSimple.getFieldList().add(fld2);

		ruleSimple.setAggregateFunctions(new ArrayList<AggregateFunctions>());
		AggregateFunctions fn1 = new AggregateFunctions();
		AggregateFunctions fn2 = new AggregateFunctions();
		fn1.setFunctionName("Function 1");
		fn1.setFunctionName("Function 2");
		ruleSimple.getAggregateFunctions().add(fn1);
		ruleSimple.getAggregateFunctions().add(fn2);

		rule.setRuleSimple(ruleSimple);

		long ruleId = ruleAPI.createRule(rule);
		rule.setId(ruleId);
		Rule r = ruleAPI.getRule(ruleId);
		Assert.assertEquals("abcd", r.getRuleName());
		System.out.println("Running: testDummyRule");

	}
	/**
	 * Test method for
	 * {@link com.pursuit.salesCommission.app.api.RuleAPI#createRule(com.pursuit.salesCommission.app.model.Rule)}
	 * .
	 */
	@Test
	public void testCreateRuleComposite() {
		 rule.setRuleType("c");
		  RuleComposite ruleComposite = new RuleComposite(); RuleSimple simple1 =
		  new RuleSimple(); RuleSimple simple2 = new RuleSimple();
		  simple1.setCalculationMode("Individual");
		  simple2.setCalculationMode("Rank"); ruleComposite.setRuleSimple(new
		  ArrayList<RuleSimple>()); ruleComposite.getRuleSimple().add(simple1);
		  ruleComposite.getRuleSimple().add(simple2);
		  rule.setRuleComposite(ruleComposite); 
		  long ruleId = ruleAPI.createRule(rule);
		  rule.setId(ruleId);
			Rule r = ruleAPI.getRule(ruleId);
			Assert.assertEquals("abcd", r.getRuleName());
			Assert.assertEquals("Composite", r.getRuleType());
			System.out.println("Running: testDummyRule");
		System.out.println("Running: testDummyRule");

	}

	/**
	 * Test method for
	 * {@link com.pursuit.salesCommission.app.api.RuleAPI#createRule(com.pursuit.salesCommission.app.model.Rule)}
	 * .
	 */
	@Test
	public void testCreateRuleSimpleIndv() {
		
		rule.setRuleType("s");
		RuleSimple ruleSimple = new RuleSimple();
		ruleSimple.setCalculationMode("i");
		

		ruleSimple.setRuleParameter(new ArrayList<RuleParameter>());
		RuleParameter rl1 = new RuleParameter();
		RuleParameter rl2 = new RuleParameter();
		rl1.setParameterName("Parameter 3");
		rl1.setParameterValue("value 3");
		rl2.setParameterName("Parameter 4");
		rl2.setParameterValue("value 4");
		ruleSimple.getRuleParameter().add(rl1);
		ruleSimple.getRuleParameter().add(rl2);

		ruleSimple.setFieldList(new ArrayList<FieldList>());
		FieldList fld1 = new FieldList();
		FieldList fld2 = new FieldList();
		fld1.setFieldName("fld 3");
		fld1.setDisplayName("fii");
		fld2.setFieldName("fld 3");
		fld2.setDisplayName("fello");
		ruleSimple.getFieldList().add(fld1);
		ruleSimple.getFieldList().add(fld2);

		ruleSimple.setAggregateFunctions(new ArrayList<AggregateFunctions>());
		AggregateFunctions fn1 = new AggregateFunctions();
		AggregateFunctions fn2 = new AggregateFunctions();
		fn1.setFunctionName("Function 3");
		fn1.setFunctionName("Function 4");
		ruleSimple.getAggregateFunctions().add(fn1);
		ruleSimple.getAggregateFunctions().add(fn2);

		rule.setRuleSimple(ruleSimple);

		long ruleId = ruleAPI.createRule(rule);
		rule.setId(ruleId);
		Rule r = ruleAPI.getRule(ruleId);
		Assert.assertEquals("abcd", r.getRuleName());
		System.out.println("Running: testDummyRule");

	}	
	/**
	 * Test method for
	 * {@link com.pursuit.salesCommission.app.api.RuleAPI#listRules()}.
	 */
	/*
	 * @Test public void testListRules() { fail("Not yet implemented"); }
	 * 
	 */
	
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
