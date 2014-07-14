package solution;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * @author Dongliang Yu
 *
 */
public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        //? if (divisor == 0) return;
        boolean positive;
        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) positive = true;
        else positive = false;
        long d1 = Math.abs((long) dividend); // caveat: abs could overflow for -2147483648
        long d2 = Math.abs((long) divisor);
        if (d2 > d1) return 0;
        int result = divide(d1, d2, 0);
        if (positive) return result;
        else return -result;
    }
    
    private static int divide(long remainder, long divisor, int times) {
        if (remainder < divisor) return times;
        int t = 0;
        long d = divisor;
        while (d <= remainder) {
            d += d; // use long to avoid int overflow
            t++;
        }
        return divide(remainder - (d >> 1), divisor, times + (1 << (t - 1)));
    }
    
    public static void main(String [] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(divide(10, 2));
        System.out.println(divide(1000, 3));
        System.out.println(divide(Integer.MAX_VALUE, 2));
        System.out.println(divide(Integer.MAX_VALUE, 1));
        System.out.println(divide(-1010369383, -2147483648));
    }
}
