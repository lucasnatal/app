/**
 * 
 */
package com.natal.beans;

import java.util.ArrayList;
import java.util.List;

import com.natal.utils.Game;

/**
 * @author Lucas Natal
 */
public class CadastroGameMB {
	
	private List<Game> games;
	
	private Game game;
	
	
	public CadastroGameMB() {
		games = new ArrayList<Game>();
		game = new Game();
	}

	
	public void gravar(){
		games.add(game);
		game = new Game();
	}
	

	public List<Game> getGames() {
		return games;
	}


	public Game getGame() {
		return game;
	}
	
	
}
