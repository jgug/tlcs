package by.bsuir.iba.trafficlights.abstractFactoryTrafficLight;

import by.bsuir.iba.trafficlights.abstractTraffiLight.AbstractTL;
import by.bsuir.iba.trafficlights.abstractTraffiLight.RoadTL;

/**
 * Class {@code FactoryRoadTL} implements {@code AbstractFactoryTL}
 * and uses for creating road traffic light
 *
 * @author Pavel Vashkel
 * @see by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.AbstractFactoryTL
 */
public class FactoryRoadTL implements AbstractFactoryTL {

    @Override
    public AbstractTL createTrafficLight() {
        return new RoadTL();
    }

}
