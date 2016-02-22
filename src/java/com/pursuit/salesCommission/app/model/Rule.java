package com.pursuit.salesCommission.app.model;

import javax.persistence.*;

@Entity
@Table (name = "RULE")
public class Rule {
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
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

	@Column(name = "ruleName")
	private String ruleName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "ruleType")
	private String ruleType;
  
}
