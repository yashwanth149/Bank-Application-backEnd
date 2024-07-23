package com.chegusBoot.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class DataBank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bid;
	private String bname;
	private String mainBranch;
	private String email;
	private Long phno;
	
	@OneToMany(mappedBy = "bank",cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("bank")
	private List<DataBranch> lst = new ArrayList<>();
	
	
	
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getBid() {
		return bid;
	}
	public void setBid(Long bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	
	
	
	public String getMainBranch() {
		return mainBranch;
	}
	public void setMainBranch(String mainBranch) {
		this.mainBranch = mainBranch;
	}
	
	
	
	public List<DataBranch> getLst() {
		return lst;
	}
	public void setLst(List<DataBranch> lst) {
		this.lst = lst;
	}
	@Override
	public String toString() {
		return "DataBank [bid=" + bid + ", bname=" + bname + ", mainBranch=" + mainBranch + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
