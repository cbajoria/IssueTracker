package com.yash.yits.dao.hibernate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.yits.dao.IssueFeedDao;
import com.yash.yits.domain.Issue;
import com.yash.yits.domain.IssueFeed;

import com.yash.yits.domain.IssuePriority;
import com.yash.yits.domain.IssueType;
import com.yash.yits.domain.Project;
import com.yash.yits.domain.User;
import com.yash.yits.form.IssueFeedForm;

@Repository
public class IssueFeedDaoImpl implements IssueFeedDao {

	@Autowired
	SessionFactory sessionFactory;

	public List<User> getusername() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User");
		List<User> users = query.list();

		List<User> users1 = new ArrayList<User>();
		for (User user : users) {
			User user1 = new User();
			user1.setUserId(user.getUserId());
			user1.setUserName(user.getUserName());
			users1.add(user1);
		}

		session.getTransaction().commit();
		session.close();

		return users1;

	}



	public List<IssueType> getIssueTypesList() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from IssueType");
		List<IssueType> issuetypes = query.list();

		List<IssueType> issuetypes1 = new ArrayList<IssueType>();

		for (IssueType issueType : issuetypes) {
			IssueType issueType2 = new IssueType();
			issueType2.setIssueType(issueType.getIssueType());
			issueType2.setIssueId(issueType.getIssueId());
			issuetypes1.add(issueType2);

		}

		return issuetypes1;
	}

	public List<Project> getProjectNamesList() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Project");
		List<Project> projects = query.list();

		List<Project> projects2 = new ArrayList<Project>();
		for (Project project : projects) {
			Project project2 = new Project();
			project2.setProjectName(project.getProjectName());
			project2.setProjectId(project.getProjectId());
			projects2.add(project2);

		}

		return projects2;
	}

	public List<IssuePriority> getIssuePriorityList() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from IssuePriority");
		List<IssuePriority> issuepriorities = query.list();

		List<IssuePriority> issuePriorities2 = new ArrayList<IssuePriority>();

		for (IssuePriority issuePriority : issuepriorities) {

			IssuePriority issuePriority2 = new IssuePriority();
			issuePriority2.setIssuePriorityType(issuePriority.getIssuePriorityType());
			issuePriority2.setIssuePriorityId(issuePriority.getIssuePriorityId());
			issuePriorities2.add(issuePriority2);
		}

		return issuePriorities2;
	}

	public List<IssueFeedForm> getFilteredIssue(int issuepriorityId, int issuetypeId, Long usernameId,
			String projectnameId, Date fromdate, Date todate) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria crit = session.createCriteria(Issue.class);
		Criteria issuePriorityCrit1 = crit.createCriteria("issueFeeds");

		if (usernameId != 0) {
			System.out.println("here");
			Criteria userCrit = issuePriorityCrit1.createCriteria("user");
			userCrit.add(Restrictions.eq("userId", usernameId));
			
		}
		if (issuetypeId != 0) {
			Criteria issueTypeCrit = crit.createCriteria("issueType");
			issueTypeCrit.add(Restrictions.eq("issueId", issuetypeId));
		}
		if (projectnameId != null) {
			Criteria projectCrit = crit.createCriteria("project");
			projectCrit.add(Restrictions.eq("projectId", projectnameId));
		}
		if (issuepriorityId != 0) {
			Criteria issuePriorityCrit = crit.createCriteria("issuePriority");
			issuePriorityCrit.add(Restrictions.eq("issuePriorityId", issuepriorityId));
		}
		if (fromdate.compareTo(new java.util.Date(1000 - 10 - 10)) > 0
				&& todate.compareTo(new java.util.Date(1000 - 10 - 10)) > 0) {
			System.out.println("hello");

			issuePriorityCrit1.add(Restrictions.between("issueFeedDate", fromdate, todate));
		}

		List<Issue> issues = crit.list();

		Set<IssueFeed> issuefeeds = new HashSet<IssueFeed>();
		List<IssueFeed> feeds = new ArrayList<IssueFeed>();

		System.out.println(issues);
		for (Issue issue : issues) {
			feeds = issue.getIssueFeeds();

			if (usernameId != 0 || fromdate.compareTo(new java.util.Date(1000 - 10 - 10)) > 0
					&& todate.compareTo(new java.util.Date(1000 - 10 - 10)) > 0) {
					System.out.println("anyone is fillled");
				for (IssueFeed issueFeed : feeds) {
					java.util.Date date = issueFeed.getIssueFeedDate();
					System.out.println(date);

					if (usernameId != 0 && !(fromdate.compareTo(new java.util.Date(1000 - 10 - 10)) > 0 && todate.compareTo(new java.util.Date(1000 - 10 - 10)) > 0) ) {
						System.out.println("username not empty and date empty");
						if (issueFeed.getUser().getUserId().equals(usernameId)) {
							System.out.println(issueFeed.getUser().getUserId());
							System.out.println(usernameId);
							issuefeeds.add(issueFeed);
						}
					}
					
					
					if (usernameId != 0 && fromdate.compareTo(new java.util.Date(1000 - 10 - 10)) > 0 && todate.compareTo(new java.util.Date(1000 - 10 - 10)) > 0 ) {
						System.out.println("username not empty and date not empty");
						if (issueFeed.getUser().getUserId().equals(usernameId) && date.after(fromdate) && date.before(todate) ) {
							System.out.println(issueFeed.getUser().getUserId());
							System.out.println(usernameId);
							issuefeeds.add(issueFeed);
						}
					}
					

					if (fromdate.compareTo(new java.util.Date(1000 - 10 - 10)) > 0 && todate.compareTo(new java.util.Date(1000 - 10 - 10)) > 0 && !(usernameId != 0)) {
						System.out.println("date not empty username empty");
						if (date.after(fromdate) && date.before(todate)) {
							System.out.println("true");
							issuefeeds.add(issueFeed);
						}
					}
				}

			} else {
				System.out.println("both empty");
				issuefeeds.addAll(feeds);
			}
		}

			System.out.println(issuefeeds);
			List<IssueFeedForm> issuefeeds2 = new ArrayList<IssueFeedForm>();
			for (IssueFeed issuefeed : issuefeeds) {
				System.out.println(issuefeed.getIssueFeedId());
				IssueFeedForm issuefeed2 = new IssueFeedForm();
				issuefeed2.setIssueType(issuefeed.getIssue().getIssueType().getIssueType());
				issuefeed2.setIssueFeedDate(issuefeed.getIssueFeedDate());
				issuefeed2.setIssueFeedId(issuefeed.getIssueFeedId());
				issuefeed2.setIssueFeedDescription(issuefeed.getIssueFeedDescription());
				User user = issuefeed.getUser();
				issuefeed2.setUserId(user.getUserId());
				issuefeed2.setUserName(user.getUserName());
				issuefeed2.setProjectName(issuefeed.getIssue().getProject().getProjectName());
				issuefeeds2.add(issuefeed2);

			}

			session.getTransaction().commit();
			session.close();
			return issuefeeds2;
		
		

	}

	
}
