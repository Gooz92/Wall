package wall.service;

import wall.entity.java.Message;
import wall.entity.java.Page;

public interface MessageService extends BaseService<Message> {
	Page<Message> getPage(int pageNumber, int pageSize);
	
	int getPagesCount(int pageSize);
}