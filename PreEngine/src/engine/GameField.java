package engine;

import java.util.ArrayList;

// This is a custom container class
// Contains all the games for a season


public class GameField {

	private ArrayList<Game> games = new ArrayList<Game>();
	
	public GameField()
	{
		
	}
	
	
	public void add(Game game)
	{
		games.add(game);
	}
	
	
	public void mergeRepeatGames()
	{
		
	}
	
	
	private ArrayList<Game> getAllGamesPlayed(Team team)
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
	
	public boolean hasGame(Team team1, Team team2)
	{
		boolean result = false;
		
		ArrayList<Game> possible = getAllGamesPlayed(team1);
		
		for(Game game : possible)
		{
			if(game.hasTeam(team2))
			{
				result = true;
			}
		}
		
		
		return result;
	}
	
	
	public double getGameDifference(Team team1, Team team2)
	{
		@SuppressWarnings("null")
		double result = (Double) null;
		
		ArrayList<Game> possible = getAllGamesPlayed(team1);
		
		for(Game game : possible)
		{
			if(game.hasTeam(team2))
			{
				result = game.getDifference(team2);
			}
		}
		
		return result;
	}
	
	public String toString()
	{
		String gamesPlayed = "";
		
		for(Game game : games)
		{
			gamesPlayed += "[" + game.toString() + "] ";
		}
		
		
		return gamesPlayed;
	}
	
	
}
