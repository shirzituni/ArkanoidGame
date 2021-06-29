package shapes;

import java.util.Objects;

/**
 * shapes.Point class.
 * Shir Zituni
 * 316537992
 */
public class Point {
    private double x;
    private double y;

    /**
     * Construct a point with x and y coordinates.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Construct a point with x and y coordinates.
     *
     * @param p the point
     */
    public Point(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }
    /**.
     * return the distance of this point to the other point
     *
     * @param other is the other point
     * @return the distance to the other point
     */
    public double distance(Point other) {
        double dx = this.x - other.getX();
        double dy = this.y - other.getY();
        return Math.sqrt((dx * dx) + (dy * dy));
    }

    /**.
     * equals return true is the points are equal, false otherwise
     * @param other is the other point
     * @return true/false
     */
    public boolean equals(Point other) {
        return (this.x == other.getX() && this.y == other.getY());
    }
    /**.
     * to use equal method we should check the hashCode
     * @return hashCode
     */
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * @return the x value of this point
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return the y value of this point
     */
    public double getY() {
        return this.y;
    }
    /**
     * @param newX the x value of the point
     */
    public void setX(double newX) {
        this.x = newX;
    }

    /**
     * @param newY value of the point
     */
    public void setY(double newY) {
        this.y = newY;
    }

}
