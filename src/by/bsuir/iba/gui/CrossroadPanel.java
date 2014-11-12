package by.bsuir.iba.gui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Ruslan Ardytski
 * @author Pavel Vashkel
 */
public class CrossroadPanel extends JPanel {
    HashMap<Integer, TrafficLine> trafficLineHashMap = new HashMap<>();
    Image image;
    ScheduledExecutorService executor;
    int[] temparr;

    /**
     * Instantiates a new Crossroad panel.
     */
    public CrossroadPanel() {
        try {
            image = javax.imageio.ImageIO.read(new java.io.File("resources\\images\\14.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Calls the UI delegate's paint method, if the UI delegate
     * is non-<code>null</code>.  We pass the delegate a copy of the
     * <code>Graphics</code> object to protect the rest of the
     * paint code from irrevocable changes
     * (for example, <code>Graphics.translate</code>).
     * <p/>
     * If you override this in a subclass you should not make permanent
     * changes to the passed in <code>Graphics</code>. For example, you
     * should not alter the clip <code>Rectangle</code> or modify the
     * transform. If you need to do these operations you may find it
     * easier to create a new <code>Graphics</code> from the passed in
     * <code>Graphics</code> and manipulate it. Further, if you do not
     * invoker super's implementation you must honor the opaque property,
     * that is
     * if this component is opaque, you must completely fill in the background
     * in a non-opaque color. If you do not honor the opaque property you
     * will likely see visual artifacts.
     * <p/>
     * The passed in <code>Graphics</code> object might
     * have a transform other than the identify transform
     * installed on it.  In this case, you might get
     * unexpected results if you cumulatively apply
     * another transform.
     *
     * @param g the <code>Graphics</code> object to protect
     * @see #paint
     * @see java.awt.Component
     */
    @Override
    protected void paintComponent(Graphics g) {
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
                        tmpY = tmpLine.y + 100;
                        break;
                    case 2:
                        tmpX = tmpLine.x + 100;
                        tmpY = tmpLine.y;
                        break;
                    case 3:
                        tmpX = tmpLine.x;
                        tmpY = tmpLine.y - 100;
                        break;
                    case 4:
                        tmpX = tmpLine.x - 100;
                        tmpY = tmpLine.y;
                        break;
                    default:
                        tmpX = tmpLine.x;
                        tmpY = tmpLine.y;
                }
                tmpLine.displayQueue.setBounds(tmpX, tmpY, 40, 25);
            }
        }
    }

    /**
     * Add traffic line.
     *
     * @param t the t
     */
    public void addTrafficLine(TrafficLine t) {
        trafficLineHashMap.put(t.lineId, t);
    }

    /**
     * Decrement lines.
     *
     * @param arr the arr
     */
    public synchronized void decrementLines(int[] arr) {
        int timeDelay = TrafficLine.getTimetogo();
        final int[] temp = arr;
        executor = Executors.newScheduledThreadPool(1);
        executor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < temp.length; i++) {
                    TrafficLine trafficLine = trafficLineHashMap.get(temp[i]);
                    trafficLine.outgoingCars();
                }
            }
        }, 0, timeDelay, TimeUnit.MILLISECONDS);
    }

    /**
     * Light green lights.
     *
     * @param lights the lights
     */
    public synchronized void lightGreenLights(int[] lights) {
        temparr = lights;
        Decrementer dec = new Decrementer();
        dec.start();
        for (int i = 0; i < lights.length; i++) {
            TrafficLine tmpLine = trafficLineHashMap.get(lights[i]);
            tmpLine.lightGreen();
        }
        this.repaint();
    }

    public synchronized void lightYellowLights(int[] lights) {
        executor.shutdown();
        for (int i = 0; i < lights.length; i++) {
            TrafficLine tmpLine = trafficLineHashMap.get(lights[i]);
            tmpLine.lightYellow();
        }
        this.repaint();
    }

    public synchronized void lightRedLights(int[] lights) {
        executor.shutdown();
        for (int i = 0; i < lights.length; i++) {
            TrafficLine tmpLine = trafficLineHashMap.get(lights[i]);
            tmpLine.lightRed();
        }
        this.repaint();
    }

    /**
     * The type Decrementer. Run in a new thread decrementing number of cars in a line
     * when green light is on
     */
    class Decrementer extends Thread {
        @Override
        public void run() {
            synchronized (this) {
                decrementLines(temparr);
            }
        }
    }
}
