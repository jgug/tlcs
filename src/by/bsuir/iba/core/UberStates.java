package by.bsuir.iba.core;

import java.util.*;

/**
 * The type Uber states.
 */
public class UberStates {
    private static final int USED = Integer.MAX_VALUE;
    ArrayList<int[]> friendsCombArrayList;
    Map<Integer, int[]> treeMap = new TreeMap<>();
    Set<int[]> stateTreeSet = new TreeSet<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return Arrays.equals(o1, o2) ? 0 : Arrays.hashCode(o1) - Arrays.hashCode(o2);
        }
    });
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
            int[] friendsCopy = new int[numOfFriends];
            int indexFiend = 0;
            for (int f = 0; f < adventurer.length; f++) {
                if (adventurer[f] == 0) {                             //добавляем в друзья
                    friends[indexFiend] = keys[f];
                    friendsCopy[indexFiend] = keys[f];
                    System.out.print(keys[f] + " ");
                    indexFiend++;
                }
            }
            friendsCombArrayList = new ArrayList<>();
            friendsCombArrayList.add(friends);
            bubbleSortDown(friendsCopy);
            friendsCombArrayList.add(friendsCopy);

            // мы нашли друзей, теперь важно чтобы друзья дружили между собой
            for (int it = 0; it < friendsCombArrayList.size(); it++) {
                System.out.println('\n'+"-------------------------Работаем с  " + i);
                int[] allFriends = friendsCombArrayList.get(it);
                int countFriends = allFriends.length;
                ArrayList<Integer> noFriendsArrayList = new ArrayList<>();
                for (int m = 0; m < allFriends.length; m++) {                  //Серьезный разговор с друзьями по очереди

                    System.out.println('\n' + "Проверим " + allFriends[m]);
                    if (!noFriendsArrayList.contains(allFriends[m])) {
                        for (int k = 0; k < adventurer.length; k++) {
                            if (treeMap.get(allFriends[m])[k] != adventurer[k] && treeMap.get(allFriends[m])[k] == 1) {

                                System.out.println(keys[k] + " Больше не друг!");
                                if (!noFriendsArrayList.contains(keys[k])) {
                                    int noFriend = keys[k];
                                    noFriendsArrayList.add(noFriend);
                                    countFriends--;
                                    friends = new int[countFriends];
                                    int newFriendIndex = 0;
                                    for (int h = 0; h < allFriends.length; h++) {
                                        if (!noFriendsArrayList.contains(allFriends[h])) {
                                            friends[newFriendIndex] = allFriends[h];
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
                    bubbleSortUp(friends);
                    stateTreeSet.add(friends);
                    System.out.println(friends[s]);
                }

                System.out.println("из друзей мы потеряли");
                for (int j : noFriendsArrayList) {
                    System.out.print(j + " ");
                }
                System.out.println('\n' + "-------------------------закончили с " + i + '\n');
            }
        }
        for(int j = 0; j<2;j++){
            int k = 100;
        }
    }

    public static void bubbleSortDown(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void bubbleSortUp(int[] arr) {
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
