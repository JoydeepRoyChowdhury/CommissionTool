
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
import com.pursuit.salesCommission.app.model.Rule;

@Controller
public class RuleController {
	@Autowired
	private RuleAPI ruleApi;
	
	private static final Logger logger = Logger.getLogger(RuleController.class);

	@RequestMapping(value = "/simpleRule", method = RequestMethod.GET)
	public ModelAndView ruleSimp() {
		logger.debug("RENDERING TO Rule FORM LOAD PAGE");
		return new ModelAndView("simpRuleDetails", "command", new Rule());
	}

	@RequestMapping(value = "/submitSimpRule", method = RequestMethod.POST)
	public String addRule(@ModelAttribute("SpringWeb") RuleUI ruleUI, ModelMap model) {
			model.addAttribute("id", ruleUI.getId());
			model.addAttribute("ruleName", ruleUI.getRuleName());
			model.addAttribute("ruleName", ruleUI.getDescription());
			model.addAttribute("ruleDetails", ruleUI.getRuleDetails());
			model.addAttribute("ruleType", ruleUI.getRuleType());
			//model.addAttribute("parameters", rule.getRuleSimple().getRuleParameter());
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
			ruleSimple.setCalculationMode(ruleUI.getCalculationMode());
			rule.setRuleSimple(ruleSimple);
			ruleApi.createRule(rule);
			
			logger.info("A NEW rule HAS CREATED" + rule);
		return "redirect:/SimpRuleList";
	}


	@RequestMapping(value = "/SimpRuleList", method = RequestMethod.GET)
	public String listRules(ModelMap model) {
		model.addAttribute("rule", new Rule());
		model.addAttribute("listRule", ruleApi.listRules());
		//logger.info("A NEW List HAS CREATED");
		System.out.println("*****************ListDone**********************");
		return "hello1";
	}
	
	
}
