package sprites;
/**
 * sprites.Ball class.
 * Shir Zituni
 * 316537992
 */

import biuoop.DrawSurface;
import collidables.CollisionInfo;
import collidables.Velocity;
import game.GameLevel;
import game.GameEnvironment;
import shapes.Line;
import shapes.Point;

import java.awt.Color;

/**
 * sprites.Ball class.
 */
public class Ball implements Sprite {
    private java.awt.Color color;
    private int r;
    private Point p;
    private Velocity v;
    private GameEnvironment game;

    /**.
     * Construct a ball with point, size and color
     * @param center the center point of the ball
     * @param r      the radius (size) of the ball
     * @param color  the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.p = center;
        this.r = r;
        this.color = color;
    }
    /**.
     * Construct a ball with point, size, color and game.GameEnvironment
     * @param center the center point of the ball
     * @param r      the radius (size) of the ball
     * @param color  the color of the ball.
     * @param g game.GameEnvironment of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment g) {
        this.p = center;
        this.r = r;
        this.color = color;
        this.game = g;
    }

    /**.
     * Construct a ball with point, size and color
     *
     * @param x     the x value of the point
     * @param y     the y value of the point
     * @param r     the radius (size) of the ball
     * @param color the color of the ball
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.p = new Point(x, y);
        this.r = r;
        this.color = color;
    }

    // accessors

    /**
     * @return the x value of the center point
     */
    public int getX() {
        return (int) this.p.getX();
    }

    /**
     * @return the y value of the center point
     */
    public int getY() {
        return (int) this.p.getY();
    }

    /**
     * @return the size of the ball (the radius)
     */
    public int getSize() {
        return this.r;
    }

    /**
     * @return the color of the ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**.
     * void method, draw the ball on the given DrawSurface
     *
     * @param surface is the given DrawSurface
     */
    public void drawOn(DrawSurface surface) {
        //fill the ball with color
        surface.setColor(this.getColor());
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
        //draw the ball
        surface.setColor(Color.black);
        surface.drawCircle(this.getX(), this.getY(), this.getSize());
    }
    /**.
     * void method, set the collidables.Velocity value
     *
     * @param newV collidables.Velocity argument
     */
    public void setVelocity(Velocity newV) {
        this.v = newV;
    }
    /**.
     * void method, set the collidables.Velocity values dx, dy
     *
     * @param dx collidables.Velocity dx argument
     * @param dy collidables.Velocity dy argument
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * @return the velocity
     */
    public Velocity getVelocity() {
        return this.v;
    }
    /**.
     * void method, check if there is a collision and move the ball one step accordingly
     *
     */
    public void moveOneStep() {
        //creating the trajectory
        Line trajectory = new Line(this.p, new Point(this.getVelocity().applyToPoint(this.p)));
        CollisionInfo collisionInfo = this.game.getClosestCollision(trajectory);
        //check if there isn't a collision, then change the center point
        if (collisionInfo == null) {
            this.p = new Point(this.getVelocity().applyToPoint(this.p));
        } else {
            //check if there is a collision, then change the center point and use the hit method

            Velocity vel = collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint() , this.v);
            this.v = vel;
            this.p = this.getVelocity().applyToPoint(this.p);
        }
    }
        /**.
         * set method
         * @param g the GameEnviroment
         */
    public void setGameEnviroment(GameEnvironment g) {
        this.game = g;
    }
    /**.
     * get method
     * @return the GameEnviroment
     */
    public GameEnvironment getGameEnvironment() {
        return this.game;
    }
    /**.
     * void method, set GameEnviroment
     * @param g the GameEnviroment
     */
    public void setGameEnvironment(GameEnvironment g) {
        this.game = g;
    }
    /**.
     * void method, notify the sprite that time has passed
     */
    public void timePassed() {
        this.moveOneStep();
    }
    /**.
     * void method, This method will add the ball to the game.
     * @param g the game.Game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
    /**.
     * void method, This method will remove the ball to the game.
     * @param g the game.Game
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}