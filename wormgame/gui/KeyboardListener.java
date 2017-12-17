
package wormgame.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import wormgame.Direction;
import wormgame.domain.Worm;

public class KeyboardListener implements KeyListener{
    
    private Worm worm;
    
    public KeyboardListener(Worm worm) {
        this.worm = worm;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_UP) {
            this.worm.setDirection(Direction.UP);
        }
        else if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
            this.worm.setDirection(Direction.DOWN);
        }
        else if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
            this.worm.setDirection(Direction.LEFT);
        }
        else if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
            this.worm.setDirection(Direction.RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
