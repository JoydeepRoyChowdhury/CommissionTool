package com.pursuit.salesCommission.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RuleParameter")
public class RuleParameter {

	@Id
	@GeneratedValue
	@Column(name = "rule_param_id")
	private long id;

	@Column(name = "parameterName")
	private String parameterName;

	@Column(name = "parameterValue")
	private String parameterValue;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterValue() {
		return parameterValue;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}
}
