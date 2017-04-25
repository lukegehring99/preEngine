package engine;

import java.util.ArrayList;

// This is a custom container class
// Contains all the games for a season


public class GameField {

	private ArrayList<Game> games = new ArrayList<Game>();
	
	
	public void add(Game game)
	{
		games.add(game);
	}
	
	
	public void mergeRepeatGames()
	{
		
	}
	
	public ArrayList<Team> getAllGamesPlayed(Team team)
	{
		return new ArrayList<Team>();
	}
}
