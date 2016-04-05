package com.simpsoft.salesCommission.ui;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pursuit.salesCommission.app.api.EmployeeAPI;
import com.pursuit.salesCommission.app.api.RoleAPI;
import com.pursuit.salesCommission.app.api.RuleAPI;
import com.pursuit.salesCommission.app.model.Employee;
import com.pursuit.salesCommission.app.model.Rule;

@Controller
public class TestCompController {
	@Autowired
	private RoleAPI roleApi;
	@Autowired
	private RuleAPI ruleApi;
	@Autowired
	private EmployeeAPI empApi;

	@RequestMapping(value = "/compplan", method = RequestMethod.GET)
	public ModelAndView listRules(ModelMap model) {
		
		roleApi.listOfRoles();
		ruleApi.listRules();
		
		model.addAttribute("listRole", roleApi.listOfRoles());
		model.addAttribute("listRules", ruleApi.listRules());
		
		System.out.println(".......servlet running.......");
		return new ModelAndView("CompPlan", "command", new Rule());
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView showForm() {
	return new ModelAndView("SearchEmployee", "command", new Employee());	
	}
	@RequestMapping(value = "/searchempimage", method = RequestMethod.POST)
	public String addempSerch(@ModelAttribute("SpringWeb") Employee obj1, ModelMap model) {
		model.addAttribute("EmployeeName", obj1.getEmployeeName());	
		System.out.println("********" + obj1.getEmployeeName());
		empApi.searchEmployeesByName(obj1.getEmployeeName());
		model.addAttribute("listEmp", empApi.searchEmployeesByName(obj1.getEmployeeName()));
		
		
		System.out.println(".........successfully submit..........");
				
	return "SearchEmployee";	
}

	
}
*/