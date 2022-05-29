package lessons_from_class.devide_and_conquer;


import java.util.ArrayList;
import java.util.List;

public class QuickSort<T extends Comparable<T>> {
    /**
     * Algorithm partition(S, p)
         * Input sequence S, position p of pivot
         * Output subsequences L, E, G of the
         * elements of S less than, equal to,
         * or greater than the pivot, resp.
     * L, E, G <-- empty sequences
     * x <-- S.removeElementAt(p)
     * E.insert(x)
     * while !S.isEmpty()
         * y <-- S.removeFirst()
         * if y < x
         * L.insertLast(y)
         * else if y = x
         * E.insertLast(y)
         * else { y > x }
         * G.insertLast(y)
     * return L, E, G
     */

    /*
    Pseudocode for partition with indexes
    Algorithm partition(S, low, high)
        Input squesnce of integer and index low and high indexes for sorting
        Output sequence of sorted integer of S from low to high

        pivot <-- S[high]
        indexOfSmallerElement <-- low - 1;

        for j <-- low to  j <= high - 1 do
             if  S[j] < pivot then
                indexOfSmallerElement++;
                swap arr[indexOfSmallerElement] and arr[j]
        swap arr[indexOfSmallerElement + 1] and arr[high]
        return indexOfSmallerElement + 1;
     */

    private static<T> void swap (List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private static<T extends Comparable<T>>  int partition(List<? extends T> list, int low, int high) {
        T pivot =list.get(high);
        int lowIndex = low - 1;
        for (int i = low; i <= high - 1; i++) {
            if (list.get(i).compareTo(pivot) < 0) {
                lowIndex++;
                swap(list, lowIndex, i);
            }
        }
        swap(list,lowIndex+1, high);
        return lowIndex+1;
    };

    private static <T extends Comparable<T>> void quickSort(List<? extends T> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSort(list, low, pi-1);
            quickSort(list, pi+1, high);
        }
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(13);
        list.add(12);
        list.add(2);
        list.add(222);
        list.add(23);
        list.add(2235);
        list.add(2112);
        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("sadf");
        list2.add("a");
        list2.add("asd");
        list2.add("basdf");
        System.out.println(partition(list, 0, list.size() - 1));
        quickSort(list, 0, list.size()-1);
        quickSort(list2, 0, list2.size()-1);
        System.out.println(list);
        System.out.println(list2);
    }

}
