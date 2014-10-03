package solution;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * <p>For example,
 * <p>a = "11"
 * <p>b = "1"
 * <p>Return "100".
 * 
 * @author Dongliang Yu
 *
 */
public class AddBinary {
	public static String addBinary(String a, String b) {
        if (a == null || b == null) return null;
        int len1 = a.length();
        int len2 = b.length();
        if (len1 == 0) return b;
        if (len2 == 0) return a;
        int len = 1 + Math.max(len1, len2);
        char[] c = new char[len];
        int carry = 0;
        int i = 0;
        while (len1-1-i >= 0 || len2-1-i >= 0) {
            int i1 = len1-1-i >= 0 ? a.charAt(len1-1-i)-'0' : 0;
            int i2 = len2-1-i >= 0 ? b.charAt(len2-1-i)-'0' : 0;
            int sum = i1 + i2 + carry;
            carry = sum / 2;
            sum %= 2;
            c[len-1-i] = (char) (sum + '0'); //
            i++; //
        }
        if (carry == 1) c[0] = '1';
        else c[0] = ' '; // sum not so big
        return new String(c).trim();
    }

    public static void main(String[] args) {
        String a = "1011";
        String b = "110";
        System.out.println(addBinary(a, b));
    }
}
