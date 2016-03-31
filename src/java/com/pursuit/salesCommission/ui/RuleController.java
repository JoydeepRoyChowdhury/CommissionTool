
package com.pursuit.salesCommission.ui;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import com.pursuit.salesCommission.app.api.RuleAPI;
import com.pursuit.salesCommission.app.api.RuleSimpleAPI;

import com.pursuit.salesCommission.app.model.RuleSimple;
import com.pursuit.salesCommission.app.model.RuleUI;
import com.pursuit.salesCommission.app.model.AggregateFunctions;
import com.pursuit.salesCommission.app.model.ConditionList;
import com.pursuit.salesCommission.app.model.Employee;
import com.pursuit.salesCommission.app.model.FieldList;
import com.pursuit.salesCommission.app.model.ParameterUI;
import com.pursuit.salesCommission.app.model.Person;
import com.pursuit.salesCommission.app.model.Person1;
import com.pursuit.salesCommission.app.model.PersonListContainer;
import com.pursuit.salesCommission.app.model.PersonListContainer1;
import com.pursuit.salesCommission.app.model.PersonListContainer2;
import com.pursuit.salesCommission.app.model.QualifyingClause;
import com.pursuit.salesCommission.app.model.QualifyingClauseUI;
import com.pursuit.salesCommission.app.model.Rule;
import com.pursuit.salesCommission.app.model.RuleParameter;

@Controller
public class RuleController {
	@Autowired
	private RuleAPI ruleApi;
	@Autowired
	private RuleSimpleAPI ruleSimpleApi;
	

	@RequestMapping(value = "/simpleRule", method = RequestMethod.GET)
	public String simpleRule(ModelMap model, HttpSession session,  HttpServletRequest request, String message ) {
	   
		  if( session.getAttribute("personListContainer") == null )
	            session.setAttribute("personListContainer", getDummyPersonListContainer());
	        model.addAttribute("personListContainer", (PersonListContainer)session.getAttribute("personListContainer"));
	        
		
	            session.setAttribute("personListContainer1", getDummyPersonListContainer1());
	        model.addAttribute("personListContainer1", (PersonListContainer1)session.getAttribute("personListContainer1"));
	        
		
		model.addAttribute("listRule1", ruleSimpleApi.listOfAggregateFunctions());
		model.addAttribute("listRule2",ruleSimpleApi.listOfFields());
		model.addAttribute("listRule3",ruleSimpleApi.listOfConditions());
		System.out.println(".......servlet running.......");
		return "simpRuleDetails";
	}
	
	  private PersonListContainer getDummyPersonListContainer() {
	        List<RuleParameter> personList = new ArrayList<RuleParameter>();
	        for( int i=0; i<1; i++ ) {
	           personList.add(new RuleParameter() );
	        }
	        return new PersonListContainer(personList);
	    }
	  
	  private PersonListContainer1 getDummyPersonListContainer1() {
	        List<QualifyingClauseUI> personList = new ArrayList<QualifyingClauseUI>();
	        for( int i=0; i<1; i++ ) {
	            personList.add( new QualifyingClauseUI() );
	        }
	        return new PersonListContainer1();
	    }

