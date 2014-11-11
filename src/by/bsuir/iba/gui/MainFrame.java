package by.bsuir.iba.gui;

import by.bsuir.iba.core.configuration.Configuration;
import by.bsuir.iba.core.configuration.ConfigurationLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ruslan on 07.11.14.
 */
public class MainFrame extends JFrame {
    final ConfigurationLoader configurationLoader = new ConfigurationLoader();
    protected JFrame frame;
    protected Configuration conf;
    protected CrossroadPanel crossroadPanel = new CrossroadPanel();
    protected HashMap<Integer, Coordinates> startPoints = new HashMap<>();
    protected File directory = new File("D:\\");
    protected String _path = "";
    protected ScheduledExecutorService executor;
    protected JButton buttonGetConfigFile;
    protected JButton buttonLightGreen;
    protected JButton buttonTransportStart;
    protected JButton buttonTransportStop;
    protected JButton buttonConfigurate;
    protected JButton buttonNextState;
    protected JTextField textFieldTime;
    protected JCheckBox checkBoxIsUse;
    protected JComboBox<Integer> comboboxOrder;
    private boolean isChecked;
    private int item;
    private int time;
    private int count;
    private int globalIndex = 0;
    private Map<Integer, String> map1 = new HashMap<>();
    private Map<Integer, String> map2 = new HashMap<>();

    /**
     * Sets configs.
     */
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

    /**
     * Init components.
     */
    public void initComponents() {
        frame = new JFrame("Traffic Line Control System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(BorderLayout.WEST, crossroadPanel);

        // Get config file
        buttonGetConfigFile = new JButton("Get config");
        frame.add(buttonGetConfigFile);
        buttonGetConfigFile.setBounds(600, 45, 150, 25);
        buttonGetConfigFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileOpen = new JFileChooser();
                fileOpen.setCurrentDirectory(directory);
                int result = fileOpen.showOpenDialog(MainFrame.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    directory = fileOpen.getCurrentDirectory();
                    _path = fileOpen.getSelectedFile().getPath();
                    crossroadPanel.trafficLineHashMap.clear();
                    crossroadPanel.removeAll();
                    frame.repaint();
                    setConfigs();
                    frame.repaint();
                }
                if (result == JFileChooser.CANCEL_OPTION) {
                    System.out.println("Canceled");
                }
            }
        });

        // Order combo box
        comboboxOrder = new JComboBox<Integer>();
        frame.add(comboboxOrder);
        comboboxOrder.setBounds(675, 145, 75, 25);
        comboboxOrder.setEnabled(false);
        comboboxOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item = comboboxOrder.getItemAt(comboboxOrder.getSelectedIndex());
            }
        });

        // Green time in seconds
        textFieldTime = new JTextField();
        frame.add(textFieldTime);
        textFieldTime.setBounds(625, 145, 45, 25);
        textFieldTime.setEnabled(false);

        // Is using check box
        checkBoxIsUse = new JCheckBox();
        frame.add(checkBoxIsUse);
        checkBoxIsUse.setBounds(600, 145, 25, 25);
        checkBoxIsUse.setEnabled(false);
        checkBoxIsUse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxIsUse.isSelected()) {
                    textFieldTime.setEnabled(true);
                    comboboxOrder.setEnabled(true);
                    isChecked = true;
                } else {
                    textFieldTime.setEnabled(false);
                    comboboxOrder.setEnabled(false);
                    isChecked = false;
                }
            }
        });

        // Configurate crossroad
        buttonConfigurate = new JButton("Configurate");
        frame.add(buttonConfigurate);
        buttonConfigurate.setBounds(600, 115, 150, 25);
        buttonConfigurate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBoxIsUse.setEnabled(true);
                buttonNextState.setEnabled(true);
                fillMap();
                count = map1.keySet().size();
                readMap(map1);
                textFieldTime.setText("8");
                int size = map1.keySet().size();
                for (int i = 0; i < size; i++) {
                    comboboxOrder.addItem(i);
                }
            }
        });

        // Next state
        buttonNextState = new JButton("Next");
        frame.add(buttonNextState);
        buttonNextState.setBounds(600, 175, 150, 25);
        buttonNextState.setEnabled(false);
        buttonNextState.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextItem();
                if (isChecked) {
                    time = Integer.parseInt(textFieldTime.getText());
                }
            }
        });

        // Light green
        buttonLightGreen = new JButton("Light green");
        frame.add(buttonLightGreen);
        buttonLightGreen.setBounds(600, 240, 150, 25);
        buttonLightGreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                crossroadPanel.trafficLineHashMap.get(11).lightGreen();
                frame.repaint();
                System.out.println();
                System.out.println("MAP1");
                readMap(map1);
                System.out.println();
                System.out.println("MAP2");
                readMap(map2);
            }
        });

        // Start transport generating
        buttonTransportStart = new JButton("Start transport");
        frame.add(buttonTransportStart);
        buttonTransportStart.setEnabled(false);
        buttonTransportStart.setBounds(600, 455, 150, 25);
        buttonTransportStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateTransport();
            }
        });

        // Stop transport generationg
        buttonTransportStop = new JButton("Stop transport");
        frame.add(buttonTransportStop);
        buttonTransportStop.setBounds(600, 485, 150, 25);
        buttonTransportStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopTransportGeneration();
            }
        });

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

    /**
     * Generate transport.
     */
    public void generateTransport() {
        executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                for (int key : crossroadPanel.trafficLineHashMap.keySet()) {
                    TrafficLine tmpLine = crossroadPanel.trafficLineHashMap.get(key);
                    if (tmpLine.hasTrafficLight) {
                        tmpLine.comingCars();
                    }
                }
            }
        }, 4, 4, TimeUnit.SECONDS);
        buttonTransportStart.setEnabled(false);
        buttonTransportStop.setEnabled(true);
    }

    /**
     * Stop transport generation.
     */
    public void stopTransportGeneration() {
        executor.shutdown();
        buttonTransportStart.setEnabled(true);
        buttonTransportStop.setEnabled(false);
    }

//=====================================================================================================================

    public void fillMap() {
        map1.put(0, "one");
        map1.put(1, "two");
        map1.put(2, "three");
        map1.put(3, "four");
        map1.put(4, "five");
    }

    public void updateComboBox() {
        comboboxOrder.removeAllItems();
        int size = map1.keySet().size();
        for (int i = 0; i < size; i++) {
            comboboxOrder.addItem(i);
        }
    }

    public void nextItem() {
        if (globalIndex < map1.keySet().size()) {
            if (isChecked) {
                map2.put(item, map1.get(globalIndex));
            }
            map1.remove(globalIndex);
            globalIndex++;
        } else {
            System.out.println("зэтс инаф");
        }
    }

    public void readMap(Map<Integer, String> map) {
//        int size = map.keySet().size();
//        for (int i = 0; i < size; i++) {
//            System.out.println(map.get(i));
//        }
        for (Integer i : map.keySet()) {
            System.out.println(map.get(i));
        }
    }

//=====================================================================================================================

    /**
     * The type Coordinates.
     */
    public class Coordinates {
        int x;
        int y;

        /**
         * Instantiates a new Coordinates.
         *
         * @param _x the _ x
         * @param _y the _ y
         */
        public Coordinates(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
}
