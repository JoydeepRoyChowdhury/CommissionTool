package com.pursuit.salesCommission.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "RuleComposite")
public class RuleComposite {
	@Id
	@GeneratedValue
	@Column(name = "rule_comp_id")
	private long id;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "RULE_COMP_ID")
	@IndexColumn(name = "idx")
	private List<RuleSimple> ruleSimple;
}
