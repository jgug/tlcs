package by.bsuir.iba.core.trafficlights.abstractFactoryTrafficLight;

import by.bsuir.iba.core.trafficlights.abstractTraffiLight.AbstractTL;
import by.bsuir.iba.core.trafficlights.abstractTraffiLight.RoadTL;

/**
 * Class {@code FactoryRoadTL} implements {@code AbstractFactoryTL}
 * and uses for creating road traffic light
 *
 * @author Pavel Vashkel
 * @see by.bsuir.iba.core.trafficlights.abstractFactoryTrafficLight
 * .AbstractFactoryTL
 */
public class FactoryRoadTL implements AbstractFactoryTL {

    @Override
    public AbstractTL createTrafficLight() {
        return new RoadTL();
    }

}
