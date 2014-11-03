package by.bsuir.iba.trafficlights.abstractTraffiLight;

import by.bsuir.iba.enumerations.TrafficLightColor;

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
     * @param tlc
     */
    public void setLight(TrafficLightColor tlc);

    /**
     * Test method
     *
     * @return {@code String}
     * @see java.lang.String
     */
    public String test();

}
