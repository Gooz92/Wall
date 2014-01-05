package wall.dao;

import java.util.List;

import wall.entity.java.BaseEntity;

public interface BaseDao<E extends BaseEntity> {
	long getCount();

	List<E> getAll();
	
	void save(E entity);
	
	void delete(long id);
}
