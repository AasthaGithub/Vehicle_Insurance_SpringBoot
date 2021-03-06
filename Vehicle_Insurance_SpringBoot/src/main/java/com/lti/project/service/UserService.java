package com.lti.project.service;

import java.sql.Date;
import java.util.List;

import com.lti.project.bean.Claims;
import com.lti.project.bean.Policy;
import com.lti.project.bean.User;
import com.lti.project.bean.Vehicle;
import com.lti.project.exceptions.HrExceptions;

public interface UserService {
	
public List<User> getAllUsers() throws HrExceptions;
	
	public boolean addUser(User u) throws HrExceptions;
	//updated checkLogin
	public User CheckLogin(String EnteredEmail , String EnteredPassword) throws HrExceptions;
	
	public abstract List<Policy> getAllPolicies() throws HrExceptions;
	
	public List<Policy> getPolicyByUser(String userEmail) throws HrExceptions;
	
	public List<Vehicle> getAllVehicle() throws HrExceptions;

	public boolean addPolicy(Policy p,String userId,String regNum,int planId) throws HrExceptions;

	
	public boolean addVehicle(Vehicle v,String userEmail) throws HrExceptions;
	
	public abstract int updatePolicyEndDate(int id, Date newEndDate) throws HrExceptions;
	
	public abstract boolean deletePolicy(int id) throws HrExceptions;
	
	public List<String> getVehicleNamesList(String vehicle_type) throws HrExceptions;
	
	public List<Claims> getClaimsById(String userEmail) throws HrExceptions;
	
	public abstract boolean claimPolicy(Claims clm,long policyNum) throws HrExceptions; 

}
