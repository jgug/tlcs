package by.bsuir.iba.gui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Ruslan
 */
public class CrossroadPanel extends JPanel {
    HashMap<Integer, TrafficLine> trafficLineHashMap = new HashMap<>();
    Image image;

    public CrossroadPanel() {
        try {
            image = javax.imageio.ImageIO.read(new java.io.File("resources\\images\\14.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, 555, 555, this);
        }
        for (int key : trafficLineHashMap.keySet()) {
            TrafficLine tmpLine = trafficLineHashMap.get(key);
            g.drawImage(tmpLine.alight, tmpLine.x, tmpLine.y, 30, 30, this);

            if (tmpLine.hasTrafficLight) {
                this.add(tmpLine.displayQueue);
                int tmpX, tmpY;
                switch (tmpLine.lineId / 10) {
                    case 1:
                        tmpX = tmpLine.x;
                        tmpY = tmpLine.y - 100;
                        break;
                    case 2:
                        tmpX = tmpLine.x + 100;
                        tmpY = tmpLine.y;
                        break;
                    case 3:
                        tmpX = tmpLine.x;
                        tmpY = tmpLine.y + 100;
                        break;
                    case 4:
                        tmpX = tmpLine.x - 100;
                        tmpY = tmpLine.y;
                        break;
                    default:
                        tmpX = tmpLine.x;
                        tmpY = tmpLine.y;
                }
                tmpLine.displayQueue.setBounds(tmpX, tmpY, 20, 25);
            }


        }
    }

    public void addTrafficLine(TrafficLine t) {
        trafficLineHashMap.put(t.lineId, t);
    }
}
