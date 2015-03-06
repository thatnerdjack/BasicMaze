
package com.github.thatnerdjack.basicmaze;

// main class for Mini-Maze Project; all it currently does is create a maze
// object and print it out

public class MazeMain {
		public static void main(String args[]) {
			RandomMaze randomMaze = new RandomMaze(10, 10);
            randomMaze.printMaze();
            System.out.println(randomMaze.randomEmptySquare());
            System.out.println(randomMaze.numberEmptyNeighbors(new MazeCoords(0,0)));
		}
}
