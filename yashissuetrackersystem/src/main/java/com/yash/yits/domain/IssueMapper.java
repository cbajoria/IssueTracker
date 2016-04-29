package com.yash.yits.domain;

import java.util.Date;

public class IssueMapper {

	private int issueFeedId;
	private Date issueFeedDate;
	private String issueFeedDescription;
	private String userName;
	private String issueType;
	private String userId;
	private String issueFromDate;
	private String issueToDate;
	
	
	
	
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	
}
