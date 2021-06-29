package game;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * AnimationRunner class.
 * Shir Zituni
 * 316537992
 */

public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    /**.
     * Constructor
     * @param g the GUI
     * @param fps is the framesPerSecond
     */
    public AnimationRunner(GUI g, int fps) {
        this.framesPerSecond = fps;
        this.gui = g;
    }

    /**.
     * void method, runs the animation
     * @param animation  is the animation
     */
    public void run(Animation animation) {
        Sleeper sleeper = new Sleeper();
        int millisecondsPerFrame = 1000 / framesPerSecond;
        //check if the animation should stop
        while (!animation.shouldStop())  {
            // timing
            long startTime = System.currentTimeMillis();

            DrawSurface d = this.gui.getDrawSurface();
            //run one frame
            animation.doOneFrame(d);

            this.gui.show(d);

            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }

        }
    }
    /**.
     * get method
     * @return the gui
     */
    public GUI getGui() {
        return this.gui;
    }
}