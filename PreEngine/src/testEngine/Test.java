package testEngine;
import engine.*;

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
		
		Pathway path0lvl = new Pathway(a, b, 0, s); 
		printArray(path0lvl.generatePathway());
		
		Pathway path1lvl = new Pathway(a, c, 2, s);
		printArray(path1lvl.generatePathway());
		
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
