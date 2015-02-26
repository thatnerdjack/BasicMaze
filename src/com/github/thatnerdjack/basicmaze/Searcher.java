package com.github.thatnerdjack.basicmaze;

import java.util.ArrayList;
import java.util.Collections;

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
        if(maze.validCoordinates(newCoords) && maze.isPassable(newCoords)) {
            return newCoords;
        } else {
            return null;
        }
    }

    public MazeCoords checkDown(MazeCoords oldCoords) {
        MazeCoords newCoords = new MazeCoords(oldCoords.x, oldCoords.y);
        newCoords.y = oldCoords.y + 1;
        if(maze.validCoordinates(newCoords) && maze.isPassable(newCoords)) {
            return newCoords;
        } else {
            return null;
        }
    }

    public MazeCoords checkLeft(MazeCoords oldCoords) {
        MazeCoords newCoords = new MazeCoords(oldCoords.x, oldCoords.y);
        newCoords.x = oldCoords.x - 1;
        if(maze.validCoordinates(newCoords) && maze.isPassable(newCoords)) {
            return newCoords;
        } else {
            return null;
        }
    }

    public MazeCoords checkRight(MazeCoords oldCoords) {
        MazeCoords newCoords = new MazeCoords(oldCoords.x, oldCoords.y);
        newCoords.x = oldCoords.x + 1;
        if(maze.validCoordinates(newCoords) && maze.isPassable(newCoords)) {
            return newCoords;
        } else {
            return null;
        }
    }

    public ArrayList<MazeCoords> findNeighbors(MazeCoords coords) {
        ArrayList<MazeCoords> coordList = new ArrayList<MazeCoords>();

        coordList.add(checkUp(coords));
        coordList.add(checkDown(coords));
        coordList.add(checkLeft(coords));
        coordList.add(checkRight(coords));

        coordList.removeAll(Collections.singleton(null));
        return coordList;
    }

}
