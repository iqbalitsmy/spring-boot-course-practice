package com.learn_spring_boot.learn_spring_boot;

public class Course {
	private float id;
	private String name;
	private String autor;
	
	public Course(float id, String name, String autor) {
		super();
		this.id = id;
		this.name = name;
		this.autor = autor;
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



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", autor=" + autor + "]";
	}
	
	
}
