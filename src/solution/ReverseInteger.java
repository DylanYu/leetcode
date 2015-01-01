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
        // abs(Integer.MIN_VALUE) will overflow, but abs(Integer.MIN_VALUE) is 
        // Integer.MIN_VALUE, so the while loop is skipped, which return 0...
        //if (x == Integer.MIN_VALUE) return 0;
        x = Math.abs(x);
        int num = 0;
        while (x > 0) {
            int digit = x % 10;
            if (num > MAX/10 || num == MAX/10 && digit > 7) {
                //if (sign == 1) return MAX;
                //else return -MAX-1;
                return 0; // follow the requirement
            }
            num = num * 10 + digit;
            x /= 10;
        }
        return sign * num;
    }
    
    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(Integer.MIN_VALUE));
    }
}
