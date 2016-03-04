package com.pursuit.salesCommission.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RuleSimple")
public class RuleSimple {
	@Id
	@GeneratedValue
	@Column(name = "rule_simp_id")
	private int id;

	@Column(name = "calculationMode")
	private String calculationMode;

	@Column(name = "rankCount")
	private String rankCount;

	@Column(name = "rankingType")
	private String rankingType;

	@Column(name = "populationType")
	private String populationType;

	@Column(name = "populationUpto")
	private String populationUpto;

	@Column(name = "compensationType")
	private String compensationType;

	@Column(name = "fixedCompValue")
	private String fixedCompValue;
	
}