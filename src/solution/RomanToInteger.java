package solution;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author Dongliang Yu
 *
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        if (s == null) return -1;
        int[] converter = new int['z'];
        converter['i'] = 1;
        converter['v'] = 5;
        converter['x'] = 10;
        converter['l'] = 50;
        converter['c'] = 100;
        converter['d'] = 500;
        converter['m'] = 1000;
        s = s.toLowerCase();
        char[] c = s.toCharArray();
        int number = converter[c[c.length-1]];
        for (int i = c.length-2; i >= 0; i--) {
            if (converter[c[i]] >= converter[c[i+1]]) number += converter[c[i]];
            else number -= converter[c[i]];
        }
        return number;
    }
    
    /*
    private int getInt(char c) {
        switch (c) {
            case 'I': return 1; // no statement after return, or error when compiling
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }
    
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length()-1 || i < s.length()-1 && getInt(s.charAt(i)) >= getInt(s.charAt(i+1)))
                num += getInt(s.charAt(i));
            else
                num -= getInt(s.charAt(i));
        }
        return num;
    }
    */
}
