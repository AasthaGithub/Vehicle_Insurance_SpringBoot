package com.lti.project.bean;

import java.sql.Date;

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
public class Policy {
	
	@Id
	@Column(name="Policy_Num")
//	@OneToOne
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="POLICY_GEN")
    @SequenceGenerator(name="POLICY_GEN",sequenceName="policy_seq",allocationSize=1)
	private long policyNum;
	
	@JoinColumn(name="Vehicle_Reg_Num")
	@ManyToOne(fetch=FetchType.LAZY)
	private Vehicle vehicleRegNum;
	
	@JoinColumn(name="User_Id")
	@ManyToOne(fetch=FetchType.LAZY)
	private User userId;
	
	@JoinColumn(name="Plan_Id")
	@ManyToOne(fetch=FetchType.LAZY)
	private Plan planId;
	
	@Column(name="Period")
	private int period;
	
	@Column(name="Start_Date")
	private Date startDate;
	
	@Column(name="End_Date")
	private Date endDate;

	public Policy() {
		super();
	}

	public Policy(long policyNum, Vehicle vehicleRegNum, User userId, Plan planId, int period, Date startDate,
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

	public long getPolicyNum() {
		return policyNum;
	}

	public void setPolicyNum(long policyNum) {
		this.policyNum = policyNum;
	}

	
	public Vehicle getVehicleRegNum() {
		return vehicleRegNum;
	}

	public void setVehicleRegNum(Vehicle vehicleRegNum) {
		this.vehicleRegNum = vehicleRegNum;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Plan getPlanId() {
		return planId;
	}

	public void setPlanId(Plan planId) {
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

}
