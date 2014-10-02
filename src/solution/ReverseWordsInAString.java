package solution;

/**
 * Reverse Words in a String 
 * <p>
 * Given an input string, reverse the string word by word.
 * <p>For example,
 * <p>Given s = "the sky is blue",
 * <p>return "blue is sky the".
 * 
 * @author Dongliang Yu
 *
 */
public class ReverseWordsInAString {
	/*
    public static String reverseWords(String s) {
        String[] a = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = a.length-1; i >= 0; i--) {
            sb.append(a[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    */
    
	public String reverseWords(String s) {
        if (s == null) return null;
        char[] c = s.toCharArray();
        int start = 0;
        while (start < c.length && c[start] == ' ') start++;
        if (start == c.length) return "";
        int end = c.length-1;
        while (end >= start && c[end] == ' ') end--;
        
        // delete redundant space between words
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (i-1-count >= start && c[i-1-count] == ' ' && c[i] == ' ')
                count++;
            else
                c[i-count] = c[i];
        }
        end -= count;
        
        reverse(c, start, end);
        int i = start;
        while (i <= end) {
            int j = i;
            while (j <= end && c[j] != ' ') j++;
            reverse(c, i, j-1);
            i = j+1;
        }
        
        char[] ret = new char[end-start+1];
        for (int index = start; index <= end; index++)
        	ret[index-start] = c[index];
        return new String(ret);
    }
	
    private void reverse(char[] c, int lo, int hi) {
        while (lo < hi) {
            char tmp = c[lo];
            c[lo] = c[hi];
            c[hi] = tmp;
            lo++;
            hi--;
        }
    }
	
    public static void main(String[] args) {
    	ReverseWordsInAString reverser = new ReverseWordsInAString();
        System.out.println(reverser.reverseWords(""));
        System.out.println(reverser.reverseWords("  "));
        System.out.println(reverser.reverseWords("  a "));
        System.out.println(reverser.reverseWords("  a  b "));
        System.out.println(reverser.reverseWords("  a b  c d e  f"));
        System.out.println(reverser.reverseWords("  a b  c  e  f"));
        System.out.println(reverser.reverseWords(" the sky is blue  "));
    }
}
