package solution;

public class SortColors {
    public void sortColors(int[] A) {
        /* cool */
        int i=-1, j=-1, k=-1;
        for(int p = 0; p < A.length; p++) {
            if(A[p] == 0) {
                A[++k]=2;
                A[++j]=1;
                A[++i]=0;
            } else if (A[p] == 1) {
                A[++k]=2;
                A[++j]=1;
            } else if (A[p] == 2) {
                A[++k]=2;
            }
        }
        
        /* 3 way partition
        int lt = 0;
        int gt = A.length - 1;
        int i = 0;
        while (i <= gt) { // (i < gt) wrong for [1, 0] case
            if (A[i] < 1)
                swap(A, i++, lt++);
            else if (A[i] > 1)
                swap(A, i, gt--);
            else
                i++;
        }
        
        OR
        
        int lt = -1;
        int i = 0;
        int gt = A.length;
        while (i < gt) {
            if (A[i] == 0) swap(A, ++lt, i++);
            else if (A[i] == 2) swap(A, i, --gt);
            else i++;
        }
        */
        
        /* counting sort
        int length = A.length;
        int[] count = new int[]{0, 0, 0};
        for (int i = 0; i < length; i++)
            count[A[i]]++;
        int i = 0;
        for (int j = 0; j < count.length; j++)
            for (int k = 0; k < count[j]; k++)
                A[i++] = j;
        */
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
