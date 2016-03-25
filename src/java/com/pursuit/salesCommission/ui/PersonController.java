package com.pursuit.salesCommission.ui;
/*
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pursuit.salesCommission.app.model.Person;
import com.pursuit.salesCommission.app.model.PersonListContainer;
 
@Controller
public class PersonController {
 
    @RequestMapping("/persons")
    public String index1( ModelMap map, HttpSession session,  HttpServletRequest request, String message ) {
 
      
        if( session.getAttribute("personListContainer") == null )
            session.setAttribute("personListContainer", getDummyPersonListContainer());
        map.addAttribute("personListContainer", (PersonListContainer)session.getAttribute("personListContainer"));
        if( message != null )
            map.addAttribute("message", message);
        map.addAttribute("cp", request.getContextPath());
 
        return "simpRuleDetails";
    }
 
    @RequestMapping(value="/editpersonlistcontainer", method= RequestMethod.POST)
    public String editpersonListContainer(@ModelAttribute PersonListContainer personListContainer, HttpSession session) {
        for( Person p : personListContainer.getPersonList() ) {
            System.out.println("Name: " + p.getName());
            System.out.println("Age: " + p.getAge());
        }
        session.setAttribute("personListContainer",personListContainer);
        return "compRule";
    }
 
    private PersonListContainer getDummyPersonListContainer() {
        List<Person> personList = new ArrayList<Person>();
        for( int i=0; i<1; i++ ) {
            personList.add( new Person("Person Name [" + i + "]", String.valueOf(i)) );
        }
        return new PersonListContainer(personList);
    }
}
*/