package by.bsuir.iba.gui;

import by.bsuir.iba.core.roadline.RoadLine;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ruslan
 */
public class TrafficLine extends RoadLine {

    boolean hasTrafficLight;
    int lineId, numQueueCar, x, y;
    Image greenLight, yellowLight, redLight, brick, alight;

    Font myFont = new Font("TimesRoman", Font.BOLD, 32);
    JLabel displayQueue = new JLabel("0");

    public TrafficLine(int _id, int _x, int _y, boolean _hasTrafficLight){
        hasTrafficLight = _hasTrafficLight;
        lineId = _id;
        numQueueCar = 0;
        x = _x;
        y = _y;
        try{
            greenLight = javax.imageio.ImageIO.read(new java.io.File("resources\\images\\green.png"));
            yellowLight= javax.imageio.ImageIO.read(new java.io.File("resources\\images\\yellow.png"));
            redLight = javax.imageio.ImageIO.read(new java.io.File("resources\\images\\red.png"));
            brick = javax.imageio.ImageIO.read(new java.io.File("resources\\images\\brick.png"));
            alight = redLight;
        } catch (Exception e){
            e.printStackTrace();
        }
        displayQueue.setFont(myFont);
    }

    public TrafficLine(int _id, int _x, int _y, boolean isBrick, boolean _hasTrafficLight){
        hasTrafficLight = _hasTrafficLight;
        lineId = _id;
        numQueueCar = 0;
        x = _x;
        y = _y;
        try{
            brick = javax.imageio.ImageIO.read(new java.io.File("resources\\images\\brick.png"));
            if(isBrick){
            alight = brick;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        displayQueue.setFont(myFont);
    }

    public void comeCars(int numCars){
        numQueueCar+=numCars;
    }

    public void lightRed(){
        alight = redLight;
    }

    public void lightGreen(){
        alight = greenLight;
    }

    public void lightYellow(){
        alight = yellowLight;
    }

    public void comingCars(){
        numQueueCar+= generateRandomNumOfCars();
        displayQueue.setText(Integer.toString(numQueueCar));
    }

}
