package com.charge.point;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The Class World.
 */
public class World {
	
	/** The width. */
	private final int width;
	
	/** The height. */
	private final int height;

	/** The alive cells. */
	private final Map<Coordinate, Cell> aliveCells = new HashMap<>();

	/**
	 * Instantiates a new world.
	 *
	 * @param width the width
	 * @param height the height
	 * @param seedCoordinates the seed coordinates
	 */
	public World(int width, int height, List<Coordinate> seedCoordinates) {
		this.width = width;
		this.height = height;

		for (Coordinate coord : seedCoordinates) {
			Cell seedCell = new Cell(coord, this);
			seedCell.makeAlive();
			aliveCells.put(coord, seedCell);
		}
	}

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Gets the cell.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the cell
	 */
	public Cell getCell(int x, int y) {
		Coordinate coord = new Coordinate(x, y);
		return getCell(coord);
	}

	/**
	 * Gets the cell.
	 *
	 * @param coord the coord
	 * @return the cell
	 */
	public Cell getCell(Coordinate coord) {
		return aliveCells.get(coord);
	}

	/**
	 * Compute new status.
	 */
	public void computeNewStatus() {

		Set<Coordinate> coordinatesToCheck = computeCoordinatesToCheck();

		Map<Coordinate, Cell> newAliveCells = computeNewAliveCells(coordinatesToCheck);

		commitNewWorldStatus(newAliveCells);
	}

	/**
	 * Compute new alive cells.
	 *
	 * @param coordinatesToCheck the coordinates to check
	 * @return the map
	 */
	private Map<Coordinate, Cell> computeNewAliveCells(Set<Coordinate> coordinatesToCheck) {
		Map<Coordinate, Cell> newAliveCells = new HashMap<>();
		for (Coordinate coord : coordinatesToCheck) {
			Cell cell = getCell(coord);
			if (cell == null) {
				cell = new Cell(coord, this);
			} else {
				cell = new Cell(cell);
			}
			cell.computeNewStatus();
			if (cell.isAlive()) {
				newAliveCells.put(coord, cell);
			}
		}
		return newAliveCells;
	}

	/**
	 * computeCoordinatesToCheck
	 * check all the adjacent cells to any living cell. No other cells would be
	 * checked
	 *
	 * @return the sets the
	 */
	private Set<Coordinate> computeCoordinatesToCheck() {
		Set<Coordinate> coordinatesToCheck = new HashSet<>();
		for (Coordinate coord : aliveCells.keySet()) {
			int x = coord.getX();
			int y = coord.getY();

			for (int ox = x - 1; ox <= x + 1; ox++) {
				for (int oy = y - 1; oy <= y + 1; oy++) {
					coordinatesToCheck.add(new Coordinate(ox, oy));
				}
			}
		}
		return coordinatesToCheck;
	}

	/**
	 * Commit new world status.
	 *
	 * @param newAliveCells the new alive cells
	 */
	public void commitNewWorldStatus(Map<Coordinate, Cell> newAliveCells) {
		aliveCells.clear();
		aliveCells.putAll(newAliveCells);
	}

}
