package sprites;

import biuoop.DrawSurface;

/**.
 * interface sprites.Sprite
 * Shir Zituni
 * 316537992
 */
public interface Sprite {
    /**.
     * void method draw the sprite to the screen
     * @param d the surface
     */
    void drawOn(DrawSurface d);
    /**.
     * void method  notify the sprite that time has passed
     */
    void timePassed();
}