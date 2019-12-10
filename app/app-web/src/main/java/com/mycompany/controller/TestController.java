package com.mycompany.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.mycompany.model.TestModel;
import com.mycompany.pojo.Tag;
import com.mycompany.pojo.TagList;
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

	private TagList generateTagList() {
		TagList tagList = new TagList();
		int superTypeCount = 5;
		int subTypeCount = 5;

		for (int i = 0; i < superTypeCount; i++) {
			Tag superType = new Tag();
			superType.setSubTypeDescription("Description " + i);
			superType.setSubTypeName("SubTypeName " + i);
			superType.setSubTypeShort("SubTypeShort " + i);
			superType.setSuperTypeDescription("SuperTypeDescription " + i);
			superType.setSuperTypeName("SuperTypeName " + i);
			superType.setSuperTypeShort("SuperTypeShort " + i);
			for (int ii = 0; ii < subTypeCount; i++) {
				Tag subType = new Tag();
				subType.setSubTypeDescription("SubTypeDescription " + i + "." + ii);
				subType.setSubTypeName("SubTypeName " + i + "." + ii);
				subType.setSubTypeShort("SubTypeShort " + i + "." + ii);
				subType.setSuperTypeDescription(superType.getSuperTypeDescription());
				subType.setSuperTypeName(superType.getSuperTypeName());
				subType.setSuperTypeShort(superType.getSubTypeShort());
			}
		}

		return tagList;
	}

	public void init() {
		testModel.init();
		testModel.setTagList(generateTagList().getTagList());
		testModel.setTestList(testService.loadAll());

		PrimeFaces.current().executeScript("PF('selectTagsDataTable').filter();");

	}
}
