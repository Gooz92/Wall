package wall.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import wall.dao.MessageDao;
import wall.entity.java.Message;

@Repository
public class MessageDaoImpl extends BaseDaoImpl<Message> implements MessageDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getPage(int pageNumber, int pageSize) {
		Criteria pageCriteria = getCurrentSession().createCriteria(Message.class);

		pageCriteria.setFirstResult((pageNumber - 1) * pageSize).setMaxResults(pageSize)
				.addOrder(Order.desc(Message.DATE_PROPERTY_NAME));

		return (List<Message>) pageCriteria.list();

	}

}