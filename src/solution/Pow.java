package solution;

/**
 * Implement pow(x, n).
 * 
 * @author Dongliang Yu
 *
 */
public class Pow {
    public static double pow(double x, int n) {
        //if (n == 0) return 1;
        if (x == 1) return 1;
        if (x == -1) return (n % 2 == 0) ? 1 : -1;
        double ret = power(x, Math.abs(n));
        if (n > 0) return ret;
        else return 1/ret;
    }
    
    private static double power(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        return n % 2 == 0 ? power(x*x, n/2) : power(x*x, n/2) * x;   
    }

    public static void main(String[] args) {
        System.out.println(pow(0.0000000001, 88888));
        System.out.println(pow(1.0000000001, 88888));
        System.out.println(pow(1.000000, -2147483648));
        System.out.println(pow(-1, -2147483647));
        System.out.println(pow(-0.5, -2147483647));
        System.out.println(pow(-0.5, 2147483647));
    }
}
