package com.github.thatnerdjack.basicmaze;

import java.util.ArrayList;

public abstract class AdvancedMaze {
	private int height, width;
    private MazeCoords start, end;
	private ArrayList<ArrayList<Boolean>> grid = new ArrayList<ArrayList<Boolean>>();

	public AdvancedMaze(int height, int width) {
		height = 2 + (int)(Math.random()*maxHeight);
        width = 2 + (int)(Math.random()*maxWidth);
        for(int i = 0; i < width; i++) {
            grid.add(i, new ArrayList<Boolean>());
        }
        for(ArrayList<Boolean> innerList : grid) {
            for(int i = 0; i < height; i++) {
                innerList.add(i, true);
            }
        }
	}
	
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	// returns true if the given location is the start square 
	// doesn't check whether coords are valid
	public boolean isStartSquare(MazeCoords c) {
		return (c.x == 0 && c.y == 0);
	}
	
	// returns true if the given location is the end square (can be used to terminate search)
	// doesn't check whether coords are valid
	public boolean isEndSquare(MazeCoords c) {
		return (c.x == (width - 1) && c.y == (height - 1));
	}
	
	// returns true if the given location is a valid location for the maze (can help
	// prune search so you can generate neighboring locations and then call this and
	// discard them without constantly checking the boundaries of the maze)
	public boolean validCoordinates(MazeCoords c) {
        return (( c.x >= 0 && c.x < width ) && ( c.y >= 0 && c.y < height));
    }
	
	// returns true if the given location is passable (i.e., empty, not a wall)
	public boolean isPassable(MazeCoords c) {
		if (! validCoordinates(c)) {
			System.err.println("Invalid coordinates " + c);
			return false;
		}

		return !grid.get(c.x).get(c.y);
	}
	
	// prints out the maze (with a border)
	public void printMaze() {
		for (int i = 0; i < width + 2; i++)
			System.out.print("=");
		System.out.println();
		for (int row = 0; row < height; row++) {
			System.out.print("|");
			for (int col = 0; col < width; col++) {
				MazeCoords coords = new MazeCoords(col, row);
				if (isStartSquare(coords)) 
					System.out.print("S");
				else if (isEndSquare(coords))
					System.out.print("E");
			    else if (isPassable(coords)) 
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println("|");
		}
		for (int i = 0; i < width + 2; i++)
			System.out.print("=");
		System.out.println();
	}
}
