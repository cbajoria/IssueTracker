package com.yash.yits.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.yits.dao.IssueDao;
import com.yash.yits.dao.IssueFeedDao;
import com.yash.yits.domain.IssuePriority;
import com.yash.yits.domain.IssueType;
import com.yash.yits.domain.Project;
import com.yash.yits.domain.User;
import com.yash.yits.form.IssueFeedForm;

@Service
public class IssueFeedServiceImpl implements IssueFeedService {

	@Autowired
	IssueFeedDao issuefeedDao;

	/**
	 *getUsernameList method is used to get all user names
	 */
	public List<User> getusername() {
		List<User> users=issuefeedDao.getusername();
		return users;
	}

	/**
	 * getIssueTypesList method is used to get all issue types
	 */
	public List<IssueType> getIssueTypesList() {
		List<IssueType> issueTypes=  issuefeedDao.getIssueTypesList();
		return issueTypes;
	}
	
	/**
	 * getProjectNamesList method is used to get all projects
	 */
	public List<Project> getProjectNamesList() {
		List<Project> projects= issuefeedDao.getProjectNamesList();
		return projects;
	}
	/**
	 * getIssuePriorityList method is used to get all priority
	 */
	
	public List<IssuePriority> getIssuePriorityList() {
		List<IssuePriority> issuePriorities=issuefeedDao.getIssuePriorityList();
		return issuePriorities;
	}
    
	/**
	 * getFilteredIssue method is used to get all issue feeds on advance search 
	 */
	
	public List<IssueFeedForm> getFilteredIssue(int issuepriorityId, int issuetypeId, Long usernameId,String projectnameId, Date fromdate, Date todate) {
		List<IssueFeedForm> issueMappers=	issuefeedDao.getFilteredIssue(issuepriorityId, issuetypeId, usernameId, projectnameId, fromdate, todate);
		return issueMappers;
	}

	

}
