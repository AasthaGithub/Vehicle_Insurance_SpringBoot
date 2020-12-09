package com.lti.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Long> findPlanByVehicle(String vehicleType) throws HrExceptions {
		return dao.findPlanByVehicle(vehicleType);
	}
	
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

}
