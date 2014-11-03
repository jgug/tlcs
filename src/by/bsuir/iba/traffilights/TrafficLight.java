package by.bsuir.iba.traffilights;

import by.bsuir.iba.enumerations.TrafficLightColor;
import by.bsuir.iba.traffilights.abstractFactoryTrafficLight.AbstractFactoryTL;
import by.bsuir.iba.traffilights.abstractTraffiLight.AbstractTL;

/**
 * Created by Pavel on 03.11.14.
 */
public class TrafficLight implements AbstractTL {
    AbstractTL trafficLight;

    public TrafficLight(AbstractFactoryTL factory) {

        trafficLight = factory.createTrafficLight();

    }

    @Override
    public TrafficLightColor getLight() {
        return trafficLight.getLight();
    }

    @Override
    public void setLight(TrafficLightColor tlc) {
        trafficLight.setLight(tlc);
    }

    @Override
    public String test() {
        return trafficLight.test();
    }
}
