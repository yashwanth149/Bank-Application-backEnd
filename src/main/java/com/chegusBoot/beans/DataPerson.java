package com.chegusBoot.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class DataPerson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long personId;
	private String personName;
	
	@ManyToOne
	@JsonIgnoreProperties("pLst")
	private DataBranch branch;

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public DataBranch getBranch() {
		return branch;
	}

	public void setBranch(DataBranch branch) {
		this.branch = branch;
	}
	
	
	

	
}
