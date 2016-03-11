package com.pursuit.salesCommission.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Role")
public class Role {
	@Id
	@GeneratedValue
	@Column(name = "role_id")
	private int id;

	@Column(name = "RoleName")
	private String RoleName;

	@Column(name = "Description")
	private String Description;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "reportsTo")
	private Role reportsTo;

/*	@OneToMany(mappedBy = "reportsTo")
	private Set<Role> subordinates = new HashSet<Role>();
*/
	public Role() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return RoleName;
	}

	/**
	 * @param roleName the roleName to set
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
	 * @param description the description to set
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
	 * @param reportsTo the reportsTo to set
	 */
	public void setReportsTo(Role reportsTo) {
		this.reportsTo = reportsTo;
	}

	/**
	 * @return the subordinates
	 */
/*	public Set<Role> getSubordinates() {
		return subordinates;
	}
*/
	/**
	 * @param subordinates the subordinates to set
	 */
/*	public void setSubordinates(Set<Role> subordinates) {
		this.subordinates = subordinates;
	}
*/	
}
