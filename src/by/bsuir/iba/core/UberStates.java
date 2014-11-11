package by.bsuir.iba.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The type Uber states.
 */
public class UberStates {
    Map<Integer, int[]> treeMap = new TreeMap<>();
    Map<Integer, int[]> treeMap2 = new TreeMap<>();
    Map<Integer, int[]> treeMap3 = new TreeMap<>();
    List<Map<Integer, int[]>> statesList = new ArrayList<>();

    /**
     * Sets hash map.
     *
     * @param hashMap the hash map
     */
    public void setHashMap(Map<Integer, int[]> hashMap) {
        treeMap = hashMap;
    }

    /**
     * Make me good.
     */
    public void makeMeGood() {

        Integer[] keys = treeMap.keySet().toArray(new Integer[treeMap.keySet().size()]);
        Map<Integer, Integer> ratio = new TreeMap<>();
        for (int i = 0; i < keys.length; i++) {
            ratio.put(i, keys[i]);
        }

        // This part delete non-friends
        int count = 0;
        for (Integer i : keys) {
            treeMap2 = copy(treeMap);
            for (Integer j : keys) {
                treeMap2 = copy(treeMap);
                if (getElement(treeMap.get(i), count) != getElement(treeMap.get(j), count)) {
                    treeMap2.remove(j);
                }
            }
            count++;
            statesList.add(treeMap2);
        }

        // Вот это вот всё должно удалять соответствующие строки. Работатет по моей безумной идее так:
        // итерируется сперва по всем хэшмэпам в листе, потом по массивам в хэшмэпе,
        // сравнивая выбранный с остальными на предмет нулей на одинаковых позициях (ещё один цикл). Далее для
        // каждого массивы вызывается метод isBro, который принимает два массива и сравнивает их по вышеописанному
        // принципу. Возвращает сие чудо массив с индексами тех, которые не совпали,
        // дабы потом получая соотношения из ratio хэшмэпа поудалять их. Или же возвражает null,
        // если несовпадений не выявлено. Проблемма на данный момент в том, что в 4й по счёту цикл "for" (we need to
        // go deeper...) что-то оно брезгует заходить...
        Integer[] newKeys = treeMap2.keySet().toArray(new Integer[treeMap2.keySet().size()]);
        for (Map<Integer, int[]> map : statesList) {
            treeMap3 = copy(map);
            for (Integer j : newKeys) {
//                treeMap3 = copy(map);
                for (Integer l : newKeys) {
                    Integer[] arr = isBro(map.get(j), treeMap3.get(l));
                    if (arr != null) {
                        for (Integer i = 0; i < arr.length; i++) {
                        }
                    }
                }
            }
        }

    }

    /**
     * Copy map.
     *
     * @param tm the tm
     * @return the map
     */
    public Map<Integer, int[]> copy(Map<Integer, int[]> tm) {
        Map<Integer, int[]> tm1 = new TreeMap<>();
        for (Integer j : tm.keySet()) {
            tm1.put(j, tm.get(j));
        }
        return tm1;
    }

    /**
     * Show void.
     */
    public void show() {
        System.out.println("ALL");
        for (Map<Integer, int[]> map : statesList) {
            for (Integer j : map.keySet()) {
                for (int l : map.get(j)) {
                    System.out.print(l + " ");
                }
                System.out.println(" ");
            }
            System.out.println(" ");
        }
    }

    /**
     * Gets element.
     *
     * @param arr     the arr
     * @param element the element
     * @return the element
     */
    public int getElement(int[] arr, int element) {
        return arr[element];
    }

    /**
     * Is bro.
     *
     * @param arr1 the arr 1
     * @param arr2 the arr 2
     * @return the integer [ ]
     */
    public Integer[] isBro(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        boolean b = true;
        if (arr1 != null && arr2 != null) {
            if (arr1.length == arr2.length) {
                for (int i = 0; i < arr1.length; i++) {
                    if (arr1[i] == 0 && arr1[i] != arr2[i]) {
                        list.add(i);
                        b = false;
                    }
                    System.out.println(list);
                }
            }
        }
        if (b) {
            return list.toArray(new Integer[list.size()]);
        } else {
            return null;
        }
    }

}
