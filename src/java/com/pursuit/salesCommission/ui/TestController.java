package com.pursuit.salesCommission.ui;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.google.gson.Gson;
import com.pursuit.salesCommission.app.api.dao.EmployeeDao;
import com.pursuit.salesCommission.app.model.Employee;
import com.pursuit.salesCommission.app.model.GoogleResults;

@Controller
// @RequestMapping("/test")
public class TestController {

	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String printHello(ModelMap model) throws IOException {
		String google = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
	    String search = "Sourav";
	    String charset = "UTF-8";

	    URL url = new URL(google + URLEncoder.encode(search, charset));
	    Reader reader = new InputStreamReader(url.openStream(), charset);
	    GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);
		//model.addAttribute("message", employeeDao.searchEmployee(new Employee()).size());
	    model.addAttribute("message", results.getResponseData().getResults().get(0).getUrl());
		//model.addAttribute("message", "hello");
		return "testResult";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView employee() {
		return new ModelAndView("employee", "command", new Employee());
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("SpringWeb") Employee employee, ModelMap model) {
		model.addAttribute("id", employee.getId());
		model.addAttribute("name", employee.getName());
		model.addAttribute("salary", employee.getSalary());
		employeeDao.saveEmployee(employee);

		return "result";
	}

}