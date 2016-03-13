package com.pursuit.salesCommission.app.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "RuleAssignment")
public class RuleAssignment {
	@Id
	@GeneratedValue
	@Column(name = "rule_ass_id")
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Employee employee;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Role role;

	@Column(name = "validityType")
	private String validityType;

	@Column(name = "startDate")
	private Date startDate;

	@Column(name = "terminationDate")
	private Date terminationDate;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Frequency frequency;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private RuleAssignmentDetails ruleAssignmentDetails;

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
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee
	 *            the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
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
	 * @return the ruleAssignmentDetails
	 */
	public RuleAssignmentDetails getRuleAssignmentDetails() {
		return ruleAssignmentDetails;
	}

	/**
	 * @param ruleAssignmentDetails
	 *            the ruleAssignmentDetails to set
	 */
	public void setRuleAssignmentDetails(RuleAssignmentDetails ruleAssignmentDetails) {
		this.ruleAssignmentDetails = ruleAssignmentDetails;
	}
}
