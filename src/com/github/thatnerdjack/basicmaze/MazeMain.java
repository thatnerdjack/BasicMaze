
package com.github.thatnerdjack.basicmaze;

// main class for Mini-Maze Project; all it currently does is create a maze
// object and print it out

public class MazeMain {
		public static void main(String args[]) {
			Maze normalMaze = new Maze();
            normalMaze.printMaze();
            Searcher searcher = new Searcher(normalMaze);
            MazeCoords normalExit = searcher.genPathTree();
            System.out.println(searcher.printPath(normalExit));

            Maze brokenMaze = new BrokenTestMaze();
            brokenMaze.printMaze();
            Searcher brokenSearcher = new Searcher(brokenMaze);
            MazeCoords brokenExit = brokenSearcher.genPathTree();
            System.out.println(brokenSearcher.printPath(brokenExit));

            Maze openMaze = new OpenTestMaze();
            openMaze.printMaze();
            Searcher openSearcher = new Searcher(openMaze);
            MazeCoords openExit = openSearcher.genPathTree();
            System.out.println(openSearcher.printPath(openExit));

            Maze spiralMaze = new SpiralTestMaze();
            spiralMaze.printMaze();
            Searcher spiralSearcher = new Searcher(spiralMaze);
            MazeCoords spiralExit = spiralSearcher.genPathTree();
            System.out.println(spiralSearcher.printPath(spiralExit));
		}
}
