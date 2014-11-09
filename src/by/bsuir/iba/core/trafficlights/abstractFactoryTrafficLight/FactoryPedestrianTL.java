package by.bsuir.iba.core.trafficlights.abstractFactoryTrafficLight;

import by.bsuir.iba.core.trafficlights.abstractTraffiLight.AbstractTL;
import by.bsuir.iba.core.trafficlights.abstractTraffiLight.PedestrianTL;

/**
 * Class {@code FactoryPedestrianTL} implements {@code AbstractFactoryTL}
 * and uses for creating pedestrian traffic light
 *
 * @author Pavel Vashkel
 * @see by.bsuir.iba.core.trafficlights.abstractFactoryTrafficLight
 * .AbstractFactoryTL
 */
public class FactoryPedestrianTL implements AbstractFactoryTL {

    @Override
    public AbstractTL createTrafficLight() {
        return new PedestrianTL();
    }

}
