package wall.dao;

import java.util.List;

import wall.entity.java.Message;

public interface MessageDao extends BaseDao<Message> {
	List<Message> getPage(int pageNumber, int pageSize);
}