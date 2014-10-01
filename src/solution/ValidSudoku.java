package solution;

/**
 * Determine if a Sudoku is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are 
 * filled with the character '.'.
 * 
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. 
 * Only the filled cells need to be validated.
 * 
 * @author Dongliang Yu
 *
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int len1 = board.length;
        if (len1 != 9) return false;
        int len2 = board[0].length;
        if (len2 != 9) return false;
        for (int i = 0; i < 9; i++)
            if (!isValidRow(i, board)) return false;
        for (int i = 0; i < 9; i++)
            if (!isValidCol(i, board)) return false;
        for (int i = 0; i < 9; i += 3)
            for (int j = 0; j < 9; j += 3)
                if (!isValidBox(i, j, board)) return false;
        return true;
    }
    
    private boolean isValidRow(int r, char[][] board) {
        boolean[] row = new boolean[9];
        for (int i = 0; i < 9; i++) {
            char cur = board[r][i];
            if (cur == '.') continue;
            if (row[cur - '1']) return false;
            else row[cur - '1'] = true;
        }
        return true;
    }
    
    private boolean isValidCol(int c, char[][] board) {
    	boolean[] col = new boolean[9];
        for (int i = 0; i < 9; i++) {
            char cur = board[i][c];
            if (cur == '.') continue;
            if (col[cur - '1']) return false;
            else col[cur - '1'] = true;
        }
        return true;
    }
    
    private boolean isValidBox(int r, int c, char[][] board) {
        boolean[] box = new boolean[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char cur = board[r+i][c+j];
                if (cur == '.') continue;
                if (box[cur - '1']) return false;
                else box[cur - '1'] = true;
            }
        }
        return true;
    }
}
