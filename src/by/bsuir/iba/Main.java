package by.bsuir.iba;

import by.bsuir.iba.gui.MainFrame;

public class Main {

    public static void main(String[] args) {

//        ConfigurationLoader configurationLoader = new ConfigurationLoader();
//        configurationLoader.setPath("D:\\6__WORK\\Java\\TLCS\\resources" +
//                "\\configurations\\TLCS.properties");
////        configurationLoader.setPath
////                ("D:\\Java\\TLCS\\resources\\configurations\\TLCS" +
////                        ".properties");
//        configurationLoader.load();
        new MainFrame().initComponents();

    }
}
