package by.bsuir.iba.core;

import java.util.*;

/**
 * The type Uber states.
 */
public class UberStates {
    private static final int USED = Integer.MAX_VALUE;
    ArrayList<int[]> friendsCombArrayList;
    Map<Integer, int[]> treeMap = new TreeMap<>();
    HashSet stateHashSet = new HashSet();
    int[] adventurer;

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

        for (int i : keys) {
            System.out.println("-------------------------Берем " + i);

            adventurer = new int[treeMap.get(i).length];
            for (int j = 0; j < treeMap.get(i).length; j++) {
                adventurer[j] = treeMap.get(i)[j];                //ищем стейты на основе всех дорожных линий с светоформи
            }

            int numOfFriends = 0;
            for (int l = 0; l < adventurer.length; l++) {
                if (adventurer[l] == 0) {                           //считаем сколько друзей у конкретной линии с светофором
                    numOfFriends++;
                }
            }
            System.out.println("Друзья у " + i);
            int[] friends = new int[numOfFriends];
            int[] allFriends = new int[numOfFriends];
            int indexFiend = 0;
            for (int f = 0; f < adventurer.length; f++) {
                if (adventurer[f] == 0) {                             //добавляем в друзья
                    friends[indexFiend] = keys[f];
                    allFriends[indexFiend] = keys[f];
                    System.out.print(keys[f] + " ");
                    indexFiend++;
                }
            }
            friendsCombArrayList = new ArrayList<>();
            friendsCombination(friends, new Stack<Integer>(), friends.length);  //все комбинации порядка друзей

            // мы нашли друзей, теперь важно чтобы друзья дружили между собой
            for (int[] allFriend : friendsCombArrayList) {
                int countFriends = allFriend.length;
                ArrayList<Integer> noFriendsArrayList = new ArrayList<>();
                for (int m = 0; m < allFriend.length; m++) {                  //Серьезный разговор с друзьями по очереди

                    System.out.println('\n' + "Проверим " + allFriend[m]);
                    if (!noFriendsArrayList.contains(allFriend[m])) {
                        for (int k = 0; k < adventurer.length; k++) {
                            if (treeMap.get(allFriends[m])[k] != adventurer[k] && treeMap.get(allFriends[m])[k] == 1) {

                                System.out.println(keys[k] + " Больше не друг!");
                                if (!noFriendsArrayList.contains(keys[k])) {
                                    int noFriend = keys[k];
                                    noFriendsArrayList.add(noFriend);
                                    countFriends--;

                               /* int[] copyFriends = new int[friends.length];
                                for (int d = 0; d < friends.length; d++) {
                                    copyFriends[d] = friends[d];
                                }*/

                                    friends = new int[countFriends];
                                    int newFriendIndex = 0;
                                    for (int h = 0; h < allFriend.length; h++) {
                                        if (!noFriendsArrayList.contains(allFriends[h])) {
                                            friends[newFriendIndex] = allFriend[h];
                                            newFriendIndex++;
                                        }
                                    }

                                }
                            }
                        }

                    } else {
                        System.out.println(allFriends[m] + " Был удален ранее");
                    }
                }
                System.out.println("      Стейт на основе     " + i);
                for (int s = 0; s < friends.length; s++) {
                    bubbleSort(friends);
                    stateHashSet.add(friends);
                    System.out.println(friends[s]);
                }

                System.out.println("из друзей мы потеряли");
                for (int j : noFriendsArrayList) {
                    System.out.print(j + " ");
                }
                System.out.println('\n' + "-------------------------закончили с " + i + '\n');
            }
        }
    }

    public void friendsCombination(int[] arr, Stack<Integer> s, int am) {
        if (am == 0) {
            System.out.println(Arrays.toString(s.toArray()));
            int[] tmp = new int[s.toArray().length];
            for (int ar = 0; ar < s.toArray().length; ar++) {
                tmp[ar] = (int) s.toArray()[ar];
            }
            friendsCombArrayList.add(tmp);
            return;
        }
        for (int i = 0; i < arr.length; i++)
            if (arr[i] != USED) {
                s.push(arr[i]);
                arr[i] = USED;
                friendsCombination(arr, s, am - 1);
                arr[i] = s.pop();
            }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
