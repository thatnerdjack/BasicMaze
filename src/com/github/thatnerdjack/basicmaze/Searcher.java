package com.github.thatnerdjack.basicmaze;

import java.util.ArrayList;
import java.util.Collections;

/**
* Created by block7 on 2/13/15.
*/
public class Searcher {
    private Maze maze;
    private MazeCoords start = new MazeCoords(0,0);
//    private ArrayList<ArrayList<MazeCoords>> visited = new ArrayList<ArrayList<MazeCoords>>();
//START HERE

    public Searcher(Maze maze) {
        this.maze = maze;
    }

    public MazeCoords checkUp(MazeCoords oldCoords) {
        MazeCoords newCoords = new MazeCoords(oldCoords.x, oldCoords.y, oldCoords);
        newCoords.y = oldCoords.y - 1;
        if(maze.validCoordinates(newCoords) && maze.isPassable(newCoords)) {
            return newCoords;
        } else {
            return null;
        }
    }

    public MazeCoords checkDown(MazeCoords oldCoords) {
        MazeCoords newCoords = new MazeCoords(oldCoords.x, oldCoords.y, oldCoords);
        newCoords.y = oldCoords.y + 1;
        if(maze.validCoordinates(newCoords) && maze.isPassable(newCoords)) {
            return newCoords;
        } else {
            return null;
        }
    }

    public MazeCoords checkLeft(MazeCoords oldCoords) {
        MazeCoords newCoords = new MazeCoords(oldCoords.x, oldCoords.y, oldCoords);
        newCoords.x = oldCoords.x - 1;
        if(maze.validCoordinates(newCoords) && maze.isPassable(newCoords)) {
            return newCoords;
        } else {
            return null;
        }
    }

    public MazeCoords checkRight(MazeCoords oldCoords) {
        MazeCoords newCoords = new MazeCoords(oldCoords.x, oldCoords.y, oldCoords);
        newCoords.x = oldCoords.x + 1;
        if(maze.validCoordinates(newCoords) && maze.isPassable(newCoords)) {
            return newCoords;
        } else {
            return null;
        }
    }

//    public ArrayList<MazeCoords> findNeighbors(MazeCoords coords) {
//        ArrayList<MazeCoords> coordList = new ArrayList<MazeCoords>();
//
//        coordList.add(checkUp(coords));
//        coordList.add(checkDown(coords));
//        coordList.add(checkLeft(coords));
//        coordList.add(checkRight(coords));
//
//        coordList.removeAll(Collections.singleton(null));
//        return coordList;
//    }

    public ArrayList<MazeCoords> getFinalLayer() {
        ArrayList<MazeCoords> oldList = new ArrayList<MazeCoords>();
        oldList.add(start);
        while(true) {
            ArrayList<MazeCoords> newList = new ArrayList<MazeCoords>();
            for(MazeCoords coords : oldList) {
                newList.add(checkUp(coords));
                newList.add(checkDown(coords));
                newList.add(checkLeft(coords));
                newList.add(checkRight(coords));
                newList.removeAll(Collections.singleton(null));
            }
            for(MazeCoords coords : newList) {
                if(maze.isEndSquare(coords)) {
                    return newList;
                }
            }
            oldList = newList;
        }
    }

}
