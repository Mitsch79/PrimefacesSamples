package com.mycompany.pojo;

import java.util.ArrayList;
import java.util.List;

public class InputStringData {

	private String text1 = "";
	private String text2 = "";
	private String text3 = "";
	private List<EditableListEntry> entryList = new ArrayList<>();

	public List<EditableListEntry> getEntryList() {
		return entryList;
	}

	public String getText1() {
		return text1;
	}

	public String getText2() {
		return text2;
	}

	public String getText3() {
		return text3;
	}

	public void setEntryList(List<EditableListEntry> entryList) {
		this.entryList = entryList;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}

	public void setText3(String text3) {
		this.text3 = text3;
	}

}
