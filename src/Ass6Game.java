import levels.LevelFour;
import levels.LevelOne;
import levels.LevelTwo;
import levels.LevelThree;
import levels.LevelInformation;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import game.AnimationRunner;
import game.GameFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * Ass6Game class.
 * Shir Zituni
 * 316537992
 */
public class Ass6Game {
    /**
     * .
     * main
     * @param args String[] on main
     */
    public static void main(String[] args) {
        GUI g = new GUI("Arkanoid", 800, 600);

        KeyboardSensor keyboardSensor = g.getKeyboardSensor();
        AnimationRunner ar = new AnimationRunner(g, 60);

        GameFlow gameFlow = new GameFlow(ar, keyboardSensor);
        List<LevelInformation> l = new ArrayList<>();

//check if there are no parameters
        if (args.length == 0) {
            l.add(new LevelOne());
            l.add(new LevelTwo());
            l.add(new LevelThree());
            l.add(new LevelFour());
            //run the levels
            gameFlow.runLevels(l);
        } else {
            //find the right level
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("1")) {
                    LevelInformation levelOne = new LevelOne();
                    l.add(levelOne);
                }
                if (args[i].equals("2")) {
                    LevelInformation levelTwo = new LevelTwo();
                    l.add(levelTwo);
                }
                if (args[i].equals("3")) {
                    LevelInformation levelThree = new LevelThree();
                    l.add(levelThree);
                }
                if (args[i].equals("4")) {
                    LevelInformation levelFour = new LevelFour();
                    l.add(levelFour);
                }
            }
            //run the levels
            gameFlow.runLevels(l);
        }
    }
}


