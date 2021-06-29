package levels;

import collidables.Block;
import collidables.Velocity;
import shapes.Point;
import sprites.BackgroundTwo;
import sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * LevelTwo class.
 * Shir Zituni
 * 316537992
 */
public class LevelTwo implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new ArrayList<>();
        Velocity v1 = Velocity.fromAngleAndSpeed(60, 7);
        Velocity v2 = Velocity.fromAngleAndSpeed(60, 6);
        Velocity v3 = Velocity.fromAngleAndSpeed(50, 5);
        Velocity v4 = Velocity.fromAngleAndSpeed(65, 7);
        Velocity v5 = Velocity.fromAngleAndSpeed(60, 5);
        Velocity v6 = Velocity.fromAngleAndSpeed(65, 5);
        Velocity v7 = Velocity.fromAngleAndSpeed(45, 7);
        Velocity v8 = Velocity.fromAngleAndSpeed(65, 6);
        Velocity v9 = Velocity.fromAngleAndSpeed(50, 8);
        Velocity v10 = Velocity.fromAngleAndSpeed(60, 8);


        l.add(v1);
        l.add(v2);
        l.add(v3);
        l.add(v4);
        l.add(v5);
        l.add(v6);
        l.add(v7);
        l.add(v8);
        l.add(v9);
        l.add(v10);

        return l;
    }

    @Override
    public int paddleSpeed() {
        return 3;
    }

    @Override
    public int paddleWidth() {
        return 600;
    }

    @Override
    public String levelName() {
        return "Level 2";
    }

    @Override
    //new class that implement sprite and build the background
    public Sprite getBackground() {
        return new BackgroundTwo();
    }

    @Override
    public List<Block> blocks() {
        List<Block> l = new ArrayList<>();
        //add the blocks to the list with their size, color and locations
        int numBlocks = 15;
        double x = 20, y = 170;
        //array of colors
        Color[] arrC = new Color[15];
        arrC[0] = Color.red;
        arrC[1] = Color.red;
        arrC[2] = Color.ORANGE;
        arrC[3] = Color.ORANGE;
        arrC[4] = Color.yellow;
        arrC[5] = Color.yellow;
        arrC[6] = Color.GREEN;
        arrC[7] = Color.GREEN;
        arrC[8] = Color.GREEN;
        arrC[9] = Color.BLUE;
        arrC[10] = Color.BLUE;
        arrC[11] = Color.PINK;
        arrC[12] = Color.PINK;
        arrC[13] = Color.CYAN;
        arrC[14] = Color.CYAN;
        //add blocks according to the pattern
            for (int j = 0; j < numBlocks; j++) {
                shapes.Rectangle tempR = new shapes.Rectangle(new Point(x, y), 50.65, 28);
                Block tempB = new Block(tempR, arrC[j]);
                l.add(tempB);
                x += 50.65;
            }

        return l;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
