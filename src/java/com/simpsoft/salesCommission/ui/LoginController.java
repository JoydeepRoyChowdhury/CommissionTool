package com.simpsoft.salesCommission.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simpsoft.salesCommission.app.UImodel.Login;
import com.simpsoft.salesCommission.app.api.EmployeeAPI;
import com.simpsoft.salesCommission.app.model.Employee;

@Controller
public class LoginController extends HttpServlet {
	
	@Autowired
	private EmployeeAPI empApi;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("login", "command", new Login());
	}
	 @RequestMapping(value = "/submitLogin", method = RequestMethod.POST)
		 public String SubmitLogin(@ModelAttribute("SpringWeb") Login login, HttpServletRequest request,
				  HttpServletResponse response, ModelMap model) throws ServletException, IOException {
	        model.addAttribute("userName", login.getUserName());
	        Employee emp = empApi.searchEmployee(login.getUserName());
	        String obj = emp.getEmployeeName();
			request.getSession().setAttribute("employee",obj);
	        String ename = emp.getEmployeeName();
	        String uname = login.getUserName();
	        System.out.println(obj);
	        System.out.println(uname);
	        System.out.println(login.getUserName());
	        String password = login.getPassword();
	        if ((password != null) && (password.equals("12345")) && (uname.equals(ename))){
	            model.put("user", login.getUserName());
	            return "hello";
	        } else {
	            model.put("error", "Invalid UserName / Password");
	            return "login";
	        }
	 
	    } 
	 
	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
	 public void Logout(@ModelAttribute("SpringWeb") Login login, HttpServletRequest request,
			  HttpServletResponse response, ModelMap model) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);
		 if(session != null)
		     session.invalidate();
		 request.getRequestDispatcher("/login").forward(request,response);
		 
		}
} 
