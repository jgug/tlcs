package by.bsuir.iba;

import by.bsuir.iba.trafficlights.TrafficLight;
import by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.FactoryBicycleTL;
import by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.FactoryPedestrianTL;
import by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.FactoryRoadTL;

public class Main {

    public static void main(String[] args) {

        TrafficLight trafficLight;

        trafficLight = new TrafficLight(new FactoryRoadTL());
        System.out.println(trafficLight.test());

        trafficLight = new TrafficLight(new FactoryPedestrianTL());
        System.out.println(trafficLight.test());

        trafficLight = new TrafficLight(new FactoryBicycleTL());
        System.out.println(trafficLight.test());

    }
}
