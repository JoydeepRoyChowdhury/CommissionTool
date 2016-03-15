
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
	public String addRule(@ModelAttribute("SpringWeb") Rule rule, ModelMap model) {
			model.addAttribute("id", rule.getId());
			model.addAttribute("ruleName", rule.getRuleName());
			model.addAttribute("ruleName", rule.getDescription());
			model.addAttribute("ruleDetails", rule.getRuleDetails());
			model.addAttribute("ruleType", rule.getRuleType());
			//model.addAttribute("parameters", rule.getRuleSimple().getRuleParameter());
			model.addAttribute("compensationType", rule.getCompensationType());
			model.addAttribute("fixedCompValue", rule.getFixedCompValue() );
			model.addAttribute("compensationFormula", rule.getCompensationType());
			model.addAttribute("compensationParameter", rule.getCompensationParameter());
			model.addAttribute("calculationMode", rule.getRuleSimple().getCalculationMode());
			
			
			
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
