package listeners;

/**
 * ScoreTrackingListener class.
 * Shir Zituni
 * 316537992
 */

import collidables.Block;
import sprites.Ball;

/**
 * ScoreTrackingListener class.
 */

public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    /**.
     * constructor
     * @param scoreCounter is the score Counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        //when the ball hit the block, the user gey 5 points
       this.currentScore.increase(5);
    }
}