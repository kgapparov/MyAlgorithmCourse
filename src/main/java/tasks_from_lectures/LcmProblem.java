package tasks_from_lectures;

public class LcmProblem {
    public static int lcm (int x, int y) {
        int  maxElement = Math.max(x, y);
        int current = x * y;
        for (int z = x*y; z >= maxElement; z--) {
            if (divides(x, z) && divides(y, z)) {
                current = z;
            }
        }
        return current;
    }
    private static boolean divides(int a, int b) {
        return a * (b/a) == b;
    }

    /**
     *for All  0 < m , n;
     *
     *   1) m * n = gcd (m , n) * lcm (m, n)
     *
     *   gcd (m , n ) = gcd (n, m mod n)
     *
     *   (m mod n) < m/2;
     *
     */
    public static int gcd (int a, int b) {
        if (b == 0) return a;
        return gcd (b, a % b);
    }

    public static int lcmOptimal(int x, int y) {
        int g = gcd(x, y);
        return x*y / g;
    }
}
