package lessons_from_class.lab4;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Khassangali
 * @email hasangaly@gmail.com
 */
public class Problem4 {
    public static final Integer TESTCOUNT = 100;
    /**
     *  problem 1
     *  A 10-sided die—having values 1, 2, . . ., 10 on its faces—is tossed repeatedly.
     * a. What is the expected number of tosses required to get a 2?
     * b. What is the expected number of tosses required to get a total of three 2’s?
     * Assume that each of the values 1, 2, . . ., 10 is equally likely to appear. Explain your
     * answer
     *
     * a) probability of p(k) = 1/n -> p(2) = 1/10;
     *
     * b) to get three time 2 we need 3*1/p(2) = 3 * 10 = 30
     */

    /**
     * problem 2
     * Is there a comparison-based sorting algorithm which, when run on an array containing
     * exactly 4 distinct integers, requires only 4 comparisons to sort the integers, even in the
     * worst case? Can it be done with 5 comparisons? Prove your answers.
     */

    /** answer
     *
     * The number of comparisions performed in order to arrive at an arrangement found in a leaf node equals the depth
     * of that leaf node in the desicion tree (Lecture 4 slides page 35)
     *
     * in our example it is 4 distinct elements, and count of leafs is 4! = 24
     * the H (height) H = Ceil(Log24) = 5; the worst case scenario we need at least 5 comparisons.
     * answer for 4 comparison it is impossible sort worst case, but with 5 comparisons we can sort.
     */

    /**
     * problem 3
     *
     * Devise an algorithm that rearranges the elements of an input array of size n in a random
     * way. What is the running time of your algorithm? Hint. There is a way to do this in O(n)
     * time.
     *
     */

    /**
     * Random rearrangement of array
     */
    public static Integer[] rearrange(Integer[] arr) {
        Random r = new Random();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int randomIndex = r.nextInt(n-1);
            int tmp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = tmp;
        }
        return arr;
    }


    /**
     *  Problem 4
     *  Goofy has thought of a new way to sort an array arr of n distinct integers:
     * a. Step 1: Check if arr is sorted. If so, return.
     * b. Step 2: Randomly arrange the elements of arr (see part 3(A))
     * c. Step 3: Repeat Steps 1 and 2 until there is a return.
     * Answer the following:
     * A. Will Goofy’s sorting procedure work at all? Explain
     * B. What is a best case for GoofySort?
     * C. What is the running time in the best case?
     * D. What is the worst-case running time?
     * E. What is the average case running time?
     * F. Is the algorithm inversion-bound?
     */

    /**
     * answer:
     * a)   * A. Will Goofy’s sorting procedure work at all? Explain
     *  Yes it is possible that input array already sorted order. Possibility of element on its spot is p(i) = 1/n!;
     *
     *  b) c)  a best case for GoofySort -> O(1), input array is already sorted
     *
     *  c) Worst-case possibility of sorted is Count = 1/p => 1/1/n! = n!; in n! once it could be sorted.
     *
     *  e) Average case running time => (O(n)(checkis for sorted or not) * n! (worst case) ) /2 = O(n/2*n!) = O(n*n!)
     *
     *  f) The algorithm is not inversion-bound!
     *
     */
    public static int goofySort(Integer [] arr) {
        int count = 0;
        while (!isSorted(arr)) {
            rearrange(arr);
            count++;
        }
        return count;
    }

    public static boolean isSorted(Integer [] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] < arr[i-1]) {
                return false;
            }
        }
        return true;
    }

    public static void  myTest(Integer[] arr) {
        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;
        Double avg = 0.0;
        for (int i = 0; i < TESTCOUNT; i++) {
            int times = goofySort(arr);
            max = Math.max(times, max);
            min = Math.min(times, min);
            avg += times;
            rearrange(arr);
        }
        System.out.printf("\nGoffy sorted array %d times and the results : \nmin %d times \nmax %d times\navg %.2f times\n", TESTCOUNT ,min, max, avg/TESTCOUNT);
    }


    /**
     * Porblem 5
     * In our average case analysis of QuickSort, we defined a good self-call to be one in
     * which the pivot x is chosen so that number of elements < x is less than 3n/4, and also
     * the number of elements > x is less than 3n/4. We call an x with these properties a
     * good pivot. When n is a power of 2, it is not hard to see that at least half of the
     * elements in an n-element array could be used as a good pivot (exactly half if there are
     * no duplicates). For this exercise, you will verify this property for the array A = [5, 1,
     * 4, 3, 6, 2, 7, 1, 3] (here, n = 9). Note: For this analysis, use the version of QuickSort
     * in which partitioning produces 3 subsequences L, E, R of the input sequence S.
         * a. Which x in A are good pivots? In other words, which values x in A satisfy:
             * i. the number of elements < x is less than 3n/4, and also
             * ii. the number of elements > x is less than 3n/4
         * b. Is it true that at least half the elements of A are good pivots?
     */

    /**
     * Answer:
     *   a. 3n/4 = 3*9/4 = 6.75  [5 1 4 3 6 2 7 1 3] -> [1 1 | 2 3 3 4 5 | 6 7] [1 1, 6 7] - bad [2 3 4 5] - good
     *   i. 4/9 < 6.75 - is good
     *   ii. 8/9 > 6.75 - is bad
     *   b. yes it is. 1/2 < 3/4
     */

    /**
     * Problem 6
     * Devise an algorithm that performs sideways sorting on the elements of a length‐n
     * integer array. When an array is sideways-sorted, the elements are arranged as follows
         * position 0: the smallest integer
         * position 1: the largest integer
         * position 2: the second smallest integer
         * position 3: the second largest integer etc.
     *
     * For example, when you sideways sort the input array {1, 2, 17, -4, ‐6, 8} you get:
     *     {-6, 17, -4, 8, 1, 2}. (Notice that –6 is the smallest, 17 the largest, -4 second smallest,
     * 8 second largest, etc.) Answer the following:
     */

    /**
     * Answer
     * Algorithm:
     * 1 . Given array A
     * 2 . Sort array A (O (n Log n)
     * 3.  Create Array B (O n)
     * 4.  Fill A[0] -> B[0], A[n] -> B[1] .... O( n)
     * Time copmlexity is : O(n Log n + n + n ) => O(n * Log N)
     *
     * Lower Bound Theorem.
     * Any comparison-based
     *     sorting algorithm running on input list of size n has a
     *     worst case in which at least ┌ log n!┐ comparisons are
     *     performed. Therefore, any comparison-based sorting
     *     algorithm has a worst-case running time of Omega(n log n).
     *
     */



    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,6};
//        System.out.println(Arrays.toString(rearrange(arr)));
        arr = rearrange(arr);
        System.out.println(Arrays.toString(arr));
        myTest(arr);
    }

}

