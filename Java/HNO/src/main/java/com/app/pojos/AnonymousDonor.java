package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name = "anonymous_donor")

public class AnonymousDonor extends BaseEntity{
	@Column(length = 30)
	private String anonymousDonorName;
	@Column(length = 10, nullable = false)
	private String anonymousMobileNo;
	@Column(length = 11,nullable = false)
    private Double anonymousDonorAmount;
	public AnonymousDonor(String anonymousDonorName, String anonymousMobileNo, Double anonymousDonorAmount) {
		super();
		this.anonymousDonorName = anonymousDonorName;
		this.anonymousMobileNo = anonymousMobileNo;
		this.anonymousDonorAmount = anonymousDonorAmount;
	}
	public AnonymousDonor() {
		super();
	}
	public String getAnonymousDonorName() {
		return anonymousDonorName;
	}
	public void setAnonymousDonorName(String anonymousDonorName) {
		this.anonymousDonorName = anonymousDonorName;
	}
	public String getAnonymousMobileNo() {
		return anonymousMobileNo;
	}
	public void setAnonymousMobileNo(String anonymousMobileNo) {
		this.anonymousMobileNo = anonymousMobileNo;
	}
	public Double getAnonymousDonorAmount() {
		return anonymousDonorAmount;
	}
	public void setAnonymousDonorAmount(Double anonymousDonorAmount) {
		this.anonymousDonorAmount = anonymousDonorAmount;
	}
	@Override
	public String toString() {
		return "AnonymousDonor [anonymousDonorName=" + anonymousDonorName + ", anonymousMobileNo=" + anonymousMobileNo
				+ ", anonymousDonorAmount=" + anonymousDonorAmount + "]";
	}

}
