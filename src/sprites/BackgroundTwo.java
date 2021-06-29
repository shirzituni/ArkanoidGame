package sprites;

import biuoop.DrawSurface;

import java.awt.Color;
/**
 * BackgroundTwo class.
 * Shir Zituni
 * 316537992
 */
public class BackgroundTwo implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        // paint the background
        d.setColor(Color.WHITE);
        d.fillRectangle(0 , 0 , 800 , 600);

        //lines
        d.setColor(Color.yellow);
        d.drawLine(100, 100, 300, 480);
        d.drawLine(100, 100, 280, 480);
        d.drawLine(100, 100, 260, 480);
        d.drawLine(100, 100, 240, 480);
        d.drawLine(100, 100, 220, 480);
        d.drawLine(100, 100, 200, 480);
        d.drawLine(100, 100, 180, 480);
        d.drawLine(100, 100, 160, 480);
        d.drawLine(100, 100, 140, 480);
        d.drawLine(100, 100, 120, 480);
        d.drawLine(100, 100, 100, 480);
        d.drawLine(100, 100, 80, 480);

        // sun
        d.setColor(Color.ORANGE);
        d.fillCircle(100, 100, 50);
        d.setColor(Color.yellow);
        d.fillCircle(100, 100, 40);
        d.setColor(Color.orange);
        d.fillCircle(100, 100, 30);

    }

    @Override
    public void timePassed() {

    }
}
