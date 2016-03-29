package com.pursuit.salesCommission.app.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "employeeName")
	private String employeeName;

	@Column(name = "startDate")
	private Date startDate;

	@Column(name = "terminationDate")
	private Date terminationDate;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "EMP_ID")
	@IndexColumn(name = "detailSrl")
	private List<Target> target;
	
	@Column(name = "salary")
	private int salary;

	public Employee() {
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
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName
	 *            the employeeName to set
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
	 * @param startDate
	 *            the startDate to set
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
	 * @param terminationDate
	 *            the terminationDate to set
	 */
	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
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
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee(long ID, String empName, int salary) {
         this.id = ID;
         this.employeeName = empName;
         this.salary = salary;
    }

    @Override
    public String toString() {
         return "<" + id + ", " + employeeName + ", "  
                                  + salary + ">";
    }
}