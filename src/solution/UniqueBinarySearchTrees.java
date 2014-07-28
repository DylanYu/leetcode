package solution;

public class UniqueBinarySearchTrees {
    /* straight forward way
    public int numTrees(int n) {
        return numTrees(1, n);
    }
    
    // [hi, lo]
    private int numTrees(int lo, int hi) {
        if (lo > hi) return 1; // should be zero, but for this problem we have to set it as 1 for the multiplication below
        if (lo == hi) return 1;
        int sum = 0;
        for (int i = lo; i <= hi; i++)
            sum += (numTrees(lo, i-1) * numTrees(i+1, hi));
        return sum;
    }
    */
}
