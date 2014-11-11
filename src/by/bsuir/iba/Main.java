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
    }
}
