package com.pursuit.salesCommission.ui;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pursuit.salesCommission.app.api.dao.EmployeeDao;
import com.pursuit.salesCommission.app.model.Employee;
import com.pursuit.salesCommission.app.model.GoogleResults;
import com.pursuit.salesCommission.app.model.ResponseData;
import com.pursuit.salesCommission.app.model.Result;

@Controller
// @RequestMapping("/test")
public class TestControllerUI {

	@Autowired
	private EmployeeDao employeeDao;
	private HibernateTemplate template;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String printResult(ModelMap model) throws IOException {
		String google = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
		String search = "Sourav";
		String charset = "UTF-8";

		URL url = new URL(google + URLEncoder.encode(search, charset));
		Reader reader = new InputStreamReader(url.openStream(), charset);
		GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);

		model.addAttribute("message", results.getResponseData().getResults().get(0).getUrl());
		// model.addAttribute("message", "hello");
		return "testResult";
	}

	@RequestMapping(value = "/jsonresponse", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("responseUI", "command", new Employee());
	}

	/*
	 * @RequestMapping(value = "/jsonresponse1", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public List<Result> check(HttpServletRequest request,
	 * HttpServletResponse response,
	 * 
	 * @ModelAttribute("SpringWeb") Result res, ModelMap model) throws
	 * IOException, IOException { String google =
	 * "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q="; String
	 * charset = "UTF-8";
	 * 
	 * URL url = new URL(google +
	 * URLEncoder.encode(request.getParameter("name"), charset)); Reader reader
	 * = new InputStreamReader(url.openStream(), charset); GoogleResults result
	 * = new Gson().fromJson(reader, GoogleResults.class);
	 * 
	 * GoogleResults res1 = new GoogleResults();
	 * res1.setResponseData(result.getResponseData()); //
	 * System.out.println(res1.getResponseData());
	 * 
	 * for (Result result1 : res1.getResponseData().getResults()) {
	 * result1.setContent(result1.getContent()); } ResponseData res2 = new
	 * ResponseData(); res2.setResults(res1.getResponseData().getResults()); //
	 * System.out.println(res2.getResults()); int size =
	 * res2.getResults().size();
	 * 
	 * List<Result> result1 = new ArrayList<>(); for (int j = 0; j <= size - 1;
	 * j++) { result1.add(res2.getResults().get(j)); } return result1;
	 * 
	 * }
	 */

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView employee() {
		return new ModelAndView("employee", "command", new Employee());
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("SpringWeb") Employee employee, ModelMap model) {
		model.addAttribute("id", employee.getId());
		model.addAttribute("name", employee.getName());
		model.addAttribute("salary", employee.getSalary());
		model.addAttribute("role", employee.getRole());
		model.addAttribute("startDate", employee.getStartDate());
		model.addAttribute("termDate", employee.getTermDate());
		model.addAttribute("managerId", employee.getManagerId());
		employeeDao.saveEmployee(employee);

		return "result";
	}

	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	@ResponseBody
	public Collection<Employee> employeeList(@ModelAttribute("SpringWeb") Employee employee, ModelMap model) {
		System.out.println("Hello    ----    " + employee.getId());
		
		return employeeDao.searchEmployee(employee);
	}

}