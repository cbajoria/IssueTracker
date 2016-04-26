package com.yash.yits.dao;

import java.util.List;

import com.yash.yits.domain.IssueType;


/**
 * 
 * @author sharma.pankaj
 * Interface for IssueType
 */
public interface IssueTypeDao {
	/**
	 * 
	 * @param issueType
	 */
	public void saveIssueType(IssueType issueType);
	
	public List<IssueType> getAllIssueType();

}
