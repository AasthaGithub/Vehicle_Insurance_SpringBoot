package com.lti.project.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.project.bean.Claims;
import com.lti.project.bean.Policy;
import com.lti.project.bean.User;
import com.lti.project.bean.Vehicle;
import com.lti.project.dao.UserDao;
import com.lti.project.exceptions.HrExceptions;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;
	
	@Transactional
	@Override
	public boolean addUser(User u) throws HrExceptions {
		return dao.addUser(u);
	}

	@Override
	public List<User> getAllUsers() throws HrExceptions {
		return dao.getAllUsers();
	}

	@Override
	public boolean CheckLogin(String EnteredEmail, String EnteredPassword) throws HrExceptions {
		return dao.CheckLogin(EnteredEmail, EnteredPassword);
	}
	
	//////////////////Policies////////////////////////
	@Override
	public List<Policy> getAllPolicies() throws HrExceptions {
		return dao.getAllPolicies();
	}
	
	@Override
	public List<Vehicle> getAllVehicle() throws HrExceptions {
		return dao.getAllVehicle();
	}
	
	@Transactional
	@Override
	public boolean addPolicy(Policy p,int userId,String regNum,int planId) throws HrExceptions {
		return dao.addPolicy(p,userId,regNum,planId);
	}
	
	@Transactional
	@Override
	public boolean addVehicle(Vehicle v,int userId) throws HrExceptions {
		return dao.addVehicle(v,userId);
	}

	@Override
	public int updatePolicyEndDate(int id, Date newEndDate) throws HrExceptions {
		return dao.updatePolicyEndDate(id, newEndDate);
	}

	@Override
	public boolean deletePolicy(int id) throws HrExceptions {
		return dao.deletePolicy(id);
	}

	
	//////////////////////Claims///////////////////////////
	public List<Claims> getClaims() throws HrExceptions{
		return dao.getClaims();
		//user method
	}

	@Transactional
	@Override
	public boolean claimPolicy(Claims clm,long policyNum) throws HrExceptions {
		return dao.claimPolicy(clm,policyNum);
	}
	

}
