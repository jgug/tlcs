package by.bsuir.iba.roadline;

/**
 * Class represents single road line with its own id and number of cars
 * in the line.
 * {@code id} it's a {@code int} value of RoadLine id. Should be unique
 * {@code cars} it's a {@code int} value of number of cars in a line
 * {@code MIN} it's a {@code static final int} field of minimum value for
 * random cars
 * number generating
 * {@code MAX} it's a {@code static final int} field of maximum value for
 * random cars
 * number generating
 *
 * @author Pavel Vashkel
 */
public class RoadLine {
    private static final int MIN = 0;
    private static final int MAX = 25;
    private int id;
    private int cars;

    /**
     * Basic constructor without parameters. Set number of cars to 0
     * by default
     */
    public RoadLine() {
        cars = 0;
    }

    /**
     * Constructor initializes id and number of cars
     *
     * @param id   RoadLine id
     * @param cars number of cars at RoadLine
     */
    public RoadLine(int id, int cars) {
        this.id = id;
        this.cars = cars;
    }

    /**
     * Constructor initializes id and sets number of cars to 0 by default
     *
     * @param id RoadLine id
     */
    public RoadLine(int id) {
        this.id = id;
        cars = 0;
    }

    /**
     * Returns id of the RoadLine
     *
     * @return {@code int} value as RoadLine id
     */
    public int getId() {
        return id;
    }

    /**
     * Increment number of cars in the RoadLine by 1
     */
    public void addCar() {
        cars++;
    }

    /**
     * Set number of cars in the RoadLine randomly in bound of
     * MAX and MIN
     */
    public void setCars() {
        cars = (int) (Math.random() * ((MAX - MIN) + 1));
    }

    /**
     * Returns {@code int} value number of cars in the RoadLine
     *
     * @return {@code int}
     */
    public int getCars() {
        return cars;
    }

    /**
     * Increases number of cars in the line by certain value
     *
     * @param cars {@code int} value of cars number increasing
     */
    public void setCars(int cars) {
        this.cars = cars;
    }
}
