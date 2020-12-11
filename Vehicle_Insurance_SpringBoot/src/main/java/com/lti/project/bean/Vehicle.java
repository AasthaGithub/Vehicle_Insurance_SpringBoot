package com.lti.project.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicles")
public class Vehicle implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Vehicle_Reg_Num")
//	@OneToOne
	private String regNum;
	
	@JoinColumn(name="User_id")
	@ManyToOne(fetch=FetchType.EAGER)
	private User userId;
	
	@Column(name="Model")
	private String model;
	
	@Column(name="Vechile_Type_V")
	private String vehicleType;
	
	@Column(name="Manufacturer")
	private String manufact;
	
	@Column(name="Driving_License")
	private String license;
	
	@Column(name="Purchase_Date")
	private Date purchaseDate;
	
	@Column(name="Engine_Num")
	private String engNo;
	
	@Column(name="Chasis_Num")
	private String chassisNo;

	
	public Vehicle() {
		super();
	}

	public Vehicle(String regNum,User userId, String model, String vehicleType, String manufact, String license,
			Date purchaseDate, String engNo, String chassisNo) {
		super();
		this.regNum = regNum;
		this.userId = userId;
		this.model = model;
		this.vehicleType = vehicleType;
		this.manufact = manufact;
		this.license = license;
		this.purchaseDate = purchaseDate;
		this.engNo = engNo;
		this.chassisNo = chassisNo;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getManufact() {
		return manufact;
	}

	public void setManufact(String manufact) {
		this.manufact = manufact;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getEngNo() {
		return engNo;
	}

	public void setEngNo(String engNo) {
		this.engNo = engNo;
	}

	public String getChassisNo() {
		return chassisNo;
	}

	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}

	@Override
	public String toString() {
		return "Vehicle [regNum=" + regNum + ", userId=" + userId + ", model=" + model + ", vehicleType=" + vehicleType
				+ ", manufact=" + manufact + ", license=" + license + ", purchaseDate=" + purchaseDate + ", engNo="
				+ engNo + ", chassisNo=" + chassisNo + "]";
	}
	
	
	
	

}
