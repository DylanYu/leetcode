package solution;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled 
 * with the character '.'.
 * 
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
        for (int i = 0; i < len1; i++)
            if (!isValidRow(i, board)) return false;
        for (int i = 0; i < len2; i++)
            if (!isValidCol(i, board)) return false;
        for (int i = 0; i < len1; i += 3)
            for (int j = 0; j < len2; j += 3)
                if (!isValidBox(i, j, board)) return false;
        return true;
    }
    
    private boolean isValidRow(int r, char[][] board) {
        char[] row = new char[9];
        for (int i = 0; i < 9; i++) {
            char cur = board[r][i];
            if (cur == '.') continue;
            if (cur == row[cur - '1']) return false;
            else row[cur - '1'] = cur;
        }
        return true;
    }
    
    private boolean isValidCol(int c, char[][] board) {
        char[] col = new char[9];
        for (int i = 0; i < 9; i++) {
            char cur = board[i][c];
            if (cur == '.') continue;
            if (cur == col[cur - '1']) return false;
            else col[cur - '1'] = cur;
        }
        return true;
    }
    
    private boolean isValidBox(int r, int c, char[][] board) {
        char[] box = new char[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char cur = board[r+i][c+j];
                if (cur == '.') continue;
                if (cur == box[cur - '1']) return false;
                else box[cur - '1'] = cur;
            }
        }
        return true;
    }
}
