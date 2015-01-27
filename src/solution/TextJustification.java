package solution;

import java.util.List;
import java.util.LinkedList;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L 
 * characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words as you can in 
 * each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces 
 * on a line do not divide evenly between words, the empty slots on the left will be assigned more 
 * spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * 
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * Return the formatted lines as:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 
 * Note: 
 * 1. Each word is guaranteed not to exceed L in length.
 * 2. A line other than the last line might contain only one word, this line should be left-justified.
 * 
 * @author Dongliang Yu
 *
 */
public class TextJustification {
    /**
     * This problem is supposed to be tedious, and cases:
     * add extra space for not divisible number of spaces,
     * single char, L == 1,
     * empty string, L == 0,
     * every line should have L length (last line and one word line),
     * last line is left-justified and only one space between each word
     */
    public List<String> fullJustify(String[] words, int L) {
        List<String> ret = new LinkedList<String>();
        int i = 0;
        while (i < words.length) {
            int j = i;
            int minLen = words[j++].length();
            int n = 1;
            while (j < words.length && minLen+words[j].length()+1 <= L) {
                minLen += words[j++].length()+1;
                n++;
            }
            
            int wordLen = minLen-n+1;
            int space = L - wordLen;
            int perSpace = (n == 1) ? 0 : space / (n-1); // space between each word
            int extraSpace = (n == 1) ? 0 : space % (n-1); // extra space added for front words
            if (j == words.length) { // just for last line
                perSpace = 1;
                extraSpace = 0;
            }
            
            StringBuffer sb = new StringBuffer();
            sb.append(words[i++]);
            while (i < j) {
                for (int k = 0; k < perSpace; k++) sb.append(' ');
                if (extraSpace-- > 0)
                    sb.append(' ');
                sb.append(words[i++]);
            }
            while (sb.length() < L) sb.append(' '); // one word and last line case
            
            ret.add(sb.toString());
        }
        return ret;
    }
}
