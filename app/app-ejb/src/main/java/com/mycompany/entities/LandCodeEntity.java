package com.mycompany.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "landcodes")
public class LandCodeEntity {

	@Id
	@Column(name = "LAND_ID")
	private Long landId;

	@Column(name = "LAND_NAME")
	private String landName = "";

	@Column(name = "LAND_SHORT")
	private String landIso = "";

	public Long getLandId() {
		return landId;
	}

	public String getLandIso() {
		return landIso;
	}

	public String getLandName() {
		return landName;
	}

	public void setLandId(Long landId) {
		this.landId = landId;
	}

	public void setLandIso(String landIso) {
		this.landIso = landIso;
	}

	public void setLandName(String landName) {
		this.landName = landName;
	}

}
