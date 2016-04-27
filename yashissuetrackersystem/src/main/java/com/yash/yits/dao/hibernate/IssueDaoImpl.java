package com.yash.yits.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.yits.dao.IssueDao;
import com.yash.yits.domain.Issue;
import com.yash.yits.domain.IssueAssignedStatus;
import com.yash.yits.domain.IssuePriority;
import com.yash.yits.domain.IssueStatus;
import com.yash.yits.domain.IssueType;
import com.yash.yits.domain.Project;

@Repository
public class IssueDaoImpl implements IssueDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<IssuePriority> getPriorities() {
		
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(IssuePriority.class);
		List<IssuePriority> priorities = criteria.list();
		session.close();
		return priorities;
	}

	public List<Project> getProjects() {
	
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Project.class);
		List<Project> projects = criteria.list();
		session.close();
		return projects;
	}

	public List<IssueType> getIssueType() {
		
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(IssueType.class);
		List<IssueType> types = criteria.list();
		session.close();
		return types;
	}

	public List<IssueAssignedStatus> getAssignedStatus() {

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(IssueAssignedStatus.class);
		List<IssueAssignedStatus> assignedStatus = criteria.list();
		session.close();
		return assignedStatus;
	}

	public List<IssueStatus> getIssueStatus() {

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(IssueStatus.class);
		List<IssueStatus> issueStatus = criteria.list();
		session.close();
		return issueStatus;
	}

	public int createIssue(Issue issue) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int issueId = (Integer) session.save(issue);
		transaction.commit();
		session.close();
		return issueId;
	}
}
