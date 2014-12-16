package solution;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example,
 *  a = "11"
 *  b = "1"
 *  Return "100".
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
        int len3 = 1 + Math.max(len1, len2);
        char[] c = new char[len3];
        int carry = 0;
        for (int i = 0; i < len1 || i < len2; i++) {
            int bit1 = i < len1 ? a.charAt(len1-1-i)-'0' : 0;
            int bit2 = i < len2 ? b.charAt(len2-1-i)-'0' : 0;
            int sum = bit1 + bit2 + carry;
            carry = sum / 2;
            sum %= 2;
            c[len3-1-i] = (char) (sum + '0'); //
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
