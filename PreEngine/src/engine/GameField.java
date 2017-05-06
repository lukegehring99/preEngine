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
		int[] indexes = new int[0];
		
		for(int i = 0; i < games.size() - 1; i++)
		{
			for(int k = i + 1; k < games.size(); k++)
			{
				if(games.get(i).hasTeam(games.get(k).getTeam1()) && games.get(i).hasTeam(games.get(k).getTeam2()))
				{
					if(isUniqueValue(indexes, i))
					{
						indexes = append(indexes, i);
					}
				}
			}
		}
		
		
		int[] temp = new int[0];
		
		int toMerge = indexes.length;
		
		while(toMerge > 0)
		{
			
		}
		

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
		double result = 0;
		
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
	
	
	private int[] append(int[] old, int addedValue)
	{
		int length = old.length;
		int[] newArray = new int[length + 1];
		
		for(int i = 0; i < length; i++)
		{
			newArray[i] = old[i];
		}
		
		newArray[length] = addedValue;
		return newArray;
	}
	
	
	private boolean isUniqueValue(int[] array, int checkValue)
	{
		boolean value = true;
		
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] == checkValue)
			{
				value = false;
			}
		}
		
		return value;
	}
	
}
