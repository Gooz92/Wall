package wall.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import wall.entity.java.Message;
import wall.entity.java.Page;
import wall.service.MessageService;

@Controller
public class MessageController {

	private static final int DEFAULT_PAGE_SIZE = 10;

	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "/", method = GET)
	public ModelAndView getFirstPage() {
		return getPage(1);
	}

	@RequestMapping(value = "/", method = GET, params = { "page", "size" })
	public ModelAndView getPage(@RequestParam("page") int pageNumber, @RequestParam int size) {
		ModelAndView model = new ModelAndView("index");
		Page<Message> page = messageService.getPage(pageNumber, size);
		
		model.addObject("page",  page);
		model.addObject("message", new Message());
		return model;
	}

	@RequestMapping(value = "/", method = GET, params = { "size" })
	public ModelAndView getFirstPage(@RequestParam int size) {
		return getPage(1, size);
	}

	@RequestMapping(value = "/", method = GET, params = { "page" })
	public ModelAndView getPage(@RequestParam int page) {
		return getPage(page, DEFAULT_PAGE_SIZE);
	}

	@RequestMapping(value = "/post", method = POST)
	public String add(Message message) {
		messageService.save(message);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete", method = GET)
	public String delete(@RequestParam long id) {
		messageService.delete(id);
		return "redirect:/";
	}
}
