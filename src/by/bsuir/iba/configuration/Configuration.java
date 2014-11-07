package by.bsuir.iba.configuration;

/**
 * This class represent configuration of traffic light control system (TLCS)
 *
 * @author Pavel Vashkel
 */
public class Configuration {
    private int roads;
    private int[] rightTurns;
    private int[] leftTurns;
    private int[] straight;
    private int[] outputLines;
    private int[] pedestrianCrossings;
    private int[][] conflictMatrix;

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
}
