package by.bsuir.iba.trafficlights.abstractTraffiLight;

import by.bsuir.iba.enumerations.TrafficLightColor;
import by.bsuir.iba.enumerations.TrafficLightType;

/**
 * Created by Pavel on 03.11.14.
 */
public class BicycleTL implements AbstractTL {
    private TrafficLightColor color;
    private TrafficLightType type = TrafficLightType.BICYCLE;

    @Override
    public TrafficLightColor getLight() {
        return color;
    }

    @Override
    public void setLight(TrafficLightColor tlc) {
        color = tlc;
    }

    @Override
    public String test() {
        return "I'm a " + this.getClass().toString();
    }
}
