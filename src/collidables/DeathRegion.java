package collidables;

import game.GameLevel;
import listeners.BallRemover;
import shapes.Rectangle;
import java.awt.Color;

/**
 * DeathRegion class.
 * Shir Zituni
 * 316537992
 */

public class DeathRegion extends Block {

    /**.
     * constructor
     * @param r the rect
     * @param c the color
     * @param ballRemover the hit listener
     */

    public DeathRegion(Rectangle r, Color c, BallRemover ballRemover) {
        super(r, c);
        this.addHitListener(ballRemover);
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
    }

    @Override
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
    }
}
