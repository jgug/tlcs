package by.bsuir.iba;

import by.bsuir.iba.configuration.ConfigurationLoaderNew;

public class Main {

    public static void main(String[] args) {
//        AbstractTL trafficLight = TrafficLight.getInstance(new FactoryRoadTL());
//        System.out.println(trafficLight.test());
//
//        trafficLight = TrafficLight.getInstance(new FactoryPedestrianTL());
//        System.out.println(trafficLight.test());
//
//        trafficLight = TrafficLight.getInstance(new FactoryBicycleTL());
//        System.out.println(trafficLight.test());

        ConfigurationLoaderNew configurationLoaderNew = new ConfigurationLoaderNew();
        configurationLoaderNew.setPath("D:\\6__WORK\\Java\\TLCS\\resources\\configurations\\TLCS.properties");
        configurationLoaderNew.load();

    }
}
