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
@Table(name = "RuleSimple")
public class RuleSimple {
	@Id
	@GeneratedValue
	@Column(name = "rule_simp_id")
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Rule rule;
	
	@Column(name = "calculationMode")
	private String calculationMode;

	@Column(name = "rankCount")
	private int rankCount;

	@Column(name = "rankingType")
	private String rankingType;

	@Column(name = "populationType")
	private String populationType;

	@Column(name = "populationUpto")
	private int populationUpto;

	@Column(name = "compensationType")
	private String compensationType;

	@Column(name = "fixedCompValue")
	private String fixedCompValue;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	public String getCalculationMode() {
		return calculationMode;
	}

	public void setCalculationMode(String calculationMode) {
		this.calculationMode = calculationMode;
	}
	public int getRankCount() {
		return rankCount;
	}

	public void setRankCount(int rankCount) {
		this.rankCount = rankCount;
	}

	public String getRankingType() {
		return rankingType;
	}

	public void setRankingType(String rankingType) {
		this.rankingType = rankingType;
	}

	public String getPopulationType() {
		return populationType;
	}

	public void setPopulationType(String populationType) {
		this.populationType = populationType;
	}

	public int getPopulationUpto() {
		return populationUpto;
	}

	public void setPopulationUpto(int populationUpto) {
		this.populationUpto = populationUpto;
	}

	public String getCompensationType() {
		return compensationType;
	}

	public void setCompensationType(String compensationType) {
		this.compensationType = compensationType;
	}

	public String getFixedCompValue() {
		return fixedCompValue;
	}

	public void setFixedCompValue(String fixedCompValue) {
		this.fixedCompValue = fixedCompValue;
	}
}