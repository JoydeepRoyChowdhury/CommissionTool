package com.simpsoft.salesCommission.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.simpsoft.salesCommission.app.api.OrderAPI;
import com.simpsoft.salesCommission.app.model.Employee;
import com.simpsoft.salesCommission.app.model.OrderRoster;
import com.simpsoft.salesCommission.app.model.RuleParameter;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrderController {
	
	@Autowired
	private OrderAPI orderApi;

	//private static final Logger logger = Logger.getLogger(EmployeeController.class);

	@RequestMapping(value = "/importOrders", method = RequestMethod.GET)
	public String ImportOrder(ModelMap model, HttpSession session, HttpServletRequest request) {
		List<OrderRoster> orm = orderApi.listOfOrderRosters();
		model.addAttribute("listOrder", orm);		
		return "Orders";
	}

	@RequestMapping(value = "/orderDetails", method = RequestMethod.GET)
	public String OrderDetails(ModelMap model, HttpSession session, HttpServletRequest request) {
		//model.addAttribute("listOrder", orderApi.listOfOrderRosters());
		return "OrderDetails";
	}



}

