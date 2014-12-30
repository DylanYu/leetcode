package solution;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * @author Dongliang Yu
 *
 */
public class FactorialTrailingZeros {
    public int trailingZeroes(int n) {
        if (n <= 0) return 0;
        int zeros = 0;
        int divisor = 5;
        while (divisor <= n) {
            zeros += (n / divisor);
            divisor *= 5;
        }
        return zeros;
    }
}
