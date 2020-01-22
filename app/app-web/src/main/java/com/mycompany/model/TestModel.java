package com.mycompany.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.mycompany.entities.LandCodeEntity;
import com.mycompany.entities.TestEntity;
import com.mycompany.pojo.Tag;

@Named
@SessionScoped
public class TestModel implements Serializable {

	private static final long serialVersionUID = -3692509064429573696L;
	private TestEntity testEntiy;
	private List<TestEntity> testEntityList;
	private List<Tag> selectedTags;
	private List<Tag> tagList = new ArrayList<>();
	private List<LandCodeEntity> landList;

	private String inputValue;
	private String selectedValue;
	private Integer inputNumber1;
	private Integer inputNumber2;

	public Long getId() {
		return testEntiy.getId();
	}

	public Integer getInputNumber1() {
		return inputNumber1;
	}

	public Integer getInputNumber2() {
		return inputNumber2;
	}

	public String getInputValue() {
		return inputValue;
	}

	public List<LandCodeEntity> getLandList() {
		return landList;
	}

	public List<Tag> getSelectedTags() {
		return selectedTags;
	}

	public String getSelectedValue() {
		return selectedValue;
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

	public void setInputNumber1(Integer inputNumber1) {
		this.inputNumber1 = inputNumber1;
	}

	public void setInputNumber2(Integer inputNumber2) {
		this.inputNumber2 = inputNumber2;
	}

	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}

	public void setLandList(List<LandCodeEntity> landList) {
		this.landList = landList;
	}

	public void setSelectedTags(List<Tag> selectedTags) {
		this.selectedTags = selectedTags;
	}

	public void setSelectedValue(String selectedValue) {
		this.selectedValue = selectedValue;
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
