

package com.lti.project.dao;

import java.util.List;

import com.lti.project.bean.Claims;

public interface ClaimsDao {
	
	public abstract List<Claims> getClaims();  //user method
	//public abstract Claims claimPolicy(Claims pol); //user method
	
	public abstract int approveClaim(long reqNum);  //admin method
	public abstract List<Claims> viewClaims(); //admin method
	

}
