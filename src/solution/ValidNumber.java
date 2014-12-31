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
    // 2e6
    // 123. , 123.123
    // +/-, 10a,  +123e-123, 123e123 e 1e1, 1  e10, just e
    // just .
    // not +/-/e/number
    public boolean isNumber(String s) {
        if (s == null) return false;
        s = s.trim();
        if (s.length() == 0) return false;
        s = s.toLowerCase(); // E to e
        String[] segments = s.split("e", -1); // split no -1 will discard tailing 0s, negative means as many as possible
        if (segments.length != 1 && segments.length != 2) return false; // can have at most one "e"
        if (segments.length == 1) return isIntegerOrFloat(segments[0], false); // no "e"
        else return isIntegerOrFloat(segments[0], false) && isIntegerOrFloat(segments[1], true); // xxxEyyy
    }
    
    // hasPoint is true : Float
    // hasPoint is false : Integer
    private boolean isIntegerOrFloat(String s, boolean hasPoint) {
        if (s.length() == 0) return false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1);
        if (s.length() == 0) return false; // just + or - is invalid
        if (s.length() == 1 && s.equals(".")) return false; // just . is invalid
        int pointCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.') {
                pointCount++;
                if (hasPoint && pointCount >= 2) return false; // two more points is invalid
                if (!hasPoint) return false; // the exponent must be an integer, 6e6.5 is invalid
            } else if (!Character.isDigit(c)){ // anything not digit is invalid
                return false;
            }
        }
        return true;
    }
    
    /*
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
    */
    
    public static void main(String[] args) {
        System.out.println(new ValidNumber().isNumber("6e6.5"));
    }
}
