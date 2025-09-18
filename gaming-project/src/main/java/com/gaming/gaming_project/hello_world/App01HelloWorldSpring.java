package com.gaming.gaming_project.hello_world;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App01HelloWorldSpring {

	public static void main(String[] args) {
		//1. Launch a spring context
		try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){
			
			//2. Configure the things that we want spring to manage 
			// HelloWorldConfiguration - -> @configuration
			// name -> @Bean
			
			//3. Retrieving Beans managed by Spring
			System.out.println(context.getBean("name"));
			
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean("person"));
			
			System.out.println(context.getBean("person2MethodCall"));
			
			System.out.println(context.getBean("person3Parameters"));
			
			System.out.println(context.getBean("person4Qualifier"));
			
			System.out.println(context.getBean(Person.class));
			
			//custom name
			System.out.println(context.getBean("customName"));
			
			//print all beans names
//			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
		}
	}

}
