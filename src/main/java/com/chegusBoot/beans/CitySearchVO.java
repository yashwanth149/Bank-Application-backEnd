
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
@Table(name = "view_City")
public class CitySearchVO {

	@Id
	@Column(name = "CID")
	private String cid;

	@Column(name = "CITYNAME")
	private String cname;
}
