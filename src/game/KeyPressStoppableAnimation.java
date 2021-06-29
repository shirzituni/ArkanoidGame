package game;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * KeyPressStoppableAnimation class.
 * Shir Zituni
 * 316537992
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor1;
    private String key1;
    private Animation animation1;
    private boolean stop;
    private boolean isAlreadyPressed;
    /**.
     * Constructor
     * @param sensor the keyboardSensor
     * @param key the KeyboardSensor
     * @param animation the Animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation1 = animation;
        this.key1 = key;
        this.sensor1 = sensor;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        animation1.doOneFrame(d);
        if (!this.sensor1.isPressed(key1) && isAlreadyPressed) {
            this.isAlreadyPressed = false;
        }

        if (this.sensor1.isPressed(key1) && !isAlreadyPressed) {
            this.stop = true;
        }

    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }

}