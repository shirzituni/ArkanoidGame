package sprites;

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**.
 * sprites.SpriteCollection class
 * Shir Zituni
 * 316537992
 */
public class SpriteCollection {
    private List<Sprite> spriteCollection;
    /**.
     * constructor
     */
    public SpriteCollection() {
        this.spriteCollection = new ArrayList<>();
    }
    /**.
     * void method add the sprite to the collection
     * @param s the sprites.Sprite
     */
    public void addSprite(Sprite s) {
        spriteCollection.add(s);
    }
    /**.
     * get method
     * @return the sprites.Sprite collection
     */
    public List<Sprite> getSprite() {
       return spriteCollection;
    }
    /**.
     * void method call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spriteCollectionCopy = new ArrayList<>(this.spriteCollection);
        for (Sprite s : spriteCollectionCopy) {
            s.timePassed();
        }
    }
    /**.
     * void method call drawOn(d) on all sprites.
     * @param d the surface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : spriteCollection) {
            s.drawOn(d);
        }
    }
    /**.
     * void method remove a sprite from the list .
     * @param s the sprite
     */
    public void removeSprite(Sprite s) {
        this.spriteCollection.remove(s);
    }
}