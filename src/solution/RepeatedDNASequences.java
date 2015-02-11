package solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and 
 * T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to 
 * identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that 
 * occur more than once in a DNA molecule.
 * 
 * For example,
 * 
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * @author Dongliang Yu
 *
 */
public class RepeatedDNASequences {
    // use 3 bit per character to represent A, C, G, T, because it's easier 
    // to encode as their last 3 bits in binary are different
    // https://oj.leetcode.com/discuss/24478/i-did-it-in-10-lines-of-c
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new LinkedList<String>();
        if (s == null) return ret;
        int t = 0;
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i = 0; i < s.length(); i++) {
            t = ((t << 3) & 0x3FFFFFFF) | (s.charAt(i) & 7);
            if (i >= 9) {
                if (map.containsKey(t)) {
                    if (map.get(t))
                        ret.add(s.substring(i-9, i+1));
                    map.put(t, false);
                } else
                    map.put(t, true);
            }
        }
        return ret;
    }
}
