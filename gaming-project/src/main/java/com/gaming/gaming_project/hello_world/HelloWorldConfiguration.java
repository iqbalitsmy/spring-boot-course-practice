package com.gaming.gaming_project.hello_world;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person (String name, int age, Address address) {};
record Address(String village, String City) {};

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "ranga";
	}
	
	@Bean 
	public int age() {
		return 15;
	}
	
	@Bean
	@Primary
	public Person person () {
		var person = new Person("Ravi", 30, address());
		return person;
	}
	
	@Bean
	public Person person2MethodCall () {
		var person = new Person(name(), age(), address());
		return person;
	}
	
	@Bean
	public Person person3Parameters (String name, int age, Address customName) {
		var person = new Person(name, age, customName);
		return person;
	}
	
	@Bean
	public Person person4Qualifier (String name, int age, @Qualifier("address3Qualifier") Address address) {
		var person = new Person(name, age, address);
		return person;
	}
	
	@Bean(name= "customName")
	public Address address() {
		return new Address("Muraim", "Noakhali");
	}
	@Bean
	@Qualifier("address3Qualifier")
	public Address address2() {
		return new Address("Motinagar", "Feni");
	}
}
