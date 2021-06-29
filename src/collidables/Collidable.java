package collidables;
import shapes.Rectangle;
import shapes.Point;
import sprites.Ball;

/**.
 * interface collidables.Collidable
 * Shir Zituni
 * 316537992
 */

public interface Collidable {
    /**.
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();
    /**.
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * @return The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us)
     * @param collisionPoint the collisionPoint
     * @param currentVelocity the currentVelocity
     * @param hitter is the Ball that hit
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}