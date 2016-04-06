package com.simpsoft.salesCommission.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "RuleAssignmentDetails")
public class RuleAssignmentDetails {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	/*	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ASSGN_ID")
	private RuleAssignment ruleAssignment; */
	
	@Column(name = "validityType")
	private String validityType;

	@Column(name = "startDate")
	private Date startDate;

	@Column(name = "terminationDate")
	private Date terminationDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FREQ_ID")
	private Frequency frequency;

	/*@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ASSN_DTL_ID")
	@IndexColumn(name = "detailSrl")
	private List<Rule> rule;*/
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RULE_ID")
	private Rule rule;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ASSN_DTL_ID")
	@IndexColumn(name = "detailSrl")
	private List<RuleAssignmentParameter> ruleAssignmentParameter;

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
	 * @return the ruleAssignment
	 */
/*	public RuleAssignment getRuleAssignment() {
		return ruleAssignment;
	}

	/**
	 * @param ruleAssignment
	 *            the ruleAssignment to set
	 */
/*	public void setRuleAssignment(RuleAssignment ruleAssignment) {
		this.ruleAssignment = ruleAssignment;
	}
	/**
	 * @return the validityType
	 */
	public String getValidityType() {
		return validityType;
	}

	/**
	 * @param validityType
	 *            the validityType to set
	 */
	public void setValidityType(String validityType) {
		this.validityType = validityType;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the terminationDate
	 */
	public Date getTerminationDate() {
		return terminationDate;
	}

	/**
	 * @param terminationDate
	 *            the terminationDate to set
	 */
	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	/**
	 * @return the frequency
	 */
	public Frequency getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency
	 *            the frequency to set
	 */
	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}


	/**
	 * @return the rule
	 */
	public Rule getRule() {
		return rule;
	}

	/**
	 * @param rule the rule to set
	 */
	public void setRule(Rule rule) {
		this.rule = rule;
	}

	/**
	 * @return the ruleAssignmentParameter
	 */
	public List<RuleAssignmentParameter> getRuleAssignmentParameter() {
		return ruleAssignmentParameter;
	}

	/**
	 * @param ruleAssignmentParameter
	 *            the ruleAssignmentParameter to set
	 */
	public void setRuleAssignmentParameter(List<RuleAssignmentParameter> ruleAssignmentParameter) {
		this.ruleAssignmentParameter = ruleAssignmentParameter;
	}
}
