/*package com.simpsoft.salesCommission.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.simpsoft.salesCommission.app.api.RoleAPI;

import com.simpsoft.salesCommission.app.model.Role;

@Controller
public class RoleController {
	@Autowired
	private RoleAPI roleApi;

	@RequestMapping(value = "/role", method = RequestMethod.GET)
	public ModelAndView role1() {
		System.out.println(".......servlet running.......");
		return new ModelAndView("addRole", "command", new Role());
	}

	@RequestMapping(value = "/submitRole", method = RequestMethod.POST)
	public String addRole(@ModelAttribute("SpringWeb") Role role, ModelMap model) {
		if (role.getId() != 0) {

			model.addAttribute("id", role.getId());
			model.addAttribute("RoleName", role.getRoleName());
			model.addAttribute("Description", role.getDescription());
			//model.addAttribute("ReportTo", role.getReportTo());
			roleApi.editRole(role);
		} else {

			model.addAttribute("id", role.getId());
			model.addAttribute("RoleName", role.getRoleName());
			model.addAttribute("Description", role.getDescription());
			//model.addAttribute("ReportTo", role.getReportTo());

			roleApi.createRole(role);

		}
		System.out.println(".........successfully submit..........");
		return "redirect:/roleList";

	}

	@RequestMapping(value = "/roleList", method = RequestMethod.GET)
	public String listRoles(ModelMap model) {
		model.addAttribute("role", new Role());
		model.addAttribute("listRole", roleApi.listRoles());
		System.out.println("working");
		System.out.println(".........list done..........");
		return "gridTest";
	}

	@RequestMapping("/deleterole/{id}")
	public String deleterole(@PathVariable("id") int id, Role role, ModelMap model) {
		roleApi.deleteRole(id);
		System.out.println(".........deleted..........");
		return "redirect:/roleList";
	}

	@RequestMapping("/editRole/{id}")
	public String editRole(@PathVariable("id") int id, ModelMap model) {
		model.addAttribute("role", roleApi.getRole(id));
		model.addAttribute("listRole", roleApi.listRoles());
		System.out.println(".........edit role running..........");
		return "testedit";
	}

} */
