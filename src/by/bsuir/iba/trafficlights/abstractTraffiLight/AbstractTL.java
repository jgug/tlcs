package by.bsuir.iba.trafficlights.abstractTraffiLight;

import by.bsuir.iba.enumerations.TrafficLightColor;
import by.bsuir.iba.enumerations.TrafficLightType;

/**
 * AbstractTrafficLight abstract class
 *
 * @author Pavel Vashkel
 */
public abstract class AbstractTL {
    private TrafficLightColor light;
    private TrafficLightType type;

    /**
     * Method for getting Traffic Light color
     *
     * @return {@code TrafficLightColor}
     */
    public TrafficLightColor getLight() {
        return light;
    }

    /**
     * Method fot setting Traffic Light color
     *
     * @param light is passing to method light color
     */
    public void setLight(TrafficLightColor light) {
        this.light = light;
    }

    /**
     * Method for getting Traffic Light type
     *
     * @return {@code TrafficLightType}
     */
    public TrafficLightType getType() {
        return type;
    }

    /**
     * Test method
     *
     * @return {@code String}
     * @see java.lang.String
     */
    public abstract String test();

}
