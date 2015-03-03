
package com.github.thatnerdjack.basicmaze;

// main class for Mini-Maze Project; all it currently does is create a maze
// object and print it out

public class MazeMain {
		public static void main(String args[]) {
			AdvancedMaze advancedMaze = new AdvancedMaze(10,10);
            advancedMaze.printMaze();
		}
}
