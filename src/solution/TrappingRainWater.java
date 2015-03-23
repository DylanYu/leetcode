package solution;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * 
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * @author Dongliang Yu
 *
 */
public class TrappingRainWater {
    // O(N) one pass solution
    public int trap(int[] A) {
        int len = A.length;
        //if (len <= 2) return 0;
        int lo = 0;
        int hi = len-1;
        int lastLevel = 0;
        int all = 0;
        int block = 0;
        
        while (lo <= hi) {
            while (lo <= hi && A[lo] <= lastLevel) {
                block += A[lo];
                lo++;
            }
            while (hi >= lo && A[hi] <= lastLevel) {
                block += A[hi];
                hi--;
            }
            if (lo > hi) break;
            int currentLevel = Math.min(A[lo], A[hi]);
            all += (currentLevel - lastLevel) * (hi - lo + 1);
            lastLevel = currentLevel;
        }
        
        //for (int i = 0; i < len; i++)
        //    block += A[i];
        
        return all - block;
    }
    
    /* one pass solution
    public int trap(int[] A) {
        int lo = 0;
        int hi = A.length-1;
        int block = 0;
        int all = 0;
        int curLevel = 0;
        while (lo <= hi) { // must include '=' here
            int lowerHeight = Math.min(A[lo], A[hi]);
            if (lowerHeight > curLevel) {
                all += (lowerHeight-curLevel) * (hi-lo+1);
                curLevel = lowerHeight;
            }
            if (A[lo] < A[hi])
                block += A[lo++];
            else
                block += A[hi--];
        }
        return all - block;
    }
    */
    
    /* 
     * O(n * height) solution, not efficient
     *
    public int trap(int[] A) {
        if (A.length <= 2) return 0;
        int originalArea = 0;
        int highest = 0;
        for (int height : A) {
            if (height > highest) highest = height;
            originalArea += height;
        }
        
        for (int y = 1; y <= highest; y++) {
            if (!canFillWater(A)) break;
            int i = 1;
            while (i < A.length-1) {
                if (A[i-1] > A[i]) {
                    if (A[i] < A[i+1]) {
                        A[i]++;
                        i++;
                    } else if (A[i] == A[i+1]) {
                        int start = i;
                        while (i < A.length-1 && A[i] == A[i+1])
                            i++;
                        if (i < A.length-1 && A[i+1] > A[i]) {
                            int h = Math.min(A[start-1], A[i+1]);
                            for (int j = start; j <= i; j++)
                                A[j] = h;
                        } else ;//
                    } else {
                        i++;
                    }
                } else 
                    i++;
            }
        }
        
        int filledWaterArea = 0;
        for (int height : A) filledWaterArea += height;
        return filledWaterArea - originalArea;
    }
    
    private boolean canFillWater(int[] A) {
        int i = 1;
        while (i < A.length-1) {
            if (A[i-1] > A[i]) {
                if (A[i] < A[i+1]) return true;
                else if (A[i] == A[i+1]) {
                    while (i < A.length-1 && A[i] == A[i+1])
                        i++;
                    if (i < A.length-1 && A[i+1] > A[i])
                        return true;
                    else
                        i++;
                } else
                    i++;
            } else
                i++;
        }
        return false;
    }
    */
    
    public static void main(String[] args) {
        //int[] A = {5, 4, 1, 2}; // 1
        int[] A = {5, 2, 1, 2, 1, 5}; // 14
        System.out.println(new TrappingRainWater().trap(A));
    }
}
