package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n�n chessboard 
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
        List<String[]> ret = new LinkedList<String[]>();
        if (n <= 0) return ret;
        boolean[][] board = new boolean[n][n];
        solve(board, 0, n, ret);
        return ret;
    }
    
    // rowIdx starts from 0, n starts from 1
    private void solve(boolean[][] board, int rowIdx, int n, List<String[]> ret) {
        if (rowIdx == n) {
            ret.add(boardToStr(board));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (posValid(board, rowIdx, i)) {
                board[rowIdx][i] = true;
                solve(board, rowIdx+1, n, ret);
                board[rowIdx][i] = false;
            }
        }
    }
    
    private boolean posValid(boolean[][] board, int x, int y) {
        for (int i = 0; i < x; i++)
            if (board[i][y]) return false;
        for (int left = 1; x-left >= 0 && y-left >= 0; left++)
            if (board[x-left][y-left]) return false;
        for (int right = 1; x-right >= 0 && y+right < board[0].length; right++)
            if (board[x-right][y+right]) return false;
        return true;
    }
    
    private String[] boardToStr(boolean[][] board) {
        int n = board.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n; j++) {
                if (board[i][j]) sb.append('Q');
                else sb.append('.');
            }
            arr[i] = sb.toString();
        }
        return arr;
    }
}
