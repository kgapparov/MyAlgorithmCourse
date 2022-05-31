package lessons_from_class.problem5;

import java.util.List;

/**
 * @author Khassangali
 * @email kgapparov@miu.edu
 */
public class Problem5<T> {
    /**
     * Problem 1
     * Implement an enhanced stack that supports push, pop, peek, isEmpty and
     * also min, so that worst case running time for any operation is still O(1). Write down
     * your idea and your logic for concluding that operations are in every case O(1). Then
     * implement your idea in a Java class called MinStack.
     */

//    Answer:
    // look on main method and at current package MinStackImpl is created.

    /**
     * Problem 2
     *Devise an algorithm for reversing the elements in a singly linked list. Implement your
     * solution in code. You can use the singly linked list in the lab folder. What is the running
     * time of your reverse algorithm?
     */

    /**
     * Answer:
     * First bruteforce solution is traverse each time until index n, n - 1, n - 2 ... 1 element and save nodes
     * int new link. in total it will take O(n^2)
     *
     * Better solution for this is three pointer approach: points on Pre, Curr, Next. rearrange the links between nodes
     * and reverse the link in one iteration
     *
     *    public Node reverse(){
     *         Node pre = null, curr = head, next = null;
     *         while (curr != null) {
     *             next = curr.next;
     *             curr.next = pre;
     *             pre = curr;
     *             curr = next;
     *         }
     *         head = pre;
     *         return head;
     *     }
     *
     *   source code implemented in the file
     */

    /**
     * problem 3
     *
     * Create a sorting routine based on a BST and place it in the sorting environment,
     * distributed earlier. For this exercise, your new class BSTSort should be a subclass of
     * Sorter. Your BSTSort class can be essentially the same as the BST class given in the
     * slides (see the folder in your labs directory for this lab), except that you will need to
     * modify the printTree method so that it outputs values to an array (rather than printing
     * to console).
     * After you have implemented, discuss the asymptotic running time of your new sorting
     * algorithm. Run an empirical test in the sorting environment and explain where
     * BSTSort fits in with the other sorting routines (which algorithms is it faster than?
     * which is it slower than?).
     *
     * public List<Integer> getSortedArray(){
     *         List<Integer> list = new ArrayList<>();
     *         if (root == null) {
     *             return list;
     *         }
     *         else
     *             getSortedArray(root, list);
     *         return list;
     *     }
     *
     *     public void getSortedArray(Node root, List<Integer> list) {
     *         if (root != null) {
     *             getSortedArray(root.left, list);
     *             list.add(root.element);
     *             getSortedArray(root.right, list);
     *         }
     *     }
     *
     * Runtime of sorting array:
     *  inserting to one element to bst O(log n), n => O(n*Log n)
     *  reading O(n), thus O(n + n*log n) = O(n * log n)
     */


    /**
     * problem 4
     * For each integer n = 1, 2, 3,…, 7, determine whether there exists a red-black tree
     * having exactly n nodes, with all of them black. Fill out the chart below to tabulate the
     * results:
     *
     * 1 - yes
     * 2 - no
     * 3 - yes
     * 4 - no
     * 5 - no
     * 6 - no
     * 7 - yes
     */

    /**
     * Problem 5
     *
     * For each integer n = 1,2,3,…, 7, determine whether there exists a red-black tree
     * having exactly n nodes, where exactly one of the nodes is red. Fill out the chart below
     * to tabulate the results:
     *
     * 1 - No
     * 2 -  yes
     * 3 - no
     * 4 - yes
     * 5 - no
     * 6 - yes
     * 7 - no
     */
    public static void main(String[] args) {
        MinStack<Integer> stack = new MinStackImpl<>();

        stack.push(2);
        stack.push(3);
        System.out.println(stack.min());
        stack.pop();
        stack.push(5);
        stack.push(1);
        System.out.println(stack.peek());
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());

        //problem 3 output
        BSTSort bst = new BSTSort();
        for (int i = 15; i >= 0; --i) {
            bst.insert(new Integer(2 * i));
            bst.insert(new Integer(2 * i - 5));
        }
        List<Integer> list = bst.getSortedArray();
        System.out.println(list);

    }


}
