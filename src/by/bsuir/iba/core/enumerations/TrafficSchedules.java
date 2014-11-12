package by.bsuir.iba.core.enumerations;

public enum TrafficSchedules {
    NIGHT(2), BASIC(4), JAM(6);
    private int values;

    private TrafficSchedules(int values) {
        this.values = values;
    }
}
