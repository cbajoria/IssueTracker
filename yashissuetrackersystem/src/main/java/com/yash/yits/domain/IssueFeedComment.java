package com.yash.yits.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the issuefeedcomment database table.
 * 
 */
@Entity
@NamedQuery(name="Issuefeedcomment.findAll", query="SELECT i FROM Issuefeedcomment i")
public class IssueFeedComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ISSUEFEEDCOMMENT_ID")
	private int issuefeedcommentId;

	@Temporal(TemporalType.DATE)
	@Column(name="ISSUEFEEDCOMMENT_DATE")
	private Date issuefeedcommentDate;

	@Lob
	@Column(name="ISSUEFEEDCOMMENT_DESCRIPTION")
	private String issuefeedcommentDescription;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	//bi-directional many-to-one association to Issuefeed
	@ManyToOne
	@JoinColumn(name="ISSUEFEED_ID")
	private IssueFeed issuefeed;

	public IssueFeedComment() {
	}

	public int getIssuefeedcommentId() {
		return this.issuefeedcommentId;
	}

	public void setIssuefeedcommentId(int issuefeedcommentId) {
		this.issuefeedcommentId = issuefeedcommentId;
	}

	public Date getIssuefeedcommentDate() {
		return this.issuefeedcommentDate;
	}

	public void setIssuefeedcommentDate(Date issuefeedcommentDate) {
		this.issuefeedcommentDate = issuefeedcommentDate;
	}

	public String getIssuefeedcommentDescription() {
		return this.issuefeedcommentDescription;
	}

	public void setIssuefeedcommentDescription(String issuefeedcommentDescription) {
		this.issuefeedcommentDescription = issuefeedcommentDescription;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public IssueFeed getIssuefeed() {
		return this.issuefeed;
	}

	public void setIssuefeed(IssueFeed issuefeed) {
		this.issuefeed = issuefeed;
	}

}