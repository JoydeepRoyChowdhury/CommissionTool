package com.pursuit.salesCommission.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "QualifyingClause")
public class QualifyingClause {
	@Id
	@GeneratedValue
	@Column(name = "clause_id")
	private long id;
	
	/*@GeneratedValue
	@Column(name = "detailSerial")
	private int detailSerial; */
	
	
	@Column(name = "value")
	private String value;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="Clause_ID")
	@IndexColumn(name="idx") 
	private List<FieldList> fieldList;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<FieldList> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<FieldList> fieldList) {
		this.fieldList = fieldList;
	}

}
