package solution;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * <p>Note: All inputs will be in lower-case.
 * 
 * @author Dongliang Yu
 *
 */
public class Anagram {
    public static ArrayList<String> anagrams(String[] strs) {
        int len = strs.length;
        ArrayList<String> result = new ArrayList<String>();
        Signature[] sarr = new Signature[len];
        for (int i = 0; i < len; i++)
            sarr[i] = new Signature(strs[i]);
        Arrays.sort(sarr);
        for (int i = 0; i < len; i++) {
            if (i >= 1 && sarr[i].sig.equals(sarr[i-1].sig))
                result.add(sarr[i].origin);
            else if (i <= len-2 && sarr[i].sig.equals(sarr[i+1].sig))
                result.add(sarr[i].origin);
        }
        return result;
    }
    
    /**
     * This is the version I wrote at Microsoft onsite interview.
     * 
     * The challenge problem coming later:
     * Q: With a huge input that will run out of memory to store and sort, how to deal with it?
     * A: Bottom-up merge sort for small pieces of data. Use file to store temporary results.
     */
    public static ArrayList<ArrayList<String>> anagrams_ms(String[] strs) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        int len = strs.length;
        Signature[] sarr = new Signature[len];
        for (int i = 0; i < len; i++)
            sarr[i] = new Signature(strs[i]);
        Arrays.sort(sarr);
        int i = 0;
        while (i < len) {
            if (i+1 < len && sarr[i].sig.equals(sarr[i+1].sig)) {
                ArrayList<String> cur = new ArrayList<String>();
                cur.add(sarr[i].origin);
                i++;
                while (i < len && sarr[i].sig.equals(sarr[i-1].sig)) {
                    cur.add(sarr[i].origin);
                    i++;
                }
                result.add(cur);
            } else
                i++;
        }
        return result;
    }
    
    static class Signature implements Comparable<Signature> {
        String origin;
        String sig;
        
        public Signature(String str) {
            origin = str;
            char[] carr = str.toCharArray();
            Arrays.sort(carr);
            sig = new String(carr);
        }
        
        @Override
        public int compareTo (Signature that) {
            return this.sig.compareTo(that.sig);
            /*
            int len1 = this.sig.length();
            int len2 = that.sig.length();
            int lim = Math.min(len1, len2); 
            int i = 0;
            while (i < lim) {
                char a = this.sig.charAt(i);
                char b = that.sig.charAt(i);
                if (a != b)
                    return a - b;
                i++;
            }
            return len1 - len2;
            */
        }
    }
    
    public static void main(String[] args) {
        String[] strs = {"dog", "cat", "god", "tac"};
        ArrayList<ArrayList<String>> result = anagrams_ms(strs);
        for (ArrayList<String> e : result) {
            for (String ee : e)
                System.out.print(ee + " ");
            System.out.println();
        }
    }
}