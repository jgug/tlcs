package by.bsuir.iba.trafficlights;

import by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.AbstractFactoryTL;
import by.bsuir.iba.trafficlights.abstractTraffiLight.AbstractTL;

/**
 * Class {@code TrafficLight} uses for creating
 * traffic light's instance depending of passing
 * to {@code getInstance} method parameter
 *
 * @author Pavel Vashkel
 */

public class TrafficLight {

    /**
     * Public static method for creating a new instance
     * depending of passing to method traffic light factory
     *
     * @param factory is passing to method traffic light factory
     * @return AbstractTL
     * @see by.bsuir.iba.trafficlights.abstractTraffiLight.AbstractTL
     * @see by.bsuir.iba.enumerations.TrafficLightType
     */
    public static AbstractTL getInstance(AbstractFactoryTL factory) {
        return factory.createTrafficLight();
    }

}
