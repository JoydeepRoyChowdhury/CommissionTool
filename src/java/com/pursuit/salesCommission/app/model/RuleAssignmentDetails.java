package com.pursuit.salesCommission.app.model;

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
	@Column(name = "assn_dtl_id")
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private RuleAssignment ruleAssignment;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ASSN_DTL_ID")
	@IndexColumn(name = "detailSrl")
	private List<Rule> rule;

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
	public RuleAssignment getRuleAssignment() {
		return ruleAssignment;
	}

	/**
	 * @param ruleAssignment
	 *            the ruleAssignment to set
	 */
	public void setRuleAssignment(RuleAssignment ruleAssignment) {
		this.ruleAssignment = ruleAssignment;
	}

	/**
	 * @return the rule
	 */
	public List<Rule> getRule() {
		return rule;
	}

	/**
	 * @param rule
	 *            the rule to set
	 */
	public void setRule(List<Rule> rule) {
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
