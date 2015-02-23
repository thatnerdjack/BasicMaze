package com.github.thatnerdjack.basicmaze;

import java.util.ArrayList;

/**
* Created by block7 on 2/13/15.
*/
public class Searcher {
    Maze maze;

    public Searcher(Maze maze) {
        this.maze = maze;
    }

    public MazeCoords checkUp(MazeCoords oldCoords) {
        MazeCoords newCoords = new MazeCoords(oldCoords.x, oldCoords.y);
        newCoords.y = oldCoords.y - 1;
        if(maze.validCoordinates(newCoords)) {
            //START HERE
        }
    }

    public ArrayList<MazeCoords> findNeighbors(MazeCoords coords) {

    }

}

/*
TO DO:
-create checkUp, checkDown, etc. methods
-finish find Neighbors
*/
