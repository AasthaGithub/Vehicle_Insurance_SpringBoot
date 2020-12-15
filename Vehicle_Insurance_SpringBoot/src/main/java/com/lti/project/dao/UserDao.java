package com.lti.project.dao;

import java.sql.Date;
import java.util.List;

import com.lti.project.bean.Claims;
import com.lti.project.bean.Plan;
import com.lti.project.bean.Policy;
import com.lti.project.bean.User;
import com.lti.project.bean.Vehicle;
import com.lti.project.exceptions.HrExceptions;

public interface UserDao {
	
	public List<User> getAllUsers() throws HrExceptions;
	
	public User getUserById(int id) throws HrExceptions;
	
	public boolean addUser(User u) throws HrExceptions;
	//updated checkLogin
	public User CheckLogin(String EnteredEmail , String EnteredPassword) throws HrExceptions;
	
	//Policies
	public List<Policy> getAllPolicies() throws HrExceptions;
	
	public Policy getPolicyById(long policyNum) throws HrExceptions;
	
	public List<Policy> getPolicyByUser(String userEmail) throws HrExceptions;
	
	public List<Vehicle> getAllVehicle() throws HrExceptions;
	
	public Vehicle getVehicleByRegNum(String regNum) throws HrExceptions;
	
	public Plan getPlanById(int planId) throws HrExceptions;
	
	public boolean addPolicy(Policy p,int userId,String regNum,int planId) throws HrExceptions;
	
	public boolean addVehicle(Vehicle v,int userId) throws HrExceptions;
	
	public int updatePolicyEndDate(int id, Date newEndDate) throws HrExceptions;
	
	public boolean deletePolicy(int id) throws HrExceptions;
	
	//Claims
	public List<Claims> getClaimsById(String userEmail) throws HrExceptions; //mfrc
	
	public abstract boolean claimPolicy(Claims clm,long policyNum) throws HrExceptions; //mfrc
}
