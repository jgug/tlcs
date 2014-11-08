package by.bsuir.iba.crossroad;

import by.bsuir.iba.trafficlights.TrafficLight;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 07.11.14.
 */
public class Crossroad {
    private List<TrafficLight> trafficLightsList = new ArrayList<>();

    public List<TrafficLight> getTrafficLightsList() {
        return trafficLightsList;
    }

    public void setTrafficLightsList(List<TrafficLight> trafficLightsList) {
        this.trafficLightsList = trafficLightsList;
    }
}
