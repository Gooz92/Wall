package wall.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;

import wall.dao.BaseDao;
import wall.entity.java.BaseEntity;

public class BaseDaoImpl<E extends BaseEntity> implements BaseDao<E> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<E> entityClass;

	private ClassMetadata entityClassMetadata;

	@SuppressWarnings("unchecked")
	protected BaseDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		entityClass = (Class<E>) pt.getActualTypeArguments()[0];
	}
	
	@PostConstruct
	public void createEntityClassMetadata() {
		entityClassMetadata = sessionFactory.getClassMetadata(entityClass);
	}
	
	@Override
	public long getCount() {
		Criteria countCriteria = getCurrentSession().createCriteria(entityClass);
		countCriteria.setProjection(Projections.rowCount());		
		return (Long) countCriteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> getAll() {
		Criteria getAllCriteria = getCurrentSession().createCriteria(entityClass);
		return (List<E>) getAllCriteria.list();
	}
	
	@Override
	public void save(E entity) {
		getCurrentSession().save(entity);
	}

	@Override
	public void delete(long id) {
		String entityName = entityClassMetadata.getEntityName();
		String idPropertyName = entityClassMetadata.getIdentifierPropertyName();
		
		String hqlDeleteQuery = new StringBuffer()
			.append("delete ")
			.append(entityName)
			.append(" where ")
			.append(idPropertyName)
			.append(" = :id")
			.toString();

		Query deleteQuery = getCurrentSession().createQuery(hqlDeleteQuery);		
		deleteQuery.setParameter("id", id);
		
		deleteQuery.executeUpdate();
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
