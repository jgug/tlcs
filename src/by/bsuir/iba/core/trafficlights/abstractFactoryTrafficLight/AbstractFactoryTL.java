package by.bsuir.iba.core.trafficlights.abstractFactoryTrafficLight;

import by.bsuir.iba.core.trafficlights.abstractTraffiLight.AbstractTL;

/**
 * AbstractFactoryTL interface
 *
 * @author Pavel Vashkel
 */
public interface AbstractFactoryTL {

    /**
     * Public method for creating concrete traffic light
     * according to using factory
     *
     * @return {@code AbstractTL}
     */
    public AbstractTL createTrafficLight();

}
