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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="claims")
public class Claims {
	
	@Id
	@Column(name="Request_Num")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="claim_seq")
    @SequenceGenerator(name="claim_seq", sequenceName="claim_seq", allocationSize=1)
	private long Request_Num;
	
	@Column(name="Claim_Date")
	private Date claimDate;
	
	@JoinColumn(name="Policy_Num")
	@ManyToOne(fetch=FetchType.LAZY)
	private Policy policyNum;
	
	@Column(name="Approval_Status")
	private String ApprovStatus;
	
	@Column(name="Request_Amount")
	private long reqAmt;
	
	@Column(name="Approval_Amount")
	private long approvAmt;
	
	@Column(name="Reason")
	private String reason;

	public long getRequest_Num() {
		return Request_Num;
	}

	public void setRequest_Num(long request_Num) {
		Request_Num = request_Num;
	}

	

	public Date getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

	

	public Policy getPolicyNum() {
		return policyNum;
	}

	public void setPolicyNum(Policy policyNum) {
		this.policyNum = policyNum;
	}

	public String getApprovStatus() {
		return ApprovStatus;
	}

	public void setApprovStatus(String approvStatus) {
		ApprovStatus = approvStatus;
	}

	public long getReqAmt() {
		return reqAmt;
	}

	public void setReqAmt(long reqAmt) {
		this.reqAmt = reqAmt;
	}

	public long getApprovAmt() {
		return approvAmt;
	}

	public void setApprovAmt(long approvAmt) {
		this.approvAmt = approvAmt;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Claims [Request_Num=" + Request_Num + ", claimDate=" + claimDate + ", policyNum=" + policyNum
				+ ", ApprovStatus=" + ApprovStatus + ", reqAmt=" + reqAmt + ", approvAmt=" + approvAmt + ", reason="
				+ reason + "]";
	}
	
	
	
	public Claims(Date claimDate, Policy policyNum, String approvStatus, long reqAmt, long approvAmt, String reason) {
		super();
		this.claimDate = claimDate;
		this.policyNum = policyNum;
		ApprovStatus = approvStatus;
		this.reqAmt = reqAmt;
		this.approvAmt = approvAmt;
		this.reason = reason;
	}

	public Claims(Date claimDate,Policy policyNum, long reqAmt, String reason) {
		super();
		this.claimDate = claimDate;
		this.policyNum = policyNum;
		this.reqAmt = reqAmt;
		this.reason = reason;
	}

	public Claims(long request_Num, Date claimDate, Policy policyNum, String approvStatus, long reqAmt, long approvAmt,
			String reason) {
		super();
		Request_Num = request_Num;
		this.claimDate = claimDate;
		this.policyNum = policyNum;
		ApprovStatus = approvStatus;
		this.reqAmt = reqAmt;
		this.approvAmt = approvAmt;
		this.reason = reason;
	}

	public Claims() {
		super();
	}
	


}
