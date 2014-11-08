package by.bsuir.iba.configuration;

/**
 * This class represent configuration of traffic light control system (TLCS)
 *
 * @author Pavel Vashkel
 */
public class Configuration {
    private volatile static Configuration instance;
    private int roads;
    private int[] rightTurns;
    private int[] leftTurns;
    private int[] straight;
    private int[] outputLines;
    private int[] pedestrianCrossings;
    private int[][] conflictMatrix;

    private Configuration() {
        // Exist only to defeat instantiation
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

    public int getRoads() {
        return roads;
    }

    public void setRoads(int roads) {
        this.roads = roads;
    }

    public int[] getRightTurns() {
        return rightTurns;
    }

    public void setRightTurns(int[] rightTurns) {
        this.rightTurns = rightTurns;
    }

    public int[] getLeftTurns() {
        return leftTurns;
    }

    public void setLeftTurns(int[] leftTurns) {
        this.leftTurns = leftTurns;
    }

    public int[] getStraight() {
        return straight;
    }

    public void setStraight(int[] straight) {
        this.straight = straight;
    }

    public int[] getOutputLines() {
        return outputLines;
    }

    public void setOutputLines(int[] outputLines) {
        this.outputLines = outputLines;
    }

    public int[] getPedestrianCrossings() {
        return pedestrianCrossings;
    }

    public void setPedestrianCrossings(int[] pedestrianCrossings) {
        this.pedestrianCrossings = pedestrianCrossings;
    }

    public int[][] getConflictMatrix() {
        return conflictMatrix;
    }

    public void setConflictMatrix(int[][] conflictMatrix) {
        this.conflictMatrix = conflictMatrix;
    }

    public int[] getConflictColumn(int column) {
        int[] arrInt = new int[roads];
        for (int i = 0; i < conflictMatrix.length; i++) {
            arrInt[i] = conflictMatrix[i][column];
        }
        return arrInt;
    }
}
