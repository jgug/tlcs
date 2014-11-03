package by.bsuir.iba.trafficlights.abstractFactoryTrafficLight;

import by.bsuir.iba.trafficlights.abstractTraffiLight.AbstractTL;
import by.bsuir.iba.trafficlights.abstractTraffiLight.BicycleTL;

/**
 * Created by Pavel on 03.11.14.
 */
public class FactoryBicycleTL implements AbstractFactoryTL {

    @Override
    public AbstractTL createTrafficLight() {
        return new BicycleTL();
    }

}
