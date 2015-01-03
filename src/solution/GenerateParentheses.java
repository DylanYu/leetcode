package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author Dongliang Yu
 *
 */
public class GenerateParentheses {
    // recursive solution
    public List<String> generateParenthesis(int n) {
        List<String> ret = new LinkedList<String>();
        if (n <= 0) return ret;
        generate(new StringBuffer(), n, n, ret);
        return ret;
    }
    
    private void generate(StringBuffer sb, int left, int right, List<String> ret) {
        //if (left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            ret.add(sb.toString());
            return;
        }
        if (left > 0) {
            sb.append('(');
            generate(sb, left-1, right, ret);
            sb.deleteCharAt(sb.length()-1);
        }
        if (left < right) {
            sb.append(')');
            generate(sb, left, right-1, ret);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    /*
    class Node {
        int l;
         int r;
         String s;
         Node (int l, int r, String s) {
             this.l = l;
             this.r = r;
             this.s = s;
         }
     }
     
     public List<String> generateParenthesis(int n) {
         List<String> rst = new LinkedList<String>();
         //if (n == 0) return rst; // later logic can handle this case
         LinkedList<Node> queue = new LinkedList<Node>();
         Node node = new Node(1, 0, "(");
         queue.add(node);
         while (queue.size() > 0) {
             Node cur = queue.removeFirst();
             if (cur.l + cur.r > n*2) continue;
             if (cur.l == cur.r && cur.l + cur.r == n*2) {
                 rst.add(cur.s);
                 continue;
             }
             if (cur.l < cur.r) continue;
             if (cur.l > cur.r) { // if l == r, add ")" will get an invalid case
                 Node plusRight = new Node(cur.l, cur.r + 1, cur.s+")");
                 queue.add(plusRight);
             }
             cur.l++;
             cur.s = cur.s + "(";
             queue.add(cur);
         }
         return rst;
     }
     */
}
