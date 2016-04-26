package com.yash.yits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yash.yits.form.IssueTypeForm;
import com.yash.yits.service.IssueTypeService;
/**
 * 
 * @author sharma.pankaj
 * IssueTypeController will be used to handle requests comming from /issuetype url
 * and providing model name for different requests.
 * On IssueTypeController IssueTypeService will be autowired, and this will be used for calling IssueType service
 * methods.  
 */
@Controller
@RequestMapping("/issuetype")

public class IssueTypeController {
	
	/**
	 * issueTypeService is used to call Business service methods
	 */
	@Autowired
	private IssueTypeService issueTypeService;
	
	
	@RequestMapping("/welcome.htm")
	public String welcomeView(){
		return "welcome";
	}
	
	@RequestMapping(value="/showIssueTypeForm.htm",method=RequestMethod.GET)
	public String showIssueTypeForm(){
		
		return "issueTypeForm";
	}
	
	@RequestMapping(value="/addIssueType.htm",method=RequestMethod.POST)
	@ResponseBody
	public String addIssueType(@RequestBody IssueTypeForm issueTypeForm){
	
		issueTypeService.saveIssueType(issueTypeForm);
		return "Issue Type : "+issueTypeForm.getIssueType()+" added.";
	}
}
