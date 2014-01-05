package wall.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import wall.dao.BaseDao;
import wall.entity.java.BaseEntity;
import wall.service.BaseService;

@Transactional
public class BaseServiceImpl<D extends BaseDao<E>, E extends BaseEntity> implements
		BaseService<E> {
	
	protected D dao;
	
	protected BaseServiceImpl(D dao) {
		this.dao = dao;
	}
	
	@Override
	public List<E> getAll() {
		return dao.getAll();
	}

	@Override
	public void save(E entity) {
		dao.save(entity);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

}
