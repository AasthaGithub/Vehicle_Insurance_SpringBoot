

package com.lti.project.dao;

import java.util.List;

import com.lti.project.bean.Claims;

public interface ClaimsDao {
	
	public abstract List<Claims> getClaims();  //user method
	public abstract boolean claimPolicy(long polNum,long reqamt,String reason); //user method
	
	public abstract int approveClaim(long reqNum);  //admin method
	public int declineClaim(long reqNum); //admin method
	public abstract List<Claims> viewClaims(); //admin method
	

}
