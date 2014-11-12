package by.bsuir.iba.gui;

import by.bsuir.iba.core.configuration.Configuration;
import by.bsuir.iba.core.configuration.ConfigurationLoader;
import by.bsuir.iba.core.crossroad.CrossroadState;
import by.bsuir.iba.core.logic.States;

/**
 * Class configurate and manage crossroad
 *
 * @author Ruslan Ardytski
 * @see by.bsuir.iba.core.configuration.ConfigurationLoader
 * @see by.bsuir.iba.core.crossroad.CrossroadState
 * @see by.bsuir.iba.core.configuration.Configuration
 * @see by.bsuir.iba.gui.MainFrame
 */
public class CrossroadCommander {
    public void startFun() {
        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        configurationLoader.setPath("resources\\configurations\\TLCS.properties");
        configurationLoader.load();

        CrossroadState state = new CrossroadState();
        state.setStateMap(Configuration.getInstance().getConflictMatrix());

        States states = new States();
        states.setHashMap(state.getStateMap());
        states.recognizeStates();

        MainFrame frame = new MainFrame();
        frame.setConfigs();
        frame.initComponents();
    }
}
