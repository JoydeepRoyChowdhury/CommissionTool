package com.simpsoft.salesCommission.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import com.simpsoft.salesCommission.app.UImodel.CompArray;
import com.simpsoft.salesCommission.app.UImodel.EmployeeUI;
import com.simpsoft.salesCommission.app.UImodel.RoleUI;
import com.simpsoft.salesCommission.app.api.EmployeeAPI;
import com.simpsoft.salesCommission.app.api.RoleAPI;
import com.simpsoft.salesCommission.app.api.RuleAPI;
import com.simpsoft.salesCommission.app.api.RuleAssignmentAPI;
import com.simpsoft.salesCommission.app.model.Employee;
import com.simpsoft.salesCommission.app.model.Role;
import com.simpsoft.salesCommission.app.model.Rule;
import com.simpsoft.salesCommission.app.model.RuleAssignment;
import com.simpsoft.salesCommission.app.model.RuleAssignmentDetails;
import com.simpsoft.salesCommission.app.model.RuleParameter;
import com.simpsoft.salesCommission.app.unRelatedImp.CompArray2;
import com.simpsoft.salesCommission.app.unRelatedImp.CompArray3;

@Controller

public class TestCompController {
	@Autowired
	private RoleAPI roleApi;
	@Autowired
	private RuleAPI ruleApi;
	@Autowired
	private EmployeeAPI empApi;
	@Autowired
	private RuleAssignmentAPI ruleAssApi;

	@RequestMapping(value = "/compplan", method = RequestMethod.GET)
	public ModelAndView listRules(ModelMap model, HttpServletRequest request,HttpSession session, SessionStatus status) {

		roleApi.listOfRoles();
		ruleApi.listOfRules();

		model.addAttribute("listRole", roleApi.listOfRoles());
		model.addAttribute("listRules", ruleApi.listOfRules());

		CompArray obj = new CompArray();
		model.addAttribute("listRule1", obj.a1);
		System.out.println("The Value Is" + obj);

		CompArray2 obj2 = new CompArray2();
		model.addAttribute("listRule2", obj2.addRule());
		System.out.println("The Value Is" + obj2);

		CompArray3 obj3 = new CompArray3();
		model.addAttribute("listRule3", obj3.addRule());
		System.out.println("The Value Is" + obj3);
		
		
      
		RoleUI object = (RoleUI) request.getSession().getAttribute("roleName");
		if (object != null ) {
			RuleAssignment rAssdtail = ruleAssApi.searchAssignedRule(object.getRoleName());
			List<RuleAssignmentDetails> ptr1 = rAssdtail.getRuleAssignmentDetails();
			ArrayList<Rule> rl1 = new ArrayList<Rule>();
			List<RuleParameter> parameterList = new ArrayList<RuleParameter>();
			Iterator<RuleAssignmentDetails> it1 = ptr1.iterator();
			while (it1.hasNext()) {
				RuleAssignmentDetails rp = (RuleAssignmentDetails) it1.next();
				Rule r1 = rp.getRule();
				List<RuleParameter> ptr2 = r1.getRuleParameter();
				Iterator it = ptr2.iterator();
				while (it.hasNext()) {
					RuleParameter r2 = (RuleParameter) it.next();
					System.out.println(r2.getParameterName());
					System.out.println(r2.getParameterValue());
					parameterList.add(r2);
				}
				System.out.println(r1.getRuleName());
				System.out.println(r1.getId());
				rl1.add(r1);
			}
			
			model.addAttribute("List2", rl1);
		 	//System.out.println(".......servlet running.......");
			status.setComplete();
	        session.removeAttribute("roleName");
	       return new ModelAndView("CompPlan");	
		}

		EmployeeUI object1 = (EmployeeUI) request.getSession().getAttribute("EmployeeName");
		if(object1 != null) {

			RuleAssignment rAssdtail = ruleAssApi.searchAssignedRule(object1.getEmployeeName());
			List<RuleAssignmentDetails> ptr1 = rAssdtail.getRuleAssignmentDetails();
			ArrayList<RuleAssignmentDetails> ruleList1 = new ArrayList<RuleAssignmentDetails>();
			ArrayList<Rule> rl1 = new ArrayList<Rule>();
			List<RuleParameter> parameterList = new ArrayList<RuleParameter>();
			Iterator<RuleAssignmentDetails> it1 = ptr1.iterator();
			while (it1.hasNext()) {

				RuleAssignmentDetails rp = (RuleAssignmentDetails) it1.next();
				Rule r1 = rp.getRule();
				List<RuleParameter> ptr2 = r1.getRuleParameter();

				Iterator it = ptr2.iterator();
				while (it.hasNext()) {
					RuleParameter r = (RuleParameter) it.next();
					System.out.println(r.getParameterName());
					System.out.println(r.getParameterValue());
					parameterList.add(r);
				}
				System.out.println(r1.getRuleName());
				System.out.println(r1.getId());
				rl1.add(r1);
			}
			// model.addAttribute("List1",ruleList1);
			model.addAttribute("List2", rl1);
			status.setComplete();
	        session.removeAttribute("EmployeeName");
	        return new ModelAndView("CompPlan");	
		}
		
	return new ModelAndView("CompPlan");
      
	}
	
