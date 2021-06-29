package shapes; /**
 * shapes.Rectangle class.
 * Shir Zituni
 * 316537992
 */

import java.util.LinkedList;

/**
 * Rectangle class.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * .
     * Create a new rectangle with location and width/height.
     *
     * @param upLeft  the up left point of the shapes.Rectangle
     * @param rWidth  the shapes.Rectangle's width
     * @param rHeight the shapes.Rectangle's height
     */
    public Rectangle(Point upLeft, double rWidth, double rHeight) {
        this.upperLeft = upLeft;
        this.height = rHeight;
        this.width = rWidth;
    }

    /**.
     * Return a (possibly empty) List of intersection points
     * with the specified line.
     *
     * @param line the specified line
     * @return List of intersection points
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        LinkedList<Point> l = new LinkedList<>();
        //check the line between upperLeft, upperRight
        Point start1 = upperLeft;
        Point end1 = new Point(upperLeft.getX() + width, upperLeft.getY());
        if (line.isIntersecting(new Line(start1 , end1))) {
            l.add(line.intersectionWith(new Line(start1, end1)));
        }
        //check the line between downLeft, downRight
        Point start2 = new Point(upperLeft.getX(), upperLeft.getY() + height);
        Point end2 = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        if (line.isIntersecting(new Line(start2 , end2))) {
            l.add(line.intersectionWith(new Line(start2, end2)));
        }
        //check the line between upperLeft, downLeft
        Point start3 = upperLeft;
        Point end3 = new Point(upperLeft.getX() , upperLeft.getY() + height);
        if (line.isIntersecting(new Line(start3 , end3))) {
            l.add(line.intersectionWith(new Line(start3, end3)));
        }
        //check the line between upperRight, downRight
        Point start4 = new Point(upperLeft.getX() + width, upperLeft.getY());
        Point end4 = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        if (line.isIntersecting(new Line(start4 , end4))) {
            l.add(line.intersectionWith(new Line(start4 , end4)));
        }
        return l;
    }

    /**.
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**.
     * @return the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**.
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
    /**.
     * void method set
     * @param x upperLeft x
     */
    public void setX(double x) {
        this.upperLeft.setX(x);
    }
    /**.
     * void method set
     * @param y upperLeft y
     */
    public void setY(double y) {
        this.upperLeft.setY(y);
    }
}
