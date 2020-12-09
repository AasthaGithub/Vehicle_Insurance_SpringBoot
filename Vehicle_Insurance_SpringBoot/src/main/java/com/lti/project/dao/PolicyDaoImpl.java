package com.lti.project.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.lti.project.bean.Policy;
import com.lti.project.exceptions.HrExceptions;

public class PolicyDaoImpl implements PolicyDao {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Policy> getAllPolicies() throws HrExceptions {
		String strQry = "from Policy";
		Query qry = manager.createQuery(strQry);
		List<Policy> policyList= qry.getResultList();
		return policyList;
	}

	@Transactional
	@Override
	public boolean addPolicy(Policy p) throws HrExceptions {
		manager.persist(p);
		return true;
	}

	@Override
	public int updatePolicyEndDate(int id, Date newEndDate) throws HrExceptions {
		String strQry = "update Policy set endDate=:newEndDate where policyId=:pid";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("newEndDate",newEndDate);
		qry.setParameter("pid",id);
		int i = qry.executeUpdate();
		return i;
	}

	@Override
	public boolean deletePolicy(int id) throws HrExceptions {
		Policy p = manager.find(Policy.class, id);
		manager.remove(p);
		return true;
	}

	@Override
	public Policy findPolicyById(int id) throws HrExceptions {
		Policy p = manager.find(Policy.class, id);
		return p;
	}

}
