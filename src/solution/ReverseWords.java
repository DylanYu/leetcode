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
public class ReverseWords {
    public static String reverseWords(String s) {
        String[] a = s.trim().split("\\s+");
        int half = a.length / 2;
        for (int i = 0; i < half; i++)
            swap(a, i, a.length - 1 - i);
        StringBuilder sb = new StringBuilder();
        for (String e : a) {
            sb.append(e);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    public static void swap(String[] arr, int a, int b) {
        String tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    
    public static void main(String[] args) {
        System.out.println(reverseWords("  "));
        System.out.println(reverseWords("  a "));
        System.out.println(reverseWords("  a  b "));
        System.out.println(reverseWords("  a b  c d e  f"));
        System.out.println(reverseWords("  a b  c  e  f"));
        System.out.println(reverseWords(" the sky is blue  "));
    }
}
