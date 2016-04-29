package com.yash.yits.controller;



import java.sql.Date;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yash.yits.domain.IssuePriority;
import com.yash.yits.domain.IssueType;
import com.yash.yits.domain.Project;
import com.yash.yits.domain.User;
import com.yash.yits.form.IssueFeedForm;
import com.yash.yits.service.IssueFeedService;


@Controller
public class FeedController {
	
	
	
	@Autowired
	IssueFeedService issueFeedService;

	@RequestMapping("searchPage")
	public String searchPage() {
		return "search";
	}


	/**
	 * getList method is used to display the prefilled data in drop data box of advance search
	 * @return list of username,project name,priority and issue type
	 */
	@ResponseBody
	@RequestMapping(value = "/getList",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getList(){
		List<User> users=issueFeedService.getusername();
		List<IssueType> issueTypes=  issueFeedService.getIssueTypesList();
		List<Project> projects= issueFeedService.getProjectNamesList();
		List<IssuePriority> issuePriorities=issueFeedService.getIssuePriorityList();
		
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("getusernameList", users);
		map.put("getIssueTypesList", issueTypes);
		map.put("getProjectNamesList",projects );
		map.put("getIssuePriorityList", issuePriorities);
	
		return map;
	
	}
	
	
	/**
	 * getFilteredFeedData method is used to filter all the feeds on the basis of user name, project name,
	 * priority,issue type and from date to to date
	 * @param usernameId
	 * @param issuetypeId
	 * @param projectnameId
	 * @param issuepriorityId
	 * @param fromDate
	 * @param todate
	 * @return filtered list of feed 
	 * @throws ParseException
	 */
	
	@ResponseBody
	@RequestMapping(value = "/getfeeddata/{username}/{issuetype}/{projectname}/{priority}/{todate}/{fromDate}",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<IssueFeedForm> getFilteredFeedData(@PathVariable("username") String usernameId,@PathVariable("issuetype") String issuetypeId,
												@PathVariable("projectname") String projectnameId,@PathVariable("priority") String issuepriorityId,
												@PathVariable("fromDate") Date fromDate,@PathVariable("todate") Date todate) throws ParseException{
		System.out.println(todate);
		System.out.println(fromDate);
		System.out.println(usernameId);
		System.out.println(projectnameId);
		System.out.println(issuetypeId);

	if(issuetypeId.equals("undefined")){
		issuetypeId="0";
	}
	int issuetypeId1=Integer.parseInt(issuetypeId);

	if(issuepriorityId.equals("undefined")){
		issuepriorityId="0";
	}
	int issuepriorityId1=Integer.parseInt(issuepriorityId);	
		
	if(usernameId.equals("undefined")){
			usernameId="0";
			System.out.println("in"+usernameId);
		}
	Long usernameId1=(long) Integer.parseInt(usernameId);	
		
	if(projectnameId.equals("undefined")){
		projectnameId=null;
			System.out.println("in"+projectnameId);
		}
		System.out.println(usernameId);
		List<IssueFeedForm> issueMappers=	issueFeedService.getFilteredIssue(issuepriorityId1, issuetypeId1, usernameId1, projectnameId, fromDate, todate);
		return issueMappers;	
	}	
	
	
	
}
