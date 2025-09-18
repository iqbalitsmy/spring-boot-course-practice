package com.learn_spring_boot.learn_spring_boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	@RequestMapping("/courses")
	public List<Course> retriveAllCourses(){
		return Arrays.asList(
				new Course(1, "Learn AWS", "iqbalitsmy"),
				new Course(2, "Devops", "iqbalitsmy"),
				new Course(3, "ML", "iqbalitsmy"),
				new Course(4, "DM", "iqbalitsmy")
				);
	}

}
