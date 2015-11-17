package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.util.Scanner;

/**
 * Test application for labyrinth game
 * 
 */
public class TestLabyrinthGame {
	/**
	 * Application's main
	 * 
	 * @param args
	 *            command-line arguments (none expected here)
	 */
	public static void main(String[] args) {

		Scanner myScanner = new Scanner(System.in);

		System.out.println("How smart should be the bot ?");
		try {
			new LabyrinthGame(new LabyrinthBuilder(new Position(3, 1)).setWidth(4)
					.setHeight(4).addForbiddenPosition(new Position(2, 0))
					.addForbiddenPosition(new Position(3, 0))
					.addForbiddenPosition(new Position(0, 1))
					.addForbiddenPosition(new Position(0, 2))
					.addForbiddenPosition(new Position(1, 2))
					.addForbiddenPosition(new Position(3, 2))
					.addForbiddenPosition(new Position(3, 3)),
					BotCreation.makeBot(myScanner.nextLine())).play();
		} catch (HeightTooSmallException | WidthTooSmallException e) {
			// this exception never happens
			e.printStackTrace();
		}

		myScanner.close();
	}
}
