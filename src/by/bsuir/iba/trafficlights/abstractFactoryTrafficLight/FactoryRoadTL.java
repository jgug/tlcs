package by.bsuir.iba.trafficlights.abstractFactoryTrafficLight;

import by.bsuir.iba.trafficlights.abstractTraffiLight.AbstractTL;
import by.bsuir.iba.trafficlights.abstractTraffiLight.RoadTL;

/**
 * Created by Pavel on 03.11.14.
 */
public class FactoryRoadTL implements AbstractFactoryTL {

    @Override
    public AbstractTL createTrafficLight() {
        return new RoadTL();
    }

}
