package com.lti.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.lti.project.bean.Claims;
import com.lti.project.bean.Plan;
import com.lti.project.bean.User;
import com.lti.project.exceptions.HrExceptions;

@Repository
public class AdminDaoImpl implements AdminDao{
	
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
	public List<Long> estimatePlan(String vehicleType) throws HrExceptions {
		String strQry = "select planAmt from Plan where vehicleType like :vehicle";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("vehicle", "%"+vehicleType+"%");
		List<Long> lst = qry.getResultList();
		return lst;
	}
	
	@Override
	public int PlanId(String vehicleType, String planType) throws HrExceptions {
		String strQry = "select planId from Plan where vehicleType like :vehicle and planType like :plan";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("vehicle", "%"+vehicleType+"%");
		qry.setParameter("plan", "%"+planType+"%");
		int res = (int) qry.getSingleResult();
		return res;
	}
	
	@Override
	public Long PlanAmount(String vehicleType, String planType) throws HrExceptions {
		String strQry = "select planAmt from Plan where vehicleType like :vehicle and planType like :plan";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("vehicle", "%"+vehicleType+"%");
		qry.setParameter("plan", "%"+planType+"%");
		Long res = (Long)qry.getSingleResult();
		return res;
	}
	
	@Transactional
	@Modifying
	public int approveClaim(long reqNum) {
		
		String strQry= "UPDATE  Claims set ApprovStatus=:stat WHERE Request_Num=:reqno";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("stat","Approved");
		qry.setParameter("reqno",reqNum);
		int i = qry.executeUpdate();
		return i;
		//adminDaoImpl method	
	}
	
	@Transactional
	@Modifying
	public int declineClaim(long reqNum) {
		
		String strQry= "UPDATE  Claims set ApprovStatus=:stat WHERE Request_Num=:reqno";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("stat","Declined");
		qry.setParameter("reqno",reqNum);
		int i = qry.executeUpdate();
		return i;
		//admin method	
	}
	
	public List<Claims> viewClaims(){
		
		String strQry = "from Claims";
		Query qry = manager.createQuery(strQry);
		List<Claims> claimList= qry.getResultList();
		return claimList;
		//admin method
	}

		


}
