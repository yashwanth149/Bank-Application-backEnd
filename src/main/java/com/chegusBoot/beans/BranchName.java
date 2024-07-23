package com.chegusBoot.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class BranchName {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bnameId;
	private String branchN;
	
	@ManyToOne
	@JsonIgnoreProperties("clst")
	private BranchCity city;

	public Long getBnameId() {
		return bnameId;
	}

	public void setBnameId(Long bnameId) {
		this.bnameId = bnameId;
	}

	public String getBranchN() {
		return branchN;
	}

	public void setBranchN(String branchN) {
		this.branchN = branchN;
	}

	public BranchCity getCity() {
		return city;
	}

	public void setCity(BranchCity city) {
		this.city = city;
	}
	
	
	
}
