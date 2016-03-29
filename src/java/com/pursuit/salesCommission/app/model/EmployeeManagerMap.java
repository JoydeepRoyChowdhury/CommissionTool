package com.pursuit.salesCommission.app.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

@Entity
@Table(name = "EmployeeManagerMap")
public class EmployeeManagerMap {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EMP_ID")
	private Employee employee;

	@Column(name = "startDate")
	private Date startDate;

	@Column(name = "endDate")
	private Date endDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "manager_id")
	private Employee manager;

	/*
	 * @OneToMany(mappedBy = "manager") private Set<Employee> subordinates = new
	 * HashSet<Employee>();
	 */

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
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param terminationDate
	 *            the terminationDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the manager
	 */
	public Employee getManager() {
		return manager;
	}

	/**
	 * @param manager
	 *            the manager to set
	 */
	public void setManager(Employee manager) {
		this.manager = manager;
	}

	/**
	 * @return the subordinates
	 */
	/*
	 * public Set<Employee> getSubordinates() { return subordinates; }
	 */
	/**
	 * @param subordinates
	 *            the subordinates to set
	 */
	/*
	 * public void setSubordinates(Set<Employee> subordinates) {
	 * this.subordinates = subordinates; }
	 */

}
