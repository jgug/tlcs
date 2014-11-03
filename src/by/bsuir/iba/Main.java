package by.bsuir.iba;

import by.bsuir.iba.enumerations.TrafficLightType;
import by.bsuir.iba.trafficlights.TrafficLight;
import by.bsuir.iba.trafficlights.abstractTraffiLight.AbstractTL;

public class Main {

    public static void main(String[] args) {
        AbstractTL trafficLight = TrafficLight.getInstance(TrafficLightType.ROAD);
        System.out.println(trafficLight.test());

        trafficLight = TrafficLight.getInstance(TrafficLightType.PEDESTRIAN);
        System.out.println(trafficLight.test());

        trafficLight = TrafficLight.getInstance(TrafficLightType.BICYCLE);
        System.out.println(trafficLight.test());
    }
}
