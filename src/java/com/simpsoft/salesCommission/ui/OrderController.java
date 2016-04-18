package com.simpsoft.salesCommission.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.simpsoft.salesCommission.app.UImodel.FileList;
import com.simpsoft.salesCommission.app.UImodel.PersonListContainer;
import com.simpsoft.salesCommission.app.UImodel.PersonListContainer1;
import com.simpsoft.salesCommission.app.UImodel.RuleUI;
import com.simpsoft.salesCommission.app.api.EmployeeAPI;
import com.simpsoft.salesCommission.app.api.OrderAPI;
import com.simpsoft.salesCommission.app.model.OrderDetail;
import com.simpsoft.salesCommission.app.model.OrderRoster;
import com.simpsoft.salesCommission.app.model.RuleParameter;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	
	private void msgbox(String s){
		   JOptionPane.showMessageDialog(null, s);
		}
	
	@RequestMapping(value = "/savefiles", method = RequestMethod.POST)
    public String crunchifySave(@ModelAttribute("uploadForm") FileList uploadForm, Model map) throws IllegalStateException, IOException {
        String saveDirectory = "c:/NewFile/";
 
        List<MultipartFile> fileList = uploadForm.getFiles();
 
        List<String> fileNames = new ArrayList<String>();
 
        if (null != fileList && fileList.size() > 0) {
            for (MultipartFile multipartFile : fileList) {
 
                String fileName = multipartFile.getOriginalFilename();
                if (!"".equalsIgnoreCase(fileName)) {
                  // System.out.println(multipartFile.getInputStream());
                   System.out.println( multipartFile.getSize());
                    multipartFile.transferTo(new File(saveDirectory + fileName));
                    orderApi.importOrders(multipartFile.getInputStream());
                }
            }
        }
        
        map.addAttribute("files", fileNames);
        return "redirect:/importOrders";
    }
	/*
	@RequestMapping(value = "/submitId", method = RequestMethod.POST)
	public String addRule(@ModelAttribute("SpringWeb")ImportOrderId id, ModelMap model) {
		model.addAttribute("importId" ,id.getId());
		System.out.println(id.getId());		
		
		return "redirect:/orderDetails";
		
	}
	*/

	@RequestMapping(value = "/orderDetails/{id}", method = RequestMethod.GET) 
	public String OrderDetails(@PathVariable("id") int id, ModelMap model, HttpSession session,
			HttpServletRequest request) {
		//model.addAttribute("listOrder", orderApi.listOfOrderRosters());
		OrderRoster ors = orderApi.getOrderRoster(id);
		List<OrderDetail> ord = ors.getOrderDetail();
		List<OrderDetail> ord1 = new ArrayList<OrderDetail>();
		Iterator it = ord.iterator();	 
	    while(it.hasNext()) {
	    	OrderDetail ord2 = (OrderDetail)it.next();
	      System.out.println(ord2.getId());
	      System.out.println(ord2.getOrderDate());
	      ord1.add(ord2);
	    }
	    model.addAttribute("ordetails", ord1);
		return "OrderDetails";
	}

}

