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
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "addressLn1")
	private String addressLine1;

	@Column(name = "addressLn2")
	private String addressLine2;	

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CUS_TYP_ID")
	private CustomerType customerType;
	
	public Customer() {
	}

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
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * @return the customerType
	 */
	public CustomerType getCustomerType() {
		return customerType;
	}

	/**
	 * @param customerType the customerType to set
	 */
	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
}
