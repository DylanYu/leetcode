package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
 * @see PalindromePartitioning
 *
 */
public class WordBreakII {
    ///*
    // DP solution, search from tail to head, use a map to act as array in traditional DP
    // NOTE: we must use a recursive approach search from tail to head to detect cases 
    // like s="aaaaaaa...aaab" and dict has not 'b'-ended word, a head to tail non-recursive
    // solution will get TLE on such case
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> ret = new LinkedList<String>();
        if (s == null || dict == null) return ret;
        
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        // special initialization for DP
        List<List<String>> emptyList = new LinkedList<List<String>>();
        emptyList.add(new ArrayList<String>());
        map.put(-1, emptyList);
        
        return collect(DP(s, s.length()-1, map, dict));
    }
    
    private List<List<String>> DP(String s, int idx, Map<Integer, List<List<String>>> map, Set<String> dict) {
        if (map.containsKey(idx)) return map.get(idx);
        
        map.put(idx, new LinkedList<List<String>>());
        List<List<String>> curr = map.get(idx);
        for (int i = 0; i <= idx; i++) {
            String secondHalf = s.substring(i, idx+1);
            if (dict.contains(secondHalf)) {
                List<List<String>> sentences = DP(s, i-1, map, dict);
                for (List<String> sentence : sentences) {
                    List<String> copy = new ArrayList<String>(sentence);
                    copy.add(secondHalf);
                    curr.add(copy);
                }
            }
        }
        return curr;
    }
    
    private List<String> collect(List<List<String>> lists) {
        List<String> ret = new LinkedList<String>();
        if (lists == null) return ret;
        for (List<String> list : lists) {
            StringBuffer sb = new StringBuffer();
            for (String s : list) {
                sb.append(s);
                sb.append(' ');
            }
            if (sb.length() > 0) sb.deleteCharAt(sb.length()-1);  // handle s = ""
            ret.add(sb.toString());
        }
        return ret;
    }
    
    /**
     * non-recursive head to tail search version, TLE on "aaaa...aab" case
     * !!: The reason why this solution is not suitable for WordBreakII but 
     * suitable for PalindromePartitioning is that, palindrome problem has no
     * tail problem for "aaaa...aab" which happends in WorkBreakII
     * 
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> ret = new LinkedList<String>();
        if (s == null || dict == null || s.length() == 0) return ret;
        
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        List<List<String>> emptyList = new LinkedList<List<String>>();
        emptyList.add(new ArrayList<String>());
        map.put(-1, emptyList);
        for (int j = 0; j < s.length(); j++) {
            map.put(j, new LinkedList<List<String>>());
            List<List<String>> curr = map.get(j);
            for (int i = j-1; i >= -1; i--) {
                String sub = s.substring(i+1, j+1);
                if (map.containsKey(i) && dict.contains(sub)) {
                    List<List<String>> sentences = map.get(i);
                    for (List<String> sentence : sentences) {
                        ArrayList<String> copy = new ArrayList<String>(sentence);
                        copy.add(sub);
                        curr.add(copy);
                    }
                }
            }
        }
        return collect(map.get(s.length()-1));
    }
    */
    
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
    
    public static void main(String[] args) {
        //false:
        //String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        //String[] ss = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        //String s = "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        //String[] ss = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        
        //true
        //String s = "cars";
        //String[] ss = {"car","ca", "rs"};
        //true:
        String s = "fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami";
        String[] ss = {"kfomka","hecagbngambii","anobmnikj","c","nnkmfelneemfgcl","ah","bgomgohl","lcbjbg","ebjfoiddndih","hjknoamjbfhckb","eioldlijmmla","nbekmcnakif","fgahmihodolmhbi","gnjfe","hk","b","jbfgm","ecojceoaejkkoed","cemodhmbcmgl","j","gdcnjj","kolaijoicbc","liibjjcini","lmbenj","eklingemgdjncaa","m","hkh","fblb","fk","nnfkfanaga","eldjml","iejn","gbmjfdooeeko","jafogijka","ngnfggojmhclkjd","bfagnfclg","imkeobcdidiifbm","ogeo","gicjog","cjnibenelm","ogoloc","edciifkaff","kbeeg","nebn","jdd","aeojhclmdn","dilbhl","dkk","bgmck","ohgkefkadonafg","labem","fheoglj","gkcanacfjfhogjc","eglkcddd","lelelihakeh","hhjijfiodfi","enehbibnhfjd","gkm","ggj","ag","hhhjogk","lllicdhihn","goakjjnk","lhbn","fhheedadamlnedh","bin","cl","ggjljjjf","fdcdaobhlhgj","nijlf","i","gaemagobjfc","dg","g","jhlelodgeekj","hcimohlni","fdoiohikhacgb","k","doiaigclm","bdfaoncbhfkdbjd","f","jaikbciac","cjgadmfoodmba","molokllh","gfkngeebnggo","lahd","n","ehfngoc","lejfcee","kofhmoh","cgda","de","kljnicikjeh","edomdbibhif","jehdkgmmofihdi","hifcjkloebel","gcghgbemjege","kobhhefbbb","aaikgaolhllhlm","akg","kmmikgkhnn","dnamfhaf","mjhj","ifadcgmgjaa","acnjehgkflgkd","bjj","maihjn","ojakklhl","ign","jhd","kndkhbebgh","amljjfeahcdlfdg","fnboolobch","gcclgcoaojc","kfokbbkllmcd","fec","dljma","noa","cfjie","fohhemkka","bfaldajf","nbk","kmbnjoalnhki","ccieabbnlhbjmj","nmacelialookal","hdlefnbmgklo","bfbblofk","doohocnadd","klmed","e","hkkcmbljlojkghm","jjiadlgf","ogadjhambjikce","bglghjndlk","gackokkbhj","oofohdogb","leiolllnjj","edekdnibja","gjhglilocif","ccfnfjalchc","gl","ihee","cfgccdmecem","mdmcdgjelhgk","laboglchdhbk","ajmiim","cebhalkngloae","hgohednmkahdi","ddiecjnkmgbbei","ajaengmcdlbk","kgg","ndchkjdn","heklaamafiomea","ehg","imelcifnhkae","hcgadilb","elndjcodnhcc","nkjd","gjnfkogkjeobo","eolega","lm","jddfkfbbbhia","cddmfeckheeo","bfnmaalmjdb","fbcg","ko","mojfj","kk","bbljjnnikdhg","l","calbc","mkekn","ejlhdk","hkebdiebecf","emhelbbda","mlba","ckjmih","odfacclfl","lgfjjbgookmnoe","begnkogf","gakojeblk","bfflcmdko","cfdclljcg","ho","fo","acmi","oemknmffgcio","mlkhk","kfhkndmdojhidg","ckfcibmnikn","dgoecamdliaeeoa","ocealkbbec","kbmmihb","ncikad","hi","nccjbnldneijc","hgiccigeehmdl","dlfmjhmioa","kmff","gfhkd","okiamg","ekdbamm","fc","neg","cfmo","ccgahikbbl","khhoc","elbg","cbghbacjbfm","jkagbmfgemjfg","ijceidhhajmja","imibemhdg","ja","idkfd","ndogdkjjkf","fhic","ooajkki","fdnjhh","ba","jdlnidngkfffbmi","jddjfnnjoidcnm","kghljjikbacd","idllbbn","d","mgkajbnjedeiee","fbllleanknmoomb","lom","kofjmmjm","mcdlbglonin","gcnboanh","fggii","fdkbmic","bbiln","cdjcjhonjgiagkb","kooenbeoongcle","cecnlfbaanckdkj","fejlmog","fanekdneoaammb","maojbcegdamn","bcmanmjdeabdo","amloj","adgoej","jh","fhf","cogdljlgek","o","joeiajlioggj","oncal","lbgg","elainnbffk","hbdi","femcanllndoh","ke","hmib","nagfahhljh","ibifdlfeechcbal","knec","oegfcghlgalcnno","abiefmjldmln","mlfglgni","jkofhjeb","ifjbneblfldjel","nahhcimkjhjgb","cdgkbn","nnklfbeecgedie","gmllmjbodhgllc","hogollongjo","fmoinacebll","fkngbganmh","jgdblmhlmfij","fkkdjknahamcfb","aieakdokibj","hddlcdiailhd","iajhmg","jenocgo","embdib","dghbmljjogka","bahcggjgmlf","fb","jldkcfom","mfi","kdkke","odhbl","jin","kcjmkggcmnami","kofig","bid","ohnohi","fcbojdgoaoa","dj","ifkbmbod","dhdedohlghk","nmkeakohicfdjf","ahbifnnoaldgbj","egldeibiinoac","iehfhjjjmil","bmeimi","ombngooicknel","lfdkngobmik","ifjcjkfnmgjcnmi","fmf","aoeaa","an","ffgddcjblehhggo","hijfdcchdilcl","hacbaamkhblnkk","najefebghcbkjfl","hcnnlogjfmmjcma","njgcogemlnohl","ihejh","ej","ofn","ggcklj","omah","hg","obk","giig","cklna","lihaiollfnem","ionlnlhjckf","cfdlijnmgjoebl","dloehimen","acggkacahfhkdne","iecd","gn","odgbnalk","ahfhcd","dghlag","bchfe","dldblmnbifnmlo","cffhbijal","dbddifnojfibha","mhh","cjjol","fed","bhcnf","ciiibbedklnnk","ikniooicmm","ejf","ammeennkcdgbjco","jmhmd","cek","bjbhcmda","kfjmhbf","chjmmnea","ifccifn","naedmco","iohchafbega","kjejfhbco","anlhhhhg"};
        Set<String> dict = new HashSet<String>();
        for (String item: ss)
           dict.add(item);
        System.out.println(new WordBreakII().wordBreak(s, dict));
    }
}
