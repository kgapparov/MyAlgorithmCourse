package lessons_from_class.problem9;

public class Problem9 {
    /**
     * Problem 1
     *
     * Show that for any simple graph G (not necessarily connected) having n vertices and m edges, if
     * m ≥ n, then G contains a cycle
     *
     * Answer:
     * Suppose G consist from components G0 G1 ... Gk => G(n, m) =>G0(m0 , n0) , Gk (mk, nk) which is connected
     * components, thus
     * to beeing connected we need m0 = n0 - 1 edges,
     * m = n0 -1 + n1 -1 + .. + nk -1 = n - K;
     * k - component counts. to be connected if we have 1 component then we need m = n - 1, adding extra edges m > n will
     * cause cycle
     *
     *
     */

    /**
     * problem 2
     *
     * Suppose G = (V, E) is a connected simple graph. Suppose S = (VS, ES) and T = (VT, ET) are subtrees
     * of G with no vertices in common (in other words, VS and VT are disjoint). Show that for any edge
     * (x,y) in E for which x is in VS and y is in VT, the subgraph obtained by forming the union of S, T
     * and the edge (x,y) (namely, U = (VS U VT, ES U ET U {(x,y)})) is also a tree.
     *
     *
     *
     */

    /**
     * Prove that if T is a tree with at least two vertices, T has at least two vertices having degree 1.
     * Hint. Let v be any vertex in T and think of T as a rooted tree with vertex v. Create the usual levels
     * for the tree. Then use properties of such a tree to solve the problem.
     *
     */
}

