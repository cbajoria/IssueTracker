package com.yash.yits.form;

import java.util.Date;

public class IssueForm {
	
	private String issueAffectedVersion;

	private String issueComponent;

	private String issueDescription;

	private Date issueCreationDate;

	private Date issueDueDate;

	private String issueEnvironment;

	private int issueOriginalEstimate;

	private int issueRemainingEstimate;

	private String issueSummary;

	private IssueAssignedStatusForm issueAssignedStatusForm;

	private UserForm userForm;

	private IssueTypeForm issueTypeForm;

	private ProjectForm projectForm;

	private IssuePriorityForm issuePriorityForm;

	private IssueStatusForm issueStatusForm;

//	private List<AttachmentForm> attachments;

	public IssueForm() {
		
		this.issueAssignedStatusForm = new IssueAssignedStatusForm();
		this.userForm = new UserForm();
		this.issueTypeForm = new IssueTypeForm();
		this.projectForm = new ProjectForm();
		this.issuePriorityForm = new IssuePriorityForm();
		this.issueStatusForm = new IssueStatusForm();
	}
	
	public String getIssueAffectedVersion() {
		return issueAffectedVersion;
	}

	public void setIssueAffectedVersion(String issueAffectedVersion) {
		this.issueAffectedVersion = issueAffectedVersion;
	}

	public String getIssueComponent() {
		return issueComponent;
	}

	public void setIssueComponent(String issueComponent) {
		this.issueComponent = issueComponent;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	public Date getIssueCreationDate() {
		return issueCreationDate;
	}

	public void setIssueCreationDate(Date issueCreationDate) {
		this.issueCreationDate = issueCreationDate;
	}

	public Date getIssueDueDate() {
		return issueDueDate;
	}

	public void setIssueDueDate(Date issueDueDate) {
		this.issueDueDate = issueDueDate;
	}

	public String getIssueEnvironment() {
		return issueEnvironment;
	}

	public void setIssueEnvironment(String issueEnvironment) {
		this.issueEnvironment = issueEnvironment;
	}

	public int getIssueOriginalEstimate() {
		return issueOriginalEstimate;
	}

	public void setIssueOriginalEstimate(int issueOriginalEstimate) {
		this.issueOriginalEstimate = issueOriginalEstimate;
	}

	public int getIssueRemainingEstimate() {
		return issueRemainingEstimate;
	}

	public void setIssueRemainingEstimate(int issueRemainingEstimate) {
		this.issueRemainingEstimate = issueRemainingEstimate;
	}

	public String getIssueSummary() {
		return issueSummary;
	}

	public void setIssueSummary(String issueSummary) {
		this.issueSummary = issueSummary;
	}

	public IssueAssignedStatusForm getIssueAssignedStatusForm() {
		return issueAssignedStatusForm;
	}

	public void setIssueAssignedStatusForm(
			IssueAssignedStatusForm issueAssignedStatusForm) {
		this.issueAssignedStatusForm = issueAssignedStatusForm;
	}

	public UserForm getUserForm() {
		return userForm;
	}

	public void setUserForm(UserForm userForm) {
		this.userForm = userForm;
	}

	public IssueTypeForm getIssueTypeForm() {
		return issueTypeForm;
	}

	public void setIssueTypeForm(IssueTypeForm issueTypeForm) {
		this.issueTypeForm = issueTypeForm;
	}

	public ProjectForm getProjectForm() {
		return projectForm;
	}

	public void setProjectForm(ProjectForm projectForm) {
		this.projectForm = projectForm;
	}

	public IssuePriorityForm getIssuePriorityForm() {
		return issuePriorityForm;
	}

	public void setIssuePriorityForm(IssuePriorityForm issuePriorityForm) {
		this.issuePriorityForm = issuePriorityForm;
	}

	public IssueStatusForm getIssueStatusForm() {
		return issueStatusForm;
	}

	public void setIssueStatusForm(IssueStatusForm issueStatusForm) {
		this.issueStatusForm = issueStatusForm;
	}
}
