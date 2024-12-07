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
@Table(name="fea_datapersons")
public class DataPersonSearch {
	

	@Column(name="NAME")
	private String personName;
	
	@Id
	@Column(name="ID")
	private String personId;
}
