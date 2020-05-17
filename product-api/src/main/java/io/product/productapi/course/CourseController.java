package io.product.productapi.course;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.product.productapi.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}/courses")
	public List<Course> getAllCourse(@PathVariable String topicId) {
		
		return courseService.getAllCourses(topicId);					
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}/courses/{id}")
	public Course getTopic(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public String addTopic(@RequestBody Course course,@PathVariable String topicId) {
		
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
		return "Successfully added";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public String updateTopic(@RequestBody Course course,@PathVariable String id,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
		return "Successfully updated";
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public String deleteTopic(@PathVariable String id) {
		courseService.deleteCourse(id);
		return "Successfully deleted";
	}
}
