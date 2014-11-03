package by.bsuir.iba.traffilights.abstractFactoryTrafficLight;

import by.bsuir.iba.traffilights.abstractTraffiLight.AbstractTL;
import by.bsuir.iba.traffilights.abstractTraffiLight.PedestrianTL;

/**
 * Created by Pavel on 03.11.14.
 */
public class FactoryPedestrianTL implements AbstractFactoryTL {

    @Override
    public AbstractTL createTrafficLight() {
        return new PedestrianTL();
    }

}
