package sprites;
/**
 * sprites.ScoreIndicator class.
 * Shir Zituni
 * 316537992
 */
import biuoop.DrawSurface;
import game.GameLevel;
import listeners.Counter;
import shapes.Rectangle;
import java.awt.Color;

/**
 * sprites.ScoreIndicator class.
 */

public class ScoreIndicator implements Sprite {
    private Rectangle rect;
    private Color color;
    private Counter scoresCounter;
    private Counter ballsCounter;
    private String levelName;
    /**.
     * Constructor
     * @param c the color of the Rectangle
     * @param r the Rectangle
     * @param scores  the scores counter.
     * @param ballsCounter1 the balls counter
     * @param name the scores counter.
     */
    public ScoreIndicator(Color c, Rectangle r, Counter scores, Counter ballsCounter1, String name) {
        this.rect = r;
        this.color = c;
        this.scoresCounter = scores;
        this.ballsCounter = ballsCounter1;
        this.levelName = name;
    }
    @Override
    public void drawOn(DrawSurface d) {
        //fill the rectangle with color
        d.setColor(this.color);
        d.fillRectangle(0, 0, 800, 20);
        //draw the rectangle
        d.setColor(Color.white);
        d.drawRectangle(0, 0, 800, 20);
        //write on the rectangle
        d.drawText(300, 18, "Score:" + this.scoresCounter.getValue() , 20);

        d.setColor(Color.white);
        //write on the rectangle
        d.drawText(150, 18, "Balls:" + this.ballsCounter.getValue() , 20);

        d.setColor(Color.white);
        //write on the rectangle
        d.drawText(450, 18, "Level Name:" + this.levelName , 20);

    }
    /**.
     * void method, adding the block to the game, calling the appropriate game methods
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public void timePassed() {

    }
}
