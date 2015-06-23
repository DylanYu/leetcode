package solution;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain 
 * amount of money stashed, the only constraint stopping you from robbing each of them is that 
 * adjacent houses have security system connected and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, determine 
 * the maximum amount of money you can rob tonight without alerting the police.
 * 
 * @author Dongliang Yu
 *
 */
public class HouseRobber {
	public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if (len == 1) return nums[0];
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int tmp = Math.max(a+nums[i], b);
            a = b;
            b = tmp;
        }
        return b;
    }
}
