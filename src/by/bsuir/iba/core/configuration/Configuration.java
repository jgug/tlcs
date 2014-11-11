package by.bsuir.iba.core.configuration;

/**
 * This class represents configuration of a system which gets from
 * configuration file *.properties by {@code ConfigurationLoader} class.
 * <p/>
 * {@code private volatile static Configuration instance} is a instance of
 * {@code Configuration} class declared {@code volatile} to prevent
 * multithreading issues.
 * <p/>
 * {@code private int roads} stores number of roads defined in a
 * configuration file.
 * <p/>
 * {@code private int lines} stores number of lines entering into crossroad.
 * Calculates as dimension of a conflictMatrix minus number of pedestrian
 * crossings (if exists).
 * <p/>
 * {@code private int[] rightTurns = null},
 * {@code private int[] leftTurns = null},
 * {@code private int[] straight = null} and
 * {@code private int[] outputLines = null} are 1D int arrays which dimension
 * equals to number of roads in the described crossroad which representing
 * numbers of right turn, left turn straight and output lines for every road
 * in the crossroad respectively.
 * <p/>
 * {@code private int[] pedestrianCrossings = null} is a 1D int array which
 * dimension equals to number of road in a crossroad. Every single element of
 * an array can be 1 or 0 which means existing pedestrian crossing or not at
 * the corresponding road.
 * <p/>
 * {@code private int[][] conflictMatrix} is a 2D int array which stores
 * conflict matrix for describing crossroad.
 *
 * @author Pavel Vashkel
 */
public class Configuration {
    private volatile static Configuration instance;
    private int roads;
    private int lines;
    private int[] rightTurns = null;
    private int[] leftTurns = null;
    private int[] straight = null;
    private int[] outputLines = null;
    private int[] pedestrianCrossings = null;
    private int[][] conflictMatrix;

    /**
     * Basic constructor without parameters defined private to prevent
     * using in out of class and for realization Singleton pattern.
     */
    private Configuration() {

    }

    /**
     * Thread-safety method for creating new instance of Configuration.
     * First it checks if any instance of Configuration already exists,
     * if no, enters in a synchronized block. Inside the block checking
     * repeats and if no instance of Configuration still exist create
     * new instance of Configuration.
     *
     * @return unique instance of Configuration.
     */
    public static synchronized Configuration getInstance() {
        if (instance == null) {
            synchronized (Configuration.class) {
                if (instance == null) {
                    instance = new Configuration();
                }
            }
        }
        return instance;
    }

    /**
     * Returns total number of lines in a crossroad
     *
     * @return int lines
     */
    public int getLines() {
        return lines;
    }

    /**
     * Sets total number of lines in a crossroad depending of is pedestrian
     * crossing exists or not.
     */
    public void setLines(int lines) {
        this.lines = lines;
    }

    /**
     * Returns number of lines with right turn.
     *
     * @return int right turns count
     */
    public int getRightTurnsCount() {
        int sum = 0;
        for (int i : rightTurns) {
            sum += i;
        }
        return sum;
    }

    /**
     * Returns number of lines with left turn.
     *
     * @return int left turns count
     */
    public int getLeftTurnsCount() {
        int sum = 0;
        for (int i : leftTurns) {
            sum += i;
        }
        return sum;
    }

    /**
     * Returns number of straight lines.
     *
     * @return int straight turns count
     */
    public int getStraightCount() {
        int sum = 0;
        for (int i : straight) {
            sum += i;
        }
        return sum;
    }

    /**
     * Returns number of pedestrian crossings.
     *
     * @return int pedestrian count
     */
    public int getPedestrianCount() {
        int sum = 0;
        if (pedestrianCrossings != null) {
            for (int i : pedestrianCrossings) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * Returns number of roads.
     *
     * @return int roads
     */
    public int getRoads() {
        return roads;
    }

    /**
     * Sets number of roads
     *
     * @param roads number of roads should to be set.
     */
    public void setRoads(int roads) {
        this.roads = roads;
    }


    /**
     * Get right turns.
     *
     * @return the int [ ]
     */
    public int[] getRightTurns() {
        return rightTurns;
    }

    /**
     * Sets right turns.
     *
     * @param rightTurns the right turns
     */
    public void setRightTurns(int[] rightTurns) {
        this.rightTurns = rightTurns;
    }

    /**
     * Get left turns.
     *
     * @return the int [ ]
     */
    public int[] getLeftTurns() {
        return leftTurns;
    }

    /**
     * Sets left turns.
     *
     * @param leftTurns the left turns
     */
    public void setLeftTurns(int[] leftTurns) {
        this.leftTurns = leftTurns;
    }

    /**
     * Get straight.
     *
     * @return the int [ ]
     */
    public int[] getStraight() {
        return straight;
    }

    /**
     * Sets straight.
     *
     * @param straight the straight
     */
    public void setStraight(int[] straight) {
        this.straight = straight;
    }

    /**
     * Get output lines.
     *
     * @return the int [ ]
     */
    public int[] getOutputLines() {
        return outputLines;
    }

    /**
     * Sets output lines.
     *
     * @param outputLines the output lines
     */
    public void setOutputLines(int[] outputLines) {
        this.outputLines = outputLines;
    }

    /**
     * Get pedestrian crossings.
     *
     * @return the int [ ]
     */
    public int[] getPedestrianCrossings() {
        return pedestrianCrossings;
    }

    /**
     * Sets pedestrian crossings.
     *
     * @param pedestrianCrossings the pedestrian crossings
     */
    public void setPedestrianCrossings(int[] pedestrianCrossings) {
        this.pedestrianCrossings = pedestrianCrossings;
    }

    /**
     * Get conflict matrix.
     *
     * @return the int [ ] [ ]
     */
    public int[][] getConflictMatrix() {
        return conflictMatrix;
    }

    /**
     * Sets conflict matrix.
     *
     * @param conflictMatrix the conflict matrix
     */
    public void setConflictMatrix(int[][] conflictMatrix) {
        this.conflictMatrix = conflictMatrix;
    }

    /**
     * Get conflict column.
     *
     * @param column the column
     * @return the int [ ]
     */
    public int[] getConflictColumn(int column) {
        int[] arrInt = new int[roads];
        for (int i = 0; i < conflictMatrix.length; i++) {
            arrInt[i] = conflictMatrix[i][column];
        }
        return arrInt;
    }
}
