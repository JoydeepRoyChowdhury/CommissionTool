package com.pursuit.salesCommission.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AggregateFunction")
public class AggregateFunctions {
	@Id
	@GeneratedValue
	@Column(name = "aggrt_fn_id")
	private long id;

	@Column(name = "functionName")
	private String functionName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
}
