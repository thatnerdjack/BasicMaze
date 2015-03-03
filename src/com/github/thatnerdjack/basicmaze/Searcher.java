package com.github.thatnerdjack.basicmaze;

import java.util.ArrayList;
import java.util.Collections;

/**
* Created by block7 on 2/13/15.
*/
public class Searcher {
    private Maze maze;
    private MazeCoords start = new MazeCoords(0,0);
    private ArrayList<ArrayList<Boolean>> visited = new ArrayList<ArrayList<Boolean>>();
    // visited.x.y

    public Searcher(Maze maze) {
        this.maze = maze;
        for(int i = 0; i < maze.getWidth(); i++) {
            visited.add(i, new ArrayList<Boolean>());
        }
        for(ArrayList<Boolean> innerList : visited) {
            for(int i = 0; i < maze.getHeight(); i++) {
                innerList.add(i, false);
            }
        }
        visited.get(start.x).set(start.y, true);
    }

    public MazeCoords checkUp(MazeCoords oldCoords) {
        MazeCoords newCoords = new MazeCoords(oldCoords.x, oldCoords.y, oldCoords);
        newCoords.y = oldCoords.y - 1;
        if(maze.validCoordinates(newCoords) && maze.isPassable(newCoords) && !visited.get(newCoords.x).get(newCoords.y)) {
            visited.get(newCoords.x).set(newCoords.y, true);
            return newCoords;
        } else {
            return null;
        }
    }

    public MazeCoords checkDown(MazeCoords oldCoords) {
        MazeCoords newCoords = new MazeCoords(oldCoords.x, oldCoords.y, oldCoords);
        newCoords.y = oldCoords.y + 1;
        if(maze.validCoordinates(newCoords) && maze.isPassable(newCoords) && !visited.get(newCoords.x).get(newCoords.y)) {
            visited.get(newCoords.x).set(newCoords.y, true);
            return newCoords;
        } else {
            return null;
        }
    }

    public MazeCoords checkLeft(MazeCoords oldCoords) {
        MazeCoords newCoords = new MazeCoords(oldCoords.x, oldCoords.y, oldCoords);
        newCoords.x = oldCoords.x - 1;
        if(maze.validCoordinates(newCoords) && maze.isPassable(newCoords) && !visited.get(newCoords.x).get(newCoords.y)) {
            visited.get(newCoords.x).set(newCoords.y, true);
            return newCoords;
        } else {
            return null;
        }
    }

    public MazeCoords checkRight(MazeCoords oldCoords) {
        MazeCoords newCoords = new MazeCoords(oldCoords.x, oldCoords.y, oldCoords);
        newCoords.x = oldCoords.x + 1;
        if(maze.validCoordinates(newCoords) && maze.isPassable(newCoords) && !visited.get(newCoords.x).get(newCoords.y)) {
            visited.get(newCoords.x).set(newCoords.y, true);
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

    public MazeCoords genPathTree() {
        ArrayList<MazeCoords> oldList = new ArrayList<MazeCoords>();
        oldList.add(start);
        while(true) {
            if(oldList.size() == 0) {
                System.out.println("ERROR: Maze unsolvable");
                return null;
            }
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
                    return coords;
                }
            }
            oldList = newList;
        }
    }

    public String printPath(MazeCoords exit) {
        if(exit == null) {
            System.out.println("ERROR: Path unprintable. MazeCood of null.");
        }
        MazeCoords node = exit;
        String path = "";
        while(node != null) {
            path = node.toString() + " -> " + path;
            node = node.parent;
        }
        return path;
    }

}
