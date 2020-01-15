package com.mycompany.pojo;

public class Tag {
	private int id;
	private String superTypeName;
	private String superTypeDescription;
	private String superTypeShort;
	private String subTypeName;
	private String subTypeDescription;
	private String subTypeShort;

	public String getSubTypeDescription() {
		return subTypeDescription;
	}

	public String getSubTypeName() {
		return subTypeName;
	}

	public String getSubTypeShort() {
		return subTypeShort;
	}

	public String getSuperTypeDescription() {
		return superTypeDescription;
	}

	public String getSuperTypeName() {
		return superTypeName;
	}

	public String getSuperTypeShort() {
		return superTypeShort;
	}

	public void setSubTypeDescription(String subTypeDescription) {
		this.subTypeDescription = subTypeDescription;
	}

	public void setSubTypeName(String subTypeName) {
		this.subTypeName = subTypeName;
	}

	public void setSubTypeShort(String subTypeShort) {
		this.subTypeShort = subTypeShort;
	}

	public void setSuperTypeDescription(String superTypeDescription) {
		this.superTypeDescription = superTypeDescription;
	}

	public void setSuperTypeName(String superTypeName) {
		this.superTypeName = superTypeName;
	}

	public void setSuperTypeShort(String superTypeShort) {
		this.superTypeShort = superTypeShort;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
