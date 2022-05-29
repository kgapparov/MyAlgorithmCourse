package educative.subsets;

import java.util.HashSet;
import java.util.Set;

public class Solutions {
    public static int hasNValues(int[] a, int n) {
        Set<Integer> set = new HashSet<>();
        for (int num : a) {
            set.add(num);
        }
        return set.size() == n ? 1 : 0;
    }

    public static int isRapidlyIncreasing(int[] a){
        int preSum  = 0;
        for (int i = 0; i  < a.length; i++) {
            if (a[i]  < 2 * preSum) {
                return 0;
            }
            preSum = preSum + a[i];
        }
        return 1;
    }

    public static int isOnionArray(int[] a) {
        if (a.length == 0) {
            return 1;
        }
        if (a.length == 1) {
            if (a[0] <= 10)
                return 1;
            return 0;
        }
        int j = 0, k = a.length-1;
        while (j < k) {
            if (a[j]  + a[k] > 10)
                return 0;
            j++;
            k--;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(hasNValues(new int[]{1,2,2,1}, 2));
        System.out.println(hasNValues(new int[]{1,2,3,2,1}, 2));
        System.out.println(isRapidlyIncreasing(new int[] {1,3,9,27}));
        System.out.println(isOnionArray(new int[]{1,2,19,4,15}));
    }
}
