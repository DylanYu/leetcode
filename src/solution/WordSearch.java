package solution;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" 
 * cells are those horizontally or vertically neighboring. The same letter cell may not be 
 * used more than once.
 *
 * For example,
 * Given board =
 *
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 * @author Dongliang Yu
 *
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        if (word == null || word.length() == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, word, 0, visited))
                    return true;
            }
        }
        return false;
    }
    
    // DFS
    private boolean exist(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if (index >= word.length()) return false;
        if (visited[i][j] == true) return false;
        char curBoard = board[i][j];
        char curWord = word.charAt(index);
        if (curBoard != curWord) return false;
        if (index == word.length()-1) return true;
        visited[i][j] = true;
        boolean exist = exist(board, i-1, j, word, index+1, visited)
                        || exist(board, i+1, j, word, index+1, visited)
                        || exist(board, i, j-1, word, index+1, visited)
                        || exist(board, i, j+1, word, index+1, visited);
        if (exist) return true;
        else {
            // go back to try another way and mark current position as unvisited
            visited[i][j] = false;
            return false;
        }
    }
    
    public static void main(String[] args) {
        char[][] board = {"ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray()};
        String word = "ABCCED";
        //char[][] board = {"aaaa".toCharArray(),"aaaa".toCharArray(),"aaaa".toCharArray()};
        //String word = "aaaaaaaaaaab";
        System.out.println(new WordSearch().exist(board, word));
    }
}
