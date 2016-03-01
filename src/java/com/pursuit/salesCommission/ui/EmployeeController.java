package com.pursuit.salesCommission.ui;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
		private EmployeeAPI employeeApi;
	
	private static final Logger logger = Logger.getLogger(EmployeeController.class);
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView employee() {
		
		logger.debug("RENDERING TO EPLOYEE FORM LOAD PAGE");
		return new ModelAndView("addEmployee", "command", new Employee());
	}

	@RequestMapping(value = "/submitEmployee", method = RequestMethod.POST)
	public String addEmployee1(@ModelAttribute("SpringWeb") Employee employee, ModelMap model) {
		
		if (employee.getId() != 0) {
			model.addAttribute("id", employee.getId());
			model.addAttribute("firstName", employee.getFirstName());
			model.addAttribute("lastName", employee.getLastName());
			model.addAttribute("salary", employee.getSalary());
			// model.addAttribute("role", employee.getRole());
			// model.addAttribute("startDate", employee.getStartDate());
			// model.addAttribute("termDate", employee.getTermDate());
			// model.addAttribute("managerId", employee.getManagerId());
			employeeApi.editEmployee(employee);
			logger.debug("EDITED AN EMPLOYEE INTO DATABASE" + employee);
		} else {
			model.addAttribute("id", employee.getId());
			model.addAttribute("firstName", employee.getFirstName());
			model.addAttribute("lastName", employee.getLastName());
			model.addAttribute("salary", employee.getSalary());
			// model.addAttribute("role", employee.getRole());
			// model.addAttribute("startDate", employee.getStartDate());
			// model.addAttribute("termDate", employee.getTermDate());
			// model.addAttribute("managerId", employee.getManagerId());
			employeeApi.createEmployee(employee);
			logger.debug("A NEW EMPLOYEE HAS CREATED" + employee);
			
		}

		return "redirect:/employeeList";

	}

	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("listEmployee", employeeApi.listEmployees());
		return "empList";
	}

	@RequestMapping("/removeEmployee/{id}")
	public String removeEmployee(@PathVariable("id") int id, Employee employee, ModelMap model) {
		employeeApi.deleteEmployee(id);
		return "redirect:/employeeList";
	}

	@RequestMapping("/editEmployee/{id}")
	public String editEmployee(@PathVariable("id") int id, ModelMap model) {
		model.addAttribute("employee", employeeApi.getEmployee(id));
		model.addAttribute("listEmployee", employeeApi.listEmployees());
		return "editEmployee";
	}
}