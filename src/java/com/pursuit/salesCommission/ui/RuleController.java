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

import com.pursuit.salesCommission.app.model.Rule;

@Controller
public class RuleController {
	@Autowired
	private RuleAPI ruleApi;

	@RequestMapping(value = "/rule", method = RequestMethod.GET)
	public ModelAndView rule1() {
		System.out.println(".......servlet running.......");
		return new ModelAndView("Rule", "command", new Rule());
	}

	@RequestMapping(value = "/submitRule", method = RequestMethod.POST)
	public String addRule(@ModelAttribute("SpringWeb") Rule rule, ModelMap model) {
		if (rule.getId() != 0) {

			model.addAttribute("Id", rule.getId());
			model.addAttribute("RuleName", rule.getRuleName());
			model.addAttribute("Description", rule.getDescription());
			//model.addAttribute("RuleType", rule.getRuleType());
			//ruleApi.editRule(rule);
		} else {

			model.addAttribute("Id", rule.getId());
			model.addAttribute("RuleName", rule.getRuleName());
			model.addAttribute("Description", rule.getDescription());
			//model.addAttribute("RuleType", rule.getRuleType());

			//ruleApi.createRule(rule);

		}
		System.out.println(".........successfully submit..........");
		return "redirect:/ruleList";

	}

	@RequestMapping(value = "/ruleList", method = RequestMethod.GET)
	public String listRules(ModelMap model) {
		model.addAttribute("rule", new Rule());
		model.addAttribute("listRule", ruleApi.listRules());
		System.out.println("working");
		System.out.println(".........list done..........");
		return "RuleList";
	}

	@RequestMapping("/deleteRule/{id}")
	public String deleterule(@PathVariable("id") int id, Rule rule, ModelMap model) {
		//ruleApi.deleteRule(id);
		System.out.println(".........deleted..........");
		return "redirect:/ruleList";
	}

	@RequestMapping("/editRule/{id}")
	public String editRule(@PathVariable("id") int id, ModelMap model) {
		model.addAttribute("rule", ruleApi.getRule(id));
		model.addAttribute("listRule", ruleApi.listRules());
		System.out.println(".........edit rule running..........");
		return "editRule";
	}

}
