package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard 
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * @author Dongliang Yu
 *
 */
public class NQueens {
    public List<String[]> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<String[]> ret = new LinkedList<String[]>();
        for (int i = 0; i < n; i++) // start from first level
            solve(board, 0, i, 0, ret);
        return ret;
    }
    
    private void solve(char[][] board, int x, int y, int k, List<String[]> ret) {
        if (x >= board.length || y >= board[0].length) return;
        if (!isValid(board, x, y)) return;
        // DFS, no need to copy entire board, just set back to '.' after this pass
        board[x][y] = 'Q';
        if (k+1 == board.length) {
            String[] arr = new String[board.length];
            for (int i = 0; i < arr.length; i++)
                arr[i] = new String(board[i]);
            ret.add(arr);
        } else {
            if (x == board.length-1) return;
            for (int i = 0; i <= y-2; i++)
                solve(board, x+1, i, k+1, ret);
            for (int i = y+2; i < board.length; i++)
                solve(board, x+1, i, k+1, ret);
        }
        board[x][y] = '.';
    }
    
    // put a queen in (x, y) on board, just check the above part
    private boolean isValid(char[][] board, int x, int y) {
        for (int i = x-1; i >= 0; i--)
            if (board[i][y] == 'Q') return false;
        int i = 1;
        while (x-i >= 0 && y-i >= 0) {
            if (board[x-i][y-i] == 'Q') return false;
            i++;
        }
        i = 1;
        while (x-i >= 0 && y+i < board.length) {
            if (board[x-i][y+i] == 'Q') return false;
            i++;
        }
        return true;
    }
}
