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

	@OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinColumn(name = "RULE_SIMP_ID")
	@IndexColumn(name = "detailSrl")
	private List<RuleParameter> ruleParameter;

	@OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinColumn(name = "RULE_SIMP_ID")
	@IndexColumn(name = "detailSrl")
	private List<QualifyingClause> qualifyingClause;

	@OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinColumn(name = "RULE_SIMP_ID")
	@IndexColumn(name = "detailSrl")
	private List<AggregateFunctions> aggregateFunctions;

	@OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinColumn(name = "RULE_SIMP_ID")
	@IndexColumn(name = "detailSrl")
	private List<FieldList> fieldList;

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
	 * @return the calculationMode
	 */
	public String getCalculationMode() {
		return calculationMode;
	}

	/**
	 * @param calculationMode
	 *            the calculationMode to set
	 */
	public void setCalculationMode(String calculationMode) {
		this.calculationMode = calculationMode;
	}

	/**
	 * @return the rankCount
	 */
	public int getRankCount() {
		return rankCount;
	}

	/**
	 * @param rankCount
	 *            the rankCount to set
	 */
	public void setRankCount(int rankCount) {
		this.rankCount = rankCount;
	}

	/**
	 * @return the rankingType
	 */
	public String getRankingType() {
		return rankingType;
	}

	/**
	 * @param rankingType
	 *            the rankingType to set
	 */
	public void setRankingType(String rankingType) {
		this.rankingType = rankingType;
	}

	/**
	 * @return the populationType
	 */
	public String getPopulationType() {
		return populationType;
	}

	/**
	 * @param populationType
	 *            the populationType to set
	 */
	public void setPopulationType(String populationType) {
		this.populationType = populationType;
	}

	/**
	 * @return the populationUpto
	 */
	public int getPopulationUpto() {
		return populationUpto;
	}

	/**
	 * @param populationUpto
	 *            the populationUpto to set
	 */
	public void setPopulationUpto(int populationUpto) {
		this.populationUpto = populationUpto;
	}

	/**
	 * @return the ruleParameter
	 */
	public List<RuleParameter> getRuleParameter() {
		return ruleParameter;
	}

	/**
	 * @param ruleParameter
	 *            the ruleParameter to set
	 */
	public void setRuleParameter(List<RuleParameter> ruleParameter) {
		this.ruleParameter = ruleParameter;
	}

	/**
	 * @return the qualifyingClause
	 */
	public List<QualifyingClause> getQualifyingClause() {
		return qualifyingClause;
	}

	/**
	 * @param qualifyingClause
	 *            the qualifyingClause to set
	 */
	public void setQualifyingClause(List<QualifyingClause> qualifyingClause) {
		this.qualifyingClause = qualifyingClause;
	}

	/**
	 * @return the aggregateFunctions
	 */
	public List<AggregateFunctions> getAggregateFunctions() {
		return aggregateFunctions;
	}

	/**
	 * @param aggregateFunctions
	 *            the aggregateFunctions to set
	 */
	public void setAggregateFunctions(List<AggregateFunctions> aggregateFunctions) {
		this.aggregateFunctions = aggregateFunctions;
	}

	/**
	 * @return the fieldList
	 */
	public List<FieldList> getFieldList() {
		return fieldList;
	}

	/**
	 * @param fieldList
	 *            the fieldList to set
	 */
	public void setFieldList(List<FieldList> fieldList) {
		this.fieldList = fieldList;
	}

}