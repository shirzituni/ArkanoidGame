package game;

import biuoop.DrawSurface;
import java.awt.Color;
/**
 * PauseScreen class.
 * Shir Zituni
 * 316537992
 */
public class PauseScreen implements Animation {
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);

    }
    @Override
    public boolean shouldStop() { return true; }
}