package by.bsuir.iba;

import by.bsuir.iba.trafficlights.TrafficLight;
import by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.FactoryBicycleTL;
import by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.FactoryPedestrianTL;
import by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.FactoryRoadTL;
import by.bsuir.iba.trafficlights.abstractTraffiLight.AbstractTL;

public class Main {

    public static void main(String[] args) {
        AbstractTL trafficLight = TrafficLight.getInstance(new FactoryRoadTL());
        System.out.println(trafficLight.test());

        trafficLight = TrafficLight.getInstance(new FactoryPedestrianTL());
        System.out.println(trafficLight.test());

        trafficLight = TrafficLight.getInstance(new FactoryBicycleTL());
        System.out.println(trafficLight.test());
    }
}
