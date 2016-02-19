package com.pursuit.salesCommission.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		 model.addAttribute("id", employee.getId());
		 model.addAttribute("firstName", employee.getFirstName());
		 model.addAttribute("lastName", employee.getLastName());
		 model.addAttribute("salary", employee.getSalary());
		 System.out.println("hello  "+employee.getFirstName());
		//model.addAttribute("role", employee.getRole());
		//model.addAttribute("startDate", employee.getStartDate());
		//model.addAttribute("termDate", employee.getTermDate());
		//model.addAttribute("managerId", employee.getManagerId());
		 EmployeeAPI empApi = new EmployeeAPI();
		empApi.createEmployee(employee);

		return "hello1";
	}
	
	 @RequestMapping(value = "/empList", method = RequestMethod.GET)
	    public String listEmployees(ModelMap model) {
		 EmployeeAPI empApi = new EmployeeAPI();
	        model.addAttribute("employee", new Employee());
	        model.addAttribute("listEmployee", empApi.listEmployees());
	        return "empList";
	    }

}