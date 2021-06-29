package game;

import levels.LevelInformation;
import biuoop.KeyboardSensor;
import listeners.Counter;

import java.util.List;
/**
 * GameFlow class.
 * Shir Zituni
 * 316537992
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    /**.
     * Constructor
     * @param ar the animationRunner
     * @param ks the keyboardSensor
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
    }
    /**.
     * runLevels
     * @param levels is the list of the levels it should run
     */
    public void runLevels(List<LevelInformation> levels) {
        Counter scoreCounter = new Counter(0);

        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, keyboardSensor, animationRunner, scoreCounter);
            level.initialize();
            level.run();
//check if there are no more balls
            if (level.getBallsCounter().getValue() == 0) {
                this.animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY,
                        new EndScreen(level.getScoresCounter())));
                break;
            }
//check if the user won the last level
            if (levels.get(levels.size() - 1).equals(levelInfo)) {
                this.animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY,
                        new WinScreen(level.getScoresCounter())));
                break;
            }

        }
        this.animationRunner.getGui().close();
    }
}