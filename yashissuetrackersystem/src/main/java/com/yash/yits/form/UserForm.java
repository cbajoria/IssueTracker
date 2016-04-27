package com.yash.yits.form;

import java.util.List;

public class UserForm {

	private String userId;
	
	private String userAliasName;

	private String userDepartment;

	private String userEmail;

	private String userJobTitle;

	private String userManagerId;

	private String userManagerName;

	private String userMobile;

	private String userName;

	private String userOffice;


	public UserForm() {
	}
	
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserAliasName() {
		return this.userAliasName;
	}

	public void setUserAliasName(String userAliasName) {
		this.userAliasName = userAliasName;
	}

	public String getUserDepartment() {
		return this.userDepartment;
	}

	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserJobTitle() {
		return this.userJobTitle;
	}

	public void setUserJobTitle(String userJobTitle) {
		this.userJobTitle = userJobTitle;
	}

	public String getUserManagerId() {
		return this.userManagerId;
	}

	public void setUserManagerId(String userManagerId) {
		this.userManagerId = userManagerId;
	}

	public String getUserManagerName() {
		return this.userManagerName;
	}

	public void setUserManagerName(String userManagerName) {
		this.userManagerName = userManagerName;
	}

	public String getUserMobile() {
		return this.userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserOffice() {
		return this.userOffice;
	}

	public void setUserOffice(String userOffice) {
		this.userOffice = userOffice;
	}
}
