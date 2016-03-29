package com.pursuit.salesCommission.ui;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pursuit.salesCommission.app.api.RuleAPI;
import com.pursuit.salesCommission.app.model.Person;
import com.pursuit.salesCommission.app.model.Person1;
import com.pursuit.salesCommission.app.model.PersonListContainer1;
import com.pursuit.salesCommission.app.model.PersonListContainer2;
import com.pursuit.salesCommission.app.model.QualifyingClauseUI;
import com.pursuit.salesCommission.app.model.RuleParameter;


 
@Controller
public class PersonController {
 
	@Autowired
	private RuleAPI ruleApi;
	
    @RequestMapping("/persons")
    public String index1( ModelMap map, HttpSession session,  HttpServletRequest request, String message ) {
 
    	map.addAttribute("listCompRule1", ruleApi.listRules());
      
        if( session.getAttribute("personListContainer2") == null )
            session.setAttribute("personListContainer2", getDummyPersonListContainer());
        map.addAttribute("personListContainer2", (PersonListContainer2)session.getAttribute("personListContainer2"));
        if( message != null )
            map.addAttribute("message", message);
        map.addAttribute("cp", request.getContextPath());
 
        return "personList";
    }
 
    @RequestMapping(value="/editpersonlistcontainer", method= RequestMethod.POST)
    public String editpersonListContainer(@ModelAttribute PersonListContainer1 personListContainer1, HttpSession session) {
        for( QualifyingClauseUI p : personListContainer1.getPersonList() ) {
            System.out.println("Name: " + p.getValue());
            System.out.println("Age: " + p.getConditionValue());
            System.out.println("condition: " + p.getFieldName());
            //System.out.println("field: " + p.getParameter());
        }
        session.setAttribute("personListContainer",personListContainer1);
        return "compRule";
    }
 
    private PersonListContainer2 getDummyPersonListContainer() {
        List<Person1> personList = new ArrayList<Person1>();
        for( int i=0; i<1; i++ ) {
            personList.add( new Person1() );
        }
        return new PersonListContainer2();
    }
}