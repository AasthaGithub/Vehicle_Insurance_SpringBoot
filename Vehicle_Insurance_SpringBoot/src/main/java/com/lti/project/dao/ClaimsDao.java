

package com.lti.project.dao;

import java.util.List;

import com.lti.project.bean.Claims;
import com.lti.project.exceptions.HrExceptions;

public interface ClaimsDao {
	
	public abstract List<Claims> getClaims() throws HrExceptions;  //user method
	public abstract boolean claimPolicy(Claims clm) throws HrExceptions; //user method
	
	public abstract int approveClaim(long reqNum);  //admin method
	public int declineClaim(long reqNum); //admin method
	public abstract List<Claims> viewClaims(); //admin method
	

}
