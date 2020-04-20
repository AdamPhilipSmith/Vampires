
package com.vampires;

/**
 *
 * @author adamp
 */
public class Player {
    private int x;
    private int y;
    private int moves;

    public Player(int moves, int x, int y){
        this.x = x;
        this.y = y;
        this.moves = moves;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
