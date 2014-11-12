package by.bsuir.iba.core.crossroad;

import by.bsuir.iba.core.configuration.Configuration;

import java.util.*;

/**
 * Class represent current state of a crossroad based on a conflict
 * matrix from a configuration file
 *
 * @author Pavel Vashkel
 * @author Ruslan Ardytski
 * @see java.util.ArrayList
 * @see java.util.Collections
 */
public class CrossroadState {
    @Deprecated
    private List<int[]> statesList = new ArrayList<>();
    private Map<Integer, int[]> treeTempMap = new TreeMap<>();
    private Map<Integer, int[]> stateMap = new TreeMap<>();
    private int currentPosition;
    private int listSize;

    /**
     * Instantiates a new Crossroad state.
     */
    public CrossroadState() {
        currentPosition = 0;
    }

    /**
     * Fill in LinkedList of 1D arrays with columns of conflict matrix
     *
     * @param arr is a conflict matrix as a 2D array of ints
     */
    @Deprecated
    public void setStatesList(int[][] arr) {
        arr = rotateMatrix(arr);
        Collections.addAll(statesList, arr);
        listSize = statesList.size();
    }

    /**
     * Gets state map.
     *
     * @return the state map
     */
    public Map<Integer, int[]> getStateMap() {
        return stateMap;
    }

    /**
     * Sets state map.
     *
     * @param arr the arr
     */
    public void setStateMap(int[][] arr) {

        Configuration configuration = Configuration.getInstance();
        int count = configuration.getRoads() + configuration.getPedestrianCount();
        int all = configuration.getLines() + configuration.getPedestrianCount();
        int[] right = configuration.getRightTurns();
        int[] left = configuration.getLeftTurns();
        int[] straight = configuration.getStraight();
        int[] pedestrian = configuration.getPedestrianCrossings();
        Integer[] indexes = new Integer[all];

        int counter = 0;
        for (int i = 1; i <= count; i++) {
            int second = 1;
            for (int k = 1; k <= right[i - 1]; k++) {
                indexes[counter] = getIndex(i, second);
                second++;
                counter++;
            }
            for (int k = 1; k <= straight[i - 1]; k++) {
                indexes[counter] = getIndex(i, second);
                second++;
                counter++;
            }
            for (int k = 1; k <= left[i - 1]; k++) {
                indexes[counter] = getIndex(i, second);
                second++;
                counter++;
            }
            if (configuration.getPedestrianCount() != 0) {
                for (int k = 1; k <= pedestrian[i - 1]; k++) {
                    indexes[counter] = getIndex(i, second);
                    second++;
                    counter++;
                }
            }
        }

        for (int i = 0; i < all; i++) {
            treeTempMap.put(i, arr[i]);
        }

        for (int i = 0; i < all; i++) {
            stateMap.put(indexes[i], treeTempMap.get(i));
        }
    }

    /**
     * Gets index.
     *
     * @param first  the first part of index
     * @param second the second part of index
     * @return the index
     */
    public int getIndex(int first, int second) {
        return Integer.parseInt(String.valueOf(first) + second);
    }

    /**
     * Method transpose matrix stored in a 2D array of ints
     *
     * @param arr matrix which should be transposed
     * @return transposed matrix as a 2D array of ints
     */
    public int[][] rotateMatrix(int[][] arr) {
        int size = arr.length;
        int array[][] = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[j][i] = arr[i][j];
            }
        }
        return array;
    }

    /**
     * Current map state.
     *
     * @return the int [ ]
     */
    public int[] currentMapState() {
        int arr[];
        List<int[]> list = new ArrayList<>(stateMap.values());
        if (currentPosition >= 0 && currentPosition < listSize) {
            arr = list.get(currentPosition);
        } else {
            arr = null;
        }
        testPrevNext(arr);
        return arr;
    }

    /**
     * Method returns current Crossroad state
     *
     * @return 1D array with current crossroad state
     */
    @Deprecated
    public int[] currentState() {
        int[] arr;
        if (currentPosition >= 0 && currentPosition < listSize) {
            arr = statesList.get(currentPosition);
        } else {
            arr = null;
        }
        testPrevNext(arr);
        return arr;
    }

    /**
     * Next map state.
     *
     * @return the int [ ]
     */
    public int[] nextMapState() {
        int[] arr;
        List<int[]> list = new ArrayList<>(stateMap.values());
        if (currentPosition < listSize) {
            currentPosition++;
            arr = list.get(currentPosition);
        } else {
            arr = null;
        }
        testPrevNext(arr);
        return arr;
    }

    /**
     * Method returns next Crossroad state
     *
     * @return 1D array with next Crossroad state
     */
    @Deprecated
    public int[] nextState() {
        int[] arr;
        if (currentPosition < listSize) {
            currentPosition++;
            arr = statesList.get(currentPosition);
        } else {
            arr = null;
        }
        testPrevNext(arr);
        return arr;
    }

    public int[] previousMapState() {
        int[] arr;
        List<int[]> list = new ArrayList<>(stateMap.values());
        if (currentPosition > 0) {
            currentPosition--;
            arr = list.get(currentPosition);
        } else {
            arr = null;
        }
        testPrevNext(arr);
        return arr;
    }

    /**
     * Method returns previous Crossroad state
     *
     * @return 1D array with previous Crossroad state
     */
    @Deprecated
    public int[] previousState() {
        int[] arr;
        if (currentPosition > 0) {
            currentPosition--;
            arr = statesList.get(currentPosition);
        } else {
            arr = null;
        }
        testPrevNext(arr);
        return arr;
    }

    /**
     * Test void.
     */
    public void test() {
        for (int[] a : statesList) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /**
     * Test prev next.
     *
     * @param arr the arr
     */
    public void testPrevNext(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
