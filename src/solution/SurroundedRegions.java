package solution;

import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * @author Dongliang Yu
 *
 */
public class SurroundedRegions {
    class Pair {
        int x;
        int y;
        Pair (int a, int b) { x = a; y = b; }
    }
    
    // concise solution
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m-1 || j == n-1)
                    && board[i][j] == 'O') {
                    // for positions in border which are 'O', exhaust all NON surrounded regions and mark them as 'N'
                    Stack<Pair> stk = new Stack<Pair>();
                    stk.push(new Pair(i, j));
                    while (!stk.isEmpty()) {
                        Pair curr = stk.pop();
                        int x = curr.x;
                        int y = curr.y;
                        if (x < 0 || x >= m || y < 0 || y >= n || !(board[x][y] == 'O'))
                            continue;
                        board[x][y] = 'N';
                        stk.push(new Pair(x-1, y));
                        stk.push(new Pair(x, y-1));
                        stk.push(new Pair(x, y+1));
                        stk.push(new Pair(x+1, y));
                    }
                }
            }
        }
        
        // mark all NON surrounded regions back to 'O' and render all surrounded regions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'N') board[i][j] = 'O';
            }
        }
    }
    
    /*
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        // mark[i][j] = true means (i,j) is already visited
        boolean[][] mark = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == 'X') mark[i][j] = true; // 'X' in board cannot be a possible start point of surrounded region
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mark[i][j]) continue;
                // use a stack to exhaust Os in a possible surrounded region,
                // caveat: use recursion here may cause StackOverFlow
                List<Pair> visited = new LinkedList<Pair>();
                boolean borderReached  = false;
                Stack<Pair> stk = new Stack<Pair>();
                stk.push(new Pair(i, j));
                while (!stk.isEmpty()) {
                    Pair curr = stk.pop();
                    int x = curr.x;
                    int y = curr.y;
                    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                        // we've reached a point in border which was 'O', this attempt cannot be a surrounded region
                        borderReached  = true;
                        continue;
                    }
                    if (board[x][y] == 'X' || mark[x][y]) continue;
                    board[x][y] = 'X';
                    visited.add(new Pair(x, y));
                    mark[x][y] = true;
                    // four directions is OK, no need to push all eight directions here
                    stk.push(new Pair(x-1, y));
                    stk.push(new Pair(x, y-1));
                    stk.push(new Pair(x, y+1));
                    stk.push(new Pair(x+1, y));
                }
                
                // current attempt is not a surrounded region, recover all the fliped 'O's
                if (borderReached ) {
                    for (Pair pair : visited)
                        board[pair.x][pair.y] = 'O';
                }
            }
        }
    }
    */
}
