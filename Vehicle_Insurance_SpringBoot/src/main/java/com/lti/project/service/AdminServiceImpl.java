package com.lti.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.project.bean.Claims;
import com.lti.project.bean.Plan;
import com.lti.project.bean.User;
import com.lti.project.dao.AdminDao;
import com.lti.project.exceptions.HrExceptions;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao dao;

	@Override
	public List<Plan> getAllPlans() throws HrExceptions {
		return dao.getAllPlans();
	}
	
	@Transactional
	@Override
	public boolean addPlan(Plan p) throws HrExceptions {
		return dao.addPlan(p);
	}
	
	@Transactional
	@Override
	public boolean deletePlan(int id) throws HrExceptions {
		return dao.deletePlan(id);
	}
	
	@Transactional
	@Override
	public int updatePlan(int id, Long amt) throws HrExceptions {
		return dao.updatePlan(id, amt);
	}
	
	@Override
	public List<Long> estimatePlan(String vehicleType) throws HrExceptions {
		return dao.estimatePlan(vehicleType);
	}
	
	@Override
	public int PlanId(String vehicleType, String planType) throws HrExceptions {
		return dao.PlanId(vehicleType, planType);
	}
	
	
	public int approveClaim(long reqNum) {
		return dao.approveClaim(reqNum);
		//admin method
	}
	
	public int declineClaim(long reqNum) {
		return dao.declineClaim(reqNum);
		//admin method
	}
	public  List<Claims> viewClaims(){
		return dao.viewClaims();
		//admin method
	}

	@Override
	public Long PlanAmount(String vehicleType, String planType) throws HrExceptions {
		return dao.PlanAmount(vehicleType, planType);
	}

	

	

}
