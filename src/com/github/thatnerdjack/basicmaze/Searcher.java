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

    public ArrayList<Integer> findNeighbors(int xCoord, int yCoord) {
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        for(int i = 0; i < maze.getWidth(); i++) {
            neighbors.add(-1);
        }

    }

}

/*
TO DO:
-create checkUp, checkDown, etc. methods
-finish find Neighbors
 */
