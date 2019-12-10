package com.mycompany.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.ListDataModel;

public class TagList extends ListDataModel<Tag> {
	private List<Tag> tagList = new ArrayList<>();

	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}
}
