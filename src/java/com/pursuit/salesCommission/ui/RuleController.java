package com.pursuit.salesCommission.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pursuit.salesCommission.app.api.RuleAPI;
import com.pursuit.salesCommission.app.model.Rule;

@Controller
public class RuleController {
	@Autowired
	private RuleAPI ruleAPI;

	@RequestMapping(value = "/rule", method = RequestMethod.GET)
	public ModelAndView rule1() {

		return new ModelAndView("Rule", "command", new Rule());
	}

	@RequestMapping(value = "/submitRule", method = RequestMethod.POST)
	public String addRule(@ModelAttribute("SpringWeb") Rule rul, ModelMap model) {
		//RuleAPI ruleAPI = new RuleAPI();
		System.out.println("hello..............................************");

		if (rul.getId() != 0) {
			model.addAttribute("id", rul.getId());
			model.addAttribute("rulName", rul.getRuleName());
			model.addAttribute("description", rul.getDescription());
			model.addAttribute("ruleType", rul.getRuleType());
			ruleAPI.editRule(rul);
		} else {

			model.addAttribute("Id", rul.getId());
			model.addAttribute("RuleName", rul.getRuleName());
			model.addAttribute("Description", rul.getDescription());
			model.addAttribute("RuleType", rul.getRuleType());
			ruleAPI.createRule(rul);
		}
		return "redirect:/ruleList";
	}

	@RequestMapping(value = "/ruleList", method = RequestMethod.GET)
	public String listRules(ModelMap model) {
		//RuleAPI ruleAPI = new RuleAPI();
		model.addAttribute("rule", new Rule());
		model.addAttribute("listRule", ruleAPI.listRules());
		System.out.println("hello  its working");
		return "RuleList";
	}

	@RequestMapping("/deleteRule/{id}")
	public String removeRule(@PathVariable("id") int id, Rule rul, ModelMap model) {
		//RuleAPI ruleAPI = new RuleAPI();
		ruleAPI.deleteRule(id);
		return "redirect:/ruleList";
	}

	@RequestMapping("/editRule/{id}")
	public String editRule(@PathVariable("id") int id, ModelMap model) {
		//RuleAPI ruleAPI = new RuleAPI();
		model.addAttribute("rule", ruleAPI.getRule(id));
		model.addAttribute("listRule", ruleAPI.listRules());

		return "editRule";

	}

}
