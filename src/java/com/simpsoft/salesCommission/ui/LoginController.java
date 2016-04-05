package com.simpsoft.salesCommission.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simpsoft.salesCommission.app.UImodel.Login;
//import javax.validation.Valid;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("login", "command", new Login());
	}
	 @RequestMapping(value = "/submit", method = RequestMethod.POST)
	    public String submit( @ModelAttribute("SpringWeb") Login login, ModelMap modelMap)  {
	        System.out.println("in submit" + login);
	        
	        String password = login.getPassword();
	        if (password != null && password.equals("12345")) {
	            modelMap.put("user", login.getUserName());
	            return "hello";
	        } else {
	            modelMap.put("error", "Invalid UserName / Password");
	            return "login";
	        }
	 
	    } 
} 
