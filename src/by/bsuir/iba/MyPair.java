package by.bsuir.iba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by Pavel on 08.11.14.
 */
public class MyPair<RoadLine, TrafficLight> implements Map.Entry<RoadLine,
        TrafficLight> {
    private TrafficLight[] trafficLight;
    private RoadLine[] roadLine;
    private int size;

    public MyPair() {
        size = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyPair)) return false;

        MyPair myPair = (MyPair) o;

        if (!Arrays.equals(roadLine, myPair.roadLine)) return false;
        if (!Arrays.equals(trafficLight, myPair.trafficLight)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(trafficLight);
        result = 31 * result + Arrays.hashCode(roadLine);
        return result;
    }

    @Override
    public RoadLine getKey() {
        return null;
    }

    @Override
    public TrafficLight getValue() {
        return null;
    }

    @Override
    public TrafficLight setValue(TrafficLight value) {
        return null;
    }

    public void add(RoadLine r, TrafficLight t) {
        Arrays.copyOf(roadLine, size);
        Arrays.copyOf(trafficLight, size);
        roadLine[size] = r;
        trafficLight[size] = t;
        size++;
    }


    public void addAll(ArrayList<RoadLine> alr, ArrayList<TrafficLight> alt) {
    }

}
