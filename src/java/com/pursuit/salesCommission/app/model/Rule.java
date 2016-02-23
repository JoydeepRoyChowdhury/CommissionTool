package com.pursuit.salesCommission.app.model;

import javax.persistence.*;

@Entity
@Table (name = "RULE")
public class Rule {
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "ruleName")
	private String ruleName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "ruleType")
	private String ruleType;
	
	@Column(name = "rulesConnectedas")
	private String rulesConnectedas;
	
	@Column(name = "listofRules")
	private String listofRules;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public String getRulesConnectedas() {
		return rulesConnectedas;
	}

	public void setRulesConnectedas(String rulesConnectedas) {
		this.rulesConnectedas = rulesConnectedas;
	}

	public String getListofRules() {
		return listofRules;
	}

	public void setListofRules(String listofRules) {
		this.listofRules = listofRules;
	}

	
	
	
}
