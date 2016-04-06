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
@Table(name = "RuleAssignment")
public class RuleAssignment {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EMP_ID")
	private Employee employee;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ROLE_ID")
	private Role role;

	/*	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RULE_ASSGN_ID")
	private RuleAssignmentDetails ruleAssignmentDetails; */

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "RUL_ASSN_ID")
	@IndexColumn(name = "detailSrl")
	private List<RuleAssignmentDetails> ruleAssignmentDetails;
	
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
	 * @return the ruleAssignmentDetails
	 */
	public List<RuleAssignmentDetails> getRuleAssignmentDetails() {
		return ruleAssignmentDetails;
	}

	/**
	 * @param ruleAssignmentDetails the ruleAssignmentDetails to set
	 */
	public void setRuleAssignmentDetails(List<RuleAssignmentDetails> ruleAssignmentDetails) {
		this.ruleAssignmentDetails = ruleAssignmentDetails;
	}

	
}
