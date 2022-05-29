package lessons_from_class.problem3A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3A {
    /**
     * Problem 1
     *
     * Use the Master Formula to find an explicit formula for the running time T(n) of a certain algorithm, given that T(n) satisfies the following recurrence relation:
     *                 T(n) = T(n/2) + n; T(1) = 1
     *
     * Answer:
     * d = 1, a = 1, b =2, c = 1, k = 0;
     * a == b^k 1 = 2^0
     * answer is O(n^K*Logn) -> O(logN)
     */

    /**
     *  Problem 2
     *
     *  Primes. Create a Java method with the following signature and return type:
     *
     *          boolean  isPrime(int n)
     */
    static boolean isPrime (int n ) {
        if (n <= 1) {
            return false;
        }
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || (n + 2) % i == 0)
                return false;
        }
        return true;
    }

    private static boolean isPrimeOptimal(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i*i <= n; i += 6) {
            if (n % i == 0|| n % (i +2) == 0)
                return false;
        }
        return true;
    }

    // T(n) = O(log(n)) int terms of value
    // T(b) = O(b) int terms of size



    /**
     * Problem 3
     *
     *
     *  Devise an o(n) algorithm (calculated in terms of the value of n) that solves the following problem:
     *  Given positive integers m, n, return true if gcd(m,n) has the form 2^k * p for some nonnegative integer k
     *  and some prime p. Demonstrate that your algorithm really runs in o(n) time.
     */
    static int gcd(int m , int n) {
        if (n == 0)
            return m;
        return gcd(n, m % n);
    }

    static boolean hasForm(int m, int n) {

        int gcd = gcd(m, n); // O(LogN)

        while (gcd % 2 == 0)  // O(LogN)
            gcd /= 2;

        if (isPrime(gcd))     //O(LogN)
            return true;

        return false;
    }
    // Tn= 3 * O(Log n) = O(Log n) == o(n)


    /**
     * Problem 4
     * Sorting. The following pseudo-code describes a recursive algorithm for sorting a list.
     *
     *
     * Algorithm recSort(L)
     *      Input list L with n elements
     *      Output list L sorted
     * if L.size() > 1 then
     *  (L1, L2) <- partition(L, n/2)
     *  recSort(L1)
     *  recSort(L2)
     *  L <- merge(L1, L2)
     * return L
     *
     * The partition step of the algorithm places every element in position ≤ n/2 into a list L1 and the elements to the right of position n/2 into a second list L2. As with BinarySearch, this can be accomplished more efficiently by using indices instead of creating new lists each time.
     * Do the following:
     * A. Prove the algorithm is correct.
     *
     * Prove:
     * I (1) -> true. return list without modification, IF condition is false return L (list) which is sorted.
     * Assume I (i) is true for every  1 <= i < n;
     *
     * I (n) ->
     *   if L.size() > 1 then
     *   (L1, L2) <- partition (L, n/2)
     *   recSort(L1) (is true I (i) i < n is true;
     *   reqSort(L2) (is true I (i) i < n is true ;
     *   L <- merge(L1, L2) (is true because both L1, L2 is true)
     * return L (List is sorted and it is true based on merge (L1, L2)
     *
     *
     * B. Use the version of the Master Formula shown below to obtain an explicit formulat for the running time T(n). Remember that merging can be done in O(n) time.
     *
     *  * Algorithm recSort(L)
     *      *      Input list L with n elements
     *      *      Output list L sorted
     *      * if L.size() > 1 then    (2) (getSize and Compare)
     *      *  (L1, L2) <- partition(L, n/2)  ( K some constant partition(L, N/2) + assignment k+1)
     *      *  recSort(L1) //  T (n/2)
     *      *  recSort(L2) // T (n/2)
     *      *  L <- merge(L1, L2)  // n
     *      * return L //1
     *
     *      T(n) = C*n + T(n/2) + T(n/2) + n = C*n + 2T(n/2);
     *      a = 2; k = 1; b = 2; d = 3;
     *      a == b^K;
     *      O (n^k * Logn) = O(n*log(n));
     *
     * C. Implement this algorithm in Java, and write it so that it can be run in the Sorting Environment. Then run
     * it and compare running times with the other sorting algorithms we have studied. Is it faster than LibrarySort?
     */
   public static void recSort(int[] arr, int l , int r) {
       if (l < r) {
           int m = l + (r - l)/2;
           recSort(arr, l, m);
           recSort(arr, m+1, r);
           merge(arr, l, m ,r );
       }
   }
   public static void merge(int[] arr, int l, int m, int r) {
       int n1 = m - l + 1;
       int n2 = r - m;

       int L[] = new int[n1];
       int R[] = new int[n2];

       for (int i = 0; i < n1; ++i) {
           L[i] = arr[l+i];
       }
       for (int i = 0; i < n2; ++i) {
           R[i] = arr[m+1+i];
       }
       int i = 0, j = 0;
       int k = l;

       while (i < n1 && j < n2) {
           arr[k++] = L[i] < R[j] ? L[i++] : R[j++];
       }

       while (i < n1) {
           arr[k++] = L[i++];
       }

       while (j < n2)
           arr[k++] = R[j++];
   }

    public static void main(String[] args) {
       int[] arr = new int[]{3,4,3,1,3,5,51,23,1};
        Problem3A.recSort(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }
}
