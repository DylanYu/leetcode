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
    /*
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
    */
    
    private static final int MAX = Integer.MAX_VALUE;
    
    // a solution dealing with overflow cases without Long
    // for oveflow cases, return closest MAX_VALUE or MIN_VALUE
    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;
        if (x == Integer.MIN_VALUE) return x; // abs(x) will overflow
        x = Math.abs(x);
        int num = 0;
        while (x > 0) {
            int digit = x % 10;
            if (sign == 1) {
                if (num > MAX/10) return MAX;
                num *= 10;
                if (num > MAX-digit) return MAX;
                num += digit;
            } else {
                if (num > ((long)MAX + 1) / 10) return -MAX-1; // in fact MAX/10 is enough
                num *= 10;
                if (num > ((long)MAX + 1 - digit)) return -MAX-1;
                if (num-1+digit == MAX) return -MAX-1; // special case for Integer.MIN_VALUE
                num += digit;
            }
            x /= 10;
        }
        
        return sign * num;
    }
}
