package com.chegusBoot.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="fea_persons")
public class DataPersonSearch {
	

	@Column(name="PERSONNAME")
	private String personName;
	
	@Id
	@Column(name="PERSONID")
	private String personId;
}
