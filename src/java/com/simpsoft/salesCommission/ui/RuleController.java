
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import com.simpsoft.salesCommission.app.api.RuleAPI;
import com.simpsoft.salesCommission.app.api.RuleSimpleAPI;

import com.simpsoft.salesCommission.app.model.RuleSimple;
import com.simpsoft.salesCommission.app.model.RuleType;
import com.simpsoft.salesCommission.app.UImodel.RuleUI;
import com.simpsoft.salesCommission.app.model.AggregateFunctions;
import com.simpsoft.salesCommission.app.model.ConditionList;
import com.simpsoft.salesCommission.app.model.FieldList;
import com.simpsoft.salesCommission.app.UImodel.ParameterUI;
import com.simpsoft.salesCommission.app.UImodel.Person1;
import com.simpsoft.salesCommission.app.UImodel.PersonListContainer;
import com.simpsoft.salesCommission.app.UImodel.PersonListContainer1;
import com.simpsoft.salesCommission.app.UImodel.PersonListContainer2;
import com.simpsoft.salesCommission.app.model.QualifyingClause;
import com.simpsoft.salesCommission.app.UImodel.QualifyingClauseUI;
import com.simpsoft.salesCommission.app.model.Rule;
import com.simpsoft.salesCommission.app.model.RuleComposite;
import com.simpsoft.salesCommission.app.model.RuleParameter;

@Controller
public class RuleController {
	@Autowired
	private RuleAPI ruleApi;
	@Autowired
	private RuleSimpleAPI ruleSimpleApi;

	@RequestMapping(value = "/simpleRule", method = RequestMethod.GET)
	public String simpleRule(ModelMap model, HttpSession session, HttpServletRequest request, String message) {

		if ((session.getAttribute("personListContainer") == null) && (session.getAttribute("personListContainer1") == null)){
			session.setAttribute("personListContainer", getDummyPersonListContainer());
			session.setAttribute("personListContainer1", getDummyPersonListContainer1());
		}
		//session.setAttribute("personListContainer1", getDummyPersonListContainer1());
		model.addAttribute("personListContainer1", (PersonListContainer1) session.getAttribute("personListContainer1"));
		model.addAttribute("personListContainer", (PersonListContainer) session.getAttribute("personListContainer"));

		model.addAttribute("listRule1", ruleSimpleApi.listOfAggregateFunctions());
		model.addAttribute("listRule2", ruleSimpleApi.listOfFields());
		model.addAttribute("listRule3", ruleSimpleApi.listOfConditions());
		System.out.println(".......servlet running.......");
		return "simpRuleDetails";
	}

	private PersonListContainer getDummyPersonListContainer() {
		List<RuleParameter> personList = new ArrayList<RuleParameter>();
		for (int i = 0; i < 1; i++) {
			personList.add(new RuleParameter());
		}
		return new PersonListContainer(personList);
	}

	private PersonListContainer1 getDummyPersonListContainer1() {
		List<QualifyingClauseUI> personList = new ArrayList<QualifyingClauseUI>();
		for (int i = 0; i < 1; i++) {
			personList.add(new QualifyingClauseUI());
		}
		return new PersonListContainer1();
	}

