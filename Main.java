package tp.p1;

import java.util.Scanner;

import tp.p1.game.Game;
import tp.p1.game.Level;

import java.io.IOException;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws RuntimeException, IOException{
		// TODO Auto-generated method stub
		
		int seed = 0;
		Level level;
		Scanner scanner = new Scanner(System.in);
		
		try {
			if(args.length == 0) {
				throw new RuntimeException("Usage: Main <EASY|HARD|INSANE> [seed]");	
			}
			else
			{
				try {
					if(args[0].equals("EASY")) {
						level = Level.EASY;
					}
					else if(args[0].equals("HARD")) {
						level = Level.HARD;
					}
					else if(args[0].equals("INSANE")){
						level = Level.INSANE;
					}
					else
					{
						throw new RuntimeException("Usage: Main <EASY|HARD|INSANE> [seed]: level must be one of: EASY, HARD, INSANE");
					}
					
					if(args.length == 1) {
						Random rand = new Random(System.currentTimeMillis());
						seed = rand.nextInt();
					}
					else if ( args.length == 2) {
						try
						{
							seed = Integer.parseInt(args[1]);
						}
						catch(RuntimeException exception)
						{
							throw new RuntimeException("Usage: Main <EASY|HARD|INSANE> [seed]: the seed must be a number");
						}
					}
					else
					{
						throw new RuntimeException("Usage: Main <EASY|HARD|INSANE> [seed]");
					}
					
					Game game = new Game(level, new Random(seed));
					Controller controller = new Controller(game, scanner);
					controller.run();
				}
				catch(RuntimeException except)
				{
					System.err.println(except.getMessage());
				}
			}
		}
		catch(RuntimeException except)
		{
			System.err.println(except.getMessage());
		}
	}
}
