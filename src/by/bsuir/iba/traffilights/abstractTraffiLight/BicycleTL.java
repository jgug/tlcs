package by.bsuir.iba.traffilights.abstractTraffiLight;

import by.bsuir.iba.enumerations.TrafficLightColor;

/**
 * Created by Pavel on 03.11.14.
 */
public class BicycleTL implements AbstractTL {
    private TrafficLightColor color;

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
