package by.bsuir.iba.crossroad;

import by.bsuir.iba.configuration.Configuration;
import by.bsuir.iba.roadline.RoadLine;
import by.bsuir.iba.trafficlights.TrafficLight;
import by.bsuir.iba.trafficlights.abstractFactoryTrafficLight
        .FactoryPedestrianTL;
import by.bsuir.iba.trafficlights.abstractFactoryTrafficLight.FactoryRoadTL;
import by.bsuir.iba.trafficlights.abstractTraffiLight.AbstractTL;

import java.util.ArrayList;

/**
 * {@code Crossroad} class represents crossroad.
 * {@code List<AbstractTL> trafficLightsList} stores traffic lights included
 * in a crossroad bases on configuration file.
 * {@code List<RoadLine> roadLinesList} stores road lines included in a
 * crossroad bases on configuration file.
 *
 * @author Pavel Vashkel
 * @see by.bsuir.iba.trafficlights.abstractTraffiLight.AbstractTL
 * @see by.bsuir.iba.trafficlights.TrafficLight
 * @see by.bsuir.iba.roadline.RoadLine
 * @see by.bsuir.iba.configuration.Configuration
 * @see java.util.ArrayList
 */
public class Crossroad {
    ArrayList<AbstractTL> trafficLightsList;
    ArrayList<RoadLine> roadLinesList;

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
            trafficLightsList.add(TrafficLight.getInstance(new FactoryRoadTL
                    ()));
        }

        for (int i = 0; i < pedestrian; i++) {
            trafficLightsList.add(TrafficLight.getInstance(new
                    FactoryPedestrianTL()));
        }
    }
}
