package com.pursuit.salesCommission.app.model;

import java.util.LinkedList;
import java.util.List;
 
public class PersonListContainer {
 
    private List<RuleParameter> personList = new LinkedList<RuleParameter>();
    
 
    public PersonListContainer() {
    }
 
    public PersonListContainer(List<RuleParameter> personList) {
        this.personList = personList;
    }
 
    public List<RuleParameter> getPersonList() {
        return personList;
    }
 
    public void setPersonList(List<RuleParameter> personList) {
        this.personList = personList;
    }
}