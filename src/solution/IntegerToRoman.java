package solution;

/**
 * I = 1; V = 5; X = 10; L = 50; C = 100; D = 500; M = 1000;
 * 
 * A smaller number in front of a larger number means subtraction, all else means addition. 
 * For example, IV means 4, VI means 6.
 * You would not put more than one smaller number in front of a larger number to subtract. 
 * For example, IIV would not mean 3.
 * You must separate ones, tens, hundreds, and thousands as separate items. That means that 99 
 * is XCIX, 90 + 9, but never should be written as IC. Similarly, 999 cannot be IM and 
 * 1999 cannot be MIM.
 * 
 * 3947 = MMMCMXLVII
 * 
 * @author Dongliang Yu
 * 
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        char[] one = {'I', 'X', 'C', 'M'};
        char[] five = {'V', 'L', 'D'};
        for (int i = 3; i >= 0; i--) {
            int divisor = (int) Math.pow(10, i);
            int cur = num / divisor;
            num = num - num / divisor * divisor;
            if (cur > 0) {
                if (cur == 4) {
                    sb.append(one[i]);
                    sb.append(five[i]);
                } else if (cur == 9) {
                    sb.append(one[i]);
                    sb.append(one[i + 1]);
                } else {
                    if (cur >= 5) {
                        sb.append(five[i]);
                        cur -= 5;
                    }
                    for (int j = 0; j < cur; j++)
                        sb.append(one[i]);
                }
            }
        }
        return sb.toString();
    }
}
