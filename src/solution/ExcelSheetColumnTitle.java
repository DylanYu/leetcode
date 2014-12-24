package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB 
 * 
 * @author Dongliang Yu
 *
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        List<Integer> list = new ArrayList<Integer>();
        while (n > 0) {
            int remainder = n % 26;
            if (remainder == 0) {
                list.add(26);
                n = n/26 - 1;
            } else {
                list.add(remainder);
                n = n / 26;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = list.size()-1; i >= 0; i--)
            sb.append((char) ('A' - 1 + list.get(i)));
        return sb.toString();
    }
}
