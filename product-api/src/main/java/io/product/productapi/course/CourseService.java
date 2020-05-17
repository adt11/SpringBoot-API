package io.product.productapi.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course>getAllCourses(String topicId){
		
		List<Course> courses = new ArrayList<Course>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) {
		
		Optional<Course> ot = courseRepository.findById(id);
		return ot.get();
	}
	
	public void addCourse(Course course) {
		
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {

		courseRepository.deleteById(id);
	}
}
