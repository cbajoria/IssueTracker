package com.yash.yits.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value="/createIssueView",method=RequestMethod.GET)
	public String issueForm(){
		return"CreateIssueForm";
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

		issueService.createIssue(issueForm);
		return "success";
	}
	
}