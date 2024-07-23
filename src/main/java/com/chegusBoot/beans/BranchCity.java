package com.chegusBoot.beans;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class BranchCity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cId;
	private String cName;
	public Long getcId() {
		return cId;
	}
	public void setcId(Long cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	
	
	@OneToMany(mappedBy = "city",cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("city")
	private List<BranchName> clst = new ArrayList<>();
	public List<BranchName> getClst() {
		return clst;
	}
	public void setClst(List<BranchName> clst) {
		this.clst = clst;
	}
	
	
}
