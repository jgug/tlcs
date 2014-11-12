package by.bsuir.iba.gui;

import by.bsuir.iba.core.roadline.RoadLine;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ruslan Ardytski
 * @author Pavel Vashkel
 */
public class TrafficLine extends RoadLine {

    /**
     * {@code private static final int TIMETOGO}
     * Time in seconds to cross crosstoad for one car
     */
    private static final int TIMETOGO = 1000;
    boolean hasTrafficLight;
    int lineId, x, y;
    volatile int numQueueCar;
    Image greenLight, yellowLight, redLight, brick, alight;

    Font myFont = new Font("TimesRoman", Font.BOLD, 32);
    JLabel displayQueue = new JLabel("0");

    /**
     * Instantiates a new Traffic line.
     *
     * @param _id              the _ id
     * @param _x               the _ x
     * @param _y               the _ y
     * @param _hasTrafficLight the _ has traffic light
     */
    public TrafficLine(int _id, int _x, int _y, boolean _hasTrafficLight) {
        hasTrafficLight = _hasTrafficLight;
        lineId = _id;
        numQueueCar = 0;
        x = _x;
        y = _y;
        try {
            greenLight = javax.imageio.ImageIO.read(new java.io.File("resources\\images\\green.png"));
            yellowLight = javax.imageio.ImageIO.read(new java.io.File("resources\\images\\yellow.png"));
            redLight = javax.imageio.ImageIO.read(new java.io.File("resources\\images\\red.png"));
            brick = javax.imageio.ImageIO.read(new java.io.File("resources\\images\\brick.png"));
            alight = redLight;
        } catch (Exception e) {
            e.printStackTrace();
        }
        displayQueue.setFont(myFont);
    }

    /**
     * Instantiates a new Traffic line.
     *
     * @param _id              the _ id
     * @param _x               the _ x
     * @param _y               the _ y
     * @param isBrick          the is brick
     * @param _hasTrafficLight the _ has traffic light
     */
    public TrafficLine(int _id, int _x, int _y, boolean isBrick, boolean _hasTrafficLight) {
        hasTrafficLight = _hasTrafficLight;
        lineId = _id;
        numQueueCar = 0;
        x = _x;
        y = _y;
        try {
            brick = javax.imageio.ImageIO.read(new java.io.File("resources\\images\\brick.png"));
            if (isBrick) {
                alight = brick;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        displayQueue.setFont(myFont);
    }

    /**
     * Gets timetogo.
     *
     * @return the timetogo
     */
    public static int getTimetogo() {
        return TIMETOGO;
    }

    /**
     * Come cars.
     *
     * @param numCars the num cars
     */
    public void comeCars(int numCars) {
        numQueueCar += numCars;
    }

    /**
     * Light red.
     */
    public void lightRed() {
        alight = redLight;
    }

    /**
     * Light green.
     */
    public void lightGreen() {
        alight = greenLight;
    }

    /**
     * Light yellow.
     */
    public void lightYellow() {
        alight = yellowLight;
    }

    /**
     * Coming cars.
     */
    public void comingCars() {
        numQueueCar += generateRandomNumOfCars();
        displayQueue.setText(Integer.toString(numQueueCar));
    }

    /**
     * Outgoing cars.
     */
    public void outgoingCars() {
        if (numQueueCar > 0) {
            numQueueCar--;
        }
        displayQueue.setText(Integer.toString(numQueueCar));
    }
}
