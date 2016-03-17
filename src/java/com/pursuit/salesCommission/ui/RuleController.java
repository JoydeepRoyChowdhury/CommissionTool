
package com.pursuit.salesCommission.ui;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import com.pursuit.salesCommission.app.api.RuleAPI;
import com.pursuit.salesCommission.app.api.RuleSimpleAPI;

import com.pursuit.salesCommission.app.model.RuleSimple;
import com.pursuit.salesCommission.app.model.RuleUI;
import com.pursuit.salesCommission.app.model.AggregateFunctions;
import com.pursuit.salesCommission.app.model.ParameterUI;
import com.pursuit.salesCommission.app.model.Rule;

@Controller
public class RuleController {
	@Autowired
	private RuleAPI ruleApi;
	@Autowired
	private RuleSimpleAPI obj;
	
	
	@RequestMapping(value = "/simpleRule", method = RequestMethod.GET)
	public String simpleRule(ModelMap model) {
		model.addAttribute("listRule1", obj.listOfAggregateFunctions());
		model.addAttribute("listRule2", obj.listOfFields());
		
		System.out.println(".......servlet running.......");
		return "simpRuleDetails";
	}

	@RequestMapping(value = "/submitSimpRule", method = RequestMethod.POST)
	public String addRule(@ModelAttribute("SpringWeb") RuleUI ruleUI, ModelMap model) {
			model.addAttribute("id", ruleUI.getId());
			model.addAttribute("ruleName", ruleUI.getRuleName());
			model.addAttribute("description", ruleUI.getDescription());
			model.addAttribute("ruleDetails", ruleUI.getRuleDetails());
			model.addAttribute("ruleType", ruleUI.getRuleType());
									
			model.addAttribute("rankCount", ruleUI.getRankCount());
			model.addAttribute("rankType", ruleUI.getRankType());
			model.addAttribute("populationType", ruleUI.getPopulationType());
			model.addAttribute("populationUpto", ruleUI.getPopulationUpto());
			
			model.addAttribute("compensationType", ruleUI.getCompensationType());
			model.addAttribute("fixedCompValue", ruleUI.getFixedCompValue() );
			model.addAttribute("compensationFormula", ruleUI.getCompensationFormula());
			model.addAttribute("compensationParameter", ruleUI.getCompensationParameter());
			model.addAttribute("calculationMode", ruleUI.getCalculationMode());
			
			
			Rule rule = new Rule();
			
			rule.setId(ruleUI.getId());
			rule.setRuleName(ruleUI.getRuleName());
			rule.setDescription(ruleUI.getDescription());
			rule.setRuleDetails(ruleUI.getRuleDetails());
			rule.setRuleType(ruleUI.getRuleType());
			rule.setCompensationType(ruleUI.getCompensationType());
			rule.setFixedCompValue(ruleUI.getFixedCompValue());
			rule.setCompensationFormula( ruleUI.getCompensationFormula());
			rule.setCompensationParameter(ruleUI.getCompensationParameter());
			
			
			RuleSimple ruleSimple = new RuleSimple();
			
			ruleSimple.setRankCount(ruleUI.getRankCount());
			ruleSimple.setRankingType(ruleUI.getRankType());
			ruleSimple.setPopulationType(ruleUI.getPopulationType());
			ruleSimple.setPopulationUpto(ruleUI.getPopulationUpto());
			ruleSimple.setCalculationMode(ruleUI.getCalculationMode());
			
			rule.setRuleSimple(ruleSimple);
			
		
			ruleApi.createRule(rule);
			//logger.info("A NEW rule HAS CREATED" + rule);
		return "redirect:/SimpRuleList";
	}


	@RequestMapping(value = "/SimpRuleList", method = RequestMethod.GET)
	public String listRules(ModelMap model) {
		//model.addAttribute("rule", new Rule());
		model.addAttribute("listRule", ruleApi.listRules());
		//logger.info("A NEW List HAS CREATED");
		System.out.println("*****************ListDone**********************");
		return "hello1";
	}
	
	
	@RequestMapping(value = "/compositeRule", method = RequestMethod.GET)
	public String compRule(ModelMap model) {
		model.addAttribute("listCompRule1", ruleApi.listRules());
		System.out.println(".......servlet running.......");
		return "ruleDetails";
	}
	

	@RequestMapping(value = "/submitCompRule", method = RequestMethod.POST)
	public String addRule2(@ModelAttribute("SpringWeb") RuleUI ruleUI, ModelMap model) {
			model.addAttribute("id", ruleUI.getId());
			model.addAttribute("ruleName", ruleUI.getRuleName());
			model.addAttribute("description", ruleUI.getDescription());
			model.addAttribute("ruleType", ruleUI.getRuleType());
			model.addAttribute("connectionType", ruleUI.getConnectionType());
			model.addAttribute("compensationType", ruleUI.getCompensationType());
			model.addAttribute("fixedCompValue", ruleUI.getFixedCompValue() );
			model.addAttribute("compensationFormula", ruleUI.getCompensationFormula());
			model.addAttribute("compensationParameter", ruleUI.getCompensationParameter());
									
			
	Rule rule = new Rule();
			
			rule.setId(ruleUI.getId());
			rule.setRuleName(ruleUI.getRuleName());
			rule.setDescription(ruleUI.getDescription());
			rule.setRuleType(ruleUI.getRuleType());
			rule.setConnectionType(ruleUI.getConnectionType());
			rule.setCompensationType(ruleUI.getCompensationType());
			rule.setFixedCompValue(ruleUI.getFixedCompValue());
			rule.setCompensationFormula( ruleUI.getCompensationFormula());
			rule.setCompensationParameter(ruleUI.getCompensationParameter());

			ruleApi.createRule(rule);
		return "redirect:/SimpRuleList";
	}
	
}
