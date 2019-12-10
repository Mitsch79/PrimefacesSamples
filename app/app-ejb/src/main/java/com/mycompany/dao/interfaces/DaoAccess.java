package com.mycompany.dao.interfaces;

import java.util.List;
import java.util.Optional;

public interface DaoAccess<T> {
	     	     
	    void save(T entity);
	     
	    void update(T entity);
	     
	    void delete(T entity);

		Optional<T> loadById(Class<T> persistenceClass, long id);

		List<T> loadAll(Class<T> entityClass);
		
}
