
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
@Table(name = "OrderDetail")
public class OrderDetail {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "orderDate")
	private Date orderDate;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "SALES_REP_ID")
	private Employee salesRepresentative;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "SUPP_ENG_ID")
	private Employee supportEngineer;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "ADMIN_ID")
	private Employee administrator;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "CUST_ID")
	private Customer customer;
	
	@Column(name = "orderTotal")
	private  long orderTotal;
	
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ORDER_ID")
	@IndexColumn(name = "detailSrl")
	private List<OrderLineItems> orderLineItems;

	public OrderDetail() {
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
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the salesRepresentative
	 */
	public Employee getSalesRepresentative() {
		return salesRepresentative;
	}

	/**
	 * @param salesRepresentative the salesRepresentative to set
	 */
	public void setSalesRepresentative(Employee salesRepresentative) {
		this.salesRepresentative = salesRepresentative;
	}

	/**
	 * @return the supportEngineer
	 */
	public Employee getSupportEngineer() {
		return supportEngineer;
	}

	/**
	 * @param supportEngineer the supportEngineer to set
	 */
	public void setSupportEngineer(Employee supportEngineer) {
		this.supportEngineer = supportEngineer;
	}

	/**
	 * @return the administrator
	 */
	public Employee getAdministrator() {
		return administrator;
	}

	/**
	 * @param administrator the administrator to set
	 */
	public void setAdministrator(Employee administrator) {
		this.administrator = administrator;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the orderTotal
	 */
	public long getOrderTotal() {
		return orderTotal;
	}

	/**
	 * @param orderTotal the orderTotal to set
	 */
	public void setOrderTotal(long orderTotal) {
		this.orderTotal = orderTotal;
	}

	/**
	 * @return the orderLineItems
	 */
	public List<OrderLineItems> getOrderLineItems() {
		return orderLineItems;
	}

	/**
	 * @param orderLineItems the orderLineItems to set
	 */
	public void setOrderLineItems(List<OrderLineItems> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}
}
