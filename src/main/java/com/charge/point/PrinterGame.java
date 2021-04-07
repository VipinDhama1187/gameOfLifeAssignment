package com.charge.point;

/**
 * The Class PrinterGame.
 */
public class PrinterGame {

	/** The world. */
	private World world;

	/** The alive marker. */
	private Character aliveMarker;
	
	/** The dead character. */
	private Character deadCharacter;

	/**
	 * Instantiates a new printer game.
	 *
	 * @param world the world
	 * @param aliveMarker the alive marker
	 * @param deadCharacter the dead character
	 */
	public PrinterGame(World world, Character aliveMarker, Character deadCharacter) {
		this.world = world;
		this.aliveMarker = aliveMarker;
		this.deadCharacter = deadCharacter;
	}

	/**
	 * Prints the.
	 */
	public void print() {
		int height = world.getHeight();
		int width = world.getWidth();
		System.out.print("   |");
		for (int y = 0; y < height; y++) {
			System.out.print(String.format("%3d", y));
		}
		System.out.println();
		for (int y = 0; y < width; y++) {
			System.out.print(String.format("%2d | ", y));
			for (int x = 0; x < height; x++) {
				Cell cell = world.getCell(x, y);
				if (cell != null && cell.isAlive()) {
					System.out.print(" " + aliveMarker + " ");
				} else {
					System.out.print(" " + deadCharacter + " ");
				}
			}
			System.out.println();
		}
	}
}
