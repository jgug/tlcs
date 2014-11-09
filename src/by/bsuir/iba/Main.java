package by.bsuir.iba;

import by.bsuir.iba.core.configuration.ConfigurationLoader;
import by.bsuir.iba.gui.MainFrame;

public class Main {

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setConfigs();
        frame.initComponents();
    }
}
