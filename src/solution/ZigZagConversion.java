package solution;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * 
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * @author Dongliang Yu
 *
 */
public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if (s == null || nRows == 0) return null;
        if (s.length() == 0 || nRows == 1) return s;
        
        int len = s.length();
        StringBuffer[] sarr = new StringBuffer[nRows];
        for (int i = 0; i < nRows; i++) sarr[i] = new StringBuffer();
        
        int i = 0;
        int row = 0;
        while (i < len) {
            int move = 0;
            while (i < len && move < 2*nRows-2) {
                if (move < nRows-1)
                    sarr[row++].append(s.charAt(i++));
                else
                    sarr[row--].append(s.charAt(i++));
                move++;
            }
        }
        /*
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sarr[idx].append(s.charAt(i++));
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sarr[idx].append(s.charAt(i++));
        }
        */
        for (int idx = 1; idx < sarr.length; idx++)
            sarr[0].append(sarr[idx]);
        return sarr[0].toString();
    }
}
