package solution;

/**
 * Related to question @link ExcelSheetColumnTitle
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28 
 * 
 * @author Dongliang Yu
 *
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0; // Exception
        int num = 0;
        for (int i = 0; i < s.length(); i++)
            num = num * 26 + (s.charAt(i)-'A'+1);
        return num;
    }
}
