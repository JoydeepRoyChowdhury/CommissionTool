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
public class TestController {
	

	@RequestMapping(value = "/CompRule", method = RequestMethod.GET)
	public ModelAndView rule1() {
		return new ModelAndView("compRule", "command", new Rule());
	}
	@RequestMapping(value = "/submitCompRuleEdit", method = RequestMethod.GET)
	public ModelAndView rule2() {
		return new ModelAndView("ruleDetails", "command", new Rule());
	}
	@RequestMapping(value = "/submitSimpRule", method = RequestMethod.GET)
	public ModelAndView rule3() {
		return new ModelAndView("simpRuleDetails", "command", new Rule());
	}
	
}
