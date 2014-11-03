package by.bsuir.iba.trafficlights;

import by.bsuir.iba.enumerations.TrafficLightType;
import by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.AbstractFactoryTL;
import by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.FactoryBicycleTL;
import by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.FactoryPedestrianTL;
import by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.FactoryRoadTL;
import by.bsuir.iba.trafficlights.abstractTraffiLight.AbstractTL;

/**
 * Created by Pavel on 03.11.14.
 */
public class TrafficLight {

    public static AbstractTL getInstance(TrafficLightType type) {
        AbstractFactoryTL factory;
        switch (type) {
            case ROAD: {
                factory = new FactoryRoadTL();
                return factory.createTrafficLight();
            }
            case PEDESTRIAN: {
                factory = new FactoryPedestrianTL();
                return factory.createTrafficLight();
            }
            case BICYCLE: {
                factory = new FactoryBicycleTL();
                return factory.createTrafficLight();
            }
        }
        return null;
    }

}
