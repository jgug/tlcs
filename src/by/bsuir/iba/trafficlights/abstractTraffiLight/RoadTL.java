package by.bsuir.iba.trafficlights.abstractTraffiLight;

import by.bsuir.iba.enumerations.TrafficLightColor;
import by.bsuir.iba.enumerations.TrafficLightType;

/**
 * class {@code RoadTL} implements AbstractTL
 * Have private fields {@code color} and {@code type}
 * to specify traffic light's type and current color
 *
 * @author Pavel Vashkel
 * @see by.bsuir.iba.trafficlights.abstractTraffiLight.AbstractTL
 */

public class RoadTL implements AbstractTL {
    private static final TrafficLightType type = TrafficLightType.ROAD;
    private TrafficLightColor color;

    @Override
    public TrafficLightColor getLight() {
        return color;
    }

    @Override
    public void setLight(TrafficLightColor color) {
        this.color = color;
    }

    @Override
    public TrafficLightType getType() {
        return type;
    }

    @Override
    public String test() {
        return "I'm a " + this.getClass().toString();
    }
}
