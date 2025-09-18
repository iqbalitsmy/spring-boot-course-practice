package com.gaming.gaming_project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gaming.gaming_project.game.GameRunner;
import com.gaming.gaming_project.game.GamingConsole;
import com.gaming.gaming_project.game.MarioGame;

public class App03GamingSpringBeans {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(GamingConfigaration.class)){
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
		
	}

}
