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
	
	public ArrayList<Game> getAllGamesPlayed(Team team)
	{
		
		ArrayList<Game> temp = new ArrayList<Game>();
		
		for(Game game : games)
		{
			if (game.hasTeam(team))
			{
				temp.add(game);
			}
		}
		
		
		return temp;
	}
	
	public boolean hasGame()
	{
		
		return false;
	}
	
	
}
