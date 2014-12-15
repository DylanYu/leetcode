package solution;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * @author Dongliang Yu
 *
 */
public class Sqrt {
    public static int sqrt(int x) {
        if (x < 0) return -1;
        //if (x == 0) return 0;
        int lo = 1;
        int hi = x;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            long mul = (long) mid * mid; // overflow
            if (mul == x) return mid;
            else if (mul < x) lo = mid+1;
            else hi = mid-1;
        }
        return hi;
    }
    
    /**
    public static int sqrt(int x) {
        if (x <= 0)
            return 0;
        return range(1, x, x);
    }
    
    private static int range(int lo, int hi, int x) {
        if (lo + 1 == hi)
            return lo;
        int mid = lo + (hi - lo) / 2;
        long mul = (long) mid * (long) mid;
        if (mul == x)
            return mid;
        else if (mul > x)
            return range(lo, mid, x);
        else
            return range(mid, hi, x);
    }
    */
    
    /*
    private static boolean overflow(int a, int b) {
        if (a != 0 && Integer.MAX_VALUE/a < b)
            return true;
        else
            return false;
    }*/

    public static void main(String[] args) {
        System.out.println(sqrt(0));
        System.out.println(sqrt(1));
        System.out.println(sqrt(3));
        System.out.println(sqrt(4));
        System.out.println(sqrt(5));
        System.out.println(sqrt(2147395599));
    }
}
