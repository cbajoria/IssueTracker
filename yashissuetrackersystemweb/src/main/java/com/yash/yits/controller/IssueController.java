package com.yash.yits.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import jdk.nashorn.internal.ir.RuntimeNode.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yash.yits.domain.Issue;
import com.yash.yits.domain.IssuePriority;
import com.yash.yits.form.IssueForm;
import com.yash.yits.service.IssueService;

@Controller
public class IssueController {

	@Autowired
	IssueService issueService;
	
	@RequestMapping(value="/createUserIssueView",method=RequestMethod.GET)
	public String userIssueForm(){
		return"UserCreateIssueForm";
	}
	
	@RequestMapping(value="/createManagerIssueView",method=RequestMethod.GET)
	public String managerIssueForm(){
		return"ManagerCreateIssueForm";
	}
	
	@RequestMapping(value="/getPriority",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Object> getPriority(){
		List<Object> formList = new ArrayList<Object>();
		formList.add(issueService.getPriorities());
		formList.add(issueService.getAssigneeList());
		formList.add(issueService.getIssueType());
		formList.add(issueService.getProjects());
		return formList;
	}
	
	@RequestMapping(value="/createIssue",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String submitCreateIssueForm(@RequestBody IssueForm issueForm){

		System.out.println(issueForm.getIssueAffectedVersion());
		System.out.println(issueForm.getIssueComponent());
		System.out.println(issueForm.getIssueDescription());
		System.out.println(issueForm.getIssueDetailId());
		
		System.out.println(issueForm.getIssueEnvironment());
		System.out.println(issueForm.getIssueSummary());
		System.out.println(issueForm.getIssueAssignedStatus().getIssueAssignmentStatusId());
		System.out.println(issueForm.getIssueDueDate());
		System.out.println(issueForm.getIssuePriority().getIssuePriorityId());
		System.out.println(issueForm.getIssueStatus().getIssueStatusId());
		System.out.println(issueForm.getIssueType().getIssueId());
		System.out.println(issueForm.getProject().getProjectId());
		
		
		/*issueService.createIssue(issueForm);*/
		return "success";
	}
	
}