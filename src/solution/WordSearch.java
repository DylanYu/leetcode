package solution;

import java.util.HashSet;
import java.util.Set;

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
        if (board.length == 0) return false;
        char[] c = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (search(board, i, j, c, 0, visited))
                    return true;
        return false;
    }
    
    // DFS
    private boolean search(char[][] board, int x, int y, char[] c, int idx, boolean[][] visited) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if (visited[x][y]) return false;
        if (board[x][y] != c[idx]) return false;
        if (idx == c.length-1) return true;
        visited[x][y] = true;
        boolean found = search(board, x-1, y, c, idx+1, visited)
                        || search(board, x+1, y, c, idx+1, visited)
                        || search(board, x, y-1, c, idx+1, visited)
                        || search(board, x, y+1, c, idx+1, visited);
        // go back to try another way and mark current position as unvisited
        visited[x][y] = false;
        return found;
    }
    
    /*
     * Interesting solution uses an extra class Position to store visited path, almost same as 
     * the above one and not necessary to apply it in this problem but worth understanding the 
     * practice of overriding equals and hashCode.
     *  
    class Position {
        int x;
        int y;
        public Position(int x, int y) { this.x = x; this.y = y; }
        
        @Override 
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (!(obj instanceof Position)) return false;
            Position that = (Position) obj;
            return this.x == that.x && this.y == that.y;
        }
        
        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 + x;
            result = result * 31 + y;
            return result;
        }
    }
    
    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        if (word == null || word.length() == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, word, 0, new HashSet<Position>()))
                    return true;
            }
        }
        return false;
    }
    
    // DFS
    private boolean exist(char[][] board, int i, int j, String word, int index, Set<Position> set) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if (index >= word.length()) return false;
        if (set.contains(new Position(i, j))) return false;
        char curBoard = board[i][j];
        char curWord = word.charAt(index);
        if (curBoard != curWord) return false;
        if (index == word.length()-1) return true;
        set.add(new Position(i, j));
        boolean exist = exist(board, i-1, j, word, index+1, set)
                        || exist(board, i+1, j, word, index+1, set)
                        || exist(board, i, j-1, word, index+1, set)
                        || exist(board, i, j+1, word, index+1, set);
        if (exist) return true;
        else {
            // go back to try another way and remove current position in set
            set.remove(new Position(i, j));
            return false;
        }
    }
    */
    
    public static void main(String[] args) {
        char[][] board = {"ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray()};
        String word = "ABCCED";
        //char[][] board = {"aaaa".toCharArray(),"aaaa".toCharArray(),"aaaa".toCharArray()};
        //String word = "aaaaaaaaaaab";
        System.out.println(new WordSearch().exist(board, word));
    }
}
