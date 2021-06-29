package levels;

import collidables.Block;
import collidables.Velocity;
import shapes.Point;
import sprites.BackgroundOne;
import sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * LevelOne class.
 * Shir Zituni
 * 316537992
 */
public class LevelOne implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new ArrayList<>();
        Velocity v1 = Velocity.fromAngleAndSpeed(330, 8);
        l.add(v1);
        return l;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Level 1";
    }

    @Override
    //new class that implement sprite and build the background
    public Sprite getBackground() {
        return new BackgroundOne();
    }

    @Override
    public List<Block> blocks() {
        List<Block> l = new ArrayList<>();
        shapes.Rectangle r = new shapes.Rectangle(new Point(380, 200), 28, 28);
                Block b = new Block(r, Color.red);
                l.add(b);
        return l;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}