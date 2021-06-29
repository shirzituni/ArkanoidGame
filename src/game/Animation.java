package game;
import biuoop.DrawSurface;
/**
 * Animation interface.
 * Shir Zituni
 * 316537992
 */
public interface Animation {
    /**.
     * doOneFrame - making on frame on the DrawSurface
     * @param d the DrawSurface
     */
    void doOneFrame(DrawSurface d);
    /**.
     * give back the answer - the animation should stop?
     * @return boolean
     */
    boolean shouldStop();
}