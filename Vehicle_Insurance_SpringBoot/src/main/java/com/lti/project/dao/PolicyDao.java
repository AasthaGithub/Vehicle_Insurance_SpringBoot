package com.lti.project.dao;

import java.sql.Date;
import java.util.List;

import com.lti.project.bean.Policy;
import com.lti.project.exceptions.HrExceptions;

public interface PolicyDao {
	
	public List<Policy> getAllPolicies() throws HrExceptions;
	
	public boolean addPolicy(Policy p) throws HrExceptions;
	
	public int updatePolicyEndDate(int id, Date newEndDate) throws HrExceptions;
	
	public boolean deletePolicy(int id) throws HrExceptions;
	
	public Policy findPolicyById(int id) throws HrExceptions;

}
