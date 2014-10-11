package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each 
 * bar is 1, find the area of largest rectangle in the histogram.
 * 
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 * 
 * @author Dongliang Yu
 *
 */
public class LargestRectangleInHistogram {
    // divide and conquer solution
    public int largestRectangleArea(int[] height) {
        return largest(height, 0, height.length-1);
    }
    
    private int largest(int[] height, int lo, int hi) {
        if (lo > hi) return 0; //
        //if (lo == hi) return height[lo];
        int minIdx = -1;
        int minHeight = Integer.MAX_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (height[i] < minHeight) {
                minHeight = height[i];
                minIdx = i;
            }
        }
        int maxMid = minHeight * (hi - lo + 1);
        int maxLeft = largest(height, lo, minIdx-1);
        int maxRight = largest(height, minIdx+1, hi);
        return Math.max(maxMid, Math.max(maxLeft, maxRight));
    }
    
    /**
     * Awesome O(N) solution, the key to understand this solution is all the index in stack is 
     * ALWAYS in ascending order.
     * The idea is from http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
     *
    public int largestRectangleArea(int[] height) {
        int maxArea = 0;
        Stack<Integer> stk = new Stack<Integer>();
        int i = 0;
        while (i < height.length) {
            if (stk.isEmpty() || height[stk.peek()] <= height[i])
                stk.push(i++);
            else {
                int top = stk.pop();
                int area =  height[top] * (stk.isEmpty() ? i : i-stk.peek()-1); // for the ?: 1 in 2,1,2
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!stk.isEmpty()) {
            int top = stk.pop();
            int area = height[top] * (stk.isEmpty() ? i : i-stk.peek()-1); // i = height.length
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    */
    
    /**
     * trivial solution
     * 
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        Map<Integer, Integer> loMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> hiMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            int h = height[i];
            if (h == 0) continue;
            if ((loMap.containsKey(h) && loMap.get(h) <= i)
                && (hiMap.containsKey(h) && hiMap.get(h) >= i))
                continue;
            int l = i-1;
            int r = i+1;
            
            while (l >= 0 && height[l] >= h) l--;
            if (!loMap.containsKey(h)) loMap.put(h, l+1);
            else loMap.put(h, Math.min(loMap.get(h), l+1));
            
            while (r < len && height[r] >= h) r++;
            if (!hiMap.containsKey(h)) hiMap.put(h, r-1);
            else hiMap.put(h, Math.max(hiMap.get(h), r-1));
            
            int area = (r - l - 1) * h;
            if (area > maxArea) maxArea = area;
        }
        return maxArea;
    }
    */
    
    public static void main(String[] args) {
        int[] height = {2,1,2,0,3,2,2,3}; // 8
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(height));
    }
}
