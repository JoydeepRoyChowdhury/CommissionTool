package com.pursuit.salesCommission.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.pursuit.salesCommission.app.api.EmployeeAPI;
import com.pursuit.salesCommission.app.model.Employee;

@Controller
public class EmployeeController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView employee1() {
		return new ModelAndView("addEmployee", "command", new Employee());
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String addEmployee1(@ModelAttribute("SpringWeb") Employee employee, ModelMap model) {
		EmployeeAPI empApi = new EmployeeAPI();
		if (employee.getId() != 0) {
			model.addAttribute("id", employee.getId());
			model.addAttribute("firstName", employee.getFirstName());
			model.addAttribute("lastName", employee.getLastName());
			model.addAttribute("salary", employee.getSalary());
			// model.addAttribute("role", employee.getRole());
			// model.addAttribute("startDate", employee.getStartDate());
			// model.addAttribute("termDate", employee.getTermDate());
			// model.addAttribute("managerId", employee.getManagerId());
			empApi.editEmployee(employee);
		} else {
			model.addAttribute("id", employee.getId());
			model.addAttribute("firstName", employee.getFirstName());
			model.addAttribute("lastName", employee.getLastName());
			model.addAttribute("salary", employee.getSalary());
			// model.addAttribute("role", employee.getRole());
			// model.addAttribute("startDate", employee.getStartDate());
			// model.addAttribute("termDate", employee.getTermDate());
			// model.addAttribute("managerId", employee.getManagerId());
			empApi.createEmployee(employee);
			
		}

		return "redirect:/employeeList";

	}

	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {
		EmployeeAPI empApi = new EmployeeAPI();
		model.addAttribute("employee", new Employee());
		model.addAttribute("listEmployee", empApi.listEmployees());
		return "empList";
	}

	@RequestMapping("/removeEmployee/{id}")
	public String removeEmployee(@PathVariable("id") int id, Employee employee, ModelMap model) {
		EmployeeAPI empApi = new EmployeeAPI();
		empApi.deleteEmployee(id);
		return "redirect:/employeeList";
	}

	@RequestMapping("/editEmployee/{id}")
	public String editEmployee(@PathVariable("id") int id, ModelMap model) {
		EmployeeAPI empApi = new EmployeeAPI();
		model.addAttribute("employee", empApi.getEmployee(id));
		model.addAttribute("listEmployee", empApi.listEmployees());
		return "editEmployee";
	}
}