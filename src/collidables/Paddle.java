package collidables;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import game.GameLevel;
import shapes.Point;
import shapes.Rectangle;
import sprites.Ball;
import sprites.Sprite;
import java.awt.Color;

/**
 * collidables.Paddle class.
 * Shir Zituni
 * 316537992
 */
public class Paddle implements Sprite, Collidable {

    private shapes.Rectangle rect;
    private biuoop.KeyboardSensor keyboard;
    private Color color;
    private int paddleSpeed;
    /**
     * Constructor.
     *
     * @param r the rect
     * @param key the KeyboardSensor
     * @param c the color
     * @param speed1 is the paddle's speed
     */
    public Paddle(shapes.Rectangle r , biuoop.KeyboardSensor key, Color c, int speed1) {
        this.rect = r;
        this.keyboard = key;
        this.color = c;
        this.paddleSpeed = speed1;
    }
    /**.
     * void method, make the paddle move left
     */
    public void moveLeft() {
        //check the KeyboardSensor and the borders of the screen
        if ((keyboard.isPressed(KeyboardSensor.LEFT_KEY)) && this.getCollisionRectangle().getUpperLeft().getX() > 21) {
            this.rect.setX(this.rect.getUpperLeft().getX() - paddleSpeed);
        }
    }
    /**.
     * void method, make the paddle move right
     */
    public void moveRight() {
        //check the KeyboardSensor and the borders of the screen
        if ((keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) && (this.getCollisionRectangle().getUpperLeft().getX()
                + this.getCollisionRectangle().getWidth()) < 779) {
            this.rect.setX(this.rect.getUpperLeft().getX() + paddleSpeed);
        }
    }
    /**.
     * void method, currently do nothing
     */
    public void timePassed() {
    }
    /**.
     * void method draw the paddle and check if it moves
     * @param d the Surface
     */
    public void drawOn(DrawSurface d) {
        //fill the rectangle with color
        d.setColor(this.color);
        d.fillRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY(), (int) rect.getWidth()
                , (int) rect.getHeight());
        //draw the rectangle
        d.setColor(Color.black);
        d.drawRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY()
                , (int) rect.getWidth() , (int) rect.getHeight());
        //check if ot moves
        moveLeft();
        moveRight();


    }
    /**.
     * get method
     * @return the Collision rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }
    /**.
     * @param collisionPoint the collisionPoint with the paddle
     * @param currentVelocity the currentVelocity of the ball
     * @param hitter is the Ball that hit
     * @return the new velocity
     */
    public Velocity hit(Ball hitter, shapes.Point collisionPoint, Velocity currentVelocity) {
        //save the values in parameters
        Velocity newVel = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
        double collispointX = collisionPoint.getX();
        double collispointY = collisionPoint.getY();
        double xRect = this.rect.getUpperLeft().getX();
        double yRect = this.rect.getUpperLeft().getY();
        //divide the paddle to 5
        double fifth = this.rect.getWidth() / 5;
        Point a1 = new shapes.Point(xRect + fifth, yRect);
        shapes.Point a2 = new shapes.Point(xRect + 2 * fifth, yRect);
        shapes.Point a3 = new shapes.Point(xRect + 3 * fifth, yRect);
        shapes.Point a4 = new shapes.Point(xRect + 4 * fifth, yRect);
        shapes.Point a5 = new shapes.Point(xRect + 5 * fifth, yRect);

        //check on which line of the rectangle the collisionPoint is
        //calculate the speed according to Pitagoras
        double speed = Math.sqrt(Math.pow(newVel.getDx() , 2) + Math.pow(newVel.getDy() , 2));
        //check y
        if (yRect + this.rect.getHeight() == collispointY || yRect == collispointY) {
            newVel.setVelocity(newVel.getDx() , newVel.getDy() * -1);
        }
        //check X, chang angle and speed accordingly
        if (xRect + this.rect.getWidth() == collispointX || xRect == collispointX) {
            if (collispointX < a1.getX()) {
                newVel.fromAngleAndSpeed(300, speed);
            }
            if (collispointX > a1.getX() && collispointX < a2.getX()) {
                newVel.fromAngleAndSpeed(330, speed);
            }
            if (collispointX > a2.getX() && collispointX < a3.getX()) {
                //same as collidables.Block hit
                newVel.setVelocity(newVel.getDx() * -1, newVel.getDy());
            }
            if (collispointX > a3.getX() && collispointX < a4.getX()) {
                newVel.fromAngleAndSpeed(30, speed);
            }
            if (collispointX > a4.getX() && collispointX < a5.getX()) {
                newVel.fromAngleAndSpeed(60, speed);
            }
        }
        return newVel;
    }
    /**.
     * void method add the paddle to the game
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}