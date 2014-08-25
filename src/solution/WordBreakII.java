package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where 
 * each word is a valid dictionary word. Return all such possible sentences.
 * <p>
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 *
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * @author Dongliang Yu
 *
 */
public class WordBreakII {
    // DP solution, search from right to left, use a map to act as array in traditional DP
    public List<String> wordBreak(String s, Set<String> dict) {
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        // special initialization for DP
        map.put(-1, new LinkedList<List<String>>());
        List<String> init = new ArrayList<String>();
        init.add("");
        map.get(-1).add(init);
        List<List<String>> ret = DP(s, s.length()-1, map, dict);
        
        List<String> finalRet = new LinkedList<String>();
        for (List<String> sentence : ret) {
            StringBuffer sb = new StringBuffer();
            for (String word : sentence) {
                if (word.equals("")) continue;
                sb.append(word);
                sb.append(" ");
            }
            sb.delete(sb.length() - 1, sb.length());
            finalRet.add(sb.toString()); // can handle s is "" case because empty StringBuffer will be ""
        }
        return finalRet;
    }
    
    private List<List<String>> DP(String originalS, int idx, Map<Integer, List<List<String>>> map, Set<String> dict) {
        if (map.containsKey(idx)) return map.get(idx);
        
        map.put(idx, new LinkedList<List<String>>());
        String s = originalS.substring(0, idx+1);
        for (int i = 0; i < s.length(); i++) {
            String secondHalf = s.substring(i);
            if (dict.contains(secondHalf)) {
                List<List<String>> sentences = DP(originalS, i-1, map, dict);
                for (List<String> sentence : sentences) {
                    List<String> copy = new ArrayList<String>(sentence);
                    copy.add(secondHalf);
                    map.get(idx).add(copy);
                }
            }
        }
        return map.get(idx);
    }
    
    /*
    public List<String> wordBreak(String s, Set<String> dict) {
        List<List<String>> ret = new LinkedList<List<String>>();
        ArrayList<String> list = new ArrayList<String>();
        list.add(s);
        segment(list, ret, dict);
        
        List<String> finalRet = new LinkedList<String>();
        for (List<String> sentence : ret) {
            StringBuffer sb = new StringBuffer();
            for (String word : sentence) {
                sb.append(word);
                sb.append(" ");
            }
            sb.delete(sb.length() - 1, sb.length());
            finalRet.add(sb.toString());
        }
        return finalRet;
    }
    
    private void segment(ArrayList<String> list, List<List<String>> ret, Set<String> dict) {
        String last = list.get(list.size()-1);
        if (dict.contains(last)) ret.add(list);
        
        // early stop is necessary for test case like:
        // String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        // String[] dict = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        boolean earlyStop = true;
        for (int i = last.length() - 1; i > 0; i --) {
            if (dict.contains(last.substring(i))) {
                earlyStop = false;
                break;
            }
        }
        if (earlyStop) return;
        
        for (int i = 1; i < last.length(); i++) {
            String firstHalf = last.substring(0, i);
            if (dict.contains(firstHalf)) {
                String secondHalf = last.substring(i);
                ArrayList<String> copy = new ArrayList<String>(list);
                copy.set(copy.size()-1, firstHalf);
                copy.add(secondHalf);
                // recurse
                segment(copy, ret, dict);
            }
        }
    }
    */
}
