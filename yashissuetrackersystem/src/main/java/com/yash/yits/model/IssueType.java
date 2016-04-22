package com.yash.yits.model;
/**
 * 
 * @author sharma.pankaj
 * This is the IssueType Domain Object. This object will hold the IssueType data
 * This domain will map to issuetype table in database
 */

public class IssueType {
	/**
	 * Name of the issue type
	 */
	private String issueType;
	/**
	 * getter of issue type
	 * @return issueType
	 */
	public String getIssueType() {
		return issueType;
	}
	/**
	 * setter of issue type
	 * @param issueType 
	 */
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	
	
	
	
}
