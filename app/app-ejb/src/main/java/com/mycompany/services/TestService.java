package com.mycompany.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.mycompany.dao.impl.BaseDaoImpl;
import com.mycompany.dao.interfaces.DaoAccess;
import com.mycompany.entities.TestEntity;

@RequestScoped
public class TestService implements DaoAccess<TestEntity>, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -2921633835664148584L;

	@Inject
	private BaseDaoImpl<TestEntity> testDao;

	@Override
	public void delete(TestEntity entity) {
		testDao.delete(entity);
	}

	public List<TestEntity> loadAll() {
		return loadAll(TestEntity.class);
	}

	@Override
	public List<TestEntity> loadAll(Class<TestEntity> entityClass) {
		return testDao.loadAll(entityClass);
	}

	@Override
	public Optional<TestEntity> loadById(Class<TestEntity> persistenceClass, long id) {
		return testDao.loadById(persistenceClass, id);
	}

	@Override
	public void save(TestEntity entity) {
		testDao.save(entity);
	}

	@Override
	public void update(TestEntity entity) {
		testDao.update(entity);
	}

}