	@RequestMapping(value = "/submitSimpRule", method = RequestMethod.POST)
	public String addRule(@ModelAttribute("SpringWeb") RuleUI ruleUI, PersonListContainer personListContainer,
			PersonListContainer1 personListContainer1, HttpSession session, ModelMap model) {

		for (RuleParameter p : personListContainer.getPersonList()) {
			System.out.println("ParameterName: " + p.getParameterName());
			System.out.println("ParameterValue: " + p.getParameterValue());
		}
		session.setAttribute("personListContainer", personListContainer);

		for (QualifyingClauseUI p : personListContainer1.getPersonList()) {
			System.out.println("QualifyingClauseValue: " + p.getValue());
			System.out.println("condition: " + p.getCondition());
			System.out.println("ConditionValue: " + p.getConditionValue());
			System.out.println("FieldName: " + p.getFieldName());

		}
		session.setAttribute("personListContainer1", personListContainer1);
		model.addAttribute("id", ruleUI.getId());
		model.addAttribute("ruleName", ruleUI.getRuleName());
		System.out.println("***************************" + ruleUI.getRuleName());
		model.addAttribute("description", ruleUI.getDescription());
		System.out.println("***************************" + ruleUI.getDescription());
		model.addAttribute("ruleDetails", ruleUI.getRuleDetails());
		model.addAttribute("ruleType", ruleUI.getRuleType());

		model.addAttribute("rankCount", ruleUI.getRankCount());
		model.addAttribute("rankType", ruleUI.getRankType());
		model.addAttribute("populationType", ruleUI.getPopulationType());
		model.addAttribute("populationUpto", ruleUI.getPopulationUpto());

		model.addAttribute("compensationType", ruleUI.getCompensationType());
		model.addAttribute("fixedCompValue", ruleUI.getFixedCompValue());
		model.addAttribute("compensationFormula", ruleUI.getCompensationFormula());
		model.addAttribute("compensationParameter", ruleUI.getCompensationParameter());
		model.addAttribute("calculationMode", ruleUI.getCalculationMode());
		System.out.println("***************************" + ruleUI.getCalculationMode());
		model.addAttribute("aggregateFunctions", ruleUI.getAggregateFunctions());
		System.out.println("***************************" + ruleUI.getAggregateFunctions());
		model.addAttribute("field", ruleUI.getField());
		System.out.println("***************************" + ruleUI.getField());

		Rule rule = new Rule();

		rule.setId(ruleUI.getId());
		rule.setRuleName(ruleUI.getRuleName());
		rule.setDescription(ruleUI.getDescription());
		rule.setRuleDetails(ruleUI.getRuleDetails());
		rule.setRuleType(ruleUI.getRuleType());
		rule.setCompensationType(ruleUI.getCompensationType());
		rule.setFixedCompValue(ruleUI.getFixedCompValue());
		rule.setCompensationFormula(ruleUI.getCompensationFormula());
		rule.setCompensationParameter(ruleUI.getCompensationParameter());
		rule.setRuleParameter(personListContainer.getPersonList());

		RuleSimple ruleSimple = new RuleSimple();
		List<QualifyingClauseUI> ptr = personListContainer1.getPersonList();
		List<QualifyingClause> ptr1 = new ArrayList<>();
		for (Iterator iterator = ptr.iterator(); iterator.hasNext();) {
			QualifyingClauseUI qcui = (QualifyingClauseUI) iterator.next();
			QualifyingClause obj1 = new QualifyingClause();
			FieldList fldList = ruleSimpleApi.searchFieldList(qcui.getFieldName());
			ConditionList cnd = ruleSimpleApi.searchCondition(qcui.getConditionValue());
			obj1.setConditionList(cnd);
			obj1.setFieldList(fldList);
			obj1.setValue(qcui.getValue());
			obj1.setNotFlag(qcui.getCondition());
			// System.out.println(ptr.size());
			ptr1.add(obj1);
		}
		AggregateFunctions agFun = ruleSimpleApi.searchAggregateFunction(ruleUI.getAggregateFunctions());

		ruleSimple.setQualifyingClause(ptr1);
		ruleSimple.setRankCount(ruleUI.getRankCount());
		ruleSimple.setRankingType(ruleUI.getRankType());
		ruleSimple.setPopulationType(ruleUI.getPopulationType());
		ruleSimple.setPopulationUpto(ruleUI.getPopulationUpto());
		ruleSimple.setCalculationMode(ruleUI.getCalculationMode());
		ruleSimple.setAggregateFunctions(agFun);
		ruleSimple.setField(ruleUI.getField());

		rule.setRuleSimple(ruleSimple);

		ruleApi.createRule(rule);
		// logger.info("A NEW rule HAS CREATED" + rule);
		return "redirect:/ruleList";
	}

	/*
	 * @RequestMapping(value = "/SimpRuleList", method = RequestMethod.GET)
	 * public String listSimpRules(ModelMap model) {
	 * model.addAttribute("listRule", ruleApi.listRules());
	 * model.addAttribute("listSimpRule", ruleSimpleApi.listOfSimpleRules());
	 * //logger.info("A NEW List HAS CREATED");
	 * 
	 * System.out.println("*****************ListDone**********************");
	 * return "compRule"; }
	 */

