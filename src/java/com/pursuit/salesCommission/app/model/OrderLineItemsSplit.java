package com.pursuit.salesCommission.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderLineItemsSplit")
public class OrderLineItemsSplit {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "BEN_ID")
	private Employee beneficiary;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "SPLT_RUL_ID")
	private SplitRule splitRule;
	
	@Column(name = "splitQuantity")
	private int splitQuantity;
	
	@Column(name = "splitSubTotal")
	private int splitSubTotal;

	public OrderLineItemsSplit() {
	}	
}
