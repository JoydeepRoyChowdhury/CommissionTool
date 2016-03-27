package com.pursuit.salesCommission.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SplitQualifyingClause")
public class SplitQualifyingClause {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "value")
	private String value;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "FLD_LST_ID")
	private FieldList fieldList;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "CND_LST_ID")
	private ConditionList conditionList;
	
	public SplitQualifyingClause() {
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the fieldList
	 */
	public FieldList getFieldList() {
		return fieldList;
	}

	/**
	 * @param fieldList the fieldList to set
	 */
	public void setFieldList(FieldList fieldList) {
		this.fieldList = fieldList;
	}

	/**
	 * @return the conditionList
	 */
	public ConditionList getConditionList() {
		return conditionList;
	}

	/**
	 * @param conditionList the conditionList to set
	 */
	public void setConditionList(ConditionList conditionList) {
		this.conditionList = conditionList;
	}
}