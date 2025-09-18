package com.larn_spring_boot.learn_jpa_and_hibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.larn_spring_boot.learn_jpa_and_hibernate.student.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentJpaRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public void insert(Student student) {
		entityManager.merge(student);
	}

	public Student findById(long id) {
		return entityManager.find(Student.class, id);
	}

	public void deleteById(long id) {
		Student student = entityManager.find(Student.class, id);
		entityManager.remove(student);
	}
}
