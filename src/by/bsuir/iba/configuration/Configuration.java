package by.bsuir.iba.configuration;

/**
 * This class store configuration of traffic light
 * control system (TLCS)
 *
 * @author Pavel Vashkel
 */

public class Configuration {
    private int roads;
    private String rightTurns;
    private String leftTurns;
    private String straight;
    private String outputLines;
    private String pedestrianCrossings;
    private int[][] conflictMatrix;

    public int getRoads() {
        return roads;
    }

    public void setRoads(int roads) {
        this.roads = roads;
    }

    public String getRightTurns() {
        return rightTurns;
    }

    public void setRightTurns(String rightTurns) {
        this.rightTurns = rightTurns;
    }

    public String getLeftTurns() {
        return leftTurns;
    }

    public void setLeftTurns(String leftTurns) {
        this.leftTurns = leftTurns;
    }

    public String getStraight() {
        return straight;
    }

    public void setStraight(String straight) {
        this.straight = straight;
    }

    public String getOutputLines() {
        return outputLines;
    }

    public void setOutputLines(String outputLines) {
        this.outputLines = outputLines;
    }

    public String getPedestrianCrossings() {
        return pedestrianCrossings;
    }

    public void setPedestrianCrossings(String pedestrianCrossings) {
        this.pedestrianCrossings = pedestrianCrossings;
    }

    public int[][] getConflictMatrix() {
        return conflictMatrix;
    }

    public void setConflictMatrix(int[][] conflictMatrix) {
        this.conflictMatrix = conflictMatrix;
    }
}
