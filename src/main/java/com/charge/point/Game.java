package com.charge.point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

	private World world;
	private int tick;

	public Game(int worldWidth, int worldheight, List<Coordinate> seedCoordinates) {
		world = new World(worldWidth, worldheight, seedCoordinates);
		tick = 0;
	}

	public void start() {
		PrinterGame printGame = new PrinterGame(world, '*', ' ');
		while (true) {
			System.out.println("-: " + tick);
			printGame.print();
			world.computeNewStatus();
			tick++;
			try {
				Thread.sleep(2000);
			} catch ( InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		int worldWidth = Integer.parseInt(args[0]);
		int worldheight = Integer.parseInt(args[1]);

		List<Coordinate> seedCoordinates = new ArrayList<>();
		for (String seedCoordinate : Arrays.copyOfRange(args, 2, args.length)) {
			String[] coordinateTokens = seedCoordinate.split(",");
			Coordinate coord = new Coordinate(Integer.parseInt(coordinateTokens[0]), Integer.parseInt(coordinateTokens[1]));
			seedCoordinates.add(coord);
		}
		new Game(worldWidth, worldheight, seedCoordinates).start();
	}

}
