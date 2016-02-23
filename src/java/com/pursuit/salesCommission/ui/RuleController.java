package com.pursuit.salesCommission.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pursuit.salesCommission.app.model.Rule;

@Controller
public class RuleController {
	
	@RequestMapping(value = "/rule", method = RequestMethod.GET)
	public ModelAndView rule1() {
		return new ModelAndView("Rule", "command", new Rule());
	}

}
