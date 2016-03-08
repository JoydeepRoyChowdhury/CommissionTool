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
public class RuleAPITest {
	@Autowired
	private RuleAPI ruleAPI;
	/**
	 * @throws java.lang.Exception
	 */
/*	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
*/
	/**
	 * @throws java.lang.Exception
	 */
/*	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
*/
	/**
	 * @throws java.lang.Exception
	 */
/*	@Before
	public void setUp() throws Exception {
	}
*/
	/**
	 * @throws java.lang.Exception
	 */
/*	@After
	public void tearDown() throws Exception {
	}
*/
	/**
	 * Test method for {@link com.pursuit.salesCommission.app.api.RuleAPI#getRule(long)}.
	 */
/*	@Test
	public void testGetRule() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link com.pursuit.salesCommission.app.api.RuleAPI#createRule(com.pursuit.salesCommission.app.model.Rule)}.
	 */
	@Test
	public void testCreateRule1() {
		Rule r = new Rule();
		r.setRuleName("abcd");
		r.setDescription("efgh");
		r.setRuleDetails("Details of Rule");
		r.setCompensationFormula("Compensation formula");
		r.setCompensationParameter("Compensation Parameter");
		r.setCompensationType("fixed");
		r.setFixedCompValue(1000);
		r.setFlag("s");
		
		RuleSimple ruleSimple = new RuleSimple();
		ruleSimple.setCalculationMode("Individual");
		ruleSimple.setCompensationType("Compensation Type");
		ruleSimple.setFixedCompValue("Fixed Comensation Value");
		ruleSimple.setPopulationType("Population Type");
		ruleSimple.setPopulationUpto(4);
		
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
		
		r.setRuleSimple(ruleSimple);
		
		ruleAPI.createRule(r);
		//Rule ru = ruleAPI.getRule(r.getId());
		//Assert.assertEquals("abcd", ru.getRuleName());
		Assert.assertNotNull(r);

	} 
	/**
	 * Test method for {@link com.pursuit.salesCommission.app.api.RuleAPI#createRule(com.pursuit.salesCommission.app.model.Rule)}.
	 */
	@Test
	public void testCreateRule2() {
		Rule r = new Rule();
		r.setRuleName("abcd");
		r.setDescription("efgh");
		r.setFlag("c");
		RuleComposite ruleComposite = new RuleComposite();
		RuleSimple simple1 = new RuleSimple();
		RuleSimple simple2 = new RuleSimple();
		simple1.setCalculationMode("Individual");
		simple2.setCalculationMode("Rank");
		ruleComposite.setRuleSimple(new ArrayList<RuleSimple>());
		ruleComposite.getRuleSimple().add(simple1);
		ruleComposite.getRuleSimple().add(simple2);
		r.setRuleComposite(ruleComposite);
		ruleAPI.createRule(r);
		//Rule ru = ruleAPI.getRule(r.getId());
		//Assert.assertEquals("abcd", ru.getRuleName());
		Assert.assertNotNull(r);

	} 
	/**
	 * Test method for {@link com.pursuit.salesCommission.app.api.RuleAPI#listRules()}.
	 */
/*	@Test
	public void testListRules() {
		fail("Not yet implemented");
	}
*/
}
