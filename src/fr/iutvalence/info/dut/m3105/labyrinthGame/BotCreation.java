package fr.iutvalence.info.dut.m3105.labyrinthGame;

public interface BotCreation {

	static RobotArtificialIntelligence makeBot(String intelligence){
		switch (intelligence.toLowerCase()) {
		case "dumb":
			return new DumbBotArtificialIntelligence();
		case "lesserdumb":
			return new LesserDumbBotArtificialIntelligence();
		default:
			return new DumbBotArtificialIntelligence();
		}
	}

}
