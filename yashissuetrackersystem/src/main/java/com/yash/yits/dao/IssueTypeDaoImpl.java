package com.yash.yits.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.yits.domain.IssueType;


/**
 * 
 * @author sharma.pankaj
 * It is a Repository, this will have hibernate sessionFactory to perform
 * all service related functionalities
 */
@Repository
public class IssueTypeDaoImpl implements IssueTypeDao {
	/**
	 * Hibernate SessionFactory reference is used to perform all transactions.\
	 * it will be autowired 
	 */
	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * logger will be used to log the messages for debugging
	 */
	private final Logger logger= LoggerFactory.getLogger(IssueTypeDaoImpl.class);


	public void saveIssueType(IssueType issueType) {
		logger.info("Inside saveIssueType of IssueTypeDaoImpl");
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(issueType);
		transaction.commit();
		session.close();

	}

	public List<IssueType> getAllIssueType() {
		
		return null;
	}

}
