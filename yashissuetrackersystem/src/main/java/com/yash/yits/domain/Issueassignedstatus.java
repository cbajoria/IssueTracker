package com.yash.yits.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the issueassignedstatus database table.
 * 
 */
@Entity
@NamedQuery(name="Issueassignedstatus.findAll", query="SELECT i FROM Issueassignedstatus i")
public class Issueassignedstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ISSUEASSIGNMENT_STATUS_ID")
	private int issueassignmentStatusId;

	@Column(name="ISSUEASSIGNMENT_STATUS")
	private String issueassignmentStatus;

	//bi-directional many-to-one association to Issue
	@OneToMany(mappedBy="issueassignedstatus")
	private List<Issue> issues;

	public Issueassignedstatus() {
	}

	public int getIssueassignmentStatusId() {
		return this.issueassignmentStatusId;
	}

	public void setIssueassignmentStatusId(int issueassignmentStatusId) {
		this.issueassignmentStatusId = issueassignmentStatusId;
	}

	public String getIssueassignmentStatus() {
		return this.issueassignmentStatus;
	}

	public void setIssueassignmentStatus(String issueassignmentStatus) {
		this.issueassignmentStatus = issueassignmentStatus;
	}

	public List<Issue> getIssues() {
		return this.issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

	public Issue addIssue(Issue issue) {
		getIssues().add(issue);
		issue.setIssueassignedstatus(this);

		return issue;
	}

	public Issue removeIssue(Issue issue) {
		getIssues().remove(issue);
		issue.setIssueassignedstatus(null);

		return issue;
	}

}