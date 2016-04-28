/**
 * 
 */
package com.yash.yits.controller;

import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yash.yits.form.LoginForm;
import com.yash.yits.form.UserForm;
import com.yash.yits.service.LoginService;

/**
 * @author somesh.kumar
 *
 */
@Controller
@RequestMapping("Login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	/**
	 * @return login page
	 */
	
	@RequestMapping(value="/loginForm")
	public String getLoginForm()
	{
		System.out.println("in login");
		return "login";
	}
	
	/**
	 * 
	 * @param loginForm
	 * @return UserForm Object
	 * @throws NamingException
	 */
			
	
	@ResponseBody
	@RequestMapping(value="/validateUser",method=RequestMethod.POST)
	public UserForm validateUser(@RequestBody LoginForm loginForm) throws NamingException
	{
		/**
		 * loginService CheckUser first check the user in database, if not persist then insert into database
		 */
		InitialDirContext ctx=loginService.checkUser(loginForm);
		
		/**
		 *finding the index of '@' in user email 
		 */
		
		int position=loginForm.getUsername().indexOf("@");
		/**
		 * retrieve the user name before the '@' symbol
		 */
		String username=loginForm.getUsername().substring(0,position);
		
		/**
		 *loginService fetchAttributes fetch the attributes of particular user 
		 */
		
		UserForm userForm=loginService.fetchAttributes(ctx,username);
		/**
		 * returning the userForm Object
		 */
		
		return userForm;
		
	
		
		
		
	}
}