	@RequestMapping(value = "/editSimple/{id}", method = RequestMethod.GET)
	public String EditSimpRule(@PathVariable("id") int id, ModelMap model, HttpSession session,
			HttpServletRequest request, String message) {
		model.addAttribute("listRule1", ruleSimpleApi.listOfAggregateFunctions());
		model.addAttribute("listRule2", ruleSimpleApi.listOfFields());
		model.addAttribute("listRule3", ruleSimpleApi.listOfConditions());
		model.addAttribute("listRule4", ruleApi.getRule(id));
		Rule qRule = ruleApi.getRule(id);
		RuleSimple sRule = qRule.getRuleSimple();
		List<QualifyingClause> qList = sRule.getQualifyingClause();
		List<QualifyingClause> qualiCList = new ArrayList<QualifyingClause>();
		for (Iterator iterator = qList.iterator(); iterator.hasNext();) {
			QualifyingClause qcui = (QualifyingClause) iterator.next();
		      System.out.println(qcui.getValue());
		      System.out.println(qcui.isNotFlag());
		  qualiCList.add(qcui);
		}
		model.addAttribute("qualifyingList",qualiCList);
		
		
		
		Rule rule1 = ruleApi.getRule(id);
		List<RuleParameter> ptr = rule1.getRuleParameter();
		List<RuleParameter> parameterList = new ArrayList<RuleParameter>();
		Iterator it = ptr.iterator();	 
	    while(it.hasNext()) {
	    	RuleParameter rp = (RuleParameter)it.next();
	      System.out.println(rp.getParameterName());
	      System.out.println(rp.getParameterValue());
	      parameterList.add(rp);
	    }
	  model.addAttribute("parList",parameterList);

		if (session.getAttribute("personListContainer") == null)
			session.setAttribute("personListContainer", getDummyPersonListContainer());
		model.addAttribute("personListContainer", (PersonListContainer) session.getAttribute("personListContainer"));
		
		session.setAttribute("personListContainer1", getDummyPersonListContainer1());
		model.addAttribute("personListContainer1", (PersonListContainer1) session.getAttribute("personListContainer1"));
		System.out.println("*****************ListDone**********************");
		return "EditSimple";
	}

	@RequestMapping(value = "/compositeRule", method = RequestMethod.GET)
	public String compRule(ModelMap map, HttpSession session, HttpServletRequest request, String message) {
		map.addAttribute("listSimpRule", ruleApi.listOfRules(RuleType.Simple));

		if (session.getAttribute("personListContainer3") == null)
			session.setAttribute("personListContainer3", getDummyPersonListContainer3());
		map.addAttribute("personListContainer3", (PersonListContainer) session.getAttribute("personListContainer3"));

		session.setAttribute("personListContainer2", getDummyPersonListContainer2());
		map.addAttribute("personListContainer2", (PersonListContainer2) session.getAttribute("personListContainer2"));

		System.out.println(".......servlet running.......");
		return "ruleDetails";
	}

	private PersonListContainer getDummyPersonListContainer3() {
		List<RuleParameter> personList = new ArrayList<RuleParameter>();
		for (int i = 0; i < 1; i++) {
			personList.add(new RuleParameter());
		}
		return new PersonListContainer(personList);
	}

	private PersonListContainer2 getDummyPersonListContainer2() {
		List<Person1> personList = new ArrayList<Person1>();
		for (int i = 0; i < 1; i++) {
			personList.add(new Person1());
		}
		return new PersonListContainer2();
	}

