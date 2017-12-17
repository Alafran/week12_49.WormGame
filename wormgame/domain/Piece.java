
package wormgame.domain;

public class Piece {
    protected int x;
    protected int y;
    
    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    
    public boolean runsInto(Piece piece) {
        return piece.x == this.x && piece.y == this.y;
    }
    
    @Override
    public String toString() {
       return "(" + this.x + "," + this.y + ")"; 
    }
}
