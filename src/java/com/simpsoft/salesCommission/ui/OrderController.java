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
import com.simpsoft.salesCommission.app.UImodel.RuleUI;
import com.simpsoft.salesCommission.app.api.OrderAPI;
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
                    Scanner scan = null;
            		try{
            			scan = new Scanner(new File(saveDirectory + fileName));
            			while(scan.hasNextLine()){
            				System.out.println(scan.nextLine());
            			}
            		}
            		catch (FileNotFoundException e){
            			e.printStackTrace();
            		}
                    fileNames.add(fileName);
                }
            }
        }
 
        map.addAttribute("files", fileNames);
        return "redirect:/importOrders";
    }
	

	@RequestMapping(value = "/orderDetails", method = RequestMethod.GET)
	public String OrderDetails(ModelMap model, HttpSession session, HttpServletRequest request) {
		//model.addAttribute("listOrder", orderApi.listOfOrderRosters());
		return "OrderDetails";
	}



}

