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

	@Column(name = "notFlag")
	private boolean notFlag;
	
	@Column(name = "condition")
	private String condition;
}
