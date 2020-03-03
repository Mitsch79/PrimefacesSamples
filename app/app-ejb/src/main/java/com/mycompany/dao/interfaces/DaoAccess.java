package com.mycompany.dao.interfaces;

import java.util.List;
import java.util.Optional;

public interface DaoAccess<T> {

	void delete(T entity);

	List<T> loadAll(Class<T> entityClass);

	Optional<T> loadById(Class<T> persistenceClass, long id);

	void save(T entity);

	void update(T entity);

}
