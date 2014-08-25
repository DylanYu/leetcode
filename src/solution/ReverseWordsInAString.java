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
    
    public static void main(String[] args) {
        System.out.println(reverseWords(""));
        System.out.println(reverseWords("  "));
        System.out.println(reverseWords("  a "));
        System.out.println(reverseWords("  a  b "));
        System.out.println(reverseWords("  a b  c d e  f"));
        System.out.println(reverseWords("  a b  c  e  f"));
        System.out.println(reverseWords(" the sky is blue  "));
    }
}
