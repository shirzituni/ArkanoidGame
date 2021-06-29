package sprites;

import biuoop.DrawSurface;

import java.awt.Color;
/**
 * BackgroundFour class.
 * Shir Zituni
 * 316537992
 */
public class BackgroundFour implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        // paint the background
        d.setColor(Color.cyan);
        d.fillRectangle(0 , 0 , 800 , 600);

        d.setColor(Color.white);
        //left
        d.drawLine(100, 310, 380, 480);
        d.drawLine(100, 310, 360, 480);
        d.drawLine(100, 310, 340, 480);

        //right
        d.drawLine(400, 500, 680, 310);
        d.drawLine(410, 500, 680, 310);
        d.drawLine(420, 500, 680, 310);

        //draw the left clouds
        d.setColor(Color.darkGray);
        d.fillCircle(130, 270, 30);

        d.setColor(Color.gray);
        d.fillCircle(90, 340, 40);
        d.setColor(Color.gray);
        d.fillCircle(160, 340, 40);

        d.setColor(Color.lightGray);
        d.fillCircle(150, 300, 35);
        d.setColor(Color.lightGray);
        d.fillCircle(110, 300, 35);

        //draw the right clouds
        d.setColor(Color.darkGray);
        d.fillCircle(630, 270, 30);

        d.setColor(Color.gray);
        d.fillCircle(590, 340, 40);
        d.setColor(Color.gray);
        d.fillCircle(660, 340, 40);

        d.setColor(Color.lightGray);
        d.fillCircle(650, 300, 35);
        d.setColor(Color.lightGray);
        d.fillCircle(610, 300, 35);
    }

    @Override
    public void timePassed() {

    }
}
