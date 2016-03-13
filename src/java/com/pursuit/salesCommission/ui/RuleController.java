
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
		return new ModelAndView("simpRuleDetails", "command", new RuleSimple());
	}

	@RequestMapping(value = "/submitSimpRule", method = RequestMethod.POST)
	public String addRule(@ModelAttribute("SpringWeb") Rule rule, ModelMap model) {
			model.addAttribute("Id", rule.getId());
			model.addAttribute("RuleName", rule.getRuleName());
			model.addAttribute("Description", rule.getDescription());
			model.addAttribute("RuleType", rule.getRuleType());
			model.addAttribute("RuleDetails", rule.getRuleDetails());
			model.addAttribute("Parameters", rule.getRuleSimple().getRuleParameter());
			model.addAttribute("CalculationMode", rule.getRuleSimple().getCalculationMode());
			model.addAttribute("PopulationType", rule.getRuleSimple().getPopulationType());
			model.addAttribute("PopulationUpto", rule.getRuleSimple().getPopulationUpto());
			model.addAttribute("AggregateFunction", rule.getRuleSimple().getAggregateFunctions());
			model.addAttribute("QualifyingClause", rule.getRuleSimple().getQualifyingClause());
			model.addAttribute("CompensationType", rule.getCompensationType());
			model.addAttribute("CompensationFormula", rule.getCompensationFormula());
			model.addAttribute("CompensationParameter", rule.getCompensationParameter());
			
			
			logger.debug("A NEW rule HAS CREATED" + rule);
		return "redirect:/SimpRuleList";
	}


	@RequestMapping(value = "/SimpRuleList", method = RequestMethod.GET)
	public String listSimpRules(ModelMap model) {
		model.addAttribute("rule", new Rule());
		model.addAttribute("listRule", ruleApi.listRules());
		logger.debug("A NEW List HAS CREATED");
		return "compRule";
	}
	
	
	@RequestMapping(value = "/compositeRule", method = RequestMethod.GET)
	public ModelAndView ruleComp() {
		logger.debug("RENDERING TO Rule FORM LOAD PAGE");
		return new ModelAndView("ruleDetails", "command", new RuleSimple());
	}
	
	@RequestMapping(value = "/submitCompRule", method = RequestMethod.POST)
	public String addcompRule(@ModelAttribute("SpringWeb") Rule rule, ModelMap model) {
			model.addAttribute("Id", rule.getId());
			model.addAttribute("RuleName", rule.getRuleName());
			model.addAttribute("Description", rule.getDescription());
			model.addAttribute("RuleType", rule.getRuleType());
			model.addAttribute("RuleDetails", rule.getRuleDetails());
			model.addAttribute("RuleConnectedAs", rule.getConnectionType());
			model.addAttribute("CompensationType", rule.getCompensationType());
			model.addAttribute("CompensationFormula", rule.getCompensationFormula());
			model.addAttribute("CompensationParameter", rule.getCompensationParameter());
			
			logger.debug("A NEW rule HAS CREATED" + rule);
		return "redirect:/compRuleList";
	}


	@RequestMapping(value = "/compRuleList", method = RequestMethod.GET)
	public String listCompRules(ModelMap model) {
		model.addAttribute("rule", new Rule());
		model.addAttribute("listRule", ruleApi.listRules());
		logger.debug("A NEW List HAS CREATED");
		return "compRule";
	}
	
	
	
	
	
	
	
	
	
}
