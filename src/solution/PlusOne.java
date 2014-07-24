package solution;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * @author Dongliang Yu
 *
 */
public class PlusOne {
	public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 1;
        int i = len - 1;
        do {
            int sum = digits[i] + carry;
            carry = (sum == 10) ? 1 : 0;
            digits[i] = sum % 10;
            i--;
        } while (carry == 1 && i >= 0);
        if (carry == 1) {
            int[] tmp = new int[len+1];
            tmp[0] = carry;
            for (int ii = 1; ii < len+1; ii++)
                tmp[ii] = digits[ii-1];
            digits = tmp;
        }
        return digits;
    }
	
	public static void main(String[] args) {
		int[] digits = {9, 9, 9};
		digits = plusOne(digits);
		for (int digit : digits)
			System.out.print(digit);
	}
}
