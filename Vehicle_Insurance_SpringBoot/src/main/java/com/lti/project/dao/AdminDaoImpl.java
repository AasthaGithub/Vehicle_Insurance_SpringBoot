package com.lti.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

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
	public List<Long> findPlanByVehicle(String vehicleType) throws HrExceptions {
		String strQry = "select planAmt from Plan where vehicleType like :vehicle";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("vehicle", "%"+vehicleType+"%");
		List<Long> lst = qry.getResultList();
		return lst;
	}

	@Transactional
	@Override
	public boolean addUser(User u) throws HrExceptions {
		manager.persist(u);
		return true;
	}

	@Override
	public List<User> getAllUsers() throws HrExceptions {
		String strQry = "from User";
		Query qry = manager.createQuery(strQry);
		List<User> userList= qry.getResultList();
		return userList;
	}

	@Override
	public boolean CheckLogin(String EnteredEmail, String EnteredPassword) throws HrExceptions {
		String strQry ="Select userPswd from User Where userEmail  = :EnteredEmail";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("EnteredEmail",EnteredEmail);
		String ActualPassword= (String) qry.getSingleResult();
		
		if ((ActualPassword).equals(EnteredPassword))
		{
		return true;
		}
		else 
		{
		return false;
		}
	}

}
