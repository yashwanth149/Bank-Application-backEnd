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
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
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
	
	
}
