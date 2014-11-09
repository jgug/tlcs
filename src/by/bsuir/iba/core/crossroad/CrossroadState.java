package by.bsuir.iba.core.crossroad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class represent current state of a crossroad based on a conflict
 * matrix from a configuration file
 *
 * @author Pavel Vashkel
 * @see java.util.ArrayList
 * @see java.util.Collections
 */
public class CrossroadState {
    private List<int[]> statesList = new ArrayList<>();
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
    public void setStatesList(int[][] arr) {
        arr = rotateMatrix(arr);
        Collections.addAll(statesList, arr);
        listSize = statesList.size();
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
     * Method returns current Crossroad state
     *
     * @return 1D array with current crossroad state
     */
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
     * Method returns next Crossroad state
     *
     * @return 1D array with next Crossroad state
     */
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

    /**
     * Method returns previous Crossroad state
     *
     * @return 1D array with previous Crossroad state
     */
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
