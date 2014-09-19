package solution;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * @author Dongliang Yu
 *
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return null;
        //if (num1.equals("0") || num2.equals("0")) return "0";
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int[] ret = new int[n1.length+n2.length];
        for (int j = n2.length-1; j >= 0; j--) {
            for (int i = n1.length-1; i >= 0; i--) {
                ret[i+j+1] += (n2[j]-'0') * (n1[i]-'0');
            }
        }
        for (int i = ret.length-1; i >= 1; i--) {
            if (ret[i] >= 10) {
                ret[i-1] += ret[i]/10;
                ret[i] %= 10;
            }
        }
        int i = 0;
        while (i < ret.length && ret[i] == 0) i++; // eliminate leading 0s
        if (i == ret.length) return "0"; // num1 or(and) num2 is "0", later logic can NOT handle this case
        StringBuffer sb = new StringBuffer();
        while (i < ret.length) sb.append(ret[i++]);
        return sb.toString();
    }
}
