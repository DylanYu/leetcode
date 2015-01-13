package solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 * @author Dongliang Yu
 *
 */
public class LargestNumber {
    public String largestNumber(int[] num) {
        String[] arr = new String[num.length];
        for (int i = 0; i < num.length; i++)
            arr[i] = num[i] + "";
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                /*
                char h1 = s1.charAt(0);
                char h2 = s2.charAt(0);
                int i = 0;
                int j = 0;
                while (i < s1.length() || j < s2.length()) {
                    char c1 = (i < s1.length()) ? s1.charAt(i) : h1;
                    char c2 = (j < s2.length()) ? s2.charAt(j) : h2;
                    if (c1 > c2) return -1;
                    else if (c1 < c2) return 1;
                    i++;
                    j++;
                }
                */
                String s12 = s1 + s2;
                String s21 = s2 + s1;
                int ret = s12.compareTo(s21);
                if (ret > 0) return -1;
                else if (ret < 0) return 1;
                else return 0;
            }
        });
        StringBuffer sb = new StringBuffer();
        for (String e : arr)
            sb.append(e);
        if (sb.charAt(0) == '0') return "0"; // special multiple 0 case
        return sb.toString();
    }
}
