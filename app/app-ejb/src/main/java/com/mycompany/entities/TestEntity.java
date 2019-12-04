package com.mycompany.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class TestEntity {
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "VALUE")
	private String value = "";
	
	public Long getId() {
		return id;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
