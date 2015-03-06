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

    public int numberEmptyNeighbors(MazeCoords coords) {
        int totalEmpty = 0;
        MazeCoords up = new MazeCoords(coords.x, coords.y - 1);
        if(validCoordinates(up) && !grid[up.x][up.y]) {
            totalEmpty++;
        }
        MazeCoords right = new MazeCoords(coords.x + 1, coords.y );
        if(validCoordinates(right) && !grid[right.x][right.y]) {
            totalEmpty++;
        }
        MazeCoords down = new MazeCoords(coords.x, coords.y + 1);
        if(validCoordinates(down) && !grid[down.x][down.y]) {
            totalEmpty++;
        }
        MazeCoords left = new MazeCoords(coords.x - 1, coords.y);
        if(validCoordinates(left) && !grid[left.x][left.y]) {
            totalEmpty++;
        }

        return totalEmpty;
    }

}