	@RequestMapping(value = "/submitSimpRule", method = RequestMethod.POST)
	public String addRule(@ModelAttribute("SpringWeb") RuleUI ruleUI, PersonListContainer personListContainer,PersonListContainer1 personListContainer1, HttpSession session, ModelMap model) {
	
	       for( RuleParameter p : personListContainer.getPersonList() ) {
	            System.out.println("ParameterName: " + p.getParameterName());
	            System.out.println("ParameterValue: " + p.getParameterValue());
	        }
	        session.setAttribute("personListContainer",personListContainer);
	       
	        for( QualifyingClauseUI p : personListContainer1.getPersonList() ) {
	            System.out.println("QualifyingClauseValue: " + p.getValue());
	            System.out.println("ConditionValue: " + p.getConditionValue());
	            System.out.println("FieldName: " + p.getFieldName());
	            //System.out.println("field: " + p.getParameter());
	        }
	        session.setAttribute("personListContainer1",personListContainer1);
		 
	        
	        //model.addAttribute("conditionValue",ruleUI.getConditionValue());
	      //  System.out.println("***************************" +ruleUI.getConditionValue());
	       // model.addAttribute("fieldName",ruleUI.getFieldName());
	       // System.out.println("***************************" +ruleUI.getFieldName());
			model.addAttribute("id", ruleUI.getId());
			model.addAttribute("ruleName", ruleUI.getRuleName());
			System.out.println("***************************" +ruleUI.getRuleName());
			model.addAttribute("description", ruleUI.getDescription());
			System.out.println("***************************" +ruleUI.getDescription());
			model.addAttribute("ruleDetails", ruleUI.getRuleDetails());
			model.addAttribute("ruleType", ruleUI.getRuleType());
									
			model.addAttribute("rankCount", ruleUI.getRankCount());
			model.addAttribute("rankType", ruleUI.getRankType());
			model.addAttribute("populationType", ruleUI.getPopulationType());
			model.addAttribute("populationUpto", ruleUI.getPopulationUpto());
			
			model.addAttribute("compensationType", ruleUI.getCompensationType());
			model.addAttribute("fixedCompValue", ruleUI.getFixedCompValue() );
			model.addAttribute("compensationFormula", ruleUI.getCompensationFormula());
			model.addAttribute("compensationParameter", ruleUI.getCompensationParameter());
			model.addAttribute("calculationMode", ruleUI.getCalculationMode());
			System.out.println("***************************" +ruleUI.getCalculationMode());
			model.addAttribute("aggregateFunctions", ruleUI.getAggregateFunctions());
			System.out.println("***************************" +ruleUI.getAggregateFunctions());

		
			
			Rule rule = new Rule();
			
			rule.setId(ruleUI.getId());
			rule.setRuleName(ruleUI.getRuleName());
			rule.setDescription(ruleUI.getDescription());
			rule.setRuleDetails(ruleUI.getRuleDetails());
			rule.setRuleType(ruleUI.getRuleType());
			rule.setCompensationType(ruleUI.getCompensationType());
			rule.setFixedCompValue(ruleUI.getFixedCompValue());
			rule.setCompensationFormula( ruleUI.getCompensationFormula());
			rule.setCompensationParameter(ruleUI.getCompensationParameter());
			QualifyingClause obj1 = new QualifyingClause();
			ConditionList obj2 = new ConditionList();
			FieldList obj3 = new FieldList();
			RuleSimple ruleSimple = new RuleSimple();
		List<QualifyingClauseUI> ptr =  personListContainer1.getPersonList();
		List<QualifyingClause> ptr1 =  new ArrayList<>();
			for (Iterator iterator = ptr.iterator(); iterator.hasNext();) {
				QualifyingClauseUI qcui = (QualifyingClauseUI) iterator.next();		
				obj2.setConditionValue(qcui.getConditionValue());
			obj1.setConditionList(obj2);
			obj3.setFieldName(qcui.getFieldName());
			obj1.setFieldList(obj3);
			obj1.setValue(qcui.getValue());
			//System.out.println(ptr.size());
			ptr1.add(obj1);
			}
			
			ruleSimple.setQualifyingClause(ptr1);
			ruleSimple.setRuleParameter(personListContainer.getPersonList());
			ruleSimple.setRankCount(ruleUI.getRankCount());
			ruleSimple.setRankingType(ruleUI.getRankType());
			ruleSimple.setPopulationType(ruleUI.getPopulationType());
			ruleSimple.setPopulationUpto(ruleUI.getPopulationUpto());
			ruleSimple.setCalculationMode(ruleUI.getCalculationMode());
			//ruleSimple.setQualifyingClause(personListContainer1.getPersonList());
			//ruleSimple.setAggregateFunctions(ruleUI.getAggregateFunctions());
			rule.setRuleSimple(ruleSimple);
			
		
			ruleApi.createRule(rule);
			//logger.info("A NEW rule HAS CREATED" + rule);
		return "redirect:/RuleList";
	}
	
	/*
	@RequestMapping(value = "/SimpRuleList", method = RequestMethod.GET)
	public String listSimpRules(ModelMap model) {
		model.addAttribute("listRule", ruleApi.listRules());
		model.addAttribute("listSimpRule", ruleSimpleApi.listOfSimpleRules());
		//logger.info("A NEW List HAS CREATED");
		
		System.out.println("*****************ListDone**********************");
		return "compRule";
	}
	*/

	@RequestMapping(value = "/editSimple/{id}", method = RequestMethod.GET)
	public String EditSimpRule(@PathVariable("id") int id, ModelMap model, HttpSession session,  HttpServletRequest request, String message){
		model.addAttribute("listRule3", ruleApi.getRule(id));
		model.addAttribute("listRule1", ruleSimpleApi.listOfAggregateFunctions());
		model.addAttribute("listRule2",ruleSimpleApi.listOfFields());
		
		 if( session.getAttribute("personListContainer") == null )
	            session.setAttribute("personListContainer", getDummyPersonListContainer());
	        model.addAttribute("personListContainer", (PersonListContainer)session.getAttribute("personListContainer"));
	        if( message != null )
	            model.addAttribute("message", message);
	        model.addAttribute("cp", request.getContextPath());
		
	      
	        System.out.println("*****************ListDone**********************");
		return "EditSimple";
	}
	

	
	
