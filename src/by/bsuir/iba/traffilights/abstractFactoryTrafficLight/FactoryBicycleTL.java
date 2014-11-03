package by.bsuir.iba.traffilights.abstractFactoryTrafficLight;

import by.bsuir.iba.traffilights.abstractTraffiLight.AbstractTL;
import by.bsuir.iba.traffilights.abstractTraffiLight.BicycleTL;

/**
 * Created by Pavel on 03.11.14.
 */
public class FactoryBicycleTL implements AbstractFactoryTL {

    @Override
    public AbstractTL createTrafficLight() {
        return new BicycleTL();
    }

}
