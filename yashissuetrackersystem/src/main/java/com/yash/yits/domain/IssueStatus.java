package com.yash.yits.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the issuestatus database table.
 * 
 */
@Entity
@NamedQuery(name="Issuestatus.findAll", query="SELECT i FROM Issuestatus i")
public class IssueStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ISSUESTATUS_ID")
	private int issuestatusId;

	@Column(name="ISSUESTATUS_TYPE")
	private String issuestatusType;

	//bi-directional many-to-one association to Issue
	@OneToMany(mappedBy="issuestatus")
	private List<Issue> issues;

	public IssueStatus() {
	}

	public int getIssuestatusId() {
		return this.issuestatusId;
	}

	public void setIssuestatusId(int issuestatusId) {
		this.issuestatusId = issuestatusId;
	}

	public String getIssuestatusType() {
		return this.issuestatusType;
	}

	public void setIssuestatusType(String issuestatusType) {
		this.issuestatusType = issuestatusType;
	}

	public List<Issue> getIssues() {
		return this.issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

	public Issue addIssue(Issue issue) {
		getIssues().add(issue);
		issue.setIssuestatus(this);

		return issue;
	}

	public Issue removeIssue(Issue issue) {
		getIssues().remove(issue);
		issue.setIssuestatus(null);

		return issue;
	}

}