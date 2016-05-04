package com.yash.yits.dao;

import java.util.List;

import com.yash.yits.domain.Issue;
import com.yash.yits.domain.IssueAssignedStatus;
import com.yash.yits.domain.IssuePriority;
import com.yash.yits.domain.IssueStatus;
import com.yash.yits.domain.IssueType;
import com.yash.yits.domain.Project;
import com.yash.yits.domain.User;
import com.yash.yits.form.IssueForm;

public interface IssueDao {

	public List<IssuePriority> getPriorities();
	
	public List<Project> getProjects();
	
	public List<IssueType> getIssueType();
	
	public List<IssueAssignedStatus> getAssignedStatus();
	
	public List<IssueStatus> getIssueStatus();
	
	public List<User> getAssigneeList();
	
	public List<Issue> getAllIssue(Long userId);
	
	public int createIssue(Issue issue);

	public List<Issue> getDefaultIssues(String date1, String date2);

	public List<Issue> search(String searchText);
	
}
