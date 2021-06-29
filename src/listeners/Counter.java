package listeners;
/**
 * Counter class.
 * Shir Zituni
 * 316537992
 */
public class Counter {
    private int c;
    /**.
     * constructor
     * @param x is the int
     */
    public Counter(int x) {
        this.c = x;
    }
    /**.
     * void method
     * @param number is the number it will add to current count
     */
    public void increase(int number) {
        this.c += number;
    }
    /**.
     * void method
     * @param number is the number it will subtract number from current count
     */
    public void decrease(int number) {
        this.c -= number;
    }
    /**.
     * get method, Return current count.
     * @return the current count.
     */
    public int getValue() {
        return c;
    }
}