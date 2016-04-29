package com.yash.yits.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.yits.dao.IssueDao;
import com.yash.yits.domain.Issue;
import com.yash.yits.domain.IssueAssignedStatus;
import com.yash.yits.domain.IssuePriority;
import com.yash.yits.domain.IssueStatus;
import com.yash.yits.domain.IssueType;
import com.yash.yits.domain.Project;
import com.yash.yits.domain.User;
import com.yash.yits.form.IssueAssignedStatusForm;
import com.yash.yits.form.IssueForm;
import com.yash.yits.form.IssuePriorityForm;
import com.yash.yits.form.IssueStatusForm;
import com.yash.yits.form.IssueTypeForm;
import com.yash.yits.form.ProjectForm;
import com.yash.yits.form.UserForm;

/**This is a IssueService. This object will communicate between controller and dao.
 * This will be responsible for transferring
 * data by mapping from form to domain object*/
@Service
public class IssueServiceImpl implements IssueService{

	@Autowired
	IssueDao issueDao;
	
	@Autowired
	DozerBeanMapper mapper;
	
	public List<IssuePriorityForm> getPriorities() {
		
		List<IssuePriorityForm> issuePriorityForms = new ArrayList<IssuePriorityForm>();
		for (IssuePriority issuePriority : issueDao.getPriorities()) {
			
			issuePriorityForms.add(mapper.map(issuePriority, IssuePriorityForm.class));
		}
		return issuePriorityForms;
	}

	public List<ProjectForm> getProjects() {
		
		List<ProjectForm> projectForms = new ArrayList<ProjectForm>();
		for (Project project : issueDao.getProjects()) {
			
			projectForms.add(mapper.map(project, ProjectForm.class));
		}
		return projectForms;
	}

	public List<IssueTypeForm> getIssueType() {
		
		List<IssueTypeForm> issueTypeForms = new ArrayList<IssueTypeForm>();
		for (IssueType issueType : issueDao.getIssueType()) {
			
			issueTypeForms.add(mapper.map(issueType, IssueTypeForm.class));
		}
		return issueTypeForms;
	}

	public List<IssueAssignedStatusForm> getAssignedStatus() {
		
		List<IssueAssignedStatusForm> issueAssignedStatusForms = new ArrayList<IssueAssignedStatusForm>();
		for (IssueAssignedStatus issueAssignedStatus : issueDao.getAssignedStatus()) {
			
			issueAssignedStatusForms.add(mapper.map(issueAssignedStatus, IssueAssignedStatusForm.class));
		}
		return issueAssignedStatusForms;
	}

	public List<IssueStatusForm> getIssueStatus() {
		
		 List<IssueStatusForm> issueStatusForms = new ArrayList<IssueStatusForm>();
		 for (IssueStatus issueStatus : issueDao.getIssueStatus()) {
				
			 issueStatusForms.add(mapper.map(issueStatus, IssueStatusForm.class));
			}
		return issueStatusForms;
	}
	
	public List<UserForm> getAssigneeList() {
	
		 List<UserForm> userForm = new ArrayList<UserForm>();
		 for (User user : issueDao.getAssigneeList()) {
				
			 userForm.add(mapper.map(user, UserForm.class));
			}
		return userForm;
	}

	/*this method is responsible for creating issue*/
	public int createIssue(IssueForm issueForm) {
		
		Issue issue = mapper.map(issueForm, Issue.class);

		//set Assigned status
		if(issue.getUser().getUserId()!=null){
			issue.getIssueAssignedStatus().setIssueassignmentStatusId(2);
		}
		int issueId = issueDao.createIssue(issue);
		return 1;
	}
}