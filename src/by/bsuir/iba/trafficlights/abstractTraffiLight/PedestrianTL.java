package by.bsuir.iba.trafficlights.abstractTraffiLight;

import by.bsuir.iba.enumerations.TrafficLightColor;
import by.bsuir.iba.enumerations.TrafficLightType;

/**
 * Created by Pavel on 03.11.14.
 */
public class PedestrianTL implements AbstractTL {
    private TrafficLightColor color;
    private TrafficLightType type = TrafficLightType.PEDESTRIAN;

    public PedestrianTL() {
    }

    @Override
    public TrafficLightColor getLight() {
        return color;
    }

    @Override
    public void setLight(TrafficLightColor tlc) {
        tlc = color;
    }

    @Override
    public String test() {
        return "I'm a " + this.getClass().toString();
    }
}
