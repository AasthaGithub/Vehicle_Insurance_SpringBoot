package com.lti.project.service;

import java.sql.Date;
import java.util.List;

import com.lti.project.bean.Policy;
import com.lti.project.exceptions.HrExceptions;

public interface PolicyService {
	
	public abstract List<Policy> getAllPolicies() throws HrExceptions;
	
	public abstract boolean addPolicy(Policy p) throws HrExceptions;
	
	public abstract int updatePolicyEndDate(int id, Date newEndDate) throws HrExceptions;
	
	public abstract boolean deletePolicy(int id) throws HrExceptions;
	
	public abstract Policy findPolicyById(int id) throws HrExceptions;

}
