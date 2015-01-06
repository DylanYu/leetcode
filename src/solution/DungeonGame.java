package solution;

/**
 * 
 * @author Dongliang Yu
 *
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        if (m == 0) return Integer.MAX_VALUE;
        int n = dungeon[0].length;
        if (n == 0) return Integer.MAX_VALUE;
        int[][] HP = new int[m][n];
        HP[m-1][n-1] = Math.max(-dungeon[m-1][n-1]+1, 1);
        for (int i = m-2; i >= 0; i--)
            HP[i][n-1] = Math.max(HP[i+1][n-1] - dungeon[i][n-1], 1);
        for (int j = n-2; j >= 0; j--)
            HP[m-1][j] = Math.max(HP[m-1][j+1] - dungeon[m-1][j], 1);
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                HP[i][j] = Math.min(HP[i+1][j] - dungeon[i][j],
                                    HP[i][j+1] - dungeon[i][j]);
                HP[i][j] = Math.max(HP[i][j], 1);
            }
        }
        return HP[0][0];
    }
    
    /**
     * DFS solution, TLE
     *
    private int maxNetHealth;
    
    public int calculateMinimumHP2(int[][] dungeon) {
        int m = dungeon.length;
        if (m == 0) return Integer.MAX_VALUE;
        int n = dungeon[0].length;
        if (n == 0) return Integer.MAX_VALUE;
        maxNetHealth = Integer.MIN_VALUE;
        DFS(dungeon, 0, 0, 0, 0);
        return Math.max(-maxNetHealth+1, 1);
    }
    
    private void DFS(int[][] dungeon, int x, int y, int curr, int min) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n) return;
        curr += dungeon[x][y];
        if (curr < maxNetHealth) return; //
        min = Math.min(min, curr);
        if (x == m-1 && y == n-1)
            maxNetHealth = Math.max(maxNetHealth, min);
        else {
            DFS(dungeon, x+1, y, curr, min);
            DFS(dungeon, x, y+1, curr, min);
        }
    }
    */
    
    public static void main(String[] args) {
        int[][] matrix = {
                {-2, -13, -7, -18, 4, -19},
                {-14, -7, 12, -9, 0, +7},
                {-40, -1, -23, -17, -2, -9},
                {-7, -12, -22, 15, -9, -11}
        };
        System.out.println(new DungeonGame().calculateMinimumHP(matrix));
        //System.out.println(new DungeonGame().calculateMinimumHP2(matrix));
    }
}
