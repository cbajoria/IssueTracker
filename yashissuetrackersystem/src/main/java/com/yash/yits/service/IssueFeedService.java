package com.yash.yits.service;

import java.sql.Date;
import java.util.List;


import com.yash.yits.domain.IssuePriority;
import com.yash.yits.domain.IssueType;
import com.yash.yits.domain.Project;
import com.yash.yits.domain.User;
import com.yash.yits.form.IssueFeedForm;

public interface IssueFeedService {
	public List<User> getusername();
	public List<IssueType> getIssueTypesList();
	public List<Project> getProjectNamesList();
	public List<IssuePriority> getIssuePriorityList();
	public List<IssueFeedForm> getFilteredIssue(int issuepriorityId,int issuetypeId,Long usernameId1,String projectnameId,Date fromdate ,Date todate  );
}
