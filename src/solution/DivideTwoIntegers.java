package solution;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * @author Dongliang Yu
 *
 */
public class DivideTwoIntegers {
    // non-recursive solution
    public static int divide(int dividend, int divisor) {
        //if (dividend == 0) return 0; // handled by later logic
        //if (divisor == 0) throw new Exception();
        int sign = 0;
        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) sign = 1;
        else sign = -1;
        int ret = 0;
        long dividendL = Math.abs((long) dividend); // caveat: abs could overflow for -2147483648
        long divisorL = Math.abs((long) divisor); //
        //if (dividendL < divisorL) return 0;
        while (dividendL >= divisorL) {
            long d = divisorL;
            int count = 1;
            while (d <= dividendL>>1) {
                d += d;
                count++;
            }
            dividendL -= d;
            ret += 1 << (count-1);
        }
        return sign * ret;
    }
    
    /*
     * recursive solution
     * 
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
    */
    
    /*
     * faster but maybe not necessary
     *
    public static int divide(int dividend, int divisor) {
        //if (dividend == 0) return 0; // handled by later logic
        //if (divisor == 0) throw new Exception();
        int sign = 0;
        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) sign = 1;
        else sign = -1;
        int ret = 0;
        long dividendL = Math.abs((long) dividend); // caveat: abs could overflow for -2147483648
        long divisorL = Math.abs((long) divisor); //
        //if (dividendL < divisorL) return 0;
        long d = divisorL;
        int count = 1;
        // find the biggest d
        if (dividendL >= divisorL) {
            while (d <= dividendL>>1) {
                d += d;
                count++;
            }
            dividendL -= d;
            ret += 1 << (count-1);
        }
        
        while (dividendL >= divisorL) {
            // right shift d to avoid recomputation
            while (d > dividendL) {
                d >>= 1;
                count--;
            }
            dividendL -= d;
            ret += 1 << (count-1);
        }
        return sign * ret;
    }
    */
    
    public static void main(String [] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(divide(10, 2));
        System.out.println(divide(1000, 3));
        System.out.println(divide(Integer.MAX_VALUE, 2));
        System.out.println(divide(Integer.MAX_VALUE, 1));
        System.out.println(divide(-1010369383, -Integer.MIN_VALUE));
    }
}
