package sprites;

import biuoop.DrawSurface;

import java.awt.Color;
/**
 * BackgroundOne class.
 * Shir Zituni
 * 316537992
 */
public class BackgroundOne implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        // paint the background
        d.setColor(Color.black);
        d.fillRectangle(0 , 0 , 800 , 600);

        // draw the circles
        d.setColor(Color.blue);
        d.drawCircle(395, 210, 50);
        d.drawCircle(395, 210, 100);
        d.drawCircle(395, 210, 150);
        d.drawLine(260, 110, 530, 310);
        d.drawLine(260, 310, 530, 110);

    }

    @Override
    public void timePassed() {

    }
}

