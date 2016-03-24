package com.pursuit.salesCommission.app.model;

import java.util.LinkedList;
import java.util.List;
 
public class PersonListContainer {
 
    //Important. Set this to a default List in order to avoid null pointer exceptions when the list is empty
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
