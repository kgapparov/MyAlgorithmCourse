package lessons_from_class.problem6;

public class Problem6 {
    /**
     * 1. A red-black tree is said to be derivable if it is obtained from an insertion sequence of
     * nodes, using the rules for insertions starting from an empty tree. Give an example to
     * show that not every red-black tree is derivable. (In other words, you can build a BST
     * that satisfies the four conditions for a red-black tree, and yet there is no way to obtain
     * this tree by successively inserting nodes using the insertion algorithm rules.)
     *
     * Answer:
     * [5,3,8,2,4,7,15,9,11,13,20,11,14,19,21]
     *                          black(5)
     *           black(3)                                 red (8)
     *  black(2)    black(4)           black(7)                              black(15)
     *                            red(9)      red(11)            red(13)                red(20)
     *                                                  black(11)      black(14)       black(19)    black(21)
     *
     * left and right successors has same amount of black nodes. hight difference is 2.
     *
     */

    /**
     *  problem 2
     *  An AVL Tree is a BST that satisfies a different balance condition, namely:
     * The AVL Balance Condition For each internal node x, the height of the left child
     * of x differs from the height of the right child of x by at most 1. (Equivalently, the
     * heights of the left and right subtrees of x differ by at most 1.)
     * Create a red-black tree that does not satisfy the AVL Balance Condition.
     *
     *  * Answer:
     *      * [5,3,8,2,4,7,15,9,11,13,20,11,14,19,21]
     *      *                          black(5)
     *      *           black(3)                                 red (8)
     *      *  black(2)    black(4)           black(7)                              black(15)
     *      *                            red(9)      red(11)            red(13)                red(20)
     *      *                                                  black(11)      black(14)       black(19)    black(21)
     *      *
     *      * left and right successors has same amount of black nodes. hight difference is 2.
     *      *
     *
     *
     */

    /**
     *  Problem 3
     *  Use the insertion algorithm for red-black trees to successively insert the following
     * nodes, starting with an empty tree.
     * a. 1, 2, 3, 4, 5, 6, 7, 8
     * b. 3, 2, 1, 4, 5, 6
     *
     * Answer:
     * insert 1, 2
     *       black (1)
     *                   red(2)
     * insert 3, flit 1-2 and insert 3
     *       b(1)
     *           b(2)
     *               r(3)
     * insert 4, flip 2, 3 colors
     *       b(1)
     *           r(2)
     *               b(3)
     *                  r(4)
     * insert 5, flitp 3-4 and rotations
     *       b(1)
     *           r(2) (g)
     *               r(3) (p)
     *                  b(4) (x)
     * insert 5, case 1 rotation outside childs and insert 5
     *        b(1)
     *                b(3) (p)
     *        b(2) (g)      b(4) (x)
     *                           r (5)
     * insert 6, flit and insert
     *        b(1)
     *                b(3) (p)
     *           r(2) (g)      r(4) (x)
     *                                  b(5)
     *                                      red(6)
     * insert 7, flip and rotate
     *        b(1)
     *                   b(3) (p)
     *            r(2) (g)      b(5) p
     *                     b(4) g    b(6) x
     *                                    r(7)
     * insert 8, flip and rotate
     *        b(1)
     *                   b(3) (p)
     *            r(2) (g)      b(5)
     *                     b(4)     b(6)
     *                                  b(7)
     *                                      r(8)
     *
     *
     */

    /**
     * Problem 4
     *
     * Interview Question. Give a o(n) (“little-oh”) algorithm for determining whether a
     * sorted array A containing n distinct integers contains an element m for which
     * A[m] = m. You must also provide a proof that your algorithm runs in o(n) time.
     *
     * Answer:
     * for all 0 <= m <= n; we have Array with |A| = n;
     * if |A| = n and array is sorted, then arr[i] < arr[j] for all i < j;
     * The element A[m] = m, then, if Arr[i] >=0 and Arr has distinct elements that it means
     * [Ar[0] .. Arr[m]] we have exactly m elements, and only possible elements is 0 .. m or index  is equal
     * to value.
     *
     * for any array |A| with distinct n elements where 0 < elements <= n; the only option is A[element]=element
     * for checking is sorted we need O(1) operation thus is o(n);
     */
}
