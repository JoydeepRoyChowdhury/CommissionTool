package com.pursuit.salesCommission.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ConditionList")
public class ConditionList {
	@Id
	@GeneratedValue
	@Column(name = "con_lst_id")
	private long id;

	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean notFlag;

	@Column(name = "condition")
	private String condition;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isNotFlag() {
		return notFlag;
	}

	public void setNotFlag(boolean notFlag) {
		this.notFlag = notFlag;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
