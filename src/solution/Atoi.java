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
        str = str.trim(); // "    010" case
        char[] c = str.toCharArray();
        int len = c.length;
        //if (len == 0) return 0; // error
        int i = 0;
        int sign = 1;
        if (c[0] == '-')
            sign = -1;
        if (c[0] == '-' || c[0] == '+')
            i++;
        int val = 0;
        while (i < len) {
            char ch = c[i];
            if (!(ch >= '0' && ch <= '9')) break; // error
            int digit = ch - '0';
            // elegant than below ones
            if (val > Integer.MAX_VALUE/10 || val == Integer.MAX_VALUE/10 && digit > 7) {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            val = val * 10 + digit;
            /* deal with overflow
            if (sign == 1) {
                if (val > MAX/10) return MAX;
                val *= 10;
                if (val > MAX-digit) return MAX;
                val += digit;
            } else {
                if (val > ((long) MAX + 1) / 10) return -MAX-1; // not necessary to use long(MAX)+1
                val *= 10;
                if (val-1 >= MAX-digit) return -MAX-1; // = is special case for Integer.MIN_VALUE (already overflow for = case)
                //if (num-1+digit == MAX) return -MAX-1; //special case for Integer.MIN_VALUE
                val += digit;
            }
            */
            i++; //
        }
        return sign * val;
    }

    public static void main(String[] args) {
        //System.out.println(atoi("      -11919730356x"));
        //System.out.println(Integer.MAX_VALUE+1);
        System.out.println(atoi("      -2147483648"));
    }
}
