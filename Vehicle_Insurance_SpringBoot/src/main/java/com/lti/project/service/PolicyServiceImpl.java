package com.lti.project.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.project.bean.Policy;
import com.lti.project.dao.PolicyDao;
import com.lti.project.exceptions.HrExceptions;

public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyDao policy_dao;
	
	@Override
	public List<Policy> getAllPolicies() throws HrExceptions {
		return policy_dao.getAllPolicies();
	}

	@Override
	public boolean addPolicy(Policy p) throws HrExceptions {
		return policy_dao.addPolicy(p);
	}

	@Override
	public int updatePolicyEndDate(int id, Date newEndDate) throws HrExceptions {
		return policy_dao.updatePolicyEndDate(id, newEndDate);
	}

	@Override
	public boolean deletePolicy(int id) throws HrExceptions {
		return policy_dao.deletePolicy(id);
	}

	@Override
	public Policy findPolicyById(int id) throws HrExceptions {
		return policy_dao.findPolicyById(id);
	}

}
