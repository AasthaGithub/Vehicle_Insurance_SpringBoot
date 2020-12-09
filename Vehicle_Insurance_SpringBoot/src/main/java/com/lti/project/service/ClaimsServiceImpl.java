
package com.lti.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.project.bean.Claims;
import com.lti.project.dao.ClaimsDao;
import com.lti.project.exceptions.HrExceptions;

@Service
public class ClaimsServiceImpl implements ClaimsService  {
	
	@Autowired
	private ClaimsDao dao;
	
	
	public List<Claims> getClaims() throws HrExceptions{
		return dao.getClaims();
		//user method
	}
	
	@Override
	public boolean claimPolicy(Claims clm) throws HrExceptions {
		return dao.claimPolicy(clm);
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


	

}





