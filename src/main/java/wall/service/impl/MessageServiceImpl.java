package wall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wall.dao.MessageDao;
import wall.entity.java.Message;
import wall.entity.java.Page;
import wall.service.MessageService;

@Service
public class MessageServiceImpl extends BaseServiceImpl<MessageDao, Message> implements
		MessageService {

	@Autowired
	protected MessageServiceImpl(MessageDao dao) {
		super(dao);
	}

	@Override
	@Transactional
	public Page<Message> getPage(int pageNumber, int pageSize) {
		List<Message> messages = dao.getPage(pageNumber, pageSize);
		int pagesCount = getPagesCount(pageSize);
		
		if (pageNumber > pagesCount) {
			// throw Exception ?
		}

		boolean isLastPage = (pageNumber == pagesCount || pagesCount == 0);
		return new Page<Message>(messages, pageNumber, isLastPage);
	}

	@Override
	@Transactional
	public int getPagesCount(int pageSize) {
		long messagesCount = dao.getCount();
		
		int pageCount = (int)(messagesCount / pageSize);
		
		if (messagesCount % pageSize != 0) {
			++pageCount;
		}
		
		return pageCount;
	}	
	
}
