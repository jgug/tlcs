package by.bsuir.iba.trafficlights.abstractTraffiLight;

import by.bsuir.iba.enumerations.TrafficLightColor;
import by.bsuir.iba.enumerations.TrafficLightType;

/**
 * AbstractTrafficLight interface
 *
 * @author Pavel Vashkel
 */

public interface AbstractTL {

    /**
     * Method for getting Traffic Light color
     *
     * @return {@code TrafficLightColor}
     */
    public TrafficLightColor getLight();

    /**
     * Method fot setting Traffic Light color
     *
     * @param tlc is passing to method light color
     */
    public void setLight(TrafficLightColor tlc);

    /**
     * Method for getting Traffic Light type
     *
     * @return {@code TrafficLightType}
     */
    public TrafficLightType getType();

    /**
     * Test method
     *
     * @return {@code String}
     * @see java.lang.String
     */
    public String test();

}
