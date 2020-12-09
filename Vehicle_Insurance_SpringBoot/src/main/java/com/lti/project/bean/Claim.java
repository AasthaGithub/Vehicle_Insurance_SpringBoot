package com.lti.project.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="claims")
public class Claim {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="claim_seq")
    @SequenceGenerator(name="claim_seq", sequenceName="claim_seq", allocationSize=1)
	private long Request_Num;
	
	@Column(name="Claim_Date")
	private String claimDate;
	
	@Column(name="Policy_Num ")
	private long policyNum;
	
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

	public String getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}

	public long getPolicyNum() {
		return policyNum;
	}

	public void setPolicyNum(long policyNum) {
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

	public Claim(long request_Num, String claimDate, long policyNum, String approvStatus, long reqAmt, long approvAmt,
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

	public Claim() {
		super();
	}
	


}
