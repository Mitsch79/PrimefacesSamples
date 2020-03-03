package com.mycompany.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.mycompany.dao.impl.BaseDaoImpl;
import com.mycompany.dao.interfaces.DaoAccess;
import com.mycompany.entities.MenuEntity;

@RequestScoped
public class MenuService implements DaoAccess<MenuEntity>, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -4400687185271935528L;

	@Inject
	private BaseDaoImpl<MenuEntity> testDao;

	@Override
	public void delete(MenuEntity entity) {
		testDao.delete(entity);
	}

	public List<MenuEntity> loadAll() {
		return loadAll(MenuEntity.class);
	}

	@Override
	public List<MenuEntity> loadAll(Class<MenuEntity> entityClass) {
		return testDao.loadAll(entityClass);
	}

	@Override
	public Optional<MenuEntity> loadById(Class<MenuEntity> persistenceClass, long id) {
		return testDao.loadById(persistenceClass, id);
	}

	public Optional<MenuEntity> loadById(long id) {
		return testDao.loadById(MenuEntity.class, id);
	}

	@Override
	public void save(MenuEntity entity) {
		testDao.save(entity);
	}

	@Override
	public void update(MenuEntity entity) {
		testDao.update(entity);
	}

}
