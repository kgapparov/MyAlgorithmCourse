package educative.subsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets<T>{

    /**
     * https://leetcode.com/problems/subsets/
     */
    public static <T>  List<List<T>> powerSet(List<? extends T> list) {
        List<List<T>> powerSet = new ArrayList<>();
        List<T> subset = new ArrayList<>();
        powerSet.add(subset);
        for (T element : list) {
            int n = powerSet.size();
            for (int i = 0; i < n; i++) {
                subset = new ArrayList<>(powerSet.get(i));
                subset.add(element);
                powerSet.add(subset);
            }
        }
        return powerSet;
    }

    /**
     * https://leetcode.com/problems/subsets-ii/
     */
    public static<T extends Comparable<T>> List<List<T>> powerSetWithDuplicates(List<? extends T> list) {
        Collections.sort(list);
        List<List<T>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<T>());
        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < list.size(); i++){
            startIndex = 0;
            if (i > 0 && list.get(i) == list.get(i -1))
                startIndex = endIndex +1;
            endIndex = powerSet.size()-1;
            for (int j = startIndex; j <= endIndex; j++) {
                List<T> set = new ArrayList<>(powerSet.get(j));
                set.add(list.get(i));
                powerSet.add(set);
            }
        }
        return powerSet;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(4);
       // System.out.println(Subsets.powerSet(list));
        System.out.println(Subsets.powerSetWithDuplicates(list));
    }
}
