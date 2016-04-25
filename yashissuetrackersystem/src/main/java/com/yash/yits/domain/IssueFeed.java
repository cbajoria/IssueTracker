package com.yash.yits.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the issuefeed database table.
 * 
 */
@Entity
@NamedQuery(name="Issuefeed.findAll", query="SELECT i FROM Issuefeed i")
public class IssueFeed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ISSUEFEED_ID")
	private int issuefeedId;

	@Temporal(TemporalType.DATE)
	@Column(name="ISSUEFEED_DATE")
	private Date issuefeedDate;

	@Lob
	@Column(name="ISSUEFEED_DESCRIPTION")
	private String issuefeedDescription;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	//bi-directional many-to-one association to Issue
	@ManyToOne
	@JoinColumn(name="ISSUE_ID")
	private Issue issue;

	//bi-directional many-to-one association to Issuefeedcomment
	@OneToMany(mappedBy="issuefeed")
	private List<IssueFeedComment> issuefeedcomments;

	public IssueFeed() {
	}

	public int getIssuefeedId() {
		return this.issuefeedId;
	}

	public void setIssuefeedId(int issuefeedId) {
		this.issuefeedId = issuefeedId;
	}

	public Date getIssuefeedDate() {
		return this.issuefeedDate;
	}

	public void setIssuefeedDate(Date issuefeedDate) {
		this.issuefeedDate = issuefeedDate;
	}

	public String getIssuefeedDescription() {
		return this.issuefeedDescription;
	}

	public void setIssuefeedDescription(String issuefeedDescription) {
		this.issuefeedDescription = issuefeedDescription;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Issue getIssue() {
		return this.issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public List<IssueFeedComment> getIssuefeedcomments() {
		return this.issuefeedcomments;
	}

	public void setIssuefeedcomments(List<IssueFeedComment> issuefeedcomments) {
		this.issuefeedcomments = issuefeedcomments;
	}

	public IssueFeedComment addIssuefeedcomment(IssueFeedComment issuefeedcomment) {
		getIssuefeedcomments().add(issuefeedcomment);
		issuefeedcomment.setIssuefeed(this);

		return issuefeedcomment;
	}

	public IssueFeedComment removeIssuefeedcomment(IssueFeedComment issuefeedcomment) {
		getIssuefeedcomments().remove(issuefeedcomment);
		issuefeedcomment.setIssuefeed(null);

		return issuefeedcomment;
	}

}