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
@Table(name="view_branch")
public class BranchSearchVO {
	

	@Column(name="BRANCHNAME")
	private String branchName;
	
	@Id
	@Column(name="BRANCHID")
	private String branchId;
}
