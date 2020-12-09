package com.lti.project.dao;

import java.util.List;

import com.lti.project.bean.Plan;
import com.lti.project.bean.User;
import com.lti.project.exceptions.HrExceptions;

public interface AdminDao {
	
	public List<Plan> getAllPlans() throws HrExceptions;
	
	public boolean addPlan(Plan p) throws HrExceptions;
	
	public int updatePlan(int id,Long amt) throws HrExceptions;
	
	public boolean deletePlan(int id) throws HrExceptions;
	
	public List<Long> findPlanByVehicle(String vehicleType) throws HrExceptions;
	
	public List<User> getAllUsers() throws HrExceptions;
	
	public boolean addUser(User u) throws HrExceptions;
	
	public boolean CheckLogin(String EnteredEmail , String EnteredPassword) throws HrExceptions;

}
