package com.yash.yits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@RequestMapping("/showIssueTypeForm.htm")
	public String showIssueTypeForm(Model model){
		IssueTypeForm issueTypeForm=new IssueTypeForm();
		model.addAttribute("issueTypeForm", issueTypeForm);
		return "issueTypeForm";
	}
}
