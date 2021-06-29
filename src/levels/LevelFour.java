package levels;

import collidables.Block;
import collidables.Velocity;
import shapes.Point;
import sprites.BackgroundFour;
import sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * LevelFour class.
 * Shir Zituni
 * 316537992
 */
public class LevelFour implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new ArrayList<>();
        Velocity v1 = Velocity.fromAngleAndSpeed(70, 7);
        Velocity v2 = Velocity.fromAngleAndSpeed(50, 6);
        Velocity v3 = Velocity.fromAngleAndSpeed(60, 8);

        l.add(v1);
        l.add(v2);
        l.add(v3);

        return l;
    }

    @Override
    public int paddleSpeed() {
        return 6;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Level 4";
    }

    @Override
    //new class that implement sprite and build the background
    public Sprite getBackground() {
        return new BackgroundFour();
    }

    @Override
    public List<Block> blocks() {
        List<Block> l = new ArrayList<>();
        //add the blocks to the list with their size, color and locations
        int numBlocks = 15;
        double x = 20, y = 80;
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
                shapes.Rectangle tempR = new shapes.Rectangle(new Point(x, y), 50.65, 28);
                Block tempB = new Block(tempR, arrC[i - 1]);
                l.add(tempB);
                x += 50.65;
            }
            y += 28;
            x = 20;
        }
        return l;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 5;
    }
}