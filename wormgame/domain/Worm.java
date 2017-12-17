package wormgame.domain;

import wormgame.domain.Piece;
import java.util.List;
import java.util.ArrayList;
import wormgame.Direction;

public class Worm {

    private Direction Direction;
    private List<Piece> wormOfPieces;
    private boolean toGrow = false;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.Direction = originalDirection;
        this.wormOfPieces = new ArrayList<Piece>();
        this.wormOfPieces.add(new Piece(originalX, originalY));
    }

    public Direction getDirection() {
        return this.Direction;
    }

    public void setDirection(Direction dir) {
        this.Direction = dir;
    }

    public int getLength() {
        return this.wormOfPieces.size();
    }

    public List<Piece> getPieces() {
        return this.wormOfPieces;
    }

    public void move() {
        if (this.wormOfPieces.size() < 3) {
            this.grow();
        }

        Piece pieceToBeAdded = new Piece(this.wormOfPieces.get(getLength() - 1).getX(), this.wormOfPieces.get(getLength() - 1).getY());

        if (this.Direction == Direction.UP) {
            pieceToBeAdded.move(0, -1);
        }
        if (this.Direction == Direction.DOWN) {
            pieceToBeAdded.move(0, 1);
        }
        if (this.Direction == Direction.RIGHT) {
            pieceToBeAdded.move(1, 0);
        }
        if (this.Direction == Direction.LEFT) {
            pieceToBeAdded.move(-1, 0);
        }
        this.wormOfPieces.add(pieceToBeAdded);
        
        if(!this.toGrow) {
            this.wormOfPieces.remove(0);
        }
        else {
            this.toGrow = false;
        }
    }

    public void grow() {
        this.toGrow = true;
    }
    
    public boolean runsInto(Piece piece) {
        
        for(Piece wormPiece : this.wormOfPieces) {
            if(piece.getX() == wormPiece.getX() && piece.getY() == wormPiece.getY()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean runsIntoItself() {
        int headX = this.wormOfPieces.get(getLength() - 1).getX();
        int headY = this.wormOfPieces.get(getLength() - 1).getY();
        
        for(int i = 0; i < getLength() - 2; i++) {
            if(this.wormOfPieces.get(i).getX() == headX && this.wormOfPieces.get(i).getY() == headY) {
                return true;
            }
        }
        return false;
    }
}
