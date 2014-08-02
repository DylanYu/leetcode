package solution;

import java.util.ArrayList;
import java.util.List;

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
        solve(board, 0, 0);
    }
    
    private boolean solve(char[][] board, int i, int j) {
        if (i == 8 && j == 8 && board[i][j] != '.') return true; // validation test not necessary
        if (board[i][j] != '.') { // already set, move to next empty cell
            if (j == 8) {
                if (solve(board, i+1, 0)) return true;
                else return false; // else stop this attempt
            } else {
                if (solve(board, i, j+1)) return true;
                else return false; // else stop this attempt
            }
        }
        List<Character> candidates = candidates(i, j, board);
        if (candidates.size() == 0) return false;
        for (char c : candidates) {
            board[i][j] = c;
            if (i == 8 && j == 8) return true; // solution found
            if (j == 8) {
                if (solve(board, i+1, 0)) return true; // else continue
            } else 
                if (solve(board, i, j+1)) return true; // else continue
        }
        board[i][j] = '.'; // set back, we need more attempts
        return false;
    }
    
    // when board[i][j] is '.', get all of the candidates
    private List<Character> candidates(int row, int col, char[][] board) {
        char[] arr = new char[9];
        for (int i = 0; i < 9; i++) arr[i] = 0;
        for (int i = 0; i < 9; i++) {
            char cur = board[row][i];
            if (cur == '.') continue;
            arr[cur - '1'] = cur;
        }
        for (int i = 0; i < 9; i++) {
            char cur = board[i][col];
            if (cur == '.') continue;
            arr[cur - '1'] = cur;
        }
        int left = row / 3 * 3;
        int up = col / 3 * 3;
        for (int i = left; i < left+3; i++) {
            for (int j = up; j < up+3; j++) {
                char cur = board[i][j];
                if (cur == '.') continue;
                arr[cur - '1'] = cur;
            }
        }
        List<Character> rst = new ArrayList<Character>();
        for (int i = 0; i < 9; i++)
            if (arr[i] == 0) rst.add((char) ('1' + i));
        return rst;
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
