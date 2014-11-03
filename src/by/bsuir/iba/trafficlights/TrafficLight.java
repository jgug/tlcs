package by.bsuir.iba.trafficlights;

import by.bsuir.iba.enumerations.TrafficLightColor;
import by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.AbstractFactoryTL;
import by.bsuir.iba.trafficlights.abstractTraffiLight.AbstractTL;

/**
 * Created by Pavel on 03.11.14.
 */
 // Немного не то, что надо
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
