package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Note:
 * Although the above answer is in lexicographical order, 
 * your answer could be in any order you want.
 * 
 * @author Dongliang Yu
 *
 */
public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        if (digits == null) return ret;
        ret.add("");
        for (int i = 0; i < digits.length(); i++)
            combine(digits, i, ret);
        return ret;
    }
    
    private void combine(String digits, int index, List<String> ret) {
        char cur = digits.charAt(index);
        char[] letters = getLetters(cur);
        if (letters.length == 0) return;
        int len = ret.size();
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < letters.length; j++)
                ret.add(ret.get(i) + letters[j]);
            ret.set(i, ret.get(i) + letters[0]);
        }
    }
    
    private char[] getLetters(char digit) {
        switch (digit) {
            case '0':
            case '1':
                return new char[]{};
            case '2':
                return new char[]{'a', 'b', 'c'};
            case '3':
                return new char[]{'d', 'e', 'f'};
            case '4':
                return new char[]{'g', 'h', 'i'};
            case '5':
                return new char[]{'j', 'k', 'l'};
            case '6':
                return new char[]{'m', 'n', 'o'};
            case '7':
                return new char[]{'p', 'q', 'r', 's'};
            case '8':
                return new char[]{'t', 'u', 'v'};
            case '9':
                return new char[]{'w', 'x', 'y', 'z'};
            default:
                return new char[]{};
        }
    }
}
