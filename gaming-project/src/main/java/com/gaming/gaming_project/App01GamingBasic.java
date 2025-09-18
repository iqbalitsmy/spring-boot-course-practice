package com.gaming.gaming_project;

import com.gaming.gaming_project.game.GameRunner;
import com.gaming.gaming_project.game.MarioGame;

public class App01GamingBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		var game = new MarioGame();
		var game = new MarioGame();
		var gameRunner = new GameRunner(game);	// object creation + Wiring of dependencies -> "game" is dependency of GameRunner
		gameRunner.run();
	}

}
