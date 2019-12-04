package com.mycompany.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.mycompany.dao.interfaces.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {
	
	@PersistenceUnit(name = "oraclePersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public final Optional<T> loadById(Class<T> persistenceClass, long id) {
		return  Optional.ofNullable(entityManager.find(persistenceClass, id));
	}

	@Override
	public List<T> loadAll() {
		Class<T> entityClass = null;
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();		 
		CriteriaQuery<T> criteria = builder.createQuery(entityClass);
		criteria.select(criteria.from(entityClass));
		return entityManager.createQuery(criteria).getResultList();
	}

	@Override
	public final void save(T entity) {
		executeInsideTransaction(entityManager -> entityManager.persist(entityManager.merge(entity)));		
	}

	@Override
	public final void update(T entity) {
		executeInsideTransaction(entityManager -> entityManager.merge(entity));		
	}

	@Override
	public final void delete(T entity) {
		executeInsideTransaction(entityManager -> entityManager.remove(entity));	
	}
	
	 private void executeInsideTransaction(Consumer<EntityManager> action) {
	        EntityTransaction transaction = entityManager.getTransaction();
	        try {
	        	transaction.begin();
	            action.accept(entityManager);
	            entityManager.flush();
	            transaction.commit(); 
	        }
	        catch (RuntimeException e) {
	        	transaction.rollback();
	            throw e;
	        }
	    }
	
}
