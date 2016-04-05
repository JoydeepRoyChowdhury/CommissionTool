package com.pursuit.salesCommission.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

/*	@ManyToMany(cascade = { CascadeType.MERGE})
	@JoinColumn(name = "RULE_COMPJOIN_ID")
	@IndexColumn(name = "detailSrl")
	private List<Rule> rule; */
	
	@ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name="RULE_COMPRULE", 
                joinColumns={@JoinColumn(name="RULE_COMP_ID")}, 
                inverseJoinColumns={@JoinColumn(name="RULE_ID")})
	@IndexColumn(name = "detailSrl")
    private List<Rule> compJoinRule;
	
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
	 * @return the compJoinRule
	 */
	public List<Rule> getCompJoinRule() {
		return compJoinRule;
	}

	/**
	 * @param compJoinRule the compJoinRule to set
	 */
	public void setCompJoinRule(List<Rule> compJoinRule) {
		this.compJoinRule = compJoinRule;
	}

	/**
	 * @return the ruleSimple
	 */
/*	public List<Rule> getRule() {
		return rule;
	}

	/**
	 * @param ruleSimple
	 *            the ruleSimple to set
	 */
/*	public void setRule(List<Rule> rule) {
		this.rule = rule;
	} */

}
