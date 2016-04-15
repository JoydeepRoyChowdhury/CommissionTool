package com.simpsoft.salesCommission.app.dataloader;

import java.util.Date;
import java.util.List;

import com.simpsoft.salesCommission.app.model.Target;

public class EmployeeXML {
	
	private long id;

	private String employeeName;

	private Date startDate;

	private Date terminationDate;
	
	private List<EmployeeManagerMapXML> employeeManagerMapXml;
	
	private List<EmployeeRoleMapXML> employeeRoleMapXml;

	private List<Target> target;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
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
	 * @param terminationDate the terminationDate to set
	 */
	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	/**
	 * @return the employeeManagerMapXml
	 */
	public List<EmployeeManagerMapXML> getEmployeeManagerMapXml() {
		return employeeManagerMapXml;
	}

	/**
	 * @param employeeManagerMapXml the employeeManagerMapXml to set
	 */
	public void setEmployeeManagerMapXml(List<EmployeeManagerMapXML> employeeManagerMapXml) {
		this.employeeManagerMapXml = employeeManagerMapXml;
	}

	/**
	 * @return the employeeRoleMapXml
	 */
	public List<EmployeeRoleMapXML> getEmployeeRoleMapXml() {
		return employeeRoleMapXml;
	}

	/**
	 * @param employeeRoleMapXml the employeeRoleMapXml to set
	 */
	public void setEmployeeRoleMapXml(List<EmployeeRoleMapXML> employeeRoleMapXml) {
		this.employeeRoleMapXml = employeeRoleMapXml;
	}

	/**
	 * @return the target
	 */
	public List<Target> getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(List<Target> target) {
		this.target = target;
	}

}
