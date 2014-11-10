package by.bsuir.iba.core.crossroad;

import by.bsuir.iba.core.configuration.Configuration;
import by.bsuir.iba.core.roadline.RoadLine;
import by.bsuir.iba.core.trafficlights.TrafficLight;
import by.bsuir.iba.core.trafficlights.abstractFactoryTrafficLight.FactoryPedestrianTL;
import by.bsuir.iba.core.trafficlights.abstractFactoryTrafficLight.FactoryRoadTL;
import by.bsuir.iba.core.trafficlights.abstractTraffiLight.AbstractTL;

import java.util.ArrayList;

/**
 * {@code Crossroad} class represents crossroad.
 * {@code List<AbstractTL> trafficLightsList} stores traffic lights included
 * in a crossroad bases on configuration file.
 * {@code List<RoadLine> roadLinesList} stores road lines included in a
 * crossroad bases on configuration file.
 *
 * @author Pavel Vashkel
 * @see by.bsuir.iba.core.trafficlights.abstractTraffiLight.AbstractTL
 * @see by.bsuir.iba.core.trafficlights.TrafficLight
 * @see by.bsuir.iba.core.roadline.RoadLine
 * @see by.bsuir.iba.core.configuration.Configuration
 * @see java.util.ArrayList
 */
public class Crossroad {
    ArrayList<AbstractTL> trafficLightsList;
    ArrayList<RoadLine> roadLinesList;
    CrossroadState crossroadState = new CrossroadState();

    /**
     * Instantiates a new Crossroad.
     *
     * @param configuration the configuration
     */
    public Crossroad(Configuration configuration) {
        int lines = configuration.getLines();
        int pedestrian = configuration.getPedestrianCount();

        for (int i = 0; i < lines; i++) {
            roadLinesList.add(new RoadLine(i));
            trafficLightsList.add(TrafficLight.getInstance(new FactoryRoadTL()));
        }

        for (int i = 0; i < pedestrian; i++) {
            trafficLightsList.add(TrafficLight.getInstance(new
                    FactoryPedestrianTL()));
        }
    }

    /**
     * Gets crossroad state.
     *
     * @return the crossroad state
     */
    public CrossroadState getCrossroadState() {
        return crossroadState;
    }
}
