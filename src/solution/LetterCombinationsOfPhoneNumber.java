package solution;

import java.util.List;
import java.util.LinkedList;

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
        List<String> ret = new LinkedList<String>();
        recurse(new StringBuffer(), digits, ret);
        return ret;
    }
    
    private void recurse(StringBuffer sb, String digits, List<String> ret) {
        if (digits.length() == 0) {
            ret.add(sb.toString());
            return;
        }
        for (char c : map[digits.charAt(0)-'0'].toCharArray()) {
            sb.append(c);
            recurse(sb, digits.substring(1), ret);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    private String[] map = new String[] {
        " ",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    
    /**
     *  BFS
     *
    public List<String> letterCombinations(String digits) {
         List<String> ret = new LinkedList<String>();
         ret.add("");
         for (int i = 0; i < digits.length(); i++) {
             int size = ret.size();
             char[] chs = map[digits.charAt(i)].toCharArray();
             for (int j = 0; j < size; j++) {
                String s = ret.get(j);
                ret.set(j, s+chs[0]); // reuse the space
                 for (int idx = 1; idx < chs.length; idx++)
                     ret.add(s+chs[idx]);
             }
         }
         return ret;
     }
     */
}
