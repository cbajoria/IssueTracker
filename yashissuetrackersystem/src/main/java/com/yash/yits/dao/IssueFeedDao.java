package com.yash.yits.dao;

import java.sql.Date;
import java.util.List;


import com.yash.yits.domain.IssuePriority;
import com.yash.yits.domain.IssueType;
import com.yash.yits.domain.Project;
import com.yash.yits.domain.User;
import com.yash.yits.form.IssueFeedForm;

public interface IssueFeedDao {
	public List<User> getusername();
	public List<IssueType> getIssueTypesList();
	public List<Project> getProjectNamesList();
	public List<IssuePriority> getIssuePriorityList();
	public List<IssueFeedForm> getFilteredIssue(int issuepriorityId,int issuetypeId,Long usernameId,String projectnameId,Date fromdate ,Date todate  );

}
