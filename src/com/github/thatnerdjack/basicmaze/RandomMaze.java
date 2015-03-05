package com.github.thatnerdjack.basicmaze;

/**
 * Created by block7 on 3/5/15.
 */
public class RandomMaze extends Maze{

    public RandomMaze(int height, int width) {
        this.height = height;
        this.width = width;
        grid = new boolean[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                grid[i][j] = true;
            }
        }
        grid[0][0] = false;
    }

    public int randomX() {
        return (int)(Math.random() * width);
    }

    public int randomY() {
        return (int)(Math.random() * height);
    }

    public MazeCoords randomSquare() {
        return new MazeCoords(randomX(), randomY());
    }

    public MazeCoords randomEmptySquare() {
        while(true) {
            MazeCoords randomCoords = randomSquare();
            if(isPassable(randomCoords)) {
                return randomCoords;
            }
        }
    }

    public MazeCoords checkUp(MazeCoords oldCoords) {
        MazeCoords newCoords = new MazeCoords(oldCoords.x, oldCoords.y, oldCoords);
        newCoords.y = oldCoords.y - 1;
        if(validCoordinates(newCoords) && isPassable(newCoords))) { //START HERE
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

    public int numberEmptyNeighbors(MazeCoords coords) {
        int returnInt = 0;

        return returnInt;
    }

}
