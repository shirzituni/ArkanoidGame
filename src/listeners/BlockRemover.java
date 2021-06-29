package listeners;
/**
 * BlockRemover class.
 * Shir Zituni
 * 316537992
 */
import collidables.Block;
import game.GameLevel;
import sprites.Ball;
/**
 * BallRemover class.
 *  a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;
    /**.
     * constructor
     * @param g is the game
     * @param removedBlocks is the Counter
     */
    public BlockRemover(GameLevel g, Counter removedBlocks) {
        this.gameLevel = g;
        this.remainingBlocks = removedBlocks;

    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        // Blocks that are hit should be removed from the game.
        beingHit.removeFromGame(this.gameLevel);
        //remove the listener from the block that is being removed from the game.
        beingHit.removeHitListener(this);
        //less 1 block
        remainingBlocks.decrease(1);

    }
}