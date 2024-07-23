package com.chegusBoot.beans;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class DataBranch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long branchId;
	private String branchName;
	private String branchCity;
	
	@ManyToOne
	@JsonIgnoreProperties("lst")
	private DataBank bank;

	@OneToMany(mappedBy = "branch",cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("branch")
	private List<DataPerson> sublst = new ArrayList<>();
	
	
	

	public List<DataPerson> getSublst() {
		return sublst;
	}

	public void setSublst(List<DataPerson> sublst) {
		this.sublst = sublst;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchCity() {
		return branchCity;
	}

	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}

	public DataBank getBank() {
		return bank;
	}

	public void setBank(DataBank bank) {
		this.bank = bank;
	}

	

	
	
	
	
	
}
