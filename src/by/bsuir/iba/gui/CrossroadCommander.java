package by.bsuir.iba.gui;

import by.bsuir.iba.core.configuration.Configuration;
import by.bsuir.iba.core.crossroad.Crossroad;

/**
 * Created by Ruslan on 09.11.14.
 */
public class CrossroadCommander {
    public void startFun(){
        MainFrame frame = new MainFrame();
        frame.setConfigs();
        frame.initComponents();
        frame.generateTransport();
        Crossroad crossroad = new Crossroad(Configuration.getInstance());
        crossroad.getCrossroadState();
    }
}
