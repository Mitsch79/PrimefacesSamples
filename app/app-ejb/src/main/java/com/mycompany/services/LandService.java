package com.mycompany.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.mycompany.dao.impl.BaseDaoImpl;
import com.mycompany.dao.interfaces.DaoAccess;
import com.mycompany.entities.LandCodeEntity;

@RequestScoped
public class LandService implements DaoAccess<LandCodeEntity>, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -4400687185271935528L;

	@Inject
	private BaseDaoImpl<LandCodeEntity> testDao;

	@Override
	public void delete(LandCodeEntity entity) {
		testDao.delete(entity);
	}

	public List<LandCodeEntity> loadAll() {
		return loadAll(LandCodeEntity.class);
	}

	@Override
	public List<LandCodeEntity> loadAll(Class<LandCodeEntity> entityClass) {
		return testDao.loadAll(entityClass);
	}

	@Override
	public Optional<LandCodeEntity> loadById(Class<LandCodeEntity> persistenceClass, long id) {
		return testDao.loadById(persistenceClass, id);
	}

	@Override
	public void save(LandCodeEntity entity) {
		testDao.save(entity);
	}

	@Override
	public void update(LandCodeEntity entity) {
		testDao.update(entity);
	}

}
