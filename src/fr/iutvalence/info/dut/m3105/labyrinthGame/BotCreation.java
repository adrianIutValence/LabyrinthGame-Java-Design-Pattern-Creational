package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.util.HashMap;

public interface BotCreation {

	static HashMap<String, RobotArtificialIntelligence> createdBots = new HashMap<String, RobotArtificialIntelligence>();
	static String DEFAULT_BOT_TO_CREATE = "dumb";

	static RobotArtificialIntelligence makeBot(String intelligence) {

		if (createdBots.containsKey(intelligence))
			return createdBots.get(intelligence).clone();

		switch (intelligence.toLowerCase()) {
		case "dumb":
			createdBots.put(intelligence, new DumbBotArtificialIntelligence());
			return createdBots.get(intelligence).clone();

		case "lesserdumb":
			createdBots.put(intelligence,
					new LesserDumbBotArtificialIntelligence());
			return createdBots.get(intelligence).clone();

		default:
			createdBots.put(DEFAULT_BOT_TO_CREATE, new DumbBotArtificialIntelligence());
			return createdBots.get(DEFAULT_BOT_TO_CREATE).clone();
		}
	}
}