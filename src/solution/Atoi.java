package solution;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * @author Dongliang Yu
 *
 */
public class Atoi {
	private static final int MAX = Integer.MAX_VALUE;
    
    // +, -, overflow , 0000000123, if encounter invalid character return last result
    public static int atoi(String str) {
        if (str == null) return 0; // error
        str = str.trim();
        char[] c = str.toCharArray();
        int len = c.length;
        if (len == 0) return 0; // error
        int sign = 0;
        int i = 0;
        if (c[0] == '+') { sign = 1; i++; }
        else if (c[0] == '-') { sign = -1; i++; }
        else sign = 1;
        int num = 0;
        while (i < len) {
            char ch = c[i];
            if (!(ch >= '0' && ch <= '9')) break; // error
            int digit = ch - '0';
            // deal with overflow
            if (sign == 1) {
                if (num > MAX/10) return MAX;
                num *= 10;
                if (num > MAX-digit) return MAX;
                num += digit;
            } else {
                if (num > ((long) MAX + 1) / 10) return -MAX-1;
                num *= 10;
                if (num > (long) MAX + 1 - digit) return -MAX-1;
                if (num-1+digit == MAX) return -MAX-1; //special case for Integer.MIN_VALUE
                num += digit;
            }
            i++; //
        }
        return sign * num;
    }

    public static void main(String[] args) {
        //System.out.println(atoi("      -11919730356x"));
        //System.out.println(Integer.MAX_VALUE+1);
        System.out.println(atoi("      -2147483648"));
    }
}
