package solution;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int length = s.length();
        char[] a = s.toCharArray();
        int max_left = 0;
        int max_right = 0;
        int max_side_len = 0;
        int max_len = 0;
        int i = 0;
        while (i < length) {
            int left = i; // [left, right] is the center part of a palindrome
            int right = i;
            int side_len = 1;
            // [left-side_len, left)[left, right][right+1, right+side_len]
            //       abcd...xy          ZZZZZ            yx...dcba 
            while (left >= 1 && a[left-1] == a[left]) left--;
            while (right <= length-2 && a[right] == a[right+1]) right++;
            while (left-side_len >= 0 && right+side_len < length &&
                    a[left-side_len] == a[right+side_len])
                    side_len++;
            side_len--;
            int len = side_len * 2 + right - left + 1;
            if (len > max_len) {
                max_len = len;
                max_left = left;
                max_right = right;
                max_side_len = side_len;
            }
            i = right + 1;
        }
        return s.substring(max_left - max_side_len, max_right + max_side_len + 1);
    }
	
	/*
	 * less efficient solution
	 *
	public String longestPalindrome(String s) {
        if (s == null) return null;
        char[] c = s.toCharArray();
        int len = c.length;
        if (len == 0) return "";
        int maxLen = 0;
        String maxStr = "";
        for (int i = 0; i < len; i++) {
            // odd length case;
            int left = i-1;
            int right = i+1;
            while (left >= 0 && right < len && c[left] == c[right]) {
                left--;
                right++;
            }
            int l = right-left-1;
            maxLen = Math.max(maxLen, l);
            if (maxLen == l) maxStr = s.substring(left+1, right);
            // even length case
            if (i+1 < len && c[i+1] == c[i]) {
                left = i-1;
                right = i+2;
                while (left >= 0 && right < len && c[left] == c[right]) {
                    left--;
                    right++;
                }
                l = right-left-1;
                maxLen = Math.max(maxLen, l);
                if (maxLen == l) maxStr = s.substring(left+1, right);
            }
        }
        return maxStr;
    }
	*/
    
    public static void main(String[] args) {
        String s = "aaaaccbcaaaaaaaaaaaaaacaaaaaaaaaaaaaa";
        //String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        //String s = "bb";
        System.out.println(longestPalindrome(s));
    }
}
