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
    // this version can handle numbers with + or -
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return null;
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || len2 == 0) return "";
        
        // deal with sign
        int sign1 = 1;
        if (num1.charAt(0) == '-') sign1 = -1;
        if (num1.charAt(0) == '+' || num1.charAt(0) == '-') {
            num1 = num1.substring(1);
            len1--;
        }
        int sign2 = 1;
        if (num2.charAt(0) == '-') sign2 = -1;
        if (num2.charAt(0) == '+' || num2.charAt(0) == '-') {
            num2 = num2.substring(1);
            len2--;
        }
        int sign = sign1 * sign2;
        //if (num1.equals("0") || num2.equals("0")) return "0"; //
        
        // calculate
        int len3 = len1 + len2;
        int[] n3 = new int[len3]; // we should use int because char will overflow for middle results
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        for (int j = 0; len2-1-j >= 0; j++)
            for (int i = 0; len1-1-i >= 0; i++)
                n3[len3-1-i-j] += (n1[len1-1-i] - '0') * (n2[len2-1-j] - '0');
        int carry = 0;
        for (int i = len3-1; i >= 0; i--) {
            n3[i] += carry;
            carry = n3[i] / 10;
            n3[i] %= 10;
        }
        
        // collect result
        int i = 0;
        while (i < n3.length && n3[i] == 0) i++; // result not that large (or multiply 0), skip the leading 0s
        if (i == n3.length) return "0"; // multiply 0
        StringBuffer sb = new StringBuffer();
        if (sign == -1) sb.append('-');
        while (i < n3.length)
            sb.append(n3[i++]);
        return sb.toString();
    }
    
    /*
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
    */
}
