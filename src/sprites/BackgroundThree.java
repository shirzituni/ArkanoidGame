package sprites;

import biuoop.DrawSurface;

import java.awt.Color;
/**
 * BackgroundThree class.
 * Shir Zituni
 * 316537992
 */
public class BackgroundThree implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        // paint the background
        d.setColor(Color.MAGENTA);
        d.fillRectangle(0 , 0 , 800 , 600);

        //draw a flower
        d.setColor(Color.black);
        d.drawLine(100, 100, 100, 170);
        d.drawLine(150, 150, 100, 170);
        d.drawLine(50, 150, 100, 170);

        d.drawLine(130, 240, 100, 170);
        d.drawLine(70, 240, 100, 170);

        d.setColor(Color.white);
        d.fillCircle(100, 100, 30);

        d.setColor(Color.white);
        d.fillCircle(150, 150, 30);

        d.setColor(Color.white);
        d.fillCircle(50, 150, 30);

        d.setColor(Color.white);
        d.fillCircle(130, 210, 30);

        d.setColor(Color.white);
        d.fillCircle(70, 210, 30);

    }

    @Override
    public void timePassed() {

    }
}
