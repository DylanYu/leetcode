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
    public List<String> fullJustify(String[] words, int L) {
        List<String> ret = new LinkedList<String>();
        if (words.length == 0) return ret;
        int i = 0;
        while (i < words.length) {
            LinkedList<String> list = new LinkedList<String>();
            int n = 1;
            int len = words[i].length();
            list.add(words[i++]);
            while (i < words.length && len+words[i].length()+1 <= L) {
                list.add(words[i]);
                len += words[i].length()+1;
                n++;
                i++;
            }
            StringBuffer sb = new StringBuffer();
            
            if (i == words.length) { // special case for last line
                sb.append(list.removeFirst());
                while (!list.isEmpty()) {
                    sb.append(' ');
                    sb.append(list.removeFirst());
                }
                while (len++ < L) sb.append(' ');
                ret.add(sb.toString());
                break;
            }
            
            int spaceLen = L - len + (n-1);
            int perWordSpaceLen = n == 1 ? spaceLen : spaceLen / (n-1);
            int extraSpace = n == 1 ? 0 : spaceLen % (n-1);
            sb.append(list.removeFirst());
            if (list.isEmpty())
                while (perWordSpaceLen-- > 0) sb.append(' ');
            while (!list.isEmpty()) {
                int j = 0;
                while (j++ < perWordSpaceLen) sb.append(' ');
                if (extraSpace-- > 0) sb.append(' ');
                sb.append(list.removeFirst());
            }
            ret.add(sb.toString());
        }
        return ret;
    }
}
