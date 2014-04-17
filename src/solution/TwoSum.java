package solution;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the 
 * target, where index1 must be less than index2. Please note that your returned answers (both 
 * index1 and index2) are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * <p>Input: numbers={2, 7, 11, 15}, target=9
 * <p>Output: index1=1, index2=2
 * 
 * @author Dongliang Yu
 *
 */
public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        int[] num2 = numbers.clone();
        Arrays.sort(num2); // O(n) if use LSD
        int[] result = new int[2];
        int i = 0;
        int j = Arrays.binarySearch(num2, target - num2[i]);
        if (j < 0) { // not found
            j = (-j - 1) - 1;
            while (i < j) {
                int sum = num2[i] + num2[j];
                if (sum > target)      j--;
                else if (sum < target) i++;
                else break;
            }
        }
        int result_i = 0;
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] == num2[i] || numbers[index] == num2[j])
                result[result_i++] = index + 1;
        }
        return result;
    }

    public static int[] twoSumWithHash(int[] numbers, int target) {
        int[] results = new int[2];
        int length = numbers.length;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < length; i++)
            set.add(target - numbers[i]);
        for (int i = 0; i < length; i++) {
            if (set.contains(numbers[i])) {
                int another = target - numbers[i];
                for (int j = 0; j < length; j++)
                    if (numbers[j] == another && i != j) {
                        results[0] = i < j ? i+1 : j+1;
                        results[1] = i > j ? i+1 : j+1;
                    }
            }
        }
        return results;
    }
    
    public static void main(String[] args) {
        //int[] num = {2, 7, 11, 15};
        int[] num = {-1, 2, 5, 8, 0, 123, 8, -34 , 12, -54, 9, 12};
        int[] result = twoSum(num, 132);
        System.out.println(result[0] + ", " + result[1]);
    }
}
