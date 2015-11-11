package com.pursuit.salesCommission.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pursuit.salesCommission.app.api.dao.EmployeeDao;
import com.pursuit.salesCommission.app.model.Employee;

@Controller
@RequestMapping("/test")
public class TestController {
 
	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping(method = RequestMethod.GET)
   public String printHello(ModelMap model) {
	   
      model.addAttribute("message", employeeDao.searchEmployee(new Employee()).size());

      return "hello";
   }

}