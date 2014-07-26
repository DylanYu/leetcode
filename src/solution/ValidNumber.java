package solution;

/**
 * Validate if a given string is numeric.
 *
 * Valid:
 * " 0.1 ", "00123", "1e+2", "-1e2", ".123", "123."
 * Invalid:
 * " ", ".", "e", "e2", "12a3", "++321", ".e2", "1e2.3", "1e2.3"(!)
 * 
 * @author Dongliang Yu
 *
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim().toLowerCase();
        if (s.length() == 0) return false;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') s = s.substring(1); // - +
        int point = 0;
        int pIndex = -1;
        int e = 0;
        int eIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c >= '0' && c <= '9')) { // not a digit
                if (c == '.') {
                    point++;
                    pIndex = i;
                    if (point >= 2) return false;
                } else if (c == 'e') {
                    e++;
                    eIndex = i;
                    if (e >= 2) return false;
                } else if (c == '+' || c == '-') {
                    if (i == 0 || s.charAt(i-1) != 'e'
                        || i == s.length()-1) return false; // 132e+, +-123
                } else 
                    return false; // not a digit and not '.', 'e', '+', '-'
            }
        }
        if (e == 1) {
            String[] strs = s.split("e", -1); // split as many as we can
            if (strs[0].equals("") || strs[1].equals("")) return false; // "e", "1e", "e2"
            if (pIndex > eIndex) return false; // 1e2.3
            else if (pIndex != -1) { // '.' before 'e'
                if (strs[0].length() == 1) return false; // .e1
            }
        }
        if (point == 1 && s.length() == 1) return false; // "."
        // "123.", ".123" are valid
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new ValidNumber().isNumber("6e6.5"));
    }
}
