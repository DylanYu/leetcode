package solution;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * path = "/../" => "/"
 * path = "/home//foo/" => "/home/foo"
 * path = "/home/foo/..." => "/home/foo/..."
 * 
 * @author Dongliang Yu
 *
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;
        if (path.charAt(0) != '/') return ""; // invalid
        path = path.substring(1);
        String[] ps = path.split("/");
        //if (ps.length == 0) return "/"; // "////" case, later logic can handle this case
        Stack<String> stk = new Stack<String>();
        for (String s : ps) {
            if (s.equals("..")) {
                if (!stk.isEmpty()) stk.pop();
                //else continue;
            } else if (!s.equals(".") && !s.equals(""))
                stk.push(s);
            // for "." and "" case (continuous "/"), just ignore
        }
        String[] finalPath = new String[stk.size()];
        for (int i = 0; i < finalPath.length; i++)
            finalPath[finalPath.length-i-1] = stk.pop();
        StringBuffer sb = new StringBuffer();
        for (String e : finalPath) {
            sb.append('/');
            sb.append(e);
        }
        if (sb.length() == 0) sb.append('/'); // empty path left case
        return sb.toString();
    }
}
