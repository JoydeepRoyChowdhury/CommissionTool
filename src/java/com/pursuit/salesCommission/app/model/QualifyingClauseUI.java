package com.pursuit.salesCommission.app.model;

public class QualifyingClauseUI {

	private String value;
	private String conditionValue;
	private String fieldName;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getConditionValue() {
		return conditionValue;
	}

	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public QualifyingClauseUI(){
		
	}
	
public QualifyingClauseUI(String value, String conditionValue, String fieldName){
	
	this.value=value;
	this.fieldName=fieldName;
	this.conditionValue=conditionValue;
		
	}


}
