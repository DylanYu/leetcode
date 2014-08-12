package solution;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate 
 * (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) 
 * and (i, 0). Find two lines, which together with x-axis forms a container, such that the 
 * container contains the most water.
 *
 * Note: You may not slant the container.
 * 
 * @author Dongliang Yu
 *
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int lo = 0;
        int hi = height.length-1;
        while (lo < hi) {
            max = Math.max(max, Math.min(height[lo], height[hi]) * (hi-lo));
            if (height[lo] < height[hi]) lo++;
            else hi--;
        }
        return max;
    }
}
