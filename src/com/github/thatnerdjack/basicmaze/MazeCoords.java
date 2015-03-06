package com.github.thatnerdjack.basicmaze;

// very simple class to hold a pair of coords for the maze

public class MazeCoords {
	int x, y;
    MazeCoords parent;

	public MazeCoords(int x, int y) {
		this.x = x;
		this.y = y;
	}

    public MazeCoords(int x, int y, MazeCoords parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

    public MazeCoords up() {
        return new MazeCoords(x, y - 1, this);
    }

    public MazeCoords down() {
        return new MazeCoords(x, y + 1, this);
    }

    public MazeCoords left() {
        return new MazeCoords(x - 1, y, this);
    }

    public MazeCoords right() {
        return new MazeCoords(x + 1, y, this);
    }

}
