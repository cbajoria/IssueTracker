package com.yash.yits.form;
/**
 * 
 * @author sharma.pankaj
 * This is input form for IssueType.This form bean is not used for display purpose.
 */
public class IssueTypeForm {
	/**
	 * id of the issue type
	 */
	private int issueId;
	/**
	 * Name of the issue type
	 */
	private String issueType;
	/**
	 * 	
	 * @return issueID
	 * getter of issue id
	 */
	public int getIssueId() {
		return issueId;
	}
	/**
	 * setter of isse id
	 * @param issueId
	 */
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
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
