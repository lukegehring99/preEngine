package testEngine;
import engine.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Test {

	public static void main(String[] args) {
//		System.out.println("Test module");
		
		Sport s = new Sport("ball");

		Team a = new Team("A");
		s.addTeam(a);
		
		Team b = new Team("B");
		s.addTeam(b);
		
		Team c = new Team("C");
		s.addTeam(c);
		
		Game game0 = new Game(a, 5, b, 6);
		s.addGame(game0);
		
		Game game1 = new Game(a, 4, b, 2);
		s.addGame(game1);
		
		Game game2 = new Game(a, 8, c, 5);
		s.addGame(game2);
		
		Game game3 = new Game(c, 4, a, 2);
		s.addGame(game3);
		
		Game game4 = new Game(a, 3, b, 6);
		s.addGame(game4);
		
		System.out.println(s.getGameField());
		
		s.getGameField().mergeRepeatGames();
		
		System.out.println(s.getGameField());
		
		
		Test obj = new Test();
		
		obj.serializeSport(s);
		
		/*
		Team d = new Team("D");
		s.addTeam(d);
		
		Team e = new Team("E");
		s.addTeam(e);
		
//		System.out.println(s.getRoster());

		Game game0 = new Game(a, 21, b, 20);
		s.addGame(game0);
		
		Game game1 = new Game(a, 23, d, 15);
		s.addGame(game1);
		
		Game game2 = new Game(a, 20, e, 18);
		s.addGame(game2);
		
		Game game3 = new Game(b, 18, c, 19);
		s.addGame(game3);
		
		Game game4 = new Game(b, 23, d, 20);
		s.addGame(game4);
		
		Game game5 = new Game(d, 27, e, 24);
		s.addGame(game5);
		
		Game game6 = new Game(e, 16, c, 19);
		s.addGame(game6);
		
		
		Pathway path0lvl = new Pathway(a, c, 1, s); 
		printArray(path0lvl.generatePathway());
		
		Pathway path1lvl = new Pathway(a, c, 2, s);
		printArray(path1lvl.generatePathway());
		
		
		for(int i = 0; i < 4; i++)
		{
			
			Pathway path = new Pathway(a, b, i, s);
			System.out.println(System.currentTimeMillis());
			
			
			
			printArray(path.generatePathway());
		}
		*/
		
		
	}

	public void serializeSport(Sport sport) {
		
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		
		try
		{
			fout = new FileOutputStream("");
		}catch (Exception ex)
		{
			
		}
		
	}

	public static void printArray(double[] array)
	{
		System.out.print("[");
		for(int i = 0; i < array.length; i++)
		{
			if(!(i == array.length-1))
			{
				System.out.print(array[i] + ", ");
			}
			else
			{
				System.out.print(array[i]);
			}
		}
		System.out.println("]");
	}
	
	
}
