package com.larn_spring_boot.learn_jpa_and_hibernate.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.larn_spring_boot.learn_jpa_and_hibernate.course.jpa.StudentJpaRepository;

@Component
public class StudentComandLineRunner implements CommandLineRunner {

	@Autowired
	private StudentJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.insert(new Student(1, "Iqbal", 50));
		repository.insert(new Student(2, "forhad", 50));
		repository.insert(new Student(3, "Iqbal", 50));

		repository.deleteById(2);
		System.out.println("Student: " + repository.findById(3));
	}
}
