package com.pursuit.salesCommission.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "RuleSimple")
public class RuleSimple {
	@Id
	@GeneratedValue
	@Column(name = "rule_simp_id")
	private long id;

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

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "RULE_SIMP_ID")
	@IndexColumn(name = "detailSrl")
	private List<RuleParameter> ruleParameter;

	/*@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "RULE_SIMP_ID")
	@IndexColumn(name = "detailSrl")
	private List<QualifyingClause> qualifyingClause; */

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "RULE_SIMP_ID")
	@IndexColumn(name = "detailSrl")
	private List<AggregateFunctions> aggregateFunctions;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "RULE_SIMP_ID")
	@IndexColumn(name = "detailSrl")
	private List<FieldList> fieldList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<RuleParameter> getRuleParameter() {
		return ruleParameter;
	}

	public void setRuleParameter(List<RuleParameter> ruleParameter) {
		this.ruleParameter = ruleParameter;
	}

	/*public List<QualifyingClause> getQualifyingClause() {
		return qualifyingClause;
	}

	public void setQualifyingClause(List<QualifyingClause> qualifyingClause) {
		this.qualifyingClause = qualifyingClause;
	}
*/
	public List<AggregateFunctions> getAggregateFunctions() {
		return aggregateFunctions;
	}

	public void setAggregateFunctions(List<AggregateFunctions> aggregateFunctions) {
		this.aggregateFunctions = aggregateFunctions;
	}

	public List<FieldList> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<FieldList> fieldList) {
		this.fieldList = fieldList;
	} 
}