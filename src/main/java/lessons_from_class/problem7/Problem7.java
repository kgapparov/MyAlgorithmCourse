package lessons_from_class.problem7;

public class Problem7 {
    /**
     * problem 1
     *
     * 1. Starting with the values 1, 2, 4, 4, 5, 6, 9, 11, 12, 12, 17, do the following:
     * a. Create a heap H in which these values are the keys.
     * b. Perform the insertItem algorithm to insert the value 7 into H. Show all steps.
     * c. Perform the removeMin algorithm on H and show all steps.
     * d. Represent H in the form of an array A.
     * e. Perform the array-based insertItem algorithm to insert 14 into A – show all
     * steps.
     * f. Perform the array-based removeMin algorithm on A – show all steps.
     *
     * Answer:
     *a ) H <- {1,2,4,4,5,6,9,11,12,12,17}
     *      1
     *    2      4
     *       4      5
     *           6    9
     *              11   12
     *                     17
     * b)
     * Insert 7 to end and go up until condition true
     *       1
     *    2      4
     *       4      5
     *           6    9
     *              11   12
     *                     17
     *                  7
     *
     *
     *       1
     *    2      4
     *       4      5
     *           6    9
     *              11   12
     *                      7  <--
     *                        17  <--
     *
     *       1
     *    2      4
     *       4      5
     *           6    9
     *              11   7 <--
     *                      12  <--
     *                        17
     *
     *       1
     *    2      4
     *       4      5
     *           6    7 <--
     *              11   9 <--
     *                      12
     *                        17
     *
     * c) removemin
     *       17
     *    2      4
     *       4      5
     *           6    7 <--
     *              11   9 <--
     *                      12
     *                        1
     *
     *       2
     *    17      4
     *       4      5
     *           6    7 <--
     *              11   9 <--
     *                      12
     *                        1
     *
     *       2
     *     4<      4
     *       17<     5
     *           6    7
     *              11   9
     *                      12
     *                        1
     *
     *        2
     *     4      4
     *        6<     5
     *           17<    7
     *              11   9
     *                      12
     *                        1
     *          2
     *     4      4
     *        6     5
     *           9<     7
     *              11   17<
     *                      12
     *                        1
     *          2
     *     4      4
     *        6     5
     *           9     7
     *              11   12<
     *                      17<
     *                        _     1 removed
     *
     * d)
     *  H = [2 4 4 _ _ 6 5 _ _ 9  7 _ _ 11 12 _ _ _ 17]
     *
     * e) insert 14
     * H = [2 4 4 _ _ 6 5 _ _ 9  7   _  _  11  12  _   _  _   17  14]
     *      0 1 2 3 4 5 6 7 8 9  10 11  12 13  14  15 16  17  18  19
     *
     * H = [2 4 4 _ _ 6 5 _ _ 9  7   _  _  11  12  _   _  _   14  17]
     *      0 1 2 3 4 5 6 7 8 9  10 11  12 13  14  15 16  17  18  19
     *
     * f) remove
     * i - left child 2i + 1 R = 2i + 2
     * parent (i - 1) / 2
     * H = [17 4 4 _ _ 6 5 _ _ 9  7   _  _  11  12  _   _  _   14  17]
     *      0 1 2 3 4 5 6 7 8 9  10 11  12 13  14  15 16  17  18  19
     *
     * i = 0, child = 2
     * H = [4 4 17 _ _ 6 5 _ _ 9  7   _  _  11  12  _   _  _   14  17]
     *      0 1 2 3 4 5 6 7 8 9  10 11  12 13  14  15 16  17  18  19
     * i = 2, child = 6
     * H = [4 4 5 _ _ 6 17 _ _ 9  7   _  _  11  12  _   _  _   14  17]
     *      0 1 2 3 4 5 6 7 8 9  10 11  12 13  14  15 16  17  18  19
     *
     * i = 6, child = 13
     * H = [4 4 5 _ _ 6 17 _ _ 9  7   _  _  17  12  _   _  _   14  2]
     *      0 1 2 3 4 5 6 7 8 9  10 11  12  13  14  15 16  17  18  19
     *
     * i = 13
     * H = [4 4 5 _ _ 6 17 _ _ 9  7   _  _  17  12  _   _  _   14  2]
     *      0 1 2 3 4 5 6 7 8 9  10 11  12  13  14  15 16  17  18  19
     */


