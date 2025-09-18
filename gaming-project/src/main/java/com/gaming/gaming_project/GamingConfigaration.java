package com.gaming.gaming_project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gaming.gaming_project.game.GameRunner;
import com.gaming.gaming_project.game.GamingConsole;
import com.gaming.gaming_project.game.MarioGame;
import com.gaming.gaming_project.game.PacmanGame;

@Configuration
public class GamingConfigaration {
	@Bean
	public GamingConsole game() {
		return new PacmanGame();
	}
	
	@Bean 
	public GameRunner gameRunner(GamingConsole game) {
		return new GameRunner(game);
	}
//	var game = new MarioGame();
//	var game = new MarioGame();
//	var gameRunner = new GameRunner(game);	// object creation + Wiring of dependencies -> "game" is dependency of GameRunner
//	gameRunner.run();
}
