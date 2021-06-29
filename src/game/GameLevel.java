package game;

import levels.LevelInformation;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import collidables.Block;
import collidables.Collidable;
import collidables.DeathRegion;
import collidables.Paddle;
import listeners.Counter;
import listeners.ScoreTrackingListener;
import listeners.BallRemover;
import listeners.BlockRemover;
import shapes.Rectangle;
import sprites.Ball;
import sprites.ScoreIndicator;
import sprites.Sprite;
import sprites.SpriteCollection;

import java.awt.Color;

/**
 * GameLevel class.
 * Shir Zituni
 * 316537992
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI g;

    private Counter blockCounter;
    private Counter ballCounter;
    private Counter scoresCounter;

    private AnimationRunner runner;
    private boolean running;

    private biuoop.KeyboardSensor keyboardSn;
    private LevelInformation levelInformation;


    /**.
     * constructor
     * @param levelInformation1 is the levelInformation
     * @param ks is the KeyboardSensor
     * @param ar is the AnimationRunner
     * @param sc is the score counter
     */
    public GameLevel(LevelInformation levelInformation1, KeyboardSensor ks, AnimationRunner ar, Counter sc) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.g = ar.getGui();
        this.ballCounter = new Counter(0);
        this.blockCounter = new Counter(0);
        this.scoresCounter = sc;
        this.runner = ar;
        this.running = true;
        this.keyboardSn = ks;
        this.levelInformation = levelInformation1;
    }
    /**.
     * void method, add the collidables.Collidable to the environment
     * @param c is the collidables.Collidable object
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }
    /**.
     * void method, add the sprites.Sprite to the sprites
     * @param s the sprites.Sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);

    }
    /**.
     * void method, add the sprites.Sprite to the sprites
     * Initialize a new game: create the Blocks, sprites.Ball, and collidables.Paddle
     * and add them to the game
     */
    public void initialize() {
        //creating the balls, add it to the game
        for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            Ball ball = new Ball(new shapes.Point(420 , 400) , 7 , Color.WHITE , this.environment);
            ball.setVelocity(levelInformation.initialBallVelocities().get(i));
            ball.addToGame(this);
        }

        //creating a balls counter
        this.ballCounter = new Counter(this.levelInformation.numberOfBalls());
        BallRemover ballRemover = new BallRemover(this, ballCounter);

        //creating the Score Indicator
        shapes.Rectangle r = new shapes.Rectangle(new shapes.Point(0, 0), 800, 20);
        ScoreIndicator scoreIndicator = new ScoreIndicator(Color.black, r, scoresCounter, ballCounter,
                this.levelInformation.levelName());
        scoreIndicator.addToGame(this);

        //creating the blocks around the screen

        //left block
        shapes.Rectangle r1 = new shapes.Rectangle(new shapes.Point(0, 20), 20, 600);
        Block b1 = new Block(r1 , Color.GRAY);
        //right block
        shapes.Rectangle r2 = new shapes.Rectangle(new shapes.Point(780, 20), 20, 600);
        Block b2 = new Block(r2 , Color.GRAY);
        //upper Block
        Rectangle r3 = new shapes.Rectangle(new shapes.Point(0, 20), 800, 20);
        Block b3 = new Block(r3 , Color.GRAY);
        //bottom Block
        shapes.Rectangle r4 = new shapes.Rectangle(new shapes.Point(0 , 599) , 800 , 1);
        DeathRegion b4 = new DeathRegion(r4, Color.GRAY, ballRemover);


        //add it yo the game
        b1.addToGame(this);
        b2.addToGame(this);
        b3.addToGame(this);
        b4.addToGame(this);

        //creating the paddle with the KeyboardSensor, add it yo the game
        biuoop.KeyboardSensor keyboard = this.g.getKeyboardSensor();
        shapes.Rectangle pR = new shapes.Rectangle(new shapes.Point(400 - this.levelInformation.paddleWidth() / 2 ,
                552) ,
                this.levelInformation.paddleWidth() , 28);
        Paddle p = new Paddle(pR , keyboard , Color.orange , this.levelInformation.paddleSpeed());
        p.addToGame(this);

        //the number of the blocks
        int numBlocks = this.levelInformation.blocks().size();

        BlockRemover blockRemover = new BlockRemover(this , blockCounter);
        //add blocks according to the pattern
            for (int j = 0; j < numBlocks; j++) {
                Block tempB = this.levelInformation.blocks().get(j);
                tempB.addHitListener(blockRemover);

                ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.scoresCounter);
                tempB.addHitListener(scoreTrackingListener);

                blockCounter.increase(1);

                tempB.addToGame(this);

        }

    }

    /**.
     * void method
     * Remove the Collidable .
     * @param c a Collidable
     */
    public void removeCollidable(Collidable c) {
        this.environment.getCollidables().remove(c);
    }
    /**.
     * void method
     * Remove the Sprite .
     * @param s a Sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }
    /**.
     * boolean method
     * @return if the game should stop
     */
    public boolean shouldStop() {
        return !this.running;
    }
    /**.
     * void method
     * @param d is the DrawSurface
     * the logic from the previous run method goes here.
     * the `return` or `break` statements should be replaced with
     * this.running = false;
     */
    public void doOneFrame(DrawSurface d) {
        //when we identify the key p being pressed, we start running the PauseScreen animation instead of the Game one.
        // The Game animation will resume as soon as we will return from the PauseScreen animation.

        this.levelInformation.getBackground().drawOn(d);

        if (this.keyboardSn.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboardSn, KeyboardSensor.SPACE_KEY ,
                    new PauseScreen()));
        }

        //if the user hit all the Blocks To Remove, the user get 100 scores
        if (this.levelInformation.blocks().size() - this.levelInformation.numberOfBlocksToRemove()
                == blockCounter.getValue()) {
            this.scoresCounter.increase(100);
            //System.out.println(this.scoresCounter.getValue());
        }
        //if the user hit all the Blocks To Remove, or there are no balls left, the game ends
        if (ballCounter.getValue() == 0 || this.levelInformation.blocks().size()
                - this.levelInformation.numberOfBlocksToRemove() == blockCounter.getValue()) {
            this.running = false;
          //  this.g.close();
        }

        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

    }
    /**.
     * run
     * void method
     */
    public void run() {
        // countdown before turn starts.
        //this.runner.run(new CountdownAnimation(3, 3, sprites));

        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }
    /**.
     * get method
     * @return the balls counter
     */
    public Counter getBallsCounter() {
        return this.ballCounter;
    }
    /**.
     * get method
     * @return the scores counter
     */
    public Counter getScoresCounter() {
        return this.scoresCounter;
    }
}