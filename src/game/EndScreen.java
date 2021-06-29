package game;

import biuoop.DrawSurface;
import listeners.Counter;
import java.awt.Color;

/**
 * EndScreen class.
 * Shir Zituni
 * 316537992
 */

public class EndScreen implements Animation {
    private Counter scoreCounter;
    /**.
     * Constructor
     * @param sc  is the score counter
     */
    public EndScreen(Counter sc) {
        this.scoreCounter = sc;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.red);
        d.fillRectangle(0 , 0 , 800 , 600);

        d.setColor(Color.black);
        d.drawText(180, d.getHeight() / 2, "Game Over. Your score is " + scoreCounter.getValue() , 32);
    }
    @Override
    public boolean shouldStop() { return true; }
}
