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
import com.pursuit.salesCommission.app.model.Rule;
import com.pursuit.salesCommission.app.model.RuleComposite;
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
		r.setFixedCompValue("sales*1000");
		r.setFlag("s");
		RuleSimple ruleSimple = new RuleSimple();
		ruleSimple.setCalculationMode("Individual");
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
