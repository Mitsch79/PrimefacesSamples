package com.mycompany.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mycompany.model.MenuView;
import com.mycompany.model.TestModel;
import com.mycompany.pojo.EditableListEntry;
import com.mycompany.pojo.MenuHierarchie;
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
	MenuView menuView;

	@Inject
	private TestModel testModel;

	@Inject
	private TestService testService;

	@Inject
	private LandService landService;

	public void addEditableListEntry() {
		testModel.getDataTableViewData().getEntryList().add(0, new EditableListEntry());
	}

	public MenuHierarchie generateMenuHierarchie() {
		MenuHierarchie rootEntry = new MenuHierarchie();
		rootEntry.setRootEntry(rootEntry);
		rootEntry.setLevel(0);
		generateMenuHierarchie(rootEntry, 4, 4);
		return rootEntry;
	}

	public void generateMenuHierarchie(MenuHierarchie parentEntry, int maxDepth, int entriesPerLevel) {

		if (maxDepth > 0)
			for (int i = 1; i <= entriesPerLevel; i++) {
				MenuHierarchie newEntry = new MenuHierarchie();
				newEntry.setRootEntry(parentEntry.getRootEntry());
				newEntry.setLevel(parentEntry.getLevel() + 1);
				newEntry.setParentEntry(parentEntry);
				if (parentEntry.getEntryTitle() != null)
					newEntry.setEntryTitle(parentEntry.getEntryTitle() + "." + i);
				else
					newEntry.setEntryTitle("Eintrag " + i);
				if (parentEntry.getEntryOutcome() != null)
					newEntry.setEntryOutcome(parentEntry.getEntryOutcome() + "." + i);
				else
					newEntry.setEntryOutcome("Outcome " + i);

				generateMenuHierarchie(newEntry, maxDepth - 1, 4);
				parentEntry.getChildEntries().add(newEntry);
			}
	}

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
		// testModel.getDataTableViewData().getEntryList().add(0, new
		// EditableListEntry());
		testModel.setTagList(generateTagList().getTagList());
		testModel.setTestList(testService.loadAll());
		testModel.setLandList(landService.loadAll());
		menuView.init(generateMenuHierarchie());
	}

	public void removeEditableListEntry(int index) {
		testModel.getDataTableViewData().getEntryList().remove(index);
	}
}
