package com.yash.yits.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yash.yits.domain.Issue;
import com.yash.yits.form.IssueForm;
import com.yash.yits.form.UserForm;
import com.yash.yits.service.IssueService;

/**This is a IssueController. This object will communicate with front-end.
 * This will be responsible for managing flow related to issues.*/
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
	
	@RequestMapping(value="/editIssueView",method=RequestMethod.GET)
	public List<IssueForm> getAllIssues(HttpServletRequest httpServletRequest){
		
		 UserForm userForm=((UserForm)httpServletRequest.getAttribute("UserFormObject"));
		 return issueService.fetchAllIssues(userForm.getUserId());
		
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
	
	@RequestMapping(value="/showDetails",method=RequestMethod.GET)
	public String showDetais(){
		System.out.println("Hello");
		return"SearchIssue";
	}
	
	@RequestMapping(value="/createIssue",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String submitCreateIssueForm(@RequestBody IssueForm issueForm){

		System.out.println(issueForm.getIssueDueDate());
		System.out.println(issueForm.getIssueAssignedStatus().getIssueAssignmentStatusId());//
		System.out.println(issueForm.getIssueStatus().getIssueStatusId());//
		
		
		issueService.createIssue(issueForm);
		return "success";
	}
	
	
}