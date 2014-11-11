package by.bsuir.iba.gui;

import by.bsuir.iba.core.UberStates;
import by.bsuir.iba.core.configuration.Configuration;
import by.bsuir.iba.core.configuration.ConfigurationLoader;
import by.bsuir.iba.core.crossroad.CrossroadState;

/**
 * Created by Ruslan on 09.11.14.
 */
public class CrossroadCommander {
    public void startFun(){


        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        configurationLoader.setPath("D:\\Java\\TLCS\\resources\\configurations\\TLCS.properties");
        configurationLoader.load();
        CrossroadState state = new CrossroadState();
        state.setStateMap(Configuration.getInstance().getConflictMatrix());

        UberStates uberStates = new UberStates();
        uberStates.setHashMap(state.getStateMap());
        uberStates.recognizeStates();

        MainFrame frame = new MainFrame();
        frame.setConfigs();
        frame.initComponents();
//        Crossroad crossroad = new Crossroad(Configuration.getInstance());
//        crossroad.getCrossroadState();
    }
}