	@RequestMapping(value = "/searchemp", method = RequestMethod.POST)
	public String empSerch(@ModelAttribute("SpringWeb") Employee obj, HttpServletRequest request,
		HttpServletResponse response, ModelMap model) throws ServletException, IOException {
		model.addAttribute("EmployeeName", obj.getEmployeeName());
		System.out.println("#############################" + obj.getEmployeeName());
		EmployeeUI object1 = new EmployeeUI();
		object1.setEmployeeName(obj.getEmployeeName());
		request.getSession().setAttribute("EmployeeName", object1);
		return "redirect:/compplan";
	}
	
	@RequestMapping(value = "/Submitrole", method = RequestMethod.POST)
	public String addruleSerch(@ModelAttribute("SpringWeb") Role command, HttpServletRequest request,
		HttpServletResponse response, ModelMap model) throws ServletException, IOException {
		model.addAttribute("roleName", command.getRoleName());
		RoleUI object = new RoleUI();
		object.setRoleName(command.getRoleName());
		request.getSession().setAttribute("roleName", object);
		return "redirect:/compplan";

	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("SearchEmployee", "command", new Employee());
	}

	@RequestMapping(value = "/searchempimage", method = RequestMethod.POST)
	public String addempSerch(@ModelAttribute("SpringWeb") Employee obj1, ModelMap model) {
		model.addAttribute("EmployeeName", obj1.getEmployeeName());
		System.out.println("******************************" + obj1.getEmployeeName());
		empApi.searchEmployeesByName(obj1.getEmployeeName());
		model.addAttribute("listEmp", empApi.searchEmployeesByName(obj1.getEmployeeName()));

		/*
		 * model.addAttribute("select", obj1.getEmployeeName());
		 * System.out.println("#############################" +
		 * obj1.getEmployeeName());
		 * 
		 * 
		 * RuleAssignment rAssdtail =
		 * ruleAssApi.searchAssignedRule(obj1.getEmployeeName());
		 * 
		 * List<RuleAssignmentDetails> ptr1 =
		 * rAssdtail.getRuleAssignmentDetails();
		 * ArrayList<RuleAssignmentDetails> ruleList1 = new
		 * ArrayList<RuleAssignmentDetails>(); ArrayList<Rule> rl1 = new
		 * ArrayList<Rule>(); // ArrayList<Rule> rl2 = new ArrayList<Rule>();
		 * 
		 * List<RuleParameter> parameterList = new ArrayList<RuleParameter>();
		 * Iterator<RuleAssignmentDetails> it1 = ptr1.iterator(); while
		 * (it1.hasNext()) {
		 * 
		 * RuleAssignmentDetails rp = (RuleAssignmentDetails) it1.next(); Rule
		 * r1 = rp.getRule(); List<RuleParameter> ptr2 = r1.getRuleParameter();
		 * 
		 * Iterator it = ptr2.iterator(); while (it.hasNext()) { RuleParameter r
		 * = (RuleParameter) it.next();
		 * System.out.println(r.getParameterName());
		 * System.out.println(r.getParameterValue()); parameterList.add(r); }
		 * 
		 * // System.out.println(r1.getRuleParameter());
		 * System.out.println(r1.getRuleName()); System.out.println(r1.getId());
		 * 
		 * // System.out.println(rp.getRule()); // ruleList1.add(rp);
		 * rl1.add(r1);
		 * 
		 * } // model.addAttribute("List1",ruleList1);
		 * model.addAttribute("List2", rl1); model.addAttribute("List3",
		 * parameterList);
		 */
		System.out.println(".........successfully submit..........");
		return "SearchEmployee";
	}

	

}
