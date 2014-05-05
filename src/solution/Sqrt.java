package solution;

/**
 * Implement int sqrt(int x).
 * <p>Compute and return the square root of x.
 * 
 * @author Dongliang Yu
 *
 */
public class Sqrt {
    public static int sqrt(int x) {
        if (x <= 0)
            return 0;
        int max_sqrt = (int) Math.pow(2, 16);
        return range(1, Math.max(x, max_sqrt), x);
    }
    
    private static int range(int lo, int hi, int x) {
        if (lo + 1 == hi)
            return lo;
        int mid = lo + (hi - lo) / 2;
        int mul = mid * mid;
        if (mul == x)
            return mid;
        else if (overflow(mid, mid) || mul > x)
            return range(lo, mid, x);
        else
            return range(mid, hi, x);
    }
    
    private static boolean overflow(int a, int b) {
        if (a != 0 && Integer.MAX_VALUE/a < b)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(0));
        System.out.println(sqrt(1));
        System.out.println(sqrt(3));
        System.out.println(sqrt(4));
        System.out.println(sqrt(5));
        System.out.println(sqrt(2147395599));
    }
}
