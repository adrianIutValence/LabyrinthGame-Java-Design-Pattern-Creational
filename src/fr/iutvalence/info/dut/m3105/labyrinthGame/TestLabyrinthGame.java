package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Test application for labyrinth game
 * 
 */
public class TestLabyrinthGame
{
	/**
	 * Application's main
	 * 
	 * @param args
	 *            command-line arguments (none expected here)
	 */
	public static void main(String[] args)
	{
		Set<Position> blockPositions = new HashSet<Position>();
		blockPositions.add(new Position(2,0));
		blockPositions.add(new Position(3,0));
		blockPositions.add(new Position(0,1));
		blockPositions.add(new Position(0,2));
		blockPositions.add(new Position(1,2));
		blockPositions.add(new Position(3,2));
		blockPositions.add(new Position(3,3));
		
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("How smart should be the bot ?");
		new LabyrinthGame(new Labyrinth(4, 4, blockPositions, new Position(3,1)), BotCreation.makeBot(myScanner.nextLine())).play();
		
		myScanner.close();
	}
}
