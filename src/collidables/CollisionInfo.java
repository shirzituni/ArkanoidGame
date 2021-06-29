package collidables;

import shapes.Point;

/**
 * collidables.CollisionInfo class.
 * Shir Zituni
 * 316537992
 */
public class CollisionInfo {
    //collision point
    private Point c;
    //the collidables.Collidable that was hit
    private Collidable collisionObject;
    /**.
     *constructor
     * @param p the collision point
     * @param o the collidables.Collidable that was hit
     */
    public CollisionInfo(Point p, Collidable o) {
        this.c = p;
        this.collisionObject = o;
    }
    /**.
     * @return the point at which the collision occurs
     */
    //
    public Point collisionPoint() {
        return this.c;
    }
    /**.
     * @return the collidable object involved in the collision
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }

}