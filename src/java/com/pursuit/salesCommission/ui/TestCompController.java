package com.pursuit.salesCommission.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pursuit.salesCommission.app.api.RoleAPI;
import com.pursuit.salesCommission.app.model.CompArray;
import com.pursuit.salesCommission.app.model.Role;

@Controller
public class TestCompController {
	@Autowired
	private RoleAPI roleApi;

	@RequestMapping(value = "/compplan", method = RequestMethod.GET)
	public ModelAndView listRules(ModelMap model) {
		CompArray obj = new CompArray();
		roleApi.listOfRoles();
		model.addAttribute("listRule", obj.addRule());
		model.addAttribute("listRole", roleApi.listOfRoles());
		System.out.println(".......servlet running.......");
		return new ModelAndView("CompPlan", "command", new Role());
		// return "CompPlan";
	}

	// @RequestMapping(value = "/compPlan", method = RequestMethod.GET)
	// public String listRules(ModelMap model) {
	// System.out.println(".......Yes servlet is running.......");
	// CompArray obj = new CompArray();
	// model.addAttribute("listRule", obj.addRule());
	// return "CompPlan";

	// }
}
