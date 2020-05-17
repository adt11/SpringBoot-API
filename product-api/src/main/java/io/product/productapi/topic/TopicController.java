package io.product.productapi.topic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;

	@RequestMapping(method = RequestMethod.GET, value = "/topics")
	public List<Topic> getAllTopic() {
		
		return topicService.getAllTopics();					
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public String addTopic(@RequestBody Topic topic) {
		
		topicService.addTopic(topic);
		return "Successfully added";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public String updateTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicService.updateTopic(topic,id);
		return "Successfully updated";
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public String deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
		return "Successfully deleted";
	}
}
