package com.mycompany.pojo;

import java.util.ArrayList;
import java.util.List;

public class MenuHierarchie {

	List<MenuHierarchie> childEntries = new ArrayList<>();
	MenuHierarchie parentEntry;
	MenuHierarchie rootEntry;
	boolean isContentType;
	boolean isHeadline;
	String entryTitle;
	String entryOutcome;
	int level;

	public List<MenuHierarchie> getChildEntries() {
		return childEntries;
	}

	public String getEntryOutcome() {
		return entryOutcome;
	}

	public String getEntryTitle() {
		return entryTitle;
	}

	public int getLevel() {
		return level;
	}

	public MenuHierarchie getParentEntry() {
		return parentEntry;
	}

	public MenuHierarchie getRootEntry() {
		return rootEntry;
	}

	public boolean hasChildEntries() {
		return !childEntries.isEmpty();
	}

	public boolean isContentType() {
		return isContentType;
	}

	public boolean isRootEntry() {
		return this == rootEntry;
	}

	public void setChildEntries(List<MenuHierarchie> childEntries) {
		this.childEntries = childEntries;
	}

	public void setContentType(boolean isContentType) {
		this.isContentType = isContentType;
	}

	public void setEntryOutcome(String entryOutcome) {
		this.entryOutcome = entryOutcome;
	}

	public void setEntryTitle(String entryTitle) {
		this.entryTitle = entryTitle;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setParentEntry(MenuHierarchie parentEntry) {
		this.parentEntry = parentEntry;
	}

	public void setRootEntry(MenuHierarchie rootEntry) {
		this.rootEntry = rootEntry;
	}
}
