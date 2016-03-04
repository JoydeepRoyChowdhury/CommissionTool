package com.pursuit.salesCommission.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "RULE")
public class Rule {
	@Id
	@GeneratedValue
	@Column(name = "rule_id")
	private long id;

	@Column(name = "ruleName")
	private String ruleName;

	@Column(name = "description")
	private String description;

	/*	@Column(name = "ruleType")
	private String ruleType;

	@Column(name = "ruleDetails")
	private String ruleDetails;

	
	 * @Column(name = "connectionType") private String connectionType;
	 * 
	 * @Column(name = "compensationType") private String compensationType;
	 * 
	 * @Column(name = "fixedCompValue") private String fixedCompValue;
	 * 
	 * @Column(name = "compensationFormula") private String compensationFormula;
	 * 
	 * @Column(name = "compensationParameter") private String
	 * compensationParameter;
	 */
	@OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="RULE_ID")
    @IndexColumn(name="idx")
    private List<Employee> employees;

	/*@OneToMany(cascade=CascadeType.ALL)  
	 @JoinTable(name="RULE_EMPLOYEE",joinColumns={@JoinColumn(name="rule_id")},inverseJoinColumns={@JoinColumn(name="emp_id")})  
	 Collection<Employee> listOfEmployees=new ArrayList<Employee>();  
	
	public Collection<Employee> getListOfEmployees() {
		return listOfEmployees;
	}

	public void setListOfEmployees(Collection<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}
*/
	public Rule() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public String getRuleDetails() {
		return ruleDetails;
	}

	public void setRuleDetails(String ruleDetails) {
		this.ruleDetails = ruleDetails;
	}

	/*
	 * public String getConnectionType() { return connectionType; }
	 * 
	 * public void setConnectionType(String connectionType) {
	 * this.connectionType = connectionType; }
	 * 
	 * public String getCompensationType() { return compensationType; }
	 * 
	 * public void setCompensationType(String compensationType) {
	 * this.compensationType = compensationType; }
	 * 
	 * public String getFixedCompValue() { return fixedCompValue; }
	 * 
	 * public void setFixedCompValue(String fixedCompValue) {
	 * this.fixedCompValue = fixedCompValue; }
	 * 
	 * public String getCompensationFormula() { return compensationFormula; }
	 * 
	 * public void setCompensationFormula(String compensationFormula) {
	 * this.compensationFormula = compensationFormula; }
	 * 
	 * public String getCompensationParameter() { return compensationParameter;
	 * }
	 * 
	 * public void setCompensationParameter(String compensationParameter) {
	 * this.compensationParameter = compensationParameter; }
	 */
	
	public ArrayList<Employee> getEmployees() {
		return (ArrayList<Employee>) employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	} 
	
	

}
