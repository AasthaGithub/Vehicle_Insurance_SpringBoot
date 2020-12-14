package com.lti.project.dao;

import java.util.List;

import com.lti.project.bean.Claims;
import com.lti.project.bean.Plan;
import com.lti.project.bean.User;
import com.lti.project.exceptions.HrExceptions;

public interface AdminDao {
	
	public List<Plan> getAllPlans() throws HrExceptions;
	
	public boolean addPlan(Plan p) throws HrExceptions;
	
	public int updatePlan(int id,Long amt) throws HrExceptions;
	
	public boolean deletePlan(int id) throws HrExceptions;
	
	public List<Long> estimatePlan(String vehicleType) throws HrExceptions;
	
	public Long PlanAmount(String vehicleType,String planType) throws HrExceptions;
	
	public abstract int approveClaim(long reqNum); //mfrc
	
	public int declineClaim(long reqNum); //mfrc
	
	public abstract List<Claims> viewClaims(); //mfrc//DONE

}
