package com.lti.project.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.project.bean.Claims;
import com.lti.project.bean.Plan;
import com.lti.project.bean.Policy;
import com.lti.project.bean.User;
import com.lti.project.bean.Vehicle;
import com.lti.project.exceptions.HrExceptions;

@Repository
public class UserDaoImpl implements UserDao{
	
	@PersistenceContext
	private EntityManager manager;
	
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
	public User getUserById(int id) throws HrExceptions {
		User usr = manager.find(User.class,id);
		return usr;
	}
//changed login
	@Override
	public User CheckLogin(String EnteredEmail, String EnteredPassword) throws HrExceptions {
		int id = -1;
		String getidQry = "Select userId from User where userEmail = :EnteredEmail";
		Query idQry = manager.createQuery(getidQry);
		idQry.setParameter("EnteredEmail",EnteredEmail);
		id =  (int) idQry.getSingleResult();
		String strQry ="Select userPswd from User Where userId=:uid";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("uid",id);
		String ActualPassword= (String) qry.getSingleResult();
		User usr = null;
		
		if ((ActualPassword).equals(EnteredPassword))
		{
			usr = getUserById(id);
		}
		return usr;
	}
	
	///////////////////////Policies////////////////////////
	
	@Override
	public List<Policy> getAllPolicies() throws HrExceptions {
		String strQry = "from Policy";
		Query qry = manager.createQuery(strQry);
		List<Policy> policyList= qry.getResultList();
		return policyList;
	}
	
	@Override
	public List<Policy> getPolicyByUser(String userEmail) throws HrExceptions {
		String str = "from User where userEmail=:uId";
		Query qry1 = manager.createQuery(str);
		qry1.setParameter("uId", userEmail);
		User usr = (User)qry1.getSingleResult();
		String strQry ="from Policy where userId=:uid";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("uid", usr);
		return qry.getResultList();
	}
	
	@Override
	public Policy getPolicyById(long policyNum) throws HrExceptions {
		return manager.find(Policy.class, policyNum);
	}
	
	@Override
	public List<Vehicle> getAllVehicle() throws HrExceptions {
		String strQry = "from Vehicle";
		Query qry = manager.createQuery(strQry);
		List<Vehicle> vehicleList= qry.getResultList();
		return vehicleList;
	}
	
	@Override
	public Vehicle getVehicleByRegNum(String regNum) throws HrExceptions {
		return manager.find(Vehicle.class,regNum);
	}
	
	@Override
	public Plan getPlanById(int planId) throws HrExceptions {
		return manager.find(Plan.class, planId);
	}
	

	@Transactional
	@Override
	public boolean addPolicy(Policy p,String userId,String regNum,int planId) throws HrExceptions {
		String strQry = "from User where userEmail=:uemail";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("uemail",userId);
		User usr = (User)qry.getSingleResult();
		p.setUserId(usr);
		p.setVehicleRegNum(getVehicleByRegNum(regNum));
		p.setPlanId(getPlanById(planId));
		manager.persist(p);
		return true;
	}
	
	@Transactional
	@Override
	public boolean addVehicle(Vehicle v,String userEmail) throws HrExceptions {
		String str = "from User where userEmail=:uId";
		Query qry1 = manager.createQuery(str);
		qry1.setParameter("uId", userEmail);
		User usr = (User)qry1.getSingleResult();
		v.setUserId(usr);
		manager.persist(v);
		return true;
	}

	@Transactional
	@Override
	public int updatePolicyEndDate(int id, Date newEndDate) throws HrExceptions {
		long pid=id;
		String strQry = "update Policy set endDate=:newEndDate where policyNum=:pid";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("newEndDate",newEndDate);
		qry.setParameter("pid",pid);
		int i = qry.executeUpdate();
		return i;
	}

	@Transactional
	@Override
	public boolean deletePolicy(int id) throws HrExceptions {
		Policy p = manager.find(Policy.class, id);
		manager.remove(p);
		return true;
	}
	
	@Override
	public List<String> getVehicleNamesList(String vehicle_type) throws HrExceptions {
		String strQry = "select p.vehicleType from Plan p where vehicleType like :vehicle";
		
		Query qry = manager.createQuery(strQry);
		qry.setParameter("vehicle", "%"+vehicle_type+"%");
		List<String> resList= qry.getResultList();
		
		return  resList;
	}
	
	
	///////////////////Claims/////////////////
	
	@Override
	public List<Claims> getClaimsById(String userEmail) throws HrExceptions
	{
		String strQry1= "from User where userEmail=:uid";
		Query qry1 = manager.createQuery(strQry1);
		qry1.setParameter("uid", userEmail);
		User usr= (User)qry1.getSingleResult();
		
		String strQry = " select c.claimDate, c.ApprovStatus, c.reqAmt "
				+ "from Claims c, Policy p "
				+ "where p.policyNum=c.policyNum and p.userId=:uid";
		
		Query qry = manager.createQuery(strQry);
		List<Claims> resList= qry.setParameter("uid",usr).getResultList();
		return  resList;
		
		//user method
		
		
	}
	
	@Transactional
	@Override
	public  boolean claimPolicy(Claims clm,long policyNum) throws HrExceptions
	{	
		int appramt=0;
		if (clm.getReason().equals("Natural Disaster")){
			appramt=(int) (0.8*clm.getReqAmt());
		}
		else if (clm.getReason().equals("Road Accident")){
			appramt=(int) (0.65*clm.getReqAmt());
		}
		else if (clm.getReason().equals("Theft")){
			appramt=(int) (0.5*clm.getReqAmt());
		}
		else if (clm.getReason().equals("Man Made Disaster")){
			appramt=0;
		}
		
		clm.setApprovAmt(appramt);
		clm.setPolicyNum(getPolicyById(policyNum));
		clm.setApprovStatus("Pending");
		manager.persist(clm);
		
		return true;
	}


}
