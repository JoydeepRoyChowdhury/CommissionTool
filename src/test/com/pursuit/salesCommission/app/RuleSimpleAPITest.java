/**
 * 
 */
package com.pursuit.salesCommission.app;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pursuit.salesCommission.app.api.EmployeeAPI;
import com.pursuit.salesCommission.app.api.RuleSimpleAPI;
import com.pursuit.salesCommission.app.model.Rule;
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
	 * Test method for {@link com.pursuit.salesCommission.app.api.RuleSimpleAPI#createSimpleRule(com.pursuit.salesCommission.app.model.RuleSimple)}.
	 */
	@Test
	public void testCreateSimpleRule() {
		RuleSimple ruleSimple = new RuleSimple();
		ruleSimple.setCalculationMode("Individual");
		Rule rule = new Rule();
		rule.setRuleName("Rule1");
		rule.setRuleDetails("details of rule");
		rule.setRuleType("Simple");
		rule.setDescription("Description of rule");
		ruleSimple.setRule(rule);
		ruleSimpleApi.createSimpleRule(ruleSimple);
		Assert.assertNotNull(ruleSimple);
	}

}
