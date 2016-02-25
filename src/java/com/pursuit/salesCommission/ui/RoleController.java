package com.pursuit.salesCommission.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.pursuit.salesCommission.app.api.EmployeeAPI;
import com.pursuit.salesCommission.app.api.RoleAPI;
import com.pursuit.salesCommission.app.model.Employee;
import com.pursuit.salesCommission.app.model.Role;

@Controller
public class RoleController {
	/*
}
	@RequestMapping(value = "/role", method = RequestMethod.GET)
	public ModelAndView role1() {
		System.out.println("hello..............................************");
		return new ModelAndView("addRole", "command", new Role());
	}
	@RequestMapping(value = "/submitRole", method = RequestMethod.POST)
	public String addRole(@ModelAttribute("SpringWeb") Role role, ModelMap model) {
		RoleAPI obj1 = new RoleAPI();
		System.out.println("hello............................................");
		*if (role.getId() != 0) {
			model.addAttribute("id", role.getId());
			model.addAttribute("RoleName", role.getRoleName());
			model.addAttribute("Description", role.getDescription());
			model.addAttribute("ReportTo", role.getReportTo());
			
			obj1.addRole(role);
		} else {/ 
		model.addAttribute("id", role.getId());
			model.addAttribute("RoleName", role.getRoleName());
			model.addAttribute("Description", role.getDescription());
			model.addAttribute("ReportTo", role.getReportTo());
			
			obj1.createRole(role);
			
		//}
		return "redirect:/roleList";
	
	}	
	@RequestMapping(value = "/roleList", method = RequestMethod.GET)
	public String listRoles(ModelMap model) {
		RoleAPI empApi = new RoleAPI();
		model.addAttribute("role", new Role());
		model.addAttribute("listRole", empApi.listRoles());
		return "Rolelist";
	}
	*/
}

