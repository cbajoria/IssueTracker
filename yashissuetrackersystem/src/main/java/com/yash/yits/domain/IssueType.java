package com.yash.yits.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the issuetype database table.
 * 
 */
@Entity
public class IssueType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ISSUE_ID")
	private int issueId;

	@Column(name="ISSUE_TYPE")
	private String issueType;

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
}