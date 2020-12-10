package com.lti.project.dao;

import java.sql.Date;
import java.util.List;

import com.lti.project.bean.Claims;
import com.lti.project.bean.Policy;
import com.lti.project.bean.User;
import com.lti.project.bean.Vehicle;
import com.lti.project.exceptions.HrExceptions;

public interface UserDao {
	
	public List<User> getAllUsers() throws HrExceptions;
	
	public boolean addUser(User u) throws HrExceptions;
	
	public boolean CheckLogin(String EnteredEmail , String EnteredPassword) throws HrExceptions;
	
	//Policies
	public List<Policy> getAllPolicies() throws HrExceptions;
	
	public List<Vehicle> getAllVehicle() throws HrExceptions;
	
	public boolean addPolicy(Policy p) throws HrExceptions;
	
	public boolean addVehicle(Vehicle v) throws HrExceptions;
	
	public int updatePolicyEndDate(int id, Date newEndDate) throws HrExceptions;
	
	public boolean deletePolicy(int id) throws HrExceptions;
	
	public Policy findPolicyById(int id) throws HrExceptions;
	
	//Claims
	public abstract List<Claims> getClaims() throws HrExceptions;
	
	public abstract boolean claimPolicy(Claims clm) throws HrExceptions; 
}
