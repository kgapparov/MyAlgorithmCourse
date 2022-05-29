package lessons_from_class.Problem1C;

/**
 * @author Khassangali Gapparov
 * @subject Algorithm assignment 3
 */
public class Problem1C {
    /*
    Problem 1.

    Which of the following functions are increasing? eventually nondecreasing? If you
    remember techniques from calculus, you can make use of those.
    (1) f(x) = −x^2
    (2) f(x) = x2 + 2x + 1
    (3) f(x) = x^3 + x

    Answer: increasing for all x ⊆ R number (3)
     */


    /*
    problem 2.  Compute the following limits at infinity:

    1) lim(n-> ∞) (2n^3 + 3n) / (n^3 - 4) = limg(n-∞) (6n^2 + 3) / (3*n2 -4) = lim (n-> ∞) 12n/6n = 2;
    2) lim(n ->∞) n^2/2^n = lim 2n/(ln2*2^n) = lim 2 /(2ln2*2^n) = 0;

     */


    /*
     Suppose A and B are sets (they are given and you do not know what the sets contain). Define a subset C of A (defined in terms of A and B) having the property that C ∩ B = ∅
and A ∪ B = C ∪ B.
      A U B = C U B

      C = A U B U B^c;
    */

    /*
    Problem 4.
    Two TAs are to be chosen from a group of five applicants. Applicants will be ranked
according to background experience, math skills, and performance during interviews. The applicants that are ranked first and second by these criteria will be chosen for the job. In how many
different ways can two of the five applicants be ranked first and second

    answer:
    1. choose 2 TA out of 5 -> selections :
     C(5,2) = 5!/2*(5-2)! = 4*5/2 = 10;
    2. ways of ranking first or second :
     P(5, 2) = 5!/(5-2)! = 4 * 5 = 20;
     */

    /*
    problem 5:

    Use induction to show that for all n > 4, 2n < n!

    Answer:
    I(4) : 2^4 < 4!  16 < 24 is true
    I(n) : assume n > k, 2^n < n!

    I(n + 1) :  prove 2^(n+1) < (n+1)!

    2^n * 2 < n! * (n + 1)
    2^n * 2 < n!*2 (by assumption) < n! * (n+1)
    2 < n + 1, which is true for any n > 4;
     */

    /*

    Problem 6

    Write a Java method

    double log2(double x)
    that outputs log2(x) for any input x. (Note that Java does not have a base-2 logarithm function in its Math library).
     */

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
    /*
    problem 7 - 8
    Screen from paper
     */


}
