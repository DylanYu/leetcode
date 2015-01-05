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
    // (-1, -2147483648), (-2147483648, 1), (-2147483648, -1)
    public String fractionToDecimal(int numerator, int denominator) {
        //if (numerator == 0) return "0";
        if (denominator == 0) return "";
        long dividend = (long) numerator;
        long divisor = (long) denominator;
        long intPart = dividend / divisor; // Integer.MIN_VALUE / -1
        if (intPart * divisor == dividend)
            return intPart+"";
        boolean positive = dividend * divisor >= 0 ? true : false;
        dividend -= intPart * divisor;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        StringBuffer sb = new StringBuffer(); // fractional part
        int i = 0;
        while (dividend != 0 && !map.containsKey(dividend)) {
            map.put(dividend, i);
            dividend *= 10;
            long quotient = dividend / divisor;
            sb.append(quotient);
            dividend -= quotient * divisor;
            i++;
        }
        intPart = Math.abs(intPart);
        if (dividend == 0) { // no repeat
            return String.format("%s%d.%s",
                positive ? "" : "-",
                Math.abs(intPart),
                sb.toString());
        } else {
            int repeatStartIndex = map.get(dividend);
            return String.format("%s%d.%s(%s)",
                positive ? "" : "-",
                Math.abs(intPart),
                sb.substring(0, repeatStartIndex),
                sb.substring(repeatStartIndex));
        }
    }
}
