package solution;

/**
 * Implement pow(x, n).
 * 
 * @author Dongliang Yu
 *
 */
public class Pow {
    public static double pow(double x, int n) {
        if (n == 0) return 1;
        if (x == 1) return 1;
        if (x == -1) return (n % 2 == 0) ? 1 : -1;
        boolean negativeBase = x < 0;
        boolean negativeExp = n < 0;
        x = x < 0 ? -x : x;
        n = n < 0 ? -n : n;
        /*
        for (int i = 0; i < n; i++) {
            result *= x;
            // stop early
            if (result == 0.0 || result == Double.POSITIVE_INFINITY)
                break;
        }
        */
        double result = power(x, n);
        return (negativeBase ? (n % 2 == 0 ? 1 : -1) : 1) * (negativeExp ? 1/result : result);
    }
    
    private static double power(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        return n % 2 == 0 ? power(x*x, n/2) : power(x*x, n/2) * x;   
    }

    public static void main(String[] args) {
        System.out.println(pow(-1, -2147483647));
        System.out.println(pow(-0.5, -2147483647));
        System.out.println(pow(-0.5, 2147483647));
    }
}
