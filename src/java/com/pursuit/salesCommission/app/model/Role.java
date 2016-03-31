package com.pursuit.salesCommission.app.model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "Role")
public class Role {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "RoleName")
	private String RoleName;

	@Column(name = "Description")
	private String Description;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "reportsTo", nullable = true)
	private Role reportsTo;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ROLE_ID")
	@IndexColumn(name = "detailSrl")
	private List<Target> target;

	
	public Role() {
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
	 * @return the roleName
	 */
	public String getRoleName() {
		return RoleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set
	 */
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * @return the reportsTo
	 */
	public Role getReportsTo() {
		return reportsTo;
	}

	/**
	 * @param reportsTo
	 *            the reportsTo to set
	 */
	public void setReportsTo(Role reportsTo) {
		this.reportsTo = reportsTo;
	}

	/**
	 * @return the target
	 */
	public List<Target> getTarget() {
		return target;
	}

	/**
	 * @param target
	 *            the target to set
	 */
	public void setTarget(List<Target> target) {
		this.target = target;
	}

	/**
	 * @return the subordinates
	 */
	/*
	 * public Set<Role> getSubordinates() { return subordinates; }
	 */
	/**
	 * @param subordinates
	 *            the subordinates to set
	 */
	/*
	 * public void setSubordinates(Set<Role> subordinates) { this.subordinates =
	 * subordinates; }
	 */
}
