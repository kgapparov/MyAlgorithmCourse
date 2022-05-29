package lessons_from_class.problem1A;

import java.util.*;

public class Problem1a {
    public static boolean sumFound(int [] arr, int z) {
        Set<Integer> visited = new HashSet<>();
        if (arr == null || arr.length < 2)
            return false;
        for (int num : arr) {
            if (visited.contains(num))
                return true;
            else
                visited.add(z - num);
        }
        return false;
    }

    public static int secondSmallest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Input array to small");
        }
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < min) {
                min = num;
               // secondMin = Math.min(min, secondMin);
            } else if (num < secondMin) {
                secondMin = num;
            }
        }
        return secondMin;
    }

    public static List<List<Integer>> findSubsets(Integer[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i > 0 && nums[i] == nums[i -1])
                startIndex = endIndex +1;
            endIndex = subsets.size() - 1;
            for (int j = startIndex; j <= endIndex; j++) {
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }
        return subsets;
    }

    public static boolean sumFound(List<Integer> list, int k) {
        if (k == 0) {
            return true;
        }
        for (List<Integer> set : Problem1a.findSubsets(list.toArray(Integer[]::new))) {
            Integer sum = 0;
            for (Integer n : set) {
                sum += n;
            }
            if (sum == k) {
                return true;
            }
        }
        return false;
    }

    public static void sort(List<Integer> list) {
        int minInd;
        for (int i = 0; i < list.size(); i++) {
            minInd = findMinIndex(list, i, list.size() -1 );
            int temp = list.get(i);
            list.set(i, list.get(minInd));
            list.set(minInd, temp);
        }
    }

    private static int findMinIndex(List<Integer> list, int start, int end) {
        int minIndex = start;
        for (int i = start+1; i <= end; i++) {
            if (list.get(i) < list.get(minIndex)) {
                minIndex = i;
            }
        }
        return minIndex;
    }
    private static void swap(ArrayList<Integer> list, int i , int j) {
        if (i < 0 || i >= list.size() || j < 0 || j >= list.size()) {
            return;
        }
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }


    /**
     * Searching tasks
     *
     */
    //O(N)
    public static boolean finda(int[] arr, int z) {
        for (int num : arr) {
            if (num == z)
                return true;
        }
        return false;
    }
    //O(logN) if arr is sorted
    public static boolean findb(int[] arr, int z) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (arr[mid] == z) {
                return true;
            } else if (mid < z) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return false;
    }

    /**
     * problem 7
     * Fibanaci
     */
    public static int generate(int n) {
        int[] memo = new int[n+1];
        return fib(memo, n);
    }
    private static int fib(int[] memo, int n) {
        if (n == 0) {
            memo[n] = 0;
            return 0;
        }
        if (n == 1) {
            memo[1] = 1;
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fib(memo, n-1) + fib(memo,n-2);
        return memo[n];
    }

    /**
     * problem 8
     *
     */
    public static int smallestCommon(int x, int y) {
        int sum = 0;
        while (true) {
            sum += x;
            if (sum % y == 0) {
                return sum;
            }
        }
    }

    public static List<Set<Integer>> powerSet(List<Integer> list) {
        List<List<Integer>> subList = Problem1a.findSubsets(list.toArray(Integer[]::new));
        List<Set<Integer>> result = new LinkedList<>();
        for (List<Integer> set : subList) {
            result.add(new HashSet<>(set));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Problem1a.sumFound(new int[]{1,4,2,3}, 5));
        System.out.println(Problem1a.secondSmallest(new int[]{1,4,2,3}));
        System.out.println(Problem1a.secondSmallest(new int[]{3,3,4,7}));
        System.out.println(Problem1a.findSubsets(new Integer[]{1,2,3,4}));
        System.out.println(Problem1a.sumFound(List.of(1,3,9,4, 8, 5), 21));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(4);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(5);
        list2.add(3);
        list2.add(2);
        list2.add(6);
        list2.add(4);
        Problem1a.sort(list);
        Problem1a.sort(list2);
        System.out.println(list);
        System.out.println(list2);
        System.out.println(Problem1a.findb(new int[]{1,2,3,4,5,6,7,8,9,10}, 6));
        System.out.println(Problem1a.powerSet(List.of(1,2,3)));

        //generate

        for (int i = 0; i <= 20; i++) {
            System.out.println(Problem1a.generate(i));
        }
        System.out.println(Problem1a.smallestCommon(4,6));
        System.out.println(Problem1a.smallestCommon(3,5));
        System.out.println(Problem1a.smallestCommon(7,14));
    }

}
