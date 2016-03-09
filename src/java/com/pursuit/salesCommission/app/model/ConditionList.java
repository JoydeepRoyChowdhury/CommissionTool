package com.pursuit.salesCommission.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "ConditionList")
public class ConditionList {
	
	@Id
	@GeneratedValue
	@Column(name = "condition_id")
	private long id;
	
	@Type(type= "org.hibernate.type.NumericBooleanType")
	@Column(name = "notFlag", nullable = false)
	private boolean notFlag; 

	@Column(name = "conditionValue")
	private String conditionValue;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean getNotFlag() {
		return notFlag;
	}

	public void setNotFlag(boolean notFlag) {
		this.notFlag = notFlag;
	}

	public String getConditionValue() {
		return conditionValue;
	}

	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}


}
