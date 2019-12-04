package com.mycompany.services;

import java.util.List;
import java.util.Optional;

import com.mycompany.dao.impl.BaseDaoImpl;
import com.mycompany.dao.interfaces.BaseDao;
import com.mycompany.entities.TestEntity;

public class TestService implements BaseDao<TestEntity> {
	
	private BaseDaoImpl<TestEntity> testDao; 
	
	@Override
	public List<TestEntity> loadAll() {
		return testDao.loadAll();
	}

	@Override
	public void save(TestEntity entity) {
		testDao.save(entity);	
	}

	@Override
	public void update(TestEntity entity) {
		testDao.update(entity);
	}

	@Override
	public void delete(TestEntity entity) {
		testDao.delete(entity);
	}

	@Override
	public Optional<TestEntity> loadById(Class<TestEntity> persistenceClass, long id) {
		return testDao.loadById(persistenceClass, id);
	}

}
