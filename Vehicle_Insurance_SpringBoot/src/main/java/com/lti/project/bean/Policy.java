package com.lti.project.bean;

import java.sql.Date;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="policies")
public class Policy {
	
	@Id
	@Column(name="Policy_Num")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="POLICY_GEN")
    //@SequenceGenerator(name="POLICY_GEN",sequenceName="policy_seq",allocationSize=1)
	private int policyNum;
	
	@Column(name="Vehicle_Reg_Num")
	private String vehicleRegNum;
	
	@Column(name="User_Id")
	private int userId;
	
	@Column(name="Plan_Id")
	private int planId;
	
	@Column(name="Period")
	private int period;
	
	@Column(name="Start_Date")
	private Date startDate;
	
	@Column(name="End_Date")
	private Date endDate;

	public Policy() {
		super();
	}

	public Policy(int policyNum, String vehicleRegNum, int userId, int planId, int period, Date startDate,
			Date endDate) {
		super();
		this.policyNum = policyNum;
		this.vehicleRegNum = vehicleRegNum;
		this.userId = userId;
		this.planId = planId;
		this.period = period;
		this.startDate = startDate;
		this.endDate = endDate;
	}	
	
	@Override
	public String toString() {
		return "Policy [policyNum=" + policyNum + ", vehicleRegNum=" + vehicleRegNum + ", userId=" + userId
				+ ", planId=" + planId + ", period=" + period + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}

	public int getPolicyNum() {
		return policyNum;
	}

	public void setPolicyNum(int policyNum) {
		this.policyNum = policyNum;
	}

	public String getVehicleRegNum() {
		return vehicleRegNum;
	}

	public void setVehicleRegNum(String vehicleRegNum) {
		this.vehicleRegNum = vehicleRegNum;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
	
	

=======
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="policies")
public class Policy{
	
	@Id
	@Column(name="Policy_num")
	private Long policyNum;
	
	
	private String vehicleRegNum;
	
	private int userId;
	
	@Column(name="Plan_Id")
	private int planId;
	
	@Column(name="Period")
	private int period;
	
	@Column(name="Start_Date")
	private Date startDate;
	
	@Column(name="End_Date")
	private Date endDate;
>>>>>>> branch 'main' of https://github.com/AasthaGithub/Vehicle_Insurance_SpringBoot.git
}
