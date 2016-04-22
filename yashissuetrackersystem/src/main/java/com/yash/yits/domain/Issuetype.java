package com.yash.yits.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the issuetype database table.
 * 
 */
@Entity
@NamedQuery(name="Issuetype.findAll", query="SELECT i FROM Issuetype i")
public class Issuetype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ISSUE_ID")
	private int issueId;

	@Column(name="ISSUE_TYPE")
	private String issueType;

	//bi-directional many-to-one association to Issue
	@OneToMany(mappedBy="issuetype")
	private List<Issue> issues;

	public Issuetype() {
	}

	public int getIssueId() {
		return this.issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public String getIssueType() {
		return this.issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public List<Issue> getIssues() {
		return this.issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

	public Issue addIssue(Issue issue) {
		getIssues().add(issue);
		issue.setIssuetype(this);

		return issue;
	}

	public Issue removeIssue(Issue issue) {
		getIssues().remove(issue);
		issue.setIssuetype(null);

		return issue;
	}

}