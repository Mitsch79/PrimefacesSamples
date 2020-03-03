package com.mycompany.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuModel;

import com.mycompany.entities.MenuEntity;

@Named
@SessionScoped
public class MenuView implements Serializable {

	private static final long serialVersionUID = 2460995072810215199L;
	private MenuModel menuModel;
	private MenuEntity menuHierarchie;
	private int maxLevel;

	public void buildMenu(MenuEntity menuHierarchie, MenuElement menuElement) {
		this.menuHierarchie = menuHierarchie;
		for (MenuEntity menu : menuHierarchie.getChildEntries()) {
			if (maxLevel < menu.getEntryLevel())
				maxLevel = menu.getEntryLevel();
			if (!menu.getChildEntries().isEmpty()) {
				DefaultSubMenu subMenu = new DefaultSubMenu(menu.getEntryTitle());
				buildMenu(menu, subMenu);
				if (menuElement != null)
					((DefaultSubMenu) menuElement).addElement(subMenu);
				if (menu.getEntryLevel() == 1)
					menuModel.addElement(subMenu);
			} else {
				DefaultMenuItem item = new DefaultMenuItem(menu.getEntryTitle());
				item.setOutcome(menu.getEntryOutcome());
				if (menuElement != null)
					((DefaultSubMenu) menuElement).addElement(item);
			}
		}
	}

	public int getMaxLevel() {
		return maxLevel;
	}

	public MenuEntity getMenuHierarchie() {
		return menuHierarchie;
	}

	public MenuModel getMenuModel() {
		return menuModel;
	}

	public MenuModel getRootMenuModel() {
		MenuModel rootMenuModel = new DefaultMenuModel();

		for (MenuElement menuElement : menuModel.getElements()) {
			DefaultSubMenu rootElement = new DefaultSubMenu(((DefaultSubMenu) menuElement).getLabel());
			rootElement.setElements(new ArrayList<>());
			rootMenuModel.addElement(rootElement);
		}

		return rootMenuModel;
	}

	public void init(MenuEntity menuHierarchie) {
		menuModel = new DefaultMenuModel();
		maxLevel = 0;
		buildMenu(menuHierarchie, null);
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public void setMenuHierarchie(MenuEntity menuHierarchie) {
		this.menuHierarchie = menuHierarchie;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

}
