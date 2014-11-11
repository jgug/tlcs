package by.bsuir.iba;

import by.bsuir.iba.core.UberStates;
import by.bsuir.iba.core.configuration.Configuration;
import by.bsuir.iba.core.configuration.ConfigurationLoader;
import by.bsuir.iba.core.crossroad.CrossroadState;
import by.bsuir.iba.gui.CrossroadCommander;

public class Main {

    public static void main(String[] args) {
        CrossroadCommander commander = new CrossroadCommander();
        commander.startFun();

        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        configurationLoader.setPath("D:\\6__WORK\\Java\\TLCS\\resources\\configurations\\TLCS.properties");
        configurationLoader.load();

        CrossroadState state = new CrossroadState();
        state.setStateMap(Configuration.getInstance().getConflictMatrix());

        UberStates uberStates = new UberStates();
        uberStates.setHashMap(state.getStateMap());
        uberStates.makeMeGood();
//        uberStates.show();
    }
}
