package com.yash.yits.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the issue database table.
 * 
 */
@Entity
@NamedQuery(name="Issue.findAll", query="SELECT i FROM Issue i")
public class Issue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ISSUEDETAIL_ID")
	private int issuedetailId;

	@Column(name="ISSUE_AFFECTEDVERSION")
	private String issueAffectedversion;

	@Column(name="ISSUE_COMPONENT")
	private String issueComponent;

	@Column(name="ISSUE_DESCRIPTION")
	private String issueDescription;

	@Temporal(TemporalType.DATE)
	@Column(name="ISSUE_DUEDATE")
	private Date issueDuedate;

	@Column(name="ISSUE_ENVIRONMENT")
	private String issueEnvironment;

	@Column(name="ISSUE_ORIGINALESTIMATE")
	private int issueOriginalestimate;

	@Column(name="ISSUE_REMAININGESTIMATE")
	private int issueRemainingestimate;

	@Column(name="ISSUE_SUMMARY")
	private String issueSummary;

	//bi-directional many-to-one association to Issueassignedstatus
	@ManyToOne
	@JoinColumn(name="ISSUEASSIGNED_STATUS")
	private IssueAssignedStatus issueassignedstatus;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="ISSUE_ASSIGNEEID")
	private User user;

	//bi-directional many-to-one association to Issuetype
	@ManyToOne
	@JoinColumn(name="ISSUE_TYPE_ID")
	private IssueType issuetype;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="ISSUE_PROJECT_ID")
	private Project project;

	//bi-directional many-to-one association to Issuepriority
	@ManyToOne
	@JoinColumn(name="ISSUE_PRIORITY_ID")
	private IssuePriority issuepriority;

	//bi-directional many-to-one association to Issuestatus
	@ManyToOne
	@JoinColumn(name="ISSUE_STATUS_ID")
	private IssueStatus issuestatus;

	//bi-directional many-to-many association to Attachment
	@ManyToMany(mappedBy="issues")
	private List<Attachment> attachments;

	//bi-directional many-to-one association to Issuefeed
	@OneToMany(mappedBy="issue")
	private List<IssueFeed> issuefeeds;

	public Issue() {
	}

	public int getIssuedetailId() {
		return this.issuedetailId;
	}

	public void setIssuedetailId(int issuedetailId) {
		this.issuedetailId = issuedetailId;
	}

	public String getIssueAffectedversion() {
		return this.issueAffectedversion;
	}

	public void setIssueAffectedversion(String issueAffectedversion) {
		this.issueAffectedversion = issueAffectedversion;
	}

	public String getIssueComponent() {
		return this.issueComponent;
	}

	public void setIssueComponent(String issueComponent) {
		this.issueComponent = issueComponent;
	}

	public String getIssueDescription() {
		return this.issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	public Date getIssueDuedate() {
		return this.issueDuedate;
	}

	public void setIssueDuedate(Date issueDuedate) {
		this.issueDuedate = issueDuedate;
	}

	public String getIssueEnvironment() {
		return this.issueEnvironment;
	}

	public void setIssueEnvironment(String issueEnvironment) {
		this.issueEnvironment = issueEnvironment;
	}

	public int getIssueOriginalestimate() {
		return this.issueOriginalestimate;
	}

	public void setIssueOriginalestimate(int issueOriginalestimate) {
		this.issueOriginalestimate = issueOriginalestimate;
	}

	public int getIssueRemainingestimate() {
		return this.issueRemainingestimate;
	}

	public void setIssueRemainingestimate(int issueRemainingestimate) {
		this.issueRemainingestimate = issueRemainingestimate;
	}

	public String getIssueSummary() {
		return this.issueSummary;
	}

	public void setIssueSummary(String issueSummary) {
		this.issueSummary = issueSummary;
	}

	public IssueAssignedStatus getIssueassignedstatus() {
		return this.issueassignedstatus;
	}

	public void setIssueassignedstatus(IssueAssignedStatus issueassignedstatus) {
		this.issueassignedstatus = issueassignedstatus;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public IssueType getIssuetype() {
		return this.issuetype;
	}

	public void setIssuetype(IssueType issuetype) {
		this.issuetype = issuetype;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public IssuePriority getIssuepriority() {
		return this.issuepriority;
	}

	public void setIssuepriority(IssuePriority issuepriority) {
		this.issuepriority = issuepriority;
	}

	public IssueStatus getIssuestatus() {
		return this.issuestatus;
	}

	public void setIssuestatus(IssueStatus issuestatus) {
		this.issuestatus = issuestatus;
	}

	public List<Attachment> getAttachments() {
		return this.attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public List<IssueFeed> getIssuefeeds() {
		return this.issuefeeds;
	}

	public void setIssuefeeds(List<IssueFeed> issuefeeds) {
		this.issuefeeds = issuefeeds;
	}

	public IssueFeed addIssuefeed(IssueFeed issuefeed) {
		getIssuefeeds().add(issuefeed);
		issuefeed.setIssue(this);

		return issuefeed;
	}

	public IssueFeed removeIssuefeed(IssueFeed issuefeed) {
		getIssuefeeds().remove(issuefeed);
		issuefeed.setIssue(null);

		return issuefeed;
	}

}