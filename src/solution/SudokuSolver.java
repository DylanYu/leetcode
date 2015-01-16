package solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * Empty cells are indicated by the character '.'.
 *
 * You may assume that there will be only one unique solution.
 * 
 * @author Dongliang Yu
 *
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        boolean success = solve(board, 0, 0);
    }
    
    private boolean solve(char[][] board, int x, int y) {
        if (x == 9 && y == 0)
            return true;
        if (y == 9)
            return solve(board, x+1, 0);
        if (board[x][y] != '.')
            return solve(board, x, y+1);
        
        Set<Character> set = getCandidates(board, x, y);
        //if (set.size() == 0) return false;
        for (char c : set) {
            board[x][y] = c;
            if (solve(board, x, y+1)) return true;
        }
        board[x][y] = '.'; // current attempt failed, set back and try more attempts
        return false;
    }
    
    // must NOT use a 'shared' boolean array to represent the set, data will be poisoned
    private Set<Character> getCandidates(char[][]board, int x, int y) {
        Set<Character> set = new HashSet<Character>();
        for (char i = '1'; i <= '9'; i++) set.add(i);
        for (int i = 0; i < 9; i++)
            if (board[x][i] != '.') set.remove(board[x][i]);
        for (int i = 0; i < 9; i++)
            if (board[i][y] != '.') set.remove(board[i][y]);
        int x0 = x / 3 * 3;
        int y0 = y / 3 * 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[x0+i][y0+j] != '.') set.remove(board[x0+i][y0+j]);
        return set;
    }
    
    public static void main(String[] args) {
        char[][] a = {  "..9748...".toCharArray(),
                        "7........".toCharArray(),
                        ".2.1.9...".toCharArray(),
                        "..7...24.".toCharArray(),
                        ".64.1.59.".toCharArray(),
                        ".98...3..".toCharArray(),
                        "...8.3.2.".toCharArray(),
                        "........6".toCharArray(),
                        "...2759..".toCharArray()
                    };
        new SudokuSolver().solveSudoku(a);
        for (char[] subarr : a) {
            for (char c : subarr)
                System.out.print(c);
            System.out.println();
        }
    }
}
