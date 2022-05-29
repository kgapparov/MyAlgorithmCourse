package lessons_from_class.Problem1C;

public class Logarithm {
    private Logarithm(){}
    public static double log2(double x) {
        if (x == 1.0) {
            return 0;
        }
        double low =0, heigh =  x;
        while (low < heigh) {
            double mid = low + (heigh - low)/2.0;
            double power = Math.pow(2, mid);
            if (power == x) {
                return mid;
            } else if (power < x) {
                low = mid;
            } else {
                heigh = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(Logarithm.log2(3));
    }
}
