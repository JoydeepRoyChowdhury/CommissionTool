
package com.pursuit.salesCommission.app.model;

import javax.persistence.*;


public class RuleUI {
	
	private long id;

	
	private String ruleName;

	
	private String description;

	
	private String ruleType;


	private String ruleDetails;

	
	private RuleSimple ruleSimple;

	
	private RuleComposite ruleComposite;

	
	private String connectionType;

	
	private String compensationType;

	
	private int fixedCompValue;

	
	private String compensationFormula;

	private String compensationParameter;
	
	private String calculationMode;

	public RuleUI() {
	}

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
	 * @return the ruleName
	 */
	public String getRuleName() {
		return ruleName;
	}

	/**
	 * @param ruleName
	 *            the ruleName to set
	 */
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the ruleType
	 */
	public String getRuleType() {
		return ruleType;
	}

	/**
	 * @param ruleType
	 *            the ruleType to set
	 */
	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	/**
	 * @return the ruleDetails
	 */
	public String getRuleDetails() {
		return ruleDetails;
	}

	/**
	 * @param ruleDetails
	 *            the ruleDetails to set
	 */
	public void setRuleDetails(String ruleDetails) {
		this.ruleDetails = ruleDetails;
	}

	/**
	 * @return the ruleSimple
	 */
	public RuleSimple getRuleSimple() {
		return ruleSimple;
	}

	/**
	 * @param ruleSimple
	 *            the ruleSimple to set
	 */
	public void setRuleSimple(RuleSimple ruleSimple) {
		this.ruleSimple = ruleSimple;
	}

	/**
	 * @return the ruleComposite
	 */
	public RuleComposite getRuleComposite() {
		return ruleComposite;
	}

	/**
	 * @param ruleComposite
	 *            the ruleComposite to set
	 */
	public void setRuleComposite(RuleComposite ruleComposite) {
		this.ruleComposite = ruleComposite;
	}

	/**
	 * @return the connectionType
	 */
	public String getConnectionType() {
		return connectionType;
	}

	/**
	 * @param connectionType
	 *            the connectionType to set
	 */
	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}

	/**
	 * @return the compensationType
	 */
	public String getCompensationType() {
		return compensationType;
	}

	/**
	 * @param compensationType
	 *            the compensationType to set
	 */
	public void setCompensationType(String compensationType) {
		this.compensationType = compensationType;
	}

	/**
	 * @return the fixedCompValue
	 */
	public int getFixedCompValue() {
		return fixedCompValue;
	}

	/**
	 * @param fixedCompValue
	 *            the fixedCompValue to set
	 */
	public void setFixedCompValue(int fixedCompValue) {
		this.fixedCompValue = fixedCompValue;
	}

	/**
	 * @return the compensationFormula
	 */
	public String getCompensationFormula() {
		return compensationFormula;
	}

	/**
	 * @param compensationFormula
	 *            the compensationFormula to set
	 */
	public void setCompensationFormula(String compensationFormula) {
		this.compensationFormula = compensationFormula;
	}

	/**
	 * @return the compensationParameter
	 */
	public String getCompensationParameter() {
		return compensationParameter;
	}

	/**
	 * @param compensationParameter
	 *            the compensationParameter to set
	 */
	public void setCompensationParameter(String compensationParameter) {
		this.compensationParameter = compensationParameter;
	}

	/**
	 * @return the calculationMode
	 */
	public String getCalculationMode() {
		return calculationMode;
	}

	/**
	 * @param calculationMode the calculationMode to set
	 */
	public void setCalculationMode(String calculationMode) {
		this.calculationMode = calculationMode;
	}

}