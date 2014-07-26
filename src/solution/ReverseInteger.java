package solution;

/**
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * @author Dongliang Yu
 *
 */
public class ReverseInteger {
    // We should consider integers ends with 0s, which is handled by this solution,
    // and overflow cases, for which we just return 0.
    public int reverse(int x) {
        boolean positive = x > 0;
        x = (int) Math.abs(x);
        long reversed = 0; // reversed integer might overflow
        while (x > 0) {
            reversed *= 10;
            reversed += x - x / 10 * 10;
            x /= 10;
        }
        reversed = positive ? reversed : -reversed;
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) return 0; // overflow
        return (int) reversed;
    }
}
