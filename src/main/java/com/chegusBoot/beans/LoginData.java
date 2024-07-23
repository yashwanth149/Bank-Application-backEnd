package com.chegusBoot.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LoginData {
	@Id
	private String uName;
	private String pass;
	private String email;


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getPass() {
		return pass;
	}	
	public void setPass(String pass) {
		this.pass = pass;
	}


}
