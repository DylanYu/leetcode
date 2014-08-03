package solution;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author Dongliang Yu
 *
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        //if (x <= 9) return true; don't do this to avoid extra work
        int len = 0;
        int tmp = x;
        while (tmp > 0) {
            len++;
            tmp /= 10;
        }
        int divider = (int) Math.pow(10, len-1);
        while(x > 0) {
            if (x / divider != x % 10) return false;
            x = (x - x / divider * divider) / 10;
            divider /= 100;
        }
        return true;
    }
}