	@RequestMapping(value = "/compositeRule", method = RequestMethod.GET)
	public String compRule(ModelMap map, HttpSession session,  HttpServletRequest request, String message) {
		map.addAttribute("listCompRule1", ruleApi.listRules());
		
		if( session.getAttribute("personListContainer2") == null )
            session.setAttribute("personListContainer2", getDummyPersonListContainer2());
        map.addAttribute("personListContainer2", (PersonListContainer2)session.getAttribute("personListContainer2"));
        if( message != null )
            map.addAttribute("message", message);
        map.addAttribute("cp", request.getContextPath());
 
		
		
		
		System.out.println(".......servlet running.......");
		return "ruleDetails";
	}
	
	
	private PersonListContainer2 getDummyPersonListContainer2() {
        List<Person1> personList = new ArrayList<Person1>();
        for( int i=0; i<1; i++ ) {
            personList.add( new Person1() );
        }
        return new PersonListContainer2();
    }
	
	
	@RequestMapping(value = "/submitCompRule", method = RequestMethod.POST)
	public String addRule2(@ModelAttribute("SpringWeb") RuleUI ruleUI, ModelMap model) {
			
		if (ruleUI.getId() != 0){
			model.addAttribute("id", ruleUI.getId());
			model.addAttribute("ruleName", ruleUI.getRuleName());
			model.addAttribute("description", ruleUI.getDescription());
			model.addAttribute("ruleType", ruleUI.getRuleType());
			model.addAttribute("connectionType", ruleUI.getConnectionType());
			model.addAttribute("compensationType", ruleUI.getCompensationType());
			model.addAttribute("fixedCompValue", ruleUI.getFixedCompValue() );
			model.addAttribute("compensationFormula", ruleUI.getCompensationFormula());
			model.addAttribute("compensationParameter", ruleUI.getCompensationParameter());
		}
		else{
			model.addAttribute("id", ruleUI.getId());
			model.addAttribute("ruleName", ruleUI.getRuleName());
			model.addAttribute("description", ruleUI.getDescription());
			model.addAttribute("ruleType", ruleUI.getRuleType());
			model.addAttribute("connectionType", ruleUI.getConnectionType());
			model.addAttribute("compensationType", ruleUI.getCompensationType());
			model.addAttribute("fixedCompValue", ruleUI.getFixedCompValue() );
			model.addAttribute("compensationFormula", ruleUI.getCompensationFormula());
			model.addAttribute("compensationParameter", ruleUI.getCompensationParameter());
		}
			
	Rule rule = new Rule();
			
			rule.setId(ruleUI.getId());
			rule.setRuleName(ruleUI.getRuleName());
			rule.setDescription(ruleUI.getDescription());
			rule.setRuleType(ruleUI.getRuleType());
			rule.setConnectionType(ruleUI.getConnectionType());
			rule.setCompensationType(ruleUI.getCompensationType());
			rule.setFixedCompValue(ruleUI.getFixedCompValue());
			rule.setCompensationFormula( ruleUI.getCompensationFormula());
			rule.setCompensationParameter(ruleUI.getCompensationParameter());

			ruleApi.createRule(rule);
		return "redirect:/RuleList";
	}
	
	
	@RequestMapping(value = "/RuleList", method = RequestMethod.GET)
	public String listRules(ModelMap model) {
		model.addAttribute("listRule", ruleApi.listRules());
		model.addAttribute("listSimpRule", ruleSimpleApi.listOfSimpleRules());
		//logger.info("A NEW List HAS CREATED");
		System.out.println("*****************ListDone**********************");
		return "compRule";
	}
	
	@RequestMapping(value = "/editComposite/{id}", method = RequestMethod.GET)
	public String EditCompRule(@PathVariable("id") int id, ModelMap model){
		model.addAttribute("listRule1", ruleApi.getRule(id));
		model.addAttribute("listRule2", ruleApi.listRules());
		model.addAttribute("listSimpRule", ruleSimpleApi.listOfSimpleRules());
		//logger.info("A NEW List HAS CREATED");
		System.out.println("*****************ListDone**********************");
		return "EditComposite";
	}
	
}
