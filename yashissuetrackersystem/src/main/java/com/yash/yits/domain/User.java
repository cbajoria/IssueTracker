package com.yash.yits.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private String userId;

	@Column(name="USER_ALIAS_NAME")
	private String userAliasName;

	@Column(name="USER_DEPARTMENT")
	private String userDepartment;

	@Column(name="USER_EMAIL")
	private String userEmail;

	@Column(name="USER_JOB_TITLE")
	private String userJobTitle;

	@Column(name="USER_MANAGER_ID")
	private String userManagerId;

	@Column(name="USER_MANAGER_NAME")
	private String userManagerName;

	@Column(name="USER_MOBILE")
	private String userMobile;

	@Column(name="USER_NAME")
	private String userName;

	@Column(name="USER_OFFICE")
	private String userOffice;

	//bi-directional many-to-one association to Issue
	@OneToMany(mappedBy="user")
	private List<Issue> issues;

	//bi-directional many-to-one association to Issuefeed
	@OneToMany(mappedBy="user")
	private List<Issuefeed> issuefeeds;

	//bi-directional many-to-one association to Issuefeedcomment
	@OneToMany(mappedBy="user")
	private List<Issuefeedcomment> issuefeedcomments;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="user")
	private List<Project> projects1;

	//bi-directional many-to-many association to Project
	@ManyToMany
	@JoinTable(
		name="projectuser"
		, joinColumns={
			@JoinColumn(name="USER_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="PROJECT_ID")
			}
		)
	private List<Project> projects2;

	public User() {
	}

	public String getUserId() {
		return this.userId;
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

	public List<Issue> getIssues() {
		return this.issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

	public Issue addIssue(Issue issue) {
		getIssues().add(issue);
		issue.setUser(this);

		return issue;
	}

	public Issue removeIssue(Issue issue) {
		getIssues().remove(issue);
		issue.setUser(null);

		return issue;
	}

	public List<Issuefeed> getIssuefeeds() {
		return this.issuefeeds;
	}

	public void setIssuefeeds(List<Issuefeed> issuefeeds) {
		this.issuefeeds = issuefeeds;
	}

	public Issuefeed addIssuefeed(Issuefeed issuefeed) {
		getIssuefeeds().add(issuefeed);
		issuefeed.setUser(this);

		return issuefeed;
	}

	public Issuefeed removeIssuefeed(Issuefeed issuefeed) {
		getIssuefeeds().remove(issuefeed);
		issuefeed.setUser(null);

		return issuefeed;
	}

	public List<Issuefeedcomment> getIssuefeedcomments() {
		return this.issuefeedcomments;
	}

	public void setIssuefeedcomments(List<Issuefeedcomment> issuefeedcomments) {
		this.issuefeedcomments = issuefeedcomments;
	}

	public Issuefeedcomment addIssuefeedcomment(Issuefeedcomment issuefeedcomment) {
		getIssuefeedcomments().add(issuefeedcomment);
		issuefeedcomment.setUser(this);

		return issuefeedcomment;
	}

	public Issuefeedcomment removeIssuefeedcomment(Issuefeedcomment issuefeedcomment) {
		getIssuefeedcomments().remove(issuefeedcomment);
		issuefeedcomment.setUser(null);

		return issuefeedcomment;
	}

	public List<Project> getProjects1() {
		return this.projects1;
	}

	public void setProjects1(List<Project> projects1) {
		this.projects1 = projects1;
	}

	public Project addProjects1(Project projects1) {
		getProjects1().add(projects1);
		projects1.setUser(this);

		return projects1;
	}

	public Project removeProjects1(Project projects1) {
		getProjects1().remove(projects1);
		projects1.setUser(null);

		return projects1;
	}

	public List<Project> getProjects2() {
		return this.projects2;
	}

	public void setProjects2(List<Project> projects2) {
		this.projects2 = projects2;
	}

}