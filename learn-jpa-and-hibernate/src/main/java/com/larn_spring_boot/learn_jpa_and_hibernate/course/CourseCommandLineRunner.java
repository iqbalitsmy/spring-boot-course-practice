package com.larn_spring_boot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.larn_spring_boot.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.larn_spring_boot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.larn_spring_boot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.save(new Course(1, "JPA", "Iqbal"));
		repository.save(new Course(2, "AWS", "Iqbal"));
		repository.save(new Course(3, "AWS", "Iqbal"));
		
		repository.deleteById(2l);
		
		System.out.println(repository.findById(1l));
		System.out.println(repository.findById(3l));
	}
	
}
