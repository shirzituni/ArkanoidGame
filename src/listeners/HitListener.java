package listeners;
/**
 * HitListener class.
 * Shir Zituni
 * 316537992
 */
import collidables.Block;
import sprites.Ball;
/**
 * HitListener class.
 */
public interface HitListener {
    /**.
     * void method
     * This method is called whenever the beingHit object is hit.
     * @param beingHit is object that is being hit
     * @param hitter the Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}