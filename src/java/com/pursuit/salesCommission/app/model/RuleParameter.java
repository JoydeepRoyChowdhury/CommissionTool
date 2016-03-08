package com.pursuit.salesCommission.app.model;

import javax.persistence.CascadeType;
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

	/*@GeneratedValue
	@Column(name = "detailSerial")
	private long detailSerial; */

	@Column(name = "parameterName")
	private String parameterName;

	@Column(name = "parameterValue")
	private String parameterValue;
}
