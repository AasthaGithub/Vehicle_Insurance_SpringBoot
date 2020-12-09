package com.lti.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.project.bean.Claims;
import com.lti.project.exceptions.HrExceptions;

@Repository
public class ClaimsDaoImlp implements ClaimsDao{

	@PersistenceContext
	private EntityManager manager;

	public List<Claims> getClaims() throws HrExceptions
	{
		String strQry = "from Claims";
		Query qry = manager.createQuery(strQry);
		List<Claims> claimList= qry.getResultList();
		return claimList;
		//user method
		
		
	}
	
	@Transactional
	public  boolean claimPolicy(Claims clm) throws HrExceptions
	{	
		int appramt=0;
		if (clm.getReason().equals("Natural Disaster")){
			appramt=(int) (0.8*clm.getReqAmt());
		}
		else if (clm.getReason().equals("Road Accident")){
			appramt=(int) (0.65*clm.getReqAmt());
		}
		else if (clm.getReason().equals("Theft")){
			appramt=(int) (0.5*clm.getReqAmt());
		}
		else if (clm.getReason().equals("Man Made Disaster")){
			appramt=0;
		}
		
		clm.setApprovAmt(appramt);
		clm.setApprovStatus("Pending");
		manager.persist(clm);
		
		return true;
	}
	
	@Transactional
	public int approveClaim(long reqNum) {
		
		String strQry= "UPDATE  Claims ApprovStatus=:stat WHERE Request_Num=:reqno";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("stat","Approved");
		qry.setParameter("reqno",reqNum);
		int i = qry.executeUpdate();
		return i;
		//adminDaoImpl method	
	}
	
	@Transactional
	public int declineClaim(long reqNum) {
		
		String strQry= "UPDATE  Claims ApprovStatus=:stat WHERE Request_Num=:reqno";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("stat","Declined");
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