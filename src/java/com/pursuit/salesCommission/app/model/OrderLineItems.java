package com.pursuit.salesCommission.app.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderLineItems")
public class OrderLineItems {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "orderDate")
	private Date orderDate;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "PROD_ID")
	private Product product;

	@Column(name = "quantity")
	private  int quantity;
	
	@Column(name = "rate")
	private  int rate;
	
	@Column(name = "discountPercentage")
	private  int discountPercentage;
	
	@Column(name = "dutyPercentage")
	private  int dutyPercentage;

	@Column(name = "subtotal")
	private  long subtotal;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "ORDR_LNSPLT_ID")
	private OrderLineItemsSplit orderLineItemsSplit;
	
	public OrderLineItems() {
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
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the rate
	 */
	public int getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(int rate) {
		this.rate = rate;
	}

	/**
	 * @return the discountPercentage
	 */
	public int getDiscountPercentage() {
		return discountPercentage;
	}

	/**
	 * @param discountPercentage the discountPercentage to set
	 */
	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	/**
	 * @return the dutyPercentage
	 */
	public int getDutyPercentage() {
		return dutyPercentage;
	}

	/**
	 * @param dutyPercentage the dutyPercentage to set
	 */
	public void setDutyPercentage(int dutyPercentage) {
		this.dutyPercentage = dutyPercentage;
	}

	/**
	 * @return the subtotal
	 */
	public long getSubtotal() {
		return subtotal;
	}

	/**
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(long subtotal) {
		this.subtotal = subtotal;
	}
}
