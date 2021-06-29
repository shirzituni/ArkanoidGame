package levels;

import collidables.Block;
import collidables.Velocity;
import shapes.Point;
import sprites.BackgroundThree;
import sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * LevelThree class.
 * Shir Zituni
 * 316537992
 */
public class LevelThree implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new ArrayList<>();
        Velocity v1 = Velocity.fromAngleAndSpeed(70, 7);
        Velocity v2 = Velocity.fromAngleAndSpeed(50, 7);
        l.add(v1);
        l.add(v2);
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
        return "Level 3";
    }

    @Override
    //new class that implement sprite and build the background
    public Sprite getBackground() {
        return new BackgroundThree();
    }

    @Override
    public List<Block> blocks() {
        List<Block> l = new ArrayList<>();
        //add the blocks to the list with their size, color and locations
        int numBlocks = 10;
        double x = 180, y = 100;
        //array of colors
        Color[] arrC = new Color[5];
        arrC[0] = Color.GRAY;
        arrC[1] = Color.red;
        arrC[2] = Color.yellow;
        arrC[3] = Color.BLUE;
        arrC[4] = Color.white;

        //add blocks according to the pattern
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < numBlocks; j++) {
                shapes.Rectangle tempR = new shapes.Rectangle(new Point(x, y), 60, 25);
                Block tempB = new Block(tempR, arrC[i - 1]);
                l.add(tempB);
                x += 60;
            }
            y += 25;
            x = 180 + i * 60;
            numBlocks--;
        }
        return l;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 5;
    }
}
