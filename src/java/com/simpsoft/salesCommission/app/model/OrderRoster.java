package com.simpsoft.salesCommission.app.model;

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
@Table(name = "OrderRoster")
public class OrderRoster {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "importDate")
	private Date importDate;

	@Column(name = "countOfOrders")
	private int countOfOrders;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "EMP_ID")
	private Employee importedBy;
	
	@Column(name = "status")
	private String status;
	
	public OrderRoster() {
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
	 * @return the importDate
	 */
	public Date getImportDate() {
		return importDate;
	}

	/**
	 * @param importDate the importDate to set
	 */
	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	/**
	 * @return the countOfOrders
	 */
	public int getCountOfOrders() {
		return countOfOrders;
	}

	/**
	 * @param countOfOrders the countOfOrders to set
	 */
	public void setCountOfOrders(int countOfOrders) {
		this.countOfOrders = countOfOrders;
	}

	/**
	 * @return the importedBy
	 */
	public Employee getImportedBy() {
		return importedBy;
	}

	/**
	 * @param importedBy the importedBy to set
	 */
	public void setImportedBy(Employee importedBy) {
		this.importedBy = importedBy;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
