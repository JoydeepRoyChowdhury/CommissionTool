/**
 * 
 */
package com.pursuit.salesCommission.app;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pursuit.salesCommission.app.api.RuleSimpleAPI;
import com.pursuit.salesCommission.app.model.ConditionList;
import com.pursuit.salesCommission.app.model.FieldList;
import com.pursuit.salesCommission.app.model.QualifyingClause;
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
	 * Test method for {@link com.pursuit.salesCommission.app.api.RuleSimpleAPI#createSimpleRule(com.pursuit.salesCommission.app.model.RuleSimple)}.
	 */
/*	@Test
	public void testCreateSimpleRule() {
		RuleSimple ruleSimple = new RuleSimple();
		ruleSimple.setCalculationMode("Individual");
		ruleSimple.setRankCount(5);
		ruleSimple.setRankingType("percentage");
		ruleSimple.setPopulationType("fixed");
		ruleSimple.setPopulationUpto(3);
		ruleSimple.setCompensationType("fixed");
		ruleSimple.setFixedCompValue("Comp value fixed");
		Rule rule = new Rule();
		rule.setRuleName("Rule1");
		rule.setRuleDetails("details of rule");
		rule.setRuleType("Simple");
		rule.setDescription("Description of rule");
		ruleSimple.setRule(rule);
		ruleSimpleApi.createSimpleRule(ruleSimple);
		//RuleSimple rSimple = ruleSimpleApi.getRuleSimple(ruleSimple.getId());
		//Assert.assertEquals("Individual",rSimple.getCalculationMode());
		Assert.assertNotNull(ruleSimple);
	}
*/	
/*	@Test
	public void testGetSimpleRule() {
		RuleSimple rsimp = ruleSimpleApi.getRuleSimple(4);
		Assert.assertEquals("Individual",rsimp.getCalculationMode());
	}
*/
	@Test
	public void testCreateQualifyingClause() {
		QualifyingClause qClause = new QualifyingClause();
		qClause.setValue("Qualifying Clause");
		FieldList fldlst1 = new FieldList();
		fldlst1.setFieldName("fieldlstvalue1");
		fldlst1.setDisplayName("hello");
		
		qClause.setFieldList(fldlst1);
		
		ConditionList cndlst1 = new ConditionList();
		cndlst1.setNotFlag(true);
		cndlst1.setConditionValue("condition1");
		qClause.setConditionList(cndlst1);
		
		ruleSimpleApi.createQualifyingClause(qClause);

		Assert.assertNotNull(qClause);
	} 
}
