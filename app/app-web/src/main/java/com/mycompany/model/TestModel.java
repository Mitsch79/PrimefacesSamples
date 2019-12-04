package com.mycompany.model;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

import com.mycompany.entities.TestEntity;

@Named
@ConversationScoped
public class TestModel {
	
	private TestEntity testEntiy;
	private List<TestEntity> testEntityList;
	
	public void init() {
		testEntiy = new TestEntity();
		testEntityList = new ArrayList<>();
	}
	
	public List<TestEntity> getTestList(){
		return testEntityList;
	}
	
	public void setTestList(List<TestEntity> testEntityList) {
		this.testEntityList =testEntityList; 
	}
	
	public TestEntity getTestEntity() {
		return testEntiy;
	}
	
	public void setTestEntity(TestEntity testEntity) {
		this.testEntiy = testEntity;
	}
	
	public Long getId() {
		return testEntiy.getId();
	}
	
	public String getValue() {
		return testEntiy.getValue();
	}
	
	public void setValue(String value) {
		testEntiy.setValue(value);
	}
}