    /**
     *  problem 2
     * Carry out the array-based version of HeapSort on the input array
     * [1, 4, 3, 9, 12, 2, 4]
     * Show steps and outputs along the way. Make sure to distinguish between Phase I and
     * Phase II of the algorithm.
     *
     * Answer:
     * Phase 1
     * Heapify
     * [1 | 4  3 9 12 2 4]
     *
     * [1  4 | 3 9 12 2 4]
     * [1  4  3 | 9 12 2 4]
     * [1  4  3  9 | 12 2 4]
     * [1  4  3  9  12 | 2 4]
     * [1  4  3  9  12  2 | 4]
     * [1  4  2  9  12  3 | 4]
     * [1  4  2  9  12  3  4 ]
     *
     * phase2  | remove 1
     * [4 4 2 9 12 3  | 1 ]
     * [2 4 4 9 12 3  | 1 ]
     * [2 4 3 9 12 4  | 1 ]
     * remove 2
     * [4 4 3 9 12 | 2    1 ]
     * [3 4 4 9 12 | 2    1 ]
     * remove 3
     * [12 4 4 9  | 3   2    1 ]
     * [4 4 12 9  | 3   2    1 ]
     * remove 4
     * [9 4 12  |4  3   2    1 ]
     * [4 9 12  |4  3   2    1 ]
     * remove 4
     * [12 9|  4  4  3   2    1 ]
     * [9 12|  4  4  3   2    1 ]
     * remove 9
     * [12| 9  4  4  3   2    1 ]
     *
     * return reverse
     * [1 2 3 4 4 9 12]
     *
     *
     */


    /**
     * problem 3
     *
     * 3. Carry out the steps of the recursive algorithm BottomUpHeap for the input sequence
     * 11, 5, 2, 3, 17, 24, 1. (Or, you can use the iterative algorithm if you prefer.) Then
     * write the heap you obtain from BottomUpHeap as an array and carry out Phase II of
     * HeapSort. Output should be the original array in sorted order.
     *
     * answer:
     *        11, 5, 2, 3, 17, 24, 1
     *   k1 = 11 , A1 = 5 2 3 A2 = 17 24 1
     *
     *   A1:  5 2 3
     *   k2  5 A11 = 2 A12 = 3
     *
     *   T1 =  5 2 3
     *
     *   A2: 17 24 1
     *   k2 = 17  A21 = 24  A22 = 1
     *
     *   T2 = 24 17 1
     *
     *   final
     *                   11
     *                 5    24
     *               2  3  17  1
     *
     * our final BUH
     *                   24
     *                 5    17
     *               2  3  11  1
     *
     * array = [24 5 17 2 3 11 1]
     *
     * phase 2:
     * remove 24
     * [1 5 17 2 3 11 24]
     * [17 5 1 2 3 11 | 24]
     * remove 17
     * [11 5 1 2 | 17 24]
     * remove 11
     * [2 5 1  | 11  17 24]
     * [5 2 1  | 11  17 24]
     * remove 5
     * [1 2 |  5  11  17 24]
     * [2 1 |  5  11  17 24]
     * remove 2
     * [1 | 2 5 11 17 24 ]
     *
     * return
     * 1 2 5 11 17 24
     *
     */

    /**
     * problem 4
     * 4. Draw an example of a MaxHeap whose keys are all the odd numbers lie in [1, 21]
     * (with no repeats), such that the insertion of an item with key 14 would cause up-heap
     * to proceed all the way up to a child of the root (replacing that child’s key with 14).
     *
     * 1 3 5 7 9 11 13 15 17 19 21
     *
     *  H
     *               21
     *          19        13
     *      15    17   11         9
     *               1     3     5     7
     *              -  -  - -   - -   -  -
     *              insert 14
     *  H
     *               21
     *          19        13
     *      15    17   11         9
     *               1     3     5     7
     *              14  -  - -   - -   -  -
     *  H
     *               21
     *          19        13
     *      15    17   11         9
     *               14     3     5     7
     *              1  -  - -   - -   -  -
     *  H
     *               21
     *          19        13
     *      15    17   14         9
     *               11     3     5     7
     *              1  -  - -   - -   -  -
     *  H
     *               21
     *          19        14
     *      15    17   13         9
     *               11     3     5     7
     *              1  -  - -   - -   -  -
     */

}
