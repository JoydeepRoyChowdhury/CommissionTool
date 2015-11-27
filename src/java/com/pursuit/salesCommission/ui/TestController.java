package com.pursuit.salesCommission.ui;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pursuit.salesCommission.app.api.dao.EmployeeDao;
import com.pursuit.salesCommission.app.model.Employee;
import com.pursuit.salesCommission.app.model.GoogleResults;

@Controller
// @RequestMapping("/test")
public class TestController {

	@Autowired
	private EmployeeDao employeeDao;
	private List<GoogleResults> resultList = new ArrayList<GoogleResults>();

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

	/*
	 * @RequestMapping(value="/jsonresponse",method = RequestMethod.POST)
	 * public @ResponseBody Employee add(HttpServletRequest request,
	 * HttpServletResponse response) throws Exception {
	 * 
	 * Employee employee = new Employee();
	 * 
	 * String name = request.getParameter("name"); Integer id =
	 * Integer.valueOf(request.getParameter("id")); float salary =
	 * Integer.valueOf(request.getParameter("salary"));
	 * 
	 * employee.setId(id); employee.setName(name); employee.setSalary(salary);
	 * 
	 * return employee; }
	 */
	@RequestMapping(value = "/jsonresponse", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("response", "command", new Employee());
	}



	@RequestMapping(value = "/jsonresponse1", method = RequestMethod.GET)

	@ResponseBody
	public String check(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
		String google = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
		//String search = "Sourav";
		String charset = "UTF-8";

		URL url = new URL(google + URLEncoder.encode(request.getParameter("name"), charset));
		Reader reader = new InputStreamReader(url.openStream(), charset);
		GoogleResults result = new Gson().fromJson(reader, GoogleResults.class);
		/*System.out.println(result);
		List<GoogleResults> resultList = new ArrayList<GoogleResults>();
		GoogleResults res= new GoogleResults();
		int length= result.getResponseData().getResults().size();
		for(int i=0; i<=length-1;i++){
			resultList.add(res);	
		}
		//System.out.println(name);*/
	
		String message= result.getResponseData().getResults().get(0).getTitle();//model.addAttribute("id", employee.getId());
        
        return message;
    
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