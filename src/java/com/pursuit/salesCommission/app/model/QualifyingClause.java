package com.pursuit.salesCommission.app.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Table(name = "QualifyingClause")
public class QualifyingClause {
	@Id
	@GeneratedValue
	@Column(name = "clause_id")
	private long id;

	@Column(name = "value")
	private String value;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private FieldList fieldList;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private ConditionList conditionList;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public FieldList getFieldList() {
		return fieldList;
	}

	public void setFieldList(FieldList fieldList) {
		this.fieldList = fieldList;
	}

	public ConditionList getConditionList() {
		return conditionList;
	}

	public void setConditionList(ConditionList conditionList) {
		this.conditionList = conditionList;
	}


}
