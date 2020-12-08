package com.lti.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.project.bean.Claims;
import com.lti.project.bean.Plan;

@Repository
public class ClaimsDaoImlp implements ClaimsDao  {

	@PersistenceContext
	private EntityManager manager;

	public List<Claims> getClaims()
	{
		String strQry = "from Claims";
		Query qry = manager.createQuery(strQry);
		List<Claims> claimList= qry.getResultList();
		return claimList;
		//user method
		
		
	}
	//public Claims claimPolicy(Claims pol) {	//user method}
	
	public int approveClaim(long reqNum) {
		
		String strQry= "UPDATE  Claims ApprovStatus=:stat WHERE Request_Num=:reqno";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("stat","Approved");
		qry.setParameter("reqno",reqNum);
		int i = qry.executeUpdate();
		return i;
		//admin method	
	}
	public List<Claims> viewClaims(){
		
		String strQry = "from Claims";
		Query qry = manager.createQuery(strQry);
		List<Claims> claimList= qry.getResultList();
		return claimList;
		//admin method
	}
	
}
