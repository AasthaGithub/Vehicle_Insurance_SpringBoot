
package com.lti.project.service;

import java.util.List;

import com.lti.project.bean.Claim;

public interface ClaimsService {
	public abstract List<Claim> getClaims();  //user method
	public abstract boolean claimPolicy(long polNum,long reqamt,String reason); //user method
	
	public abstract int approveClaim(long reqNum);  //admin method
	public int declineClaim(long reqNum); //admin method
	public abstract List<Claim> viewClaims(); //admin method
	

}

