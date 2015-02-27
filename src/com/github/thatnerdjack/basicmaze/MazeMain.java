
package com.github.thatnerdjack.basicmaze;

// main class for Mini-Maze Project; all it currently does is create a maze
// object and print it out

public class MazeMain {
		public static void main(String args[]) {
			Maze maze = new Maze();
            Searcher searcher = new Searcher(maze);
            System.out.println(searcher.getFinalLayer());
            maze.printMaze();
		}
}
