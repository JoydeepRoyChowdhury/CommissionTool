package com.pursuit.salesCommission.ui;

import java.util.LinkedHashMap;

import org.hibernate.mapping.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pursuit.salesCommission.app.model.Role;
import com.pursuit.salesCommission.app.model.empSerch;

@Controller
public class TestCompController {
	

	
	 @RequestMapping(value = "/employeeSearch", method = RequestMethod.GET)
		public ModelAndView showForm() {
			return new ModelAndView("SearchEmployee", "command", new empSerch());	
		}
	


@RequestMapping(value = "/submitempSerch", method = RequestMethod.POST)
	public String addempSerch(@ModelAttribute("SpringWeb") empSerch obj1, ModelMap model) {
		model.addAttribute("EmployeeName", obj1.getEmp());	
			System.out.println("********" + obj1.getEmp());
			return "hello";

}

}
