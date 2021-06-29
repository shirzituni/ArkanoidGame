package collidables;
import shapes.Point;

/**
 * collidables.Velocity class, specifies the change in position on the `x` and the `y` axes.
 * Shir Zituni
 * 316537992
 */

public class Velocity {
    private double dx;
    private double dy;
    /**.
     * Constructor
     * @param dx the dx value
     * @param dy the dy value
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    /**.
     * constructor, static method that create a new instances
     * @param angle the angle
     * @param speed the speed
     * @return the new collidables.Velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(angle);
        double dy = speed * Math.cos(angle);
        return new Velocity(dx, dy);
    }

    /**.
     * @return the dx value of this point
     */
    public double getDx() {
        return this.dx;
    }
    /**.
     * @return the dy value of this point
     */
    public double getDy() {
        return this.dy;
    }
    /**.
     * @param v the velocity
     */
    public void setVelocity(Velocity v) {
        this.dx = v.dx;
        this.dy = v.dy;
    }
    /**.
     * @param dX the dx velocity
     * @param dY the dy velocity
     */
    public void setVelocity(double dX , double dY) {
        this.dx = dX;
        this.dy = dY;
    }
    /**.
     *this method Take a point with position (x,y) and return a new point
     *with position (x+dx, y+dy)
     * @param p the point
     * @return a new shapes.Point with position (x+dx, y+dy)
     */
    public Point applyToPoint(Point p) {
        Point newPoint = new Point(p.getX() + dx, p.getY() + dy);
        return newPoint;
    }
}