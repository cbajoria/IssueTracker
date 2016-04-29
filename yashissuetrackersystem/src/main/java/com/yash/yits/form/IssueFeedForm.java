package com.yash.yits.form;

import java.util.Date;

public class IssueFeedForm {

	private int issueFeedId;
	private Date issueFeedDate;
	private String issueFeedDescription;
	private String userName;
	private String issueType;
	private Long userId;
	private String projectName;
	
	

	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getIssueFeedId() {
		return issueFeedId;
	}
	public void setIssueFeedId(int issueFeedId) {
		this.issueFeedId = issueFeedId;
	}
	public Date getIssueFeedDate() {
		return issueFeedDate;
	}
	public void setIssueFeedDate(Date issueFeedDate) {
		this.issueFeedDate = issueFeedDate;
	}
	public String getIssueFeedDescription() {
		return issueFeedDescription;
	}
	public void setIssueFeedDescription(String issueFeedDescription) {
		this.issueFeedDescription = issueFeedDescription;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIssueType() {
		return issueType;
	}
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	
}
