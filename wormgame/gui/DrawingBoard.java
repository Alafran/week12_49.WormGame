package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

public class DrawingBoard extends JPanel implements Updatable {

    private int pieceLength;
    private WormGame wormGame;

    public DrawingBoard(WormGame wormGame, int pieceLength) {
        this.pieceLength = pieceLength;
        this.wormGame = wormGame;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.black);
        for (Piece piece : this.wormGame.getWorm().getPieces()) {
            graphics.fill3DRect(piece.getX() * this.pieceLength, piece.getY() * this.pieceLength, this.pieceLength, this.pieceLength, true);
        }
        graphics.setColor(Color.red);
        graphics.fillOval(this.wormGame.getApple().getX() * this.pieceLength, this.wormGame.getApple().getY() * this.pieceLength, this.pieceLength, this.pieceLength);
    }

    @Override
    public void update() {
        super.repaint();
    }

}
