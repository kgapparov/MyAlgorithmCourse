package lessons_from_class.problem3B;

import lessons_from_class.problem3A.Problem3A;

public class Problem3B {
    /*
    Problem 1:
    Perform the MergeSort algorithm by hand on the list [7, 6, 5, 4, 3, 2, 1] using a MergeSort
recursion tree, as was done in the lecture.
    Answer:

    0. [7, 6, 5, 4, 3, 2, 1]       l = 0, r = 6, mid = 3
    1.   7 6 5  |   4 3 2 1
    2.   7 | 6 5  | 4 3 | 2 1
    3.   _ | 6 | 5 | 4 | 3 | 2 | 1
    4    _ | 5 6 | 3 4 | 1 2
    5    5 6 7 | 1 2 3 4
    6    1 2 3 4 5 6 7
     */

    /*
     Problem 2:

     The fast BinarySearch algorithm is shown below. We have already shown that the algorithm's
    worst-case running time is (log n) using the Master Formula. For this problem, use the method
    of counting self-calls to establish this running time.

    Hints. Remember the result about length of descending sequences, discussed in the slides.
    Remember the worst case for BinarySearch

    Answer:
    Assume we our worst case scenario, then our searching index allocated at last position in the array.

    self calls every time cuts n/2, n /4 , n /8, ... n/n ~ logn time calls self to reach end of the array.

     */

    /*
    Problem 3

        Solve the following problem with a recursive algorithm: Given a list with n elements, put the
    elements of the list in reverse order. Compute the running time of your algorithm (hint: count
    self-calls).

    Answer:
     */
    public static String reverse(String str){
        StringBuilder result = new StringBuilder();
        reverseStr(str, str.length() - 1, result);
        return result.toString();
    }

    private static void reverseStr(String str, int index, StringBuilder result) {
        if (index >= 0) {
            result.append(str.charAt(index--));
            reverseStr(str, index, result);
        }
    };

    // self cals each time call decrease for 1 element. To perform reverse n element it need O(n) time.



    /*
       Problem 4
           In Lesson 3 slides it was shown that the recursive algorithm fib(n), for computing the nth
        Fibonacci number, runs in exponential time. Develop two fast alternatives to the fib(n)
        algorithm:

        • Devise an iterative algorithm that runs in O(n) time

        • Devise a O(n) recursive algorithm, similar to fib(n), that stores results of computations and
        re-uses them.

        Implement both in code.
     */

    //Answer:

    public static int fibonacciIterative(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int[] Fib = new int[n+1];
        Fib[1] = 1;
        Fib[2] = 1;
        for (int i = 3; i <= n; i++) {
            Fib[i] = Fib[i-1] + Fib[i-2];
        }
        return Fib[n];
    }

    public static int recFibonacci(int n) {
        int[] memo = new int[n+1];
        return fib(memo, n);
    }

    private static int fib(int[] memo, int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        if (memo[n] != 0)
            return memo[n];
        memo[n] = fib(memo, n-1) + fib(memo, n-2);
        return memo[n];
    }


    /*
    Problem 5
        We showed that the SecondSmallest problem can be solved with an O(n) iterative algorithm.
    Does the same technique solve the corresponding ThirdSmallest problem in O(n) time? Explain.
    What if "second" and "third" are replaced by "kth", where k represents any number from 2 to n1? For instance, is there a fast algorithm for finding the n/2-smallest element in a list of n
    elements? Is the sorting approach the fastest way in this case? Explain

    Asnwer:
        for 1st, 2nd, 3rd we can assume we find them in one or three different iterations.
        but for  k element which is large as n/2 time it becames n/2 * n = n^2  O(n^2)
        better is sorting and get result int O(n*LogN)

        But we can use min Heap collection to store data as minimum always on top. getting the min value from collection
        need O(1) time, polling and inserting took O (Log K) time. for taking K element from collection
        we need O(K*LogK) which is < O(N*LogN)
     */
    public static void main(String[] args) {
        System.out.println(Problem3B.reverse("ABC"));
        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacciIterative(i));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(recFibonacci(i));
        }
    }
}
