package game;

import biuoop.DrawSurface;
import listeners.Counter;

import java.awt.Color;
/**
 * WinScreen class.
 * Shir Zituni
 * 316537992
 */
public class WinScreen implements Animation {
    private Counter scoreCounter;
    /**.
     * Constructor
     * @param sc is the scoreCounter
     */
    public WinScreen(Counter sc) {
        this.scoreCounter = sc;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.green);
        d.fillRectangle(0 , 0 , 800 , 600);
        //write the massage
        d.setColor(Color.black);
        d.drawText(180, d.getHeight() / 2, "You Win! Your score is " + scoreCounter.getValue() , 32);
    }
    @Override

    public boolean shouldStop() { return true; }
}

