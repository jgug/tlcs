package by.bsuir.iba.trafficlights;

import by.bsuir.iba.enumerations.TrafficLightType;
import by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.AbstractFactoryTL;
import by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.FactoryBicycleTL;
import by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.FactoryPedestrianTL;
import by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.FactoryRoadTL;
import by.bsuir.iba.trafficlights.abstractTraffiLight.AbstractTL;

/**
 * Class {@code TrafficLight} uses for creating
 * traffic light's instance depending of passing
 * to {@code getInstance} method parameter
 * @author Pavel Vashkel
 */

public class TrafficLight {

    /**
     * Public static method for creating a new instance
     * depending of passing to method parameter
     *
     * @param type
     * @return AbstractTL
     * @see by.bsuir.iba.trafficlights.abstractTraffiLight.AbstractTL
     * @see by.bsuir.iba.enumerations.TrafficLightType
     */
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
