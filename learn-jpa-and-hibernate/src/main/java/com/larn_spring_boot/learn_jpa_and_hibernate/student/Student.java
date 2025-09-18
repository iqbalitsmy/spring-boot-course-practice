package com.larn_spring_boot.learn_jpa_and_hibernate.student;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	private float id;
	private String name;
	private float mark;

	public Student() {

	}

	public Student(float id, String name, float mark) {
		super();
		this.id = id;
		this.name = name;
		this.mark = mark;
	}

	public float getId() {
		return id;
	}

	public void setId(float id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mark=" + mark + "]";
	}

}
