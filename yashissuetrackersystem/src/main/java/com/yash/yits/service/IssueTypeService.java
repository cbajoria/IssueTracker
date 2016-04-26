package com.yash.yits.service;

import com.yash.yits.domain.IssueType;

/**
 * 
 * @author sharma.pankaj
 * It is a Service component, will perform business logic for IssueType
 */
public interface IssueTypeService {

	/**
	 * Save IssueType received from controller by calling the IssueTypeDaoImpl Object.
	 * @param issueType
	 */
	public void saveIssueType(IssueType issueType);
}
