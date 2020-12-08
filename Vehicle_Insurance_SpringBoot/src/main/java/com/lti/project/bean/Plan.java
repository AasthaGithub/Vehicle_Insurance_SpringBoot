package com.lti.project.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//can put entity name
@Entity
@Table(name="plans")
public class Plan {
	
	@Id
	@Column(name="Plan_Id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="PLAN_GEN")
    @SequenceGenerator(name="PLAN_GEN",sequenceName="plan_seq",allocationSize=1)
	private int planId;
	
	@Column(name="Amount")
	private Long planAmt;
	
	@Column(name="Vechile_type")
	private String vehicleType;
	
	@Column(name="Plan_type")
	private String planType;
	
	public Plan() {
		super();
	}

	public Plan(Long planAmt, String vehicleType, String planType) {
		super();
		this.planAmt = planAmt;
		this.vehicleType = vehicleType;
		this.planType = planType;
	}

	public Plan(int planId, Long planAmt, String vehicleType, String planType) {
		super();
		this.planId = planId;
		this.planAmt = planAmt;
		this.vehicleType = vehicleType;
		this.planType = planType;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public Long getPlanAmt() {
		return planAmt;
	}

	public void setPlanAmt(Long planAmt) {
		this.planAmt = planAmt;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	@Override
	public String toString() {
		return "Plan [planId=" + planId + ", planAmt=" + planAmt + ", vehicleType=" + vehicleType + ", planType="
				+ planType + "]";
	}
	
	
	

}
