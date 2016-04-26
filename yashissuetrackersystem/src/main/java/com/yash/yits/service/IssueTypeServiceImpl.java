package com.yash.yits.service;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.yash.yits.dao.IssueTypeDao;
import com.yash.yits.domain.IssueType;
import com.yash.yits.form.IssueTypeForm;
/**
 * 
 * @author sharma.pankaj
 * This is the implementation of IssueTypeService, here form bean will be validated, and 
 * mapped with model object using Dozzer Mapping
 */
@Service
public class IssueTypeServiceImpl implements IssueTypeService {

	/**
	 * issueTypeDao is used to call the dao layer methods. it will be automatically injected by spring.
	 */
	@Autowired
	private IssueTypeDao issueTypeDao;
	
	/**
	 * DozerBeanMapperReference (mapper) is will be used to map form object with bean
	 */
	@Autowired
	DozerBeanMapper mapper;
	
	/**
	 * implementation of saveIssueType() method to Save IssueType received from controller by calling the IssueTypeDaoImpl Object.
	 * @param issueType
	 */
	
	private final Logger logger=LoggerFactory.getLogger(IssueTypeServiceImpl.class);
	
	public void saveIssueType(IssueTypeForm issueTypeForm) {
		logger.info("inside saveIssueType() of IssueTypeServiceImpl");
		
		/*form mapped to domain*/
		IssueType issueType = mapper.map(issueTypeForm, IssueType.class);
		
		issueTypeDao.saveIssueType(issueType);

	}
	
	/**
	 * 
	 * @param issueTypeForm
	 * @param errors
	 * @return null in case of errors, mapped object in case there is no error
	 */
	public IssueType validate(IssueTypeForm issueTypeForm, Errors errors ){
		
		if(errors.hasErrors()){
			logger.error("has errors");
			return null;
		}
		else{
			return convertToIssueType(issueTypeForm);
		}
		
	}

	private IssueType convertToIssueType(IssueTypeForm issueTypeForm) {
		IssueType issueType=(IssueType)mapper.map(issueTypeForm, IssueType.class);
		return issueType;
	}

}
