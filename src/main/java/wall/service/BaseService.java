package wall.service;

import java.util.List;

import wall.entity.java.BaseEntity;

public interface BaseService<E extends BaseEntity> {
	List<E> getAll();
	
	void save(E entity);
	
	void delete(long id);
}