package com.mycompany.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mycompany.model.TestModel;
import com.mycompany.pojo.Tag;
import com.mycompany.pojo.TagList;
import com.mycompany.services.LandService;
import com.mycompany.services.TestService;

@Named
@RequestScoped
public class TestController implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1229544450575272466L;

	@Inject
	private TestModel testModel;

	@Inject
	private TestService testService;

	@Inject
	private LandService landService;

	private TagList generateTagList() {
		TagList tagList = new TagList();
		int superTypeCount = 5;
		int subTypeCount = 5;

		for (int i = 0; i < superTypeCount; ++i) {
			Tag superType = new Tag();
			superType.setId(i + 1);
			superType.setSubTypeDescription("Description " + i);
			superType.setSubTypeName("SuperTypeName " + i);
			superType.setSubTypeShort("SuperTypeShort " + i);
			superType.setSuperTypeDescription("SuperTypeDescription " + i);
			superType.setSuperTypeName("SuperTypeName " + i);
			superType.setSuperTypeShort("SuperTypeShort " + i);
			tagList.getTagList().add(superType);
			for (int j = 0; j < subTypeCount; ++j) {
				Tag subType = new Tag();
				subType.setId(100 * (i + 1) + j);
				subType.setSubTypeDescription("SubTypeDescription " + i + "." + j);
				subType.setSubTypeName("SubTypeName " + i + "." + j);
				subType.setSubTypeShort("SubTypeShort " + i + "." + j);
				subType.setSuperTypeDescription(superType.getSuperTypeDescription());
				subType.setSuperTypeName(superType.getSuperTypeName());
				subType.setSuperTypeShort(superType.getSubTypeShort());
				tagList.getTagList().add(subType);
			}
		}

		return tagList;
	}

	public void init() {
		testModel.init();
		testModel.setTagList(generateTagList().getTagList());
		testModel.setTestList(testService.loadAll());
		testModel.setLandList(landService.loadAll());
	}
}
