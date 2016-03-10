
package com.pursuit.salesCommission.ui;

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

	@RequestMapping(value = "/rule", method = RequestMethod.GET)
	public ModelAndView rule1() {
		System.out.println(".......servlet running.......");
		return new ModelAndView("simpRuleDetails", "command", new RuleSimple());
	}

	@RequestMapping(value = "/submitSimpRule", method = RequestMethod.POST)
	public String addRule(@ModelAttribute("SpringWeb") Rule rule, ModelMap model) {
		
			model.addAttribute("Id", rule.getId());
			model.addAttribute("RuleName", rule.getRuleName());
			model.addAttribute("Description", rule.getDescription());
			model.addAttribute("RuleType", rule.getRuleType());
			model.addAttribute("RuleDetails", rule.getRuleDetails());
			//model.addAttribute("CalculationMode", rule);
			//model.addAttribute("RankCount", rulesimple.getRankCount());
			//model.addAttribute("RankingType", rulesimple.getRankingType());
			//model.addAttribute("PopulationType", rulesimple.getPopulationType());
			//model.addAttribute("CompensationType", rulesimple.getCompensationType());
			//model.addAttribute("FixedCompValue", rulesimple.getFixedCompValue());
			ruleApi.createRule(rule);

		
		return "redirect:/ruleList";
	}


	@RequestMapping(value = "/ruleList", method = RequestMethod.GET)
	public String listRules(ModelMap model) {
		model.addAttribute("rule", new Rule());
		model.addAttribute("listRule", ruleApi.listRules());
		System.out.println("..........working..........");
		return "hello1";
	}
}
