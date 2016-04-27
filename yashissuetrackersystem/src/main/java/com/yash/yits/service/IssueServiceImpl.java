package com.yash.yits.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.yits.dao.IssueDao;
import com.yash.yits.domain.Issue;
import com.yash.yits.domain.IssueAssignedStatus;
import com.yash.yits.domain.IssuePriority;
import com.yash.yits.domain.IssueStatus;
import com.yash.yits.domain.IssueType;
import com.yash.yits.domain.Project;
import com.yash.yits.form.IssueAssignedStatusForm;
import com.yash.yits.form.IssueForm;
import com.yash.yits.form.IssuePriorityForm;
import com.yash.yits.form.IssueStatusForm;
import com.yash.yits.form.IssueTypeForm;
import com.yash.yits.form.ProjectForm;
import com.yash.yits.mapper.IssueAssignedStatusMapper;
import com.yash.yits.mapper.IssueMapper;
import com.yash.yits.mapper.IssuePriorityMapper;
import com.yash.yits.mapper.IssueStatusMapper;
import com.yash.yits.mapper.IssueTypeMapper;
import com.yash.yits.mapper.ProjectMapper;

@Service
public class IssueServiceImpl implements IssueService{

	@Autowired
	IssueDao issueDao;
	
	public List<IssuePriorityForm> getPriorities() {
		
		List<IssuePriorityForm> issuePriorityForms = new ArrayList<IssuePriorityForm>();
		for (IssuePriority issuePriority : issueDao.getPriorities()) {
			
			issuePriorityForms.add(IssuePriorityMapper.domainForm(issuePriority));
		}
		return issuePriorityForms;
	}

	public List<ProjectForm> getProjects() {
		
		List<ProjectForm> projectForms = new ArrayList<ProjectForm>();
		for (Project project : issueDao.getProjects()) {
			
			projectForms.add(ProjectMapper.domainForm(project));
		}
		return projectForms;
	}

	public List<IssueTypeForm> getIssueType() {
		
		List<IssueTypeForm> issueTypeForms = new ArrayList<IssueTypeForm>();
		for (IssueType issueType : issueDao.getIssueType()) {
			
			issueTypeForms.add(IssueTypeMapper.domainForm(issueType));
		}
		return issueTypeForms;
	}

	public List<IssueAssignedStatusForm> getAssignedStatus() {
		
		List<IssueAssignedStatusForm> issueAssignedStatusForms = new ArrayList<IssueAssignedStatusForm>();
		for (IssueAssignedStatus issueAssignedStatus : issueDao.getAssignedStatus()) {
			
			issueAssignedStatusForms.add(IssueAssignedStatusMapper.domainForm(issueAssignedStatus));
		}
		return issueAssignedStatusForms;
	}

	public List<IssueStatusForm> getIssueStatus() {
		
		 List<IssueStatusForm> issueStatusForms = new ArrayList<IssueStatusForm>();
		 for (IssueStatus issueStatus : issueDao.getIssueStatus()) {
				
			 issueStatusForms.add(IssueStatusMapper.domainForm(issueStatus));
			}
		return issueStatusForms;
	}

	public int createIssue(Issue issueForm) {
		
		//form to domain ????
		int issueId = issueDao.createIssue(issueForm); 
		return issueId;
	}
}