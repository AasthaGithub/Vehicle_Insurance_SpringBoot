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
}
