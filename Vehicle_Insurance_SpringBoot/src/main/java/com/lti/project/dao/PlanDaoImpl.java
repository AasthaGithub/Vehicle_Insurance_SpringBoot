package com.lti.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.project.bean.Plan;
import com.lti.project.exceptions.HrExceptions;

@Repository
public class PlanDaoImpl implements PlanDao{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Plan> getAllPlans() throws HrExceptions {
		String strQry = "from Plan";
		Query qry = manager.createQuery(strQry);
		List<Plan> planList= qry.getResultList();
		return planList;
	}

	@Transactional
	@Override
	public boolean addPlan(Plan p) throws HrExceptions {
		manager.persist(p);
		return true;
	}

	@Transactional
	@Override
	public boolean deletePlan(int id) throws HrExceptions {
		Plan p = manager.find(Plan.class, id);
		manager.remove(p);
		return true;
	}
	
	@Transactional
	@Override
	public int updatePlan(int id, Long amt) throws HrExceptions {
		String strQry = "update Plan set planAmt=:newAmt where planId=:pid";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("newAmt",amt);
		qry.setParameter("pid",id);
		int i = qry.executeUpdate();
		return i;
	}

	@Override
	public List<Long> findPlanByVehicle(String vehicleType) throws HrExceptions {
		String strQry = "select planAmt from Plan where vehicleType like :vehicle";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("vehicle", "%"+vehicleType+"%");
		List<Long> lst = qry.getResultList();
		return lst;
	}

}
