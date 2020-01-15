package com.mycompany.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

import com.mycompany.entities.TestEntity;
import com.mycompany.pojo.Tag;

@Named
@ConversationScoped
public class TestModel implements Serializable {

	private static final long serialVersionUID = -3692509064429573696L;
	private TestEntity testEntiy;
	private List<TestEntity> testEntityList;
	private List<Tag> selectedTags;
	private List<Tag> tagList = new ArrayList<>();

	public Long getId() {
		return testEntiy.getId();
	}

	public List<Tag> getSelectedTags() {
		return selectedTags;
	}

	public List<Tag> getTagList() {
		return tagList;
	}

	public TestEntity getTestEntity() {
		return testEntiy;
	}

	public List<TestEntity> getTestList() {
		return testEntityList;
	}

	public String getValue() {
		return testEntiy.getValue();
	}

	public void init() {
		testEntiy = new TestEntity();
		testEntityList = new ArrayList<>();
		tagList = new ArrayList<>();
	}

	public void setSelectedTags(List<Tag> selectedTags) {
		this.selectedTags = selectedTags;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}

	public void setTestEntity(TestEntity testEntity) {
		testEntiy = testEntity;
	}

	public void setTestList(List<TestEntity> testEntityList) {
		this.testEntityList = testEntityList;
	}

	public void setValue(String value) {
		testEntiy.setValue(value);
	}
}
