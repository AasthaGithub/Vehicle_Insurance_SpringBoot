package com.lti.project.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.project.bean.Claim;
import com.lti.project.bean.Plan;

@Repository
public class ClaimsDaoImlp implements ClaimsDao  {

	@PersistenceContext
	private EntityManager manager;

	public List<Claim> getClaims()
	{
		String strQry = "from Claims";
		Query qry = manager.createQuery(strQry);
		List<Claim> claimList= qry.getResultList();
		return claimList;
		//user method
		
		
	}
	public  boolean claimPolicy(long polNum, long reqamt, String reason)
	{	
		//String strQry ="Select planAmt from Policy pl JOIN  Plan pa WHERE pl.planId==pa.planId"
		//Query qry = manager.createQuery(strQry);
		//String resultPlanAmt= qry.getResult();
		// if (reqamt<=resultPlanAmt && reason.equals("Natural Disaster")) -----
		
		int appramt=0;
		if (reason.equals("Natural Disaster")){
			appramt=(int) (0.8*reqamt);
		}
		else if (reason.equals("Road Accident")){
			appramt=(int) (0.65*reqamt);
		}
		else if (reason.equals("Theft")){
			appramt=(int) (0.5*reqamt);
		}
		else if (reason.equals("Man Made Disaster")){
			appramt=0;
		}
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate = formatter.format(date);
		
		Claim clm=new Claim();
		//clm.setReqAmt(reqamt);
		clm.setReason(reason);
		clm.setApprovAmt(appramt);
		clm.setApprovStatus("Pending");
		clm.setClaimDate(strDate);  //today's date
		clm.setPolicyNum(polNum);
		//user method	
		return true;
	}
	
	
	public int approveClaim(long reqNum) {
		
		String strQry= "UPDATE  Claims ApprovStatus=:stat WHERE Request_Num=:reqno";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("stat","Approved");
		qry.setParameter("reqno",reqNum);
		int i = qry.executeUpdate();
		return i;
		//adminDaoImpl method	
	}
	
	public int declineClaim(long reqNum) {
		
		String strQry= "UPDATE  Claims ApprovStatus=:stat WHERE Request_Num=:reqno";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("stat","Declined");
		qry.setParameter("reqno",reqNum);
		int i = qry.executeUpdate();
		return i;
		//admin method	
	}
	
	public List<Claim> viewClaims(){
		
		String strQry = "from Claims";
		Query qry = manager.createQuery(strQry);
		List<Claim> claimList= qry.getResultList();
		return claimList;
		//admin method
	}	
	
}
