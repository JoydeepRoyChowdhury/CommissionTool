package com.pursuit.salesCommission.app.model;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
public class Role {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "RoleName")
	private String RoleName;

	@Column(name = "Description")
	private String Description;

	@Column(name = "ReportTo")
	private String ReportTo;

	public Role() {
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getReportTo() {
		return ReportTo;
	}

	public void setReportTo(String reportTo) {
		ReportTo = reportTo;
	}

	

}
