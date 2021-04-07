package com.charge.point;

import static com.charge.point.Cell.Status.ALIVE;
import static com.charge.point.Cell.Status.DEAD;

/**
 * The Class Cell.
 */
public class Cell {
	
	/**
	 * The Enum Status.
	 */
	enum Status {
		
		/** The dead. */
		DEAD, 
 /** The alive. */
 ALIVE
	}

	/** The x. */
	private int x;
	
	/** The y. */
	private int y;

	/** The status. */
	private Status status;

	/** The world. */
	private World world;

	/**
	 * Instantiates a new cell.
	 *
	 * @param coord the coord
	 * @param world the world
	 */
	public Cell(Coordinate coord, World world) {
		this(coord.getX(), coord.getY(), world, DEAD);
	}

	/**
	 * Instantiates a new cell.
	 *
	 * @param x the x
	 * @param y the y
	 * @param world the world
	 * @param status the status
	 */
	public Cell(int x, int y, World world, Status status) {
		this.x = x;
		this.y = y;
		this.world = world;
		this.status = status;
	}

	/**
	 * Instantiates a new cell.
	 *
	 * @param cell the cell
	 */
	public Cell(Cell cell) {
		this(cell.getX(), cell.getY(), cell.getWorld(), cell.getStatus());
	}

	/**
	 * Rules:- 
	 * Any live cell with fewer than two live neighbours dies, as if caused by under-population.
	 * Any live cell with two or three live neighbours lives on to the next generation.
	 * Any live cell with more than three live neighbours dies, as if by overcrowding.
	 * Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
	 */
	public void computeNewStatus() {
		Status newStatus = DEAD;
		int aliveNeighbours = countAliveNeighbours();
		switch (aliveNeighbours) {
		case 0:
		case 1:
			newStatus = DEAD;
			break;
		case 2:
			if (status == ALIVE) {
				newStatus = ALIVE;
			}
			break;
		case 3:
			newStatus = ALIVE;
			break;
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
			newStatus = DEAD;
			break;
		default:
			throw new RuntimeException("A cell can never have more than 8 neighbours...");
		}
		status = newStatus;

	}

	/**
	 * Count alive neighbours.
	 *
	 * @return the int
	 */
	private int countAliveNeighbours() {
		int aliveNeighbours = 0;
		aliveNeighbours += (isNeighbourAlive(1, 0) ? 1 : 0); 
		aliveNeighbours += (isNeighbourAlive(1, 1) ? 1 : 0); 
		aliveNeighbours += (isNeighbourAlive(0, 1) ? 1 : 0); 
		aliveNeighbours += (isNeighbourAlive(-1, 1) ? 1 : 0);
		aliveNeighbours += (isNeighbourAlive(-1, 0) ? 1 : 0);
		aliveNeighbours += (isNeighbourAlive(-1, -1) ? 1 : 0);
		aliveNeighbours += (isNeighbourAlive(0, -1) ? 1 : 0); 
		aliveNeighbours += (isNeighbourAlive(1, -1) ? 1 : 0); 
		return aliveNeighbours;
	}

	/**
	 * Checks if is neighbour alive.
	 *
	 * @param deltaX the delta X
	 * @param deltaY the delta Y
	 * @return true, if is neighbour alive
	 */
	private boolean isNeighbourAlive(int deltaX, int deltaY) {
		Cell cell = world.getCell(x + deltaX, y + deltaY);
		return cell != null && cell.status == ALIVE;
	}

	/**
	 * Checks if is alive.
	 *
	 * @return true, if is alive
	 */
	public boolean isAlive() {
		return status == ALIVE;
	}

	/**
	 * Make alive.
	 */
	public void makeAlive() {
		status = ALIVE;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + ", status=" + status + "]";
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * Gets the world.
	 *
	 * @return the world
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * Sets the world.
	 *
	 * @param world the new world
	 */
	public void setWorld(World world) {
		this.world = world;
	}

}
