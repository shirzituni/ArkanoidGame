package game;

import collidables.Collidable;
import collidables.CollisionInfo;
import shapes.Line;
import shapes.Point;

import java.util.ArrayList;
import java.util.List;


/**
 * game.GameEnvironment class.
 * Shir Zituni
 * 316537992
 */
public class GameEnvironment {
    private List<Collidable> collidables;
    /**.
     * constructor
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }

    /**.
     * void method, add the given collidable to the environment.
     * @param c the given collidable
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }
    /**.
     * the methodAssume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur
     * @param trajectory the methodAssume an object moving from line.start() to line.end()
     * @return the information about the closest collision that is going to occur
     */
    // .
    public CollisionInfo getClosestCollision(Line trajectory) {
        //initialize the length and collisionInfo
        double length = 10000000;
        CollisionInfo collisionInfo = null;
        for (Collidable c : collidables) {
            //search for intersection point
            Point p = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (p != null) {
                //check which point is closer
                if (p.distance(trajectory.start()) < length) {
                    length = p.distance(trajectory.start());
                    collisionInfo = new CollisionInfo(p , c);
                }
            }
        }
        return collisionInfo;
    }
    /**.
     * getCollidables
     * @return List<collidables.Collidable> collidables
     */
    public List<Collidable> getCollidables() {
        return this.collidables;
    }
}