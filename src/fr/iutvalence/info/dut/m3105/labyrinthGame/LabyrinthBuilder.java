package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.util.HashSet;
import java.util.Set;

public class LabyrinthBuilder {
	private int width;
	private int height;
	private final Position exitPosition;
	private Set<Position> forbiddenCellsPositions;

	public LabyrinthBuilder(int width, int height, Position exitPosition) {
		this.width = width;
		this.height = height;
		this.exitPosition = exitPosition;
		this.forbiddenCellsPositions = new HashSet<Position>();
	}

	public LabyrinthBuilder(Position exitPosition) {
		this.exitPosition = exitPosition;
		this.width = exitPosition.getX() - 1;
		this.height = exitPosition.getY() - 1;
	}

	public LabyrinthBuilder(String ascii){
		String[] lines = ascii.split("\n");
		for(int lineNumber = 0; lineNumber<lines.length; lineNumber++){
			for(int columnNumber = 0; columnNumber<lines[lineNumber].length(); columnNumber++){
				this.addAsciiForbidenPosition(lineNumber, columnNumber, lines[lineNumber].charAt(columnNumber));
			}
		}
		
	}

	private void addAsciiForbidenPosition(int lineNumber, int columnNumber,
			char charAt) {
		
		
	}

	public LabyrinthBuilder addForbiddenPosition(Position position) {
		this.forbiddenCellsPositions.add(position);
		return this;
	}

	public LabyrinthBuilder setWidth(int width) throws WidthTooSmallException {
		if (this.exitPosition.getX() >= width) {
			throw new WidthTooSmallException();
		}
		this.width = width;

		labyrinthCleaner();
		return this;
	}

	public LabyrinthBuilder setHeight(int height)
			throws HeightTooSmallException {
		if (this.exitPosition.getY() >= height) {
			throw new HeightTooSmallException();
		}
		this.height = height;

		labyrinthCleaner();
		return this;
	}

	private void labyrinthCleaner() {
		for (Position position : this.forbiddenCellsPositions) {
			if (this.isPositionOutOfBounds(position)) {
				this.forbiddenCellsPositions.remove(position);
			}
		}
	}

	public Labyrinth getLabyrinth() {
		return new Labyrinth(this.width, this.height,
				this.forbiddenCellsPositions, this.exitPosition);
	}

	public LabyrinthBuilder addForbiddenPositions(Set<Position> positions) {
		this.forbiddenCellsPositions.addAll(positions);
		return this;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	private boolean isPositionOutOfBounds(Position position) {
		if (position.getX() < 0)
			return true;
		if (position.getX() >= this.width)
			return true;
		if (position.getY() < 0)
			return true;
		if (position.getY() >= this.height)
			return true;
		return false;
	}

	public CellState getCellStateAt(Position position) {
		if (this.isPositionOutOfBounds(position))
			return CellState.FORBIDDEN;

		if (position.equals(this.exitPosition))
			return CellState.EXIT;

		if (this.forbiddenCellsPositions.contains(position))
			return CellState.FORBIDDEN;

		return CellState.FREE;
	}

	public Position getResultingPositionWhenMoving(Position startingPosition,
			Direction direction) {
		Position resultingPosition = startingPosition
				.getNeighbourPosition(direction);
		if (this.getCellStateAt(resultingPosition) == CellState.FORBIDDEN)
			resultingPosition = startingPosition;
		return resultingPosition;
	}

	public Position getStartingPosition() {
		return new Position(0, 0);
	}

}
