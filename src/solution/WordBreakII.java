package solution;

import java.util.ArrayList;
import java.util.List;
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
    public List<String> wordBreak(String s, Set<String> dict) {
        ArrayList<ArrayList<String>> sentences = new ArrayList<ArrayList<String>>();
        ArrayList<String> resource = new ArrayList<String>();
        resource.add(s);
        if (dict.contains(s))
            sentences.add((ArrayList<String>) resource.clone());
        segment(dict, resource, sentences);
        ArrayList<String> result = new ArrayList<String>();
        for (ArrayList<String> sentence : sentences) {
            StringBuffer sb = new StringBuffer();
            for (String word : sentence) {
                sb.append(word);
                sb.append(" ");
            }
            sb.delete(sb.length() - 1, sb.length());
            result.add(sb.toString());
        }
        return result;
    }
    
    private void segment(Set<String> dict, ArrayList<String> resource, ArrayList<ArrayList<String>> sentences) {
        int lastIndex = resource.size() - 1;
        String last = resource.get(lastIndex);
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
                if (dict.contains(secondHalf)) {
                    ArrayList<String> sentence = (ArrayList<String>) resource.clone();
                    sentence.remove(lastIndex);
                    sentence.add(firstHalf);
                    sentence.add(secondHalf);
                    sentences.add(sentence);
                }
                ArrayList<String> copy = (ArrayList<String>) resource.clone();
                copy.remove(lastIndex);
                copy.add(firstHalf);
                copy.add(secondHalf);
                // recurse
                segment(dict, copy, sentences);
            }
        }
    }
}
