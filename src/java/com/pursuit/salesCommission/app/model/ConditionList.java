package com.pursuit.salesCommission.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "ConditionList")
public class ConditionList {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Type(type = "org.hibernate.type.NumericBooleanType")
	@Column(name = "notFlag", nullable = false)
	private boolean notFlag;

	@Column(name = "conditionValue")
	private String conditionValue;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the notFlag
	 */
	public boolean isNotFlag() {
		return notFlag;
	}

	/**
	 * @param notFlag
	 *            the notFlag to set
	 */
	public void setNotFlag(boolean notFlag) {
		this.notFlag = notFlag;
	}

	/**
	 * @return the conditionValue
	 */
	public String getConditionValue() {
		return conditionValue;
	}

	/**
	 * @param conditionValue
	 *            the conditionValue to set
	 */
	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}

}
