package by.bsuir.iba.trafficlights.abstractFactoryTrafficLight;

import by.bsuir.iba.trafficlights.abstractTraffiLight.AbstractTL;
import by.bsuir.iba.trafficlights.abstractTraffiLight.BicycleTL;

/**
 * Class {@code FactoryBicycleTL} implements {@code AbstractFactoryTL}
 * and uses for creating bicycle traffic light
 *
 * @author Pavel Vashkel
 * @see by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.AbstractFactoryTL
 */
public class FactoryBicycleTL implements AbstractFactoryTL {

    @Override
    public AbstractTL createTrafficLight() {
        return new BicycleTL();
    }

}
