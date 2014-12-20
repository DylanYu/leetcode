package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, 
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * 
 * For example,
 * 
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * 
 * @author Dongliang Yu
 *
 */
public class FractionToRecurringDecimal {
    // (-1, -2147483648), (-2147483648, 1)
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";
        long dividend = (long) numerator; // overflow
        long divisor = (long) denominator; // overflow
        long intPart = dividend / divisor;
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return intPart + "";
        } else {
            dividend = Math.abs(remainder) * 10;
            divisor = Math.abs(divisor);
            StringBuffer sb = new StringBuffer();
            Map<Long, Integer> map = new HashMap<Long, Integer>();
            boolean repeat = true;
            int i = 0;
            while (!map.containsKey(dividend)) {
                map.put(dividend, i);
                long quotient = dividend / divisor;
                sb.append(quotient);
                remainder = dividend % divisor;
                if (remainder == 0) {
                    repeat = false;
                    break;
                } else
                    dividend = remainder * 10;
                i++;
            }
            boolean positive = (numerator >= 0 && denominator >= 0) || (numerator <= 0 && denominator <= 0); // for negative no integer part case
            intPart = Math.abs(intPart);
            if (repeat) {
                int repeatStart = map.get(dividend);
                return String.format("%s%d.%s(%s)", positive ? "" : "-", intPart, sb.substring(0, repeatStart), sb.substring(repeatStart));
            } else {
                return String.format("%s%d.%s", positive ? "" : "-", intPart, sb.toString());
            }
        }
    }
}
