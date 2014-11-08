package by.bsuir.iba;

import by.bsuir.iba.configuration.Configuration;
import by.bsuir.iba.configuration.ConfigurationLoader;
import by.bsuir.iba.crossroad.CrossroadState;

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

        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        configurationLoader.setPath("D:\\6__WORK\\Java\\TLCS\\resources\\configurations\\TLCS.properties");
        configurationLoader.load();

        CrossroadState crossroadState = new CrossroadState();
        crossroadState.setStatesList(Configuration.getInstance().getConflictMatrix());
        System.out.println("Get current");
        crossroadState.currentState();
        System.out.println("Get next");
        crossroadState.nextState();
        System.out.println("Get previous");
        crossroadState.previousState();
        System.out.println("Get next");
        crossroadState.nextState();
        crossroadState.nextState();
        System.out.println("Get previous");
        crossroadState.previousState();

    }
}
