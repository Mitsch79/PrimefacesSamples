package com.mycompany.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.mycompany.dao.interfaces.DaoAccess;

@Named
@Dependent
public class BaseDaoImpl<T> implements DaoAccess<T>,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9167809068818895581L;
	@PersistenceContext(unitName="oraclePersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public Optional<T> loadById(Class<T> persistenceClass, long id) {
		return  Optional.ofNullable(entityManager.find(persistenceClass, id));
	}
	
	
	@Override
	public List<T> loadAll(Class<T> entityClass) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();		 
		CriteriaQuery<T> query = builder.createQuery(entityClass);
		query.select(query.from(entityClass));
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public void save(T entity) {
		executeInsideTransaction(entityManager -> entityManager.persist(entityManager.merge(entity)));		
	}

	@Override
	public void update(T entity) {
		executeInsideTransaction(entityManager -> entityManager.merge(entity));		
	}

	@Override
	public void delete(T entity) {
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
