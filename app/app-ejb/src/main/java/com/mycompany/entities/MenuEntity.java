package com.mycompany.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menuitems")
public class MenuEntity {

	@Id
	@Column(name = "ENTRYID")
	private Long id;

	@Column(name = "PARENTID")
	private Long parentId;

	@ManyToOne
	private MenuEntity parentEntry;

	@OneToMany(mappedBy = "parentId", fetch = FetchType.EAGER)
	private List<MenuEntity> childEntries;

	@Column(name = "ROOTID")
	private Long rootId;

	@Column(name = "ISCONTENTTYPE")
	private Boolean isContentType;

	@Column(name = "ISHEADLINE")
	private Boolean isHeadline;

	@Column(name = "ENTRYTITLE")
	private String entryTitle;

	@Column(name = "ENTRYOUTCOME")
	private String entryOutcome;

	@Column(name = "ENTRYLEVEL")
	private Integer entryLevel;

	@Column(name = "MAXLEVEL")
	private Integer maxLevel;

	public List<MenuEntity> getChildEntries() {
		return childEntries;
	}

	public Integer getEntryLevel() {
		return entryLevel;
	}

	public String getEntryOutcome() {
		return entryOutcome;
	}

	public String getEntryTitle() {
		return entryTitle;
	}

	public Long getId() {
		return id;
	}

	public Boolean getIsContentType() {
		return isContentType;
	}

	public Boolean getIsHeadline() {
		return isHeadline;
	}

	public Integer getMaxLevel() {
		return maxLevel;
	}

	public MenuEntity getParentEntry() {
		return parentEntry;
	}

	public Long getParentId() {
		return parentId;
	}

	public MenuEntity getRootEntry() {
		return null;
	}

	public Long getRootId() {
		return rootId;
	}

	public void setChildEntries(List<MenuEntity> childEntries) {
		this.childEntries = childEntries;
	}

	public void setEntryLevel(Integer entryLevel) {
		this.entryLevel = entryLevel;
	}

	public void setEntryOutcome(String entryOutcome) {
		this.entryOutcome = entryOutcome;
	}

	public void setEntryTitle(String entryTitle) {
		this.entryTitle = entryTitle;
	}

	public void setIsContentType(Boolean isContentType) {
		this.isContentType = isContentType;
	}

	public void setIsHeadline(Boolean isHeadline) {
		this.isHeadline = isHeadline;
	}

	public void setMaxLevel(Integer maxLevel) {
		this.maxLevel = maxLevel;
	}

	public void setParentEntry(MenuEntity parentEntry) {
		this.parentEntry = parentEntry;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public void setRootEntry(MenuEntity rootEntry) {

	}

	public void setRootId(Long rootId) {
		this.rootId = rootId;
	}

}
