package problem2A;


import java.util.Arrays;

public class Problem2B {
    /**Problem 1
     *  Count the primitive operation counts
     */
//    A.sum ← 0  1
//            for i ← 0 to n-1 do   n + 1
//    sum ← sum + 1  2
//    Answer: n + 4;


//    B.
//    sum ← 0   1
//            for i ← 0 to n-1 do   n+1
//              for j ← 0 to n-1 do n + 1
//                  sum ← sum + 1    2
//   Answer:  1 + (n+1) ((n+1)*2) = 1 + 2(n+1)^2 = 1 + 2*( n^2 + 2n + 1) = 2n^2 + 4n + 3

    /** Problem 2
     *   Determine the asymptotic running time of the following procedure (an exact computation of number of basic operations is not necessary):
      */
//    int[] arrays(int n) {
//        int[] arr = new int[n];
//        for(int i = 0; i < n; ++i){
//            arr[i] = 1;
//        }
//        for(int i = 0; i < n; ++i) {
//            for(int j = i; j < n; ++j){
//                arr[i] += arr[j] + i + j;
//            } }
//        return arr; }

    //Answer:  T = n + n  O(n);

//    3.
    /**
     * Consider the following problem: As input you are given two sorted arrays of integers. Your objective is to design an algorithm that would merge the two arrays together to form a new sorted array that contains all the integers contained in the two arrays. For example, on input
     *            [1, 4, 5, 8, 17], [2, 4, 8, 11, 13, 21, 23, 25]
     * the algorithm would output the following array:
     *                [1,2,4,4,5,8,8, 11, 13, 17, 21, 23, 25]
     * For this problem, do the following:
     * A. Design an algorithm Merge to solve this problem and write your algorithm description using the pseudo-code syntax discussed in class.
     * B. Examining your pseudo-code, determine the asymptotic running time of this merge algorithm. Here, let n denote the sum of the lengths of the two arrays:
     *                  n = arr1.length + arr2.length
     * C. Implement your pseudo-code as a Java method merge having the following
     * signature:
     * Be sure to test your method in a main method to be sure it really works!
     */

    // A:
//    Algorythm Merge(arr1, arr2)
//        Input array arr1 and arr2 of sorted integers
//        Output array of sorted integer
//    n <- arr1.length + arr2.length
//    result <- new Integer[n]
//    j <-0, k <- 0, i <- 0
//    for i to i < n  do
//        if j < arr1.length AND k < arr2.length THEN
    //        if arr1[j] < arr2[k] then
    //            result[i] <- arr1[j]
    //            j++
    //        else
    //            result[i] <- arr2[k]
    //            k++
    //   else
//            break
//
//    while j < arr1.length do
//        result[i] = arr1[j]
//        i++, j++
//    while k < arr2.length do
//        result[i] = arr2[k]
//        i++, k++
//    return result
    //B
    // O(m + y) = O(n)

    //C implement your code
    public static Integer[] merge(Integer[] arr1, Integer[] arr2) {
        int n = arr1.length + arr2.length;
        Integer[] result = new Integer[n];
        int j = 0, k = 0;
        int i = 0;
        for ( ;i < n; i++) {
            if (k < arr2.length && j < arr1.length) {
                if (arr1[j] < arr2[k])
                    result[i] = arr1[j++];
                else
                    result[i] = arr2[k++];
            } else {
                break;
            }
        }

        while (j < arr1.length)
            result[i++] = arr1[j++];

        while (k < arr2.length)
            result[i++] = arr1[k++];

        return result;
    }

    /**
     * Problem 4
     * Below, an algorithm called removeDups is provided. Its purpose is to extract from the input list L a list M of all the distinct elements of L.
     * A. Explain why the running time of removeDups is O(n2) (remember to consider the running time of M.contains(x))
     * B. Try using the technique shown in the solution to the
     * Sum of Two Problem (i.e. using a HashMap) to improve running time to O(n). Be sure to prove that running time of
     * your new algorithm is O(n).
     * C. Prove your algorithm in B is correct – to do this, come up with a loop invariant I(i). Hint. At stage i, M contains the distinct elements contained in [L[0]...L[i]].
     */
//    Answers:

    /**
     *Answers
     * A) O(n2) because M.contains(L[i]) is also the O(n) is time-consuming function.
     * B) O(N) answer:
     * Algorithm removeDups(L)
     *  Input a list L
     *  Output a list M containsing the distinct element of L
     *
     *  M <- new HashSet
     *  for i <- 0 to L.size()-1 do
     *    M.add(L[i])
     *  return M
     *
     *  C) I(0) M will contain 1 distinct element which is correct statement.
     *  assume I(i) we have distinct i elements in M and it is true;
     *  for I(i + 1) element two options:
     *      a) if M contains the element i+1 will ommited
     *      b) if M not contains the element i + 1 then it will be added to M list.
     *      eventually on end of input list we will have on M all distinct elements witch is correct and true.
     */

    /**
     * problem 5
     * The following is the code for a sorting algorithm known as bubblesort:
     *
     * a) Spwcify a best case an a worst cas for BubbleSort:
     *   best: when list already sorted, now swap operation performed. Though we need O(n2) times compare elements
     *   worst: reverse ordered list, on each comparision we will swap operation. O(n2) with swap
     * b) What are the best-case and worst-case running times for BubbleSort?
     * O(n2) best and worst case
     *
     * c) Modify bubbleSort so that is has best-case running time of O(n):
     */
    void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < len; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (isSwapped) {
                break;
            }
        }
    }

    /**
     * D) Prove BubbleSort is correct;
     * I(0) - after first iteration the Max element will be swapped with every element from its position up to last
     * element. Maximum element on its position and it is final sorted.
     * I(i) - assume all elements from last Max and upto i is on its correct and final sorted positions
     * I(i+1) - the max element among 0 - (n - i - 1) position will swapped upto (n - i - 1 position). from i to n
     * position are already final and sorted order. I(i+1) element is less than all I(x : 0 ... i ) elements, and it is
     * grater than all 0 ... (n - i - 1), it means that I(i + 1) found correct spot and it is in final sorted order.
     *
     * E)
     *  Suppose arr is an input array, i < j < arr.length; x = arr[i] < arr[j] = y; At some point the initial part
     *  of the array soncisting of all values < y will be in sorted order, and y will need to be places. Y will still
     *  be to the right of x. So, int the loop that does the placing, y will have to be compared with x.
     */

//Problem 6
    public static void sortOn(int[] arr) {
        int low = 0, high = arr.length -1, index = 0;
        while (index < high) {
            if (arr[index] == 0)
                swap(arr, index, low++);
            else if (arr[index] == 2)
                swap(arr, index, high--);
            index++;
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Problem2B.merge(new Integer[]{1, 7, 9}, new Integer[]{4, 6, 8})));
        int[] arr = new int[]{0,1,1,0,0,2,2,2};
        Problem2B.sortOn(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(5 | 5);
    }
}
