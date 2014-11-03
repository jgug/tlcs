package by.bsuir.iba.trafficlights.abstractFactoryTrafficLight;

import by.bsuir.iba.trafficlights.abstractTraffiLight.AbstractTL;
import by.bsuir.iba.trafficlights.abstractTraffiLight.PedestrianTL;

/**
 * Class {@code FactoryPedestrianTL} implements {@code AbstractFactoryTL}
 * and uses for creating pedestrian traffic light
 *
 * @author Pavel Vashkel
 * @see by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.AbstractFactoryTL
 */

public class FactoryPedestrianTL implements AbstractFactoryTL {

    @Override
    public AbstractTL createTrafficLight() {
        return new PedestrianTL();
    }

}
