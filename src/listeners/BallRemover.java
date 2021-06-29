package listeners;
/**
 * BallRemover class.
 * Shir Zituni
 * 316537992
 */
import collidables.Block;
import game.GameLevel;
import sprites.Ball;
/**
 * BallRemover class.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;
    /**.
     * constructor
     * @param g is the game
     * @param removedBlocks is the Counter
     */
    public BallRemover(GameLevel g, Counter removedBlocks) {
        this.gameLevel = g;
        this.remainingBalls = removedBlocks;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);

        remainingBalls.decrease(1);
    }
}
