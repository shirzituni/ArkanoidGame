package listeners;
/**
 * HitNotifier class.
 * Shir Zituni
 * 316537992
 */
public interface HitNotifier {
    /**.
     * void method
     * add hl as a listener.
     * @param hl a listener to hit events
     */
    void addHitListener(HitListener hl);
    /**.
     * void method
     * Remove hl from the list of listeners to hit events.
     * @param hl a listener to hit events
     */
    void removeHitListener(HitListener hl);
}