package by.bsuir.iba.core;

/**
 * Created by Pavel on 11.11.14.
 */
public class State {
    private int time;
    private int[] state;

    /**
     * Gets time.
     *
     * @return the time
     */
    public int getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Get state.
     *
     * @return the int [ ]
     */
    public int[] getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(int[] state) {
        this.state = state;
    }
}
