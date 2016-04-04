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
@Table(name = "RuleComposite")
public class RuleComposite {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "RULE_COMP_ID")
	@IndexColumn(name = "detailSrl")
	private List<Rule> rule;

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
	 * @return the ruleSimple
	 */
	public List<Rule> getRule() {
		return rule;
	}

	/**
	 * @param ruleSimple
	 *            the ruleSimple to set
	 */
	public void setRule(List<Rule> rule) {
		this.rule = rule;
	}

}
