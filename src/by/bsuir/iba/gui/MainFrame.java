package by.bsuir.iba.gui;

import by.bsuir.iba.core.configuration.Configuration;
import by.bsuir.iba.core.configuration.ConfigurationLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

/**
 * Created by Ruslan on 07.11.14.
 */
public class MainFrame extends JFrame {
    protected JFrame frame;
    protected Configuration conf;
    protected CrossroadPanel crossroadPanel = new CrossroadPanel();
    protected HashMap<Integer, Coordinates> startPoints = new HashMap<>();
    protected File directory = new File("D:\\");
    protected String _path = "";
    final ConfigurationLoader configurationLoader = new ConfigurationLoader();

    public void setConfigs() {
        int lineIndex;
        boolean isBrick;

        if (_path.equals("")) {
            configurationLoader.setPath("D:\\Java\\TLCS\\resources\\configurations\\TLCS.properties");
        } else {
            configurationLoader.setPath(_path);
        }
        configurationLoader.load();
        conf = configurationLoader.getConfiguration();

        setPoints();

        for (int i = 1; i <= conf.getRoads(); i++) {
            lineIndex = i * 10;
            if (conf.getRightTurns()[i - 1] != 0) {
                lineIndex++;
                TrafficLine tmpRightLine = new TrafficLine(lineIndex, startPoints.get(lineIndex).x, startPoints.get(lineIndex).y, true);
                crossroadPanel.addTrafficLine(tmpRightLine);
            } else {
                lineIndex++;
                isBrick = true;
                TrafficLine tmpRightLine = new TrafficLine(lineIndex, startPoints.get(lineIndex).x, startPoints.get(lineIndex).y, isBrick, false);
                crossroadPanel.addTrafficLine(tmpRightLine);
            }

            if (conf.getStraight()[i - 1] != 0) {
                lineIndex++;
                TrafficLine tmpRightLine = new TrafficLine(lineIndex, startPoints.get(lineIndex).x, startPoints.get(lineIndex).y, true);
                crossroadPanel.addTrafficLine(tmpRightLine);
            } else {
                lineIndex++;
                isBrick = true;
                TrafficLine tmpRightLine = new TrafficLine(lineIndex, startPoints.get(lineIndex).x, startPoints.get(lineIndex).y, isBrick, false);
                crossroadPanel.addTrafficLine(tmpRightLine);
            }

            if (conf.getLeftTurns()[i - 1] != 0) {
                lineIndex++;
                TrafficLine tmpRightLine = new TrafficLine(lineIndex, startPoints.get(lineIndex).x, startPoints.get(lineIndex).y, true);
                crossroadPanel.addTrafficLine(tmpRightLine);
            } else {
                lineIndex++;
                isBrick = true;
                TrafficLine tmpRightLine = new TrafficLine(lineIndex, startPoints.get(lineIndex).x, startPoints.get(lineIndex).y, isBrick, false);
                crossroadPanel.addTrafficLine(tmpRightLine);
            }

            if (conf.getOutputLines()[i - 1] != 0) {
                for (int outLines = 1; outLines <= 3; outLines++) {
                    lineIndex++;
                    isBrick = (conf.getOutputLines()[i - 1] >= outLines) ? false : true;
                    TrafficLine tmpRightLine = new TrafficLine(lineIndex, startPoints.get(lineIndex).x, startPoints.get(lineIndex).y, isBrick, false);
                    crossroadPanel.addTrafficLine(tmpRightLine);
                }
            } else {
                for (int outLines = 1; outLines <= 3; outLines++) {
                    lineIndex++;
                    isBrick = true;
                    TrafficLine tmpRightLine = new TrafficLine(lineIndex, startPoints.get(lineIndex).x, startPoints.get(lineIndex).y, isBrick, false);
                    crossroadPanel.addTrafficLine(tmpRightLine);
                }
            }
        }
    }

    public void initComponents() {
        frame = new JFrame("Traffic Line Control System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(BorderLayout.WEST, crossroadPanel);

        JButton getConfigsButton = new JButton("Get config");
        getConfigsButton.addActionListener(new getConfigActionListener());

        frame.add(getConfigsButton);
        getConfigsButton.setBounds(630, 20, 100, 25);

        JButton lightButton = new JButton("Зажечь первый зеленым");
        lightButton.addActionListener(new lightButtonListener());
        frame.add(lightButton);
        lightButton.setBounds(580, 150, 200, 25);

        frame.setSize(800, 585);
        frame.setResizable(false);
        frame.getContentPane().add(crossroadPanel);
        frame.setVisible(true);
    }

    private void setPoints() {
        int[] coordinateX = {163, 203, 243, 283, 323, 363, 405, 405, 405, 405, 405, 405, 363, 320, 280, 240, 200, 160, 120, 120, 120, 120, 120, 120};
        int[] coordinateY = {115, 115, 115, 115, 115, 115, 163, 203, 243, 283, 323, 363, 410, 410, 410, 410, 410, 410, 363, 320, 280, 240, 200, 160};
        int[] coordinateId = {11, 12, 13, 14, 15, 16, 21, 22, 23, 24, 25, 26, 31, 32, 33, 34, 35, 36, 41, 42, 43, 44, 45, 46};
        for (int i = 0; i < coordinateX.length; i++) {
            Coordinates tmpCoordinate = new Coordinates(coordinateX[i], coordinateY[i]);
            startPoints.put(coordinateId[i], tmpCoordinate);
        }
    }

    public class lightButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            crossroadPanel.trafficLineHashMap.get(11).lightGreen();
            frame.repaint();

        }
    }

    public class getConfigActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.setCurrentDirectory(directory);
            int result = fileOpen.showOpenDialog(MainFrame.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                directory = fileOpen.getCurrentDirectory();
                _path = fileOpen.getSelectedFile().getPath();
                crossroadPanel.trafficLineHashMap.clear();
                setConfigs();
                frame.repaint();
            }
            if (result == JFileChooser.CANCEL_OPTION) {
                System.out.println("Canceled");
            }

        }
    }

    public class Coordinates {
        int x;
        int y;

        public Coordinates(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
}
