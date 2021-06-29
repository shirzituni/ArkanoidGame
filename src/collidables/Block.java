package collidables;

import biuoop.DrawSurface;
import game.GameLevel;
import listeners.HitListener;
import listeners.HitNotifier;
import shapes.Point;
import shapes.Rectangle;
import sprites.Ball;
import sprites.Sprite;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

/**
 * collidables.Block class.
 * Shir Zituni
 * 316537992
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rect;
    private Color color = Color.black;
    private List<HitListener> hitListeners;

    /**.
     * constructor
     * @param r the rect
     * @param c the color
     */
    public Block(Rectangle r, Color c) {
        this.rect = r;
        this.color = c;
        this.hitListeners = new ArrayList<>();
    }
    /**.
     * constructor
     * @param r the rect
     */
    public Block(Rectangle r) {
        this.rect = r;
    }
    /**.
     * the method return the "collision shape" of the object.
     * @return the "collision shape" of the object
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**.
     * the method Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * @param collisionPoint is the collision shapes.Point
     * @param currentVelocity is the current collidables.Velocity
     * @param hitter is the Ball that hit
     * @return  the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //save the values in parameters
        Velocity newVel = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
        double collispointX = collisionPoint.getX();
        double collispointY = collisionPoint.getY();
        double xRect = this.rect.getUpperLeft().getX();
        double yRect = this.rect.getUpperLeft().getY();

        //check on which line of the rectangle the collisionPoint is
        //check x
        if (xRect + this.rect.getWidth() == collispointX || xRect == collispointX) {
            newVel.setVelocity(newVel.getDx() * -1, newVel.getDy());
        }
        //check y
        if ((yRect + this.rect.getHeight() == collispointY) || yRect == collispointY) {
            newVel.setVelocity(newVel.getDx(), newVel.getDy() * -1);
        }
        this.notifyHit(hitter);

        return newVel;
    }
    /**.
     * void method, draw the ball on the given DrawSurface
     * @param surface is the given DrawSurface
     */
    public void drawOn(DrawSurface surface) {
        //fill the rectangle with color
        surface.setColor(this.color);
        surface.fillRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY(), (int) rect.getWidth()
                , (int) rect.getHeight());
        //draw the rectangle
        surface.setColor(Color.black);
        surface.drawRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY(), (int) rect.getWidth()
                , (int) rect.getHeight());

    }
    /**.
     * void method, currently do nothing
     */
    // notify the sprite that time has passed
    public void timePassed() {
    }

    /**.
     * void method, adding the block to the game, calling the appropriate game methods
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**.
     * void method,remove block from spirit and Collidable
     * @param gameLevel the game
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    @Override
    public void addHitListener(final HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(final HitListener hl) {
        this.hitListeners.remove(hl);
    }
    /**.
     * void method,Notify all listeners about a hit event
     * @param hitter is the hitter ball
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
