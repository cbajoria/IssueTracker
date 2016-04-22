package com.yash.yits.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the issuepriority database table.
 * 
 */
@Entity
@NamedQuery(name="Issuepriority.findAll", query="SELECT i FROM Issuepriority i")
public class Issuepriority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ISSUEPRIORITY_ID")
	private int issuepriorityId;

	@Column(name="ISSUEPRIORITY_TYPE")
	private String issuepriorityType;

	//bi-directional many-to-one association to Issue
	@OneToMany(mappedBy="issuepriority")
	private List<Issue> issues;

	public Issuepriority() {
	}

	public int getIssuepriorityId() {
		return this.issuepriorityId;
	}

	public void setIssuepriorityId(int issuepriorityId) {
		this.issuepriorityId = issuepriorityId;
	}

	public String getIssuepriorityType() {
		return this.issuepriorityType;
	}

	public void setIssuepriorityType(String issuepriorityType) {
		this.issuepriorityType = issuepriorityType;
	}

	public List<Issue> getIssues() {
		return this.issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

	public Issue addIssue(Issue issue) {
		getIssues().add(issue);
		issue.setIssuepriority(this);

		return issue;
	}

	public Issue removeIssue(Issue issue) {
		getIssues().remove(issue);
		issue.setIssuepriority(null);

		return issue;
	}

}