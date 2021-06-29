package shapes;

import java.util.Objects;

/**
 * shapes.Line class.
 * Shir Zituni
 * 316537992
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * Constructors tow points end and last.
     *
     * @param start is the first point
     * @param end   is the last point
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Constructors for the values of the tow points.
     *
     * @param x1 is the x value of start point
     * @param y1 is the y value of end point
     * @param x2 is the x value of start point
     * @param y2 is the y value of end point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    /**.
     * Returns the start point of the line
     *
     * @return start point
     */
    //
    public Point start() {
        return this.start;
    }

    /**.
     * Returns true if the lines intersect, false otherwise
     *
     * @param other the other line
     * @return true / false
     */
    public boolean isIntersecting(Line other) {
        // t, u are parameters to help found if there is an intersection point
        double t = 0;
        double u = 0;
        // find the x, y values of all the points
        double x1 = this.start.getX();
        double y1 = this.start.getY();
        double x2 = this.end.getX();
        double y2 = this.end.getY();
        double x3 = other.start.getX();
        double y3 = other.start.getY();
        double x4 = other.end.getX();
        double y4 = other.end.getY();
        //save the divider in m
        double m = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (m == 0) {
            return false;
        }
        // calculate t, u according to a formula
        t = (((x1 - x3) * (y3 - y4)) - ((y1 - y3) * (x3 - x4))) / m;
        u = -(((x1 - x2) * (y1 - y3)) - ((y1 - y2) * (x1 - x3))) / m;
        // check if t, u are in a certain range, and the denominator is not 0
        return ((0.0 <= t) && (t <= 1.0) && (0.0 <= u) && (u <= 1.0));
    }

    /**
     * Returns the intersection point if the lines intersect, and null otherwise.
     *
     * @param other the other line
     * @return the intersection point
     */
    public Point intersectionWith(Line other) {
        // check if there is an intersection point
        if (!isIntersecting(other)) {
            return null;
        }
        // t is a parameter to help found the intersection point, px py are the intersection point's value
        double t, px, py;
        // find the x, y values of all the points
        double x1 = this.start.getX();
        double y1 = this.start.getY();
        double x2 = this.end.getX();
        double y2 = this.end.getY();
        double x3 = other.start.getX();
        double y3 = other.start.getY();
        double x4 = other.end.getX();
        double y4 = other.end.getY();
        // calculate t according to a formula
        double m = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        t = (((x1 - x3) * (y3 - y4)) - ((y1 - y3) * (x3 - x4))) / m;
        // calculate px, py according to a formula
        px = x1 + (t * (x2 - x1));
        py = y1 + (t * (y2 - y1));
        // build the intersection point and return it
        Point p = new Point(px, py);
        return p;
    }

    /**.
     * boolean equals - return true is the lines are equal, false otherwise
     * @param other the other line
     * @return boolean true / false
     */
    public boolean equals(Line other) {
        // check if both lines have exactly the same points
        return (this.end.getX() == other.end.getX() && this.end.getY() == other.end.getY()
                && this.start.getX() == other.start.getX() && this.start.getY() == other.start.getY());
    }
    /**.
     * to use equal method we should check the hashCode
     * @return hashCode
     */
    public int hashCode() {
        return Objects.hash(end.getX(), end.getY(), start.getX(), end.getY());
    }

    /**.
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     * @return the closest intersection point to the
     * @param rect the rectangle
     * start of the line / null
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //fine the intersect of the line with the rectangle
        java.util.List<Point> l = rect.intersectionPoints(new Line(this.start , this.end));
        //return null if there is no intersection
        if (l.isEmpty()) {
            return null;
        } else {
            //check hoe many intersection points
            int size = l.size();
            if (size == 1) {
                  return l.get(0);
            } else {
                double length1, length2;
                //return the closest
                length1 = this.start.distance(l.get(0));
                length2 = this.start.distance(l.get(1));
                if (length1 < length2) {
                    return l.get(0);
                } else {
                    return l.get(1);
                }
            }
        }
    }
}
