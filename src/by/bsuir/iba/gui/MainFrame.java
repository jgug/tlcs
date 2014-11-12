package by.bsuir.iba.gui;

import by.bsuir.iba.core.UberStates;
import by.bsuir.iba.core.configuration.Configuration;
import by.bsuir.iba.core.configuration.ConfigurationLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
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
    protected JPanel optionPanel;
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
    protected JButton goButton;
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
    Set<int[]> stateTreeSetForConfig;// = UberStates.getStateTreeSet();
    Iterator<int[]> iterator;// = stateTreeSet.iterator();

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
//        frame.add(BorderLayout.WEST, crossroadPanel);
        optionPanel = new JPanel();
        optionPanel.setLayout(null);
        // Get config file
        buttonGetConfigFile = new JButton("Get config");
        optionPanel.add(buttonGetConfigFile);
        buttonGetConfigFile.setBounds(50, 50, 150, 25);
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
        optionPanel.add(comboboxOrder);
        comboboxOrder.setBounds(150, 150, 45, 25);
        comboboxOrder.setEnabled(false);
        comboboxOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item = comboboxOrder.getItemAt(comboboxOrder.getSelectedIndex());
            }
        });

        // Green time in seconds
        textFieldTime = new JTextField();
        optionPanel.add(textFieldTime);
        textFieldTime.setBounds(90, 150, 45, 25);
        textFieldTime.setEnabled(false);

        // Is using check box
        checkBoxIsUse = new JCheckBox();
        optionPanel.add(checkBoxIsUse);
        checkBoxIsUse.setBounds(50, 150, 25, 25);
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
        optionPanel.add(buttonConfigurate);
        buttonConfigurate.setBounds(50, 110, 150, 25);
        buttonConfigurate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBoxIsUse.setEnabled(true);
                buttonNextState.setEnabled(true);
                /*fillMap();
                count = map1.keySet().size();
                readMap(map1);
                textFieldTime.setText("8");*/

//                updateComboBox();

                for(int i = 0; i<stateTreeSet.size();i++){
                    comboboxOrder.addItem(i);
                }


            }
        });

        // Next state
        buttonNextState = new JButton("Next");
        optionPanel.add(buttonNextState);
        buttonNextState.setBounds(50, 185, 150, 25);
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
        optionPanel.add(buttonLightGreen);
        buttonLightGreen.setBounds(50, 240, 150, 25);
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

        goButton = new JButton("Поехали!");
        optionPanel.add(goButton);
        goButton.setBounds(50, 280, 150, 25);
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RunGarland garland = new RunGarland();
                garland.start();
            }
        });

        // Start transport generating
        buttonTransportStart = new JButton("Start transport");
        optionPanel.add(buttonTransportStart);
        buttonTransportStart.setEnabled(true);
        buttonTransportStart.setBounds(50, 455, 150, 25);
        buttonTransportStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateTransport();
            }
        });

        // Stop transport generationg
        buttonTransportStop = new JButton("Stop transport");
        optionPanel.add(buttonTransportStop);
        buttonTransportStop.setEnabled(false);
        buttonTransportStop.setBounds(50, 490, 150, 25);
        buttonTransportStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopTransportGeneration();
            }
        });

        frame.setSize(800, 585);
        frame.setResizable(true);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(crossroadPanel);
        crossroadPanel.setBounds(0,0,555,555);
        frame.getContentPane().add(optionPanel);
        optionPanel.setBounds(555,0,200,555);
        frame.setVisible(true);
    }

    private void setPoints() {
        int[] coordinateX = {163, 203, 243, 283, 323, 363, 405, 405, 405, 405, 405, 405, 363, 320, 280, 240, 200, 160, 120, 120, 120, 120, 120, 120};
        int[] coordinateY = {115, 115, 115, 115, 115, 115, 163, 203, 243, 283, 323, 363, 410, 410, 410, 410, 410, 410, 363, 320, 280, 240, 200, 160};
        int[] coordinateId = {33, 32, 31, 34, 35, 36, 23, 22, 21, 24, 25, 26, 13, 12, 11, 14, 15, 16, 43, 42, 41, 44, 45, 46};
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
        for (Integer i : map1.keySet()) {
            comboboxOrder.addItem(i);
        }
    }

    public void nextItem() {
        System.out.println("LALAL = " + map1.keySet().size());
        if (globalIndex < map1.keySet().size()) {
            if (isChecked) {
                map2.put(item, map1.get(globalIndex));
            }
            map1.remove(globalIndex);
            globalIndex++;
            System.out.println("GLOBAL INDEX = " + globalIndex);
        } else {
            System.out.println("зэтс инаф");
        }
        updateComboBox();
    }

    public void readMap(Map<Integer, String> map) {
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

    class RunGarland extends Thread {
        private final Object monitor = new Object();

        @Override
        public void run() {
            synchronized (monitor) {
                Set<int[]> stateTreeSet = UberStates.getStateTreeSet();
                Iterator<int[]> iterator = stateTreeSet.iterator();
                int[] lastLights = {};
                while (iterator.hasNext()) {

                    int[] tmp = iterator.next();
                    if (lastLights.length != 0) {
                        //      crossroadPanel.lightYellowLights(lastLights, tmp);
                    /*try {
                        wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    }

                    lastLights = new int[tmp.length];
                    for (int i = 0; i < tmp.length; i++) {
                        lastLights[i] = tmp[i];
                    }

                    crossroadPanel.lightGreenLights(tmp);
                    try {
                        monitor.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    crossroadPanel.lightRedLights(lastLights);
//                        wait(5000);
                }
            }
        }
    }
}