	@RequestMapping(value = "/submitCompRule", method = RequestMethod.POST)
	public String addRule2(@ModelAttribute("SpringWeb") RuleUI ruleUI, PersonListContainer personListContainer, PersonListContainer2 personListContainer2,
			HttpSession session, ModelMap model) {
		for (Person1 p : personListContainer2.getPersonList()) {
			System.out.println("listOfSimpRule: " + p.getSimpRule());
		}
		session.setAttribute("personListContainer2", personListContainer2);
		for (RuleParameter p : personListContainer.getPersonList()) {
			System.out.println("ParameterName: " + p.getParameterName());
			System.out.println("ParameterValue: " + p.getParameterValue());
		}
		session.setAttribute("personListContainer3", personListContainer);

		model.addAttribute("id", ruleUI.getId());
		model.addAttribute("ruleName", ruleUI.getRuleName());
		model.addAttribute("description", ruleUI.getDescription());
		model.addAttribute("ruleType", ruleUI.getRuleType());
		model.addAttribute("connectionType", ruleUI.getConnectionType());
		model.addAttribute("compensationType", ruleUI.getCompensationType());
		model.addAttribute("fixedCompValue", ruleUI.getFixedCompValue());
		model.addAttribute("compensationFormula", ruleUI.getCompensationFormula());
		model.addAttribute("compensationParameter", ruleUI.getCompensationParameter());

		Rule rule = new Rule();
		//RuleSimple ruleSimple = new RuleSimple();
		List<Person1> ptr = personListContainer2.getPersonList();
		List<Rule> ruleObj = new ArrayList<Rule>();
		for (Iterator iterator = ptr.iterator(); iterator.hasNext();) {
			Person1 person1 = (Person1) iterator.next();
			RuleComposite ruleComp = new RuleComposite();
			Rule  rulSimple = ruleApi.searchRuleByName(person1.getSimpRule());
			ruleObj.add(rulSimple);
			ruleComp.setCompJoinRule(ruleObj);
			rule.setRuleComposite(ruleComp);
		}

		rule.setId(ruleUI.getId());
		rule.setRuleName(ruleUI.getRuleName());
		rule.setDescription(ruleUI.getDescription());
		rule.setRuleType(ruleUI.getRuleType());
		rule.setConnectionType(ruleUI.getConnectionType());
		rule.setCompensationType(ruleUI.getCompensationType());
		rule.setFixedCompValue(ruleUI.getFixedCompValue());
		rule.setCompensationFormula(ruleUI.getCompensationFormula());
		rule.setCompensationParameter(ruleUI.getCompensationParameter());
		rule.setRuleParameter(personListContainer.getPersonList());

		ruleApi.createRule(rule);
		return "redirect:/ruleList";
	}

	@RequestMapping(value = "/ruleList", method = RequestMethod.GET)
	public String listRules(ModelMap model) {
		model.addAttribute("listRule", ruleApi.listOfRules());
		// logger.info("A NEW List HAS CREATED");
		System.out.println("*****************ListDone**********************");
		return "compRule";
	}

	@RequestMapping(value = "/editComposite/{id}", method = RequestMethod.GET)
	public String EditCompRule(@PathVariable("id") int id,HttpSession session, ModelMap model) {
		//model.addAttribute("listRule2", ruleApi.listOfRules(RuleType.Simple));
		model.addAttribute("listRule1", ruleApi.getRule(id));
		Rule rule1 = ruleApi.getRule(id);
		List<RuleParameter> ptr = rule1.getRuleParameter();
		List<RuleParameter> parameterList = new ArrayList<RuleParameter>();
		Iterator it = ptr.iterator();	 
	    while(it.hasNext()) {
	    	RuleParameter rp = (RuleParameter)it.next();
	      System.out.println(rp.getParameterName());
	      System.out.println(rp.getParameterValue());
	      parameterList.add(rp);
	    }
	  model.addAttribute("parList",parameterList);
	    
		if (session.getAttribute("personListContainer3") == null)
			session.setAttribute("personListContainer3", getDummyPersonListContainer3());
		model.addAttribute("personListContainer3", (PersonListContainer) session.getAttribute("personListContainer3"));

		session.setAttribute("personListContainer2", getDummyPersonListContainer2());
		model.addAttribute("personListContainer2", (PersonListContainer2) session.getAttribute("personListContainer2"));
		model.addAttribute("listSimpRule", ruleApi.listOfRules(RuleType.Simple));
		return "EditComposite";
	}

}
