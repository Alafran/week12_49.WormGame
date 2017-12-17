package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;
    private Random random;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;
        this.random = new Random();
        this.worm = new Worm(this.width / 2, this.height / 2, Direction.DOWN);
        Apple appleToBeSet = new Apple(this.random.nextInt(this.width), this.random.nextInt(this.height));
        while (true) {
            if (!this.worm.runsInto(appleToBeSet)) {
                this.apple = appleToBeSet;
                break;
            }
            else {
                appleToBeSet = new Apple(this.random.nextInt(this.width), this.random.nextInt(this.height));
            }
        }
        
        addActionListener(this);
        setInitialDelay(2000);

    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }
        this.worm.move();
        
        if (this.worm.runsInto(this.apple)) {
            this.worm.grow();
            setApple(new Apple(this.random.nextInt(this.width), this.random.nextInt(this.height)));
        }
        if (this.worm.runsIntoItself()) {
            this.continues = false;
        }
        this.updatable.update();
        super.setDelay(1000 / this.worm.getLength());

        if (this.worm.getPieces().get(this.worm.getLength() - 1).getX() >= this.width
                || this.worm.getPieces().get(this.worm.getLength() - 1).getX() < 0) {
            this.continues = false;
        }
        if (this.worm.getPieces().get(this.worm.getLength() - 1).getY() >= this.height
                || this.worm.getPieces().get(this.worm.getLength() - 1).getY() < 0) {
            this.continues = false;
        }
    }

    public Worm getWorm() {
        return this.worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Apple getApple() {
        return this.apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

}
