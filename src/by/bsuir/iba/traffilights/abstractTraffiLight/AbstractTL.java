package by.bsuir.iba.traffilights.abstractTraffiLight;

import by.bsuir.iba.enumerations.TrafficLightColor;

/**
 * Created by Pavel on 03.11.14.
 */
public interface AbstractTL {

    public TrafficLightColor getLight();

    public void setLight(TrafficLightColor tlc);

    public String test();

}
