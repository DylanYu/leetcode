package solution;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * @author Dongliang Yu
 *
 */
public class Atoi {
    public static int atoi(String str) {
        str = str.trim();
        if (str.equals("")) return 0;
        char[] a = str.toCharArray();
        int length = a.length;
        int num = 0;
        boolean positive = true;
        int i = 0;
        if (a[i] == '-') {
            positive = false;
            i++;
        } else if (a[i] == '+') {
            positive = true;
            i++;
        }
        while (i < length) {
            char c = a[i];
            if (c >= '0' && c <= '9') {
                int digit = c - '0';
                long carried = (long) num * 10; // overflow is possible here
                long diff = Integer.MAX_VALUE - carried;
                if (positive) {
                    if (diff <= digit) return Integer.MAX_VALUE;
                } else {
                    if (diff <= digit - 1) return Integer.MIN_VALUE;
                }
                num = (int) carried + digit; // carried is not overflowed thanks for previous check
            } else
                break;
            i++;
        }
        return positive ? num : -num;
    }

    public static void main(String[] args) {
        System.out.println(atoi("      -11919730356x"));
    }
}
