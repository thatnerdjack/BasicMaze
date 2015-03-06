package com.github.thatnerdjack.basicmaze;

import java.util.Random;

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

    public static int[] randomizeArray(int[] array){
        Random rgen = new Random();  // Random number generator

        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }

    public boolean canTunnelTo(MazeCoords coords) {
        return validCoordinates(coords) && (numberEmptyNeighbors(coords) == 1);
    }

    public boolean tunnelFrom(MazeCoords coords, int currentDepth, int maxDepth) {
        grid[coords.y][coords.x] = false; // this square is now empty
        if (isEndSquare(coords))
            return true;
        if (currentDepth >= maxDepth)
            return false;
        int[] directions = {1, 2, 3, 4};
        directions = randomizeArray(directions);
        for (int i = 0; i < 4; i++) {
            switch (directions[i]) {
                case 0:  // up
                    MazeCoords up = coords.up();
                    if (canTunnelTo(up)) {
                        tunnelFrom(up, currentDepth + 1, maxDepth);
                    }
                    break;
                case 1: // right
                    MazeCoords right = coords.right();
                    if (canTunnelTo(right)) {
                        tunnelFrom(right, currentDepth + 1, maxDepth);
                    }
                    break;
                case 2:
                    MazeCoords down = coords.down();
                    if (canTunnelTo(down)) {
                        tunnelFrom(down, currentDepth + 1, maxDepth);
                    }
                    break;
                case 3:
                    MazeCoords left = coords.left();
                    if (canTunnelTo(left)) {
                        tunnelFrom(left, currentDepth + 1, maxDepth);
                    }
                    break;
            }
        }
        return false;
    }

}
