package com.github.thatnerdjack.basicmaze;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by block7 on 3/5/15.
 */
public class RandomMaze extends Maze{
    private final int MAX_TUNNEL_LENGTH = 7;

    public RandomMaze(int height, int width) {
        this.height = height;
        this.width = width;
        grid = new boolean[height][width];
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                grid[i][j] = true;
        tunnelFrom(new MazeCoords(0,0), 0, height * width + 1);
    }

    public int randomX() {
        return (int) (Math.random() * width);
    }

    public int randomY() {
        return (int) (Math.random() * height);
    }

    public MazeCoords randomSquare() {
        return new MazeCoords(randomX(), randomY());
    }

    // return MazeCoords for a random square that is empty (false in grid)
    public MazeCoords randomEmptySquare() {
        while (true) {
            MazeCoords square = randomSquare();
            if (! grid[square.y][square.x])
                return square;
        }
    }

    // returns the number of empty neighbors (false in grid) looking up/right/down/left
    // for the given coordinates
    public int numberEmptyNeighbors(MazeCoords coords) {
        int totalEmpty = 0;
        MazeCoords up = coords.up();
        if (validCoordinates(up) && ! grid[up.y][up.x])
            totalEmpty++;
        MazeCoords right = coords.right();
        if (validCoordinates(right) && ! grid[right.y][right.x])
            totalEmpty++;
        MazeCoords down = coords.down();
        if (validCoordinates(down) && ! grid[down.y][down.x])
            totalEmpty++;
        MazeCoords left = coords.left();
        if (validCoordinates(left) && ! grid[left.y][left.x])
            totalEmpty++;

        return totalEmpty;
    }

    public boolean okToTunnelTo(MazeCoords coords) {
        if ((Math.abs(coords.x - endSquare().x) == 1) && (Math.abs(coords.y - endSquare().y) == 1))
            return false;
        return validCoordinates(coords) && (numberEmptyNeighbors(coords) == 1);
    }

    public boolean tunnelFrom(MazeCoords coords, int currentDepth, int maxDepth) {
        grid[coords.y][coords.x] = false; // this square is now empty
        if (isEndSquare(coords))
            return true;
        if (currentDepth >= maxDepth)
            return false;

        // create the array that randomizes the order the directions are checked
        int[] directions = {0, 1, 2, 3};
        for (int i = 0; i < 10; i++) {
            int ndx1 = (int) (Math.random() * 4);
            int ndx2 = (int) (Math.random() * 4);
            int temp = directions[ndx1];
            directions[ndx1] = directions[ndx2];
            directions[ndx2] = temp;
        }

        for (int i = 0; i < 4; i++) {
            switch (directions[i]) {
                case 0:  // up
                    MazeCoords up = coords.up();
                    if (okToTunnelTo(up)) {
                        if (tunnelFrom(up, currentDepth + 1, maxDepth))
                            return true;
                    }
                    break;
                case 1: // right
                    MazeCoords right = coords.right();
                    if (okToTunnelTo(right)) {
                        if (tunnelFrom(right, currentDepth + 1, maxDepth))
                            return true;
                    }
                    break;
                case 2:
                    MazeCoords down = coords.down();
                    if (okToTunnelTo(down)) {
                        if (tunnelFrom(down, currentDepth + 1, maxDepth))
                            return true;
                    }
                    break;
                case 3:
                    MazeCoords left = coords.left();
                    if (okToTunnelTo(left)) {
                        if (tunnelFrom(left, currentDepth + 1, maxDepth))
                            return true;
                    }
                    break;
            }
        }
        return false;
    }

    public void generateMaze() {
        boolean foundEnd = false;
        while(!foundEnd) {
            int tunnelLength = (int)(Math.random() * MAX_TUNNEL_LENGTH + 1);
            MazeCoords startSquare = randomSquare();
            foundEnd = tunnelFrom(startSquare, 0, tunnelLength);
        }
    }

}
