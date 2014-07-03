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
        char[] aa = a.toCharArray();
        char[] ab = b.toCharArray();
        ArrayList<Character> clist = new ArrayList<Character>();
        boolean carry = false;
        int i = aa.length - 1;
        int j = ab.length - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry ? 1 : 0;
            if (i >= 0) {
                if (aa[i] == '1') sum++;
                i--;
            }
            if (j >= 0) {
                if (ab[j] == '1') sum++;
                j--;
            }
            carry = sum <= 1 ? false : true;
            sum = sum % 2;
            clist.add((char) ('0' + sum));
        }
        if (carry) clist.add('1');
        Collections.reverse(clist);
        char[] arr = new char[clist.size()];
        for (i = 0; i < arr.length; i++)
            arr[i] = clist.get(i);
        return new String(arr);
    }

    public static void main(String[] args) {
        String a = "1011";
        String b = "110";
        System.out.println(addBinary(a, b));
    }
}
