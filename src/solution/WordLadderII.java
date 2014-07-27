package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Given two words (start and end), and a dictionary, find all shortest 
 * transformation sequence(s) from start to end, such that:
 *  1. Only one letter can be changed at a time
 *  1. Each intermediate word must exist in the dictionary
 * 
 * @author Dongliang Yu
 *
 */
public class WordLadderII {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        HashSet<String> neighbors = new HashSet<String>();
        StringBuffer sbEnd = new StringBuffer(end);
        for (int i = 0; i < end.length(); i++) {
            char ch = sbEnd.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != ch) {
                    sbEnd.setCharAt(i, c);
                    neighbors.add(sbEnd.toString());
                }
            }
            sbEnd.setCharAt(i, ch);
        }
        Queue<String> queue = new LinkedList<String>(); // for building the graph using BFS
        HashMap<String, Integer> lenMap = new HashMap<String, Integer>();
        HashMap<String, Set<String>> adjMap = new HashMap<String, Set<String>>();
        queue.add(start);
        lenMap.put(start, 1);
        Set<String> endAdj = new HashSet<String>();
        adjMap.put(end, endAdj);
        for (String e : dict) {
            adjMap.put(e, new HashSet<String>());
        }
        while (!queue.isEmpty()) {
            String cur = queue.remove();
            if (neighbors.contains(cur)) {
                Set<String> adj = adjMap.get(end);
                adj.add(cur);
            } else {
                StringBuffer sb = new StringBuffer(cur);
                for (int i = 0; i < cur.length(); i++) {
                    char ch = cur.charAt(i);
                    for (char c = 'a'; c < 'z'; c++) {
                        if (c != ch) {
                            sb.setCharAt(i, c);
                            String next = sb.toString();
                            if (dict.contains(next)
                                && (!lenMap.containsKey(next)
                                    || lenMap.get(cur)+1 <= lenMap.get(next))) { // actually is ==
                                queue.add(next);
                                lenMap.put(next, lenMap.get(cur)+1);
                                // TODO: map operation
                                Set<String> adj = adjMap.get(next);
                                adj.add(cur);
                            }
                        }
                    }
                    sb.setCharAt(i, ch);
                }
            }
        }
        
        // DFS to find all path
        Stack<List<String>> stk = new Stack<List<String>>();
        List<String> endList = new ArrayList<String>();
        endList.add(end);
        stk.add(endList);
        List<List<String>> results = new ArrayList<List<String>>();
        while (!stk.empty()) {
            ArrayList<String> curList = (ArrayList<String>) stk.pop();
            String last = curList.get(curList.size()-1);
            if (last.equals(start)) {   // find the end to start path, store it
                Collections.reverse(curList);
                results.add(curList);
            } else {                    // still in the half way, keep going
                Set<String> adj = adjMap.get(last);
                for (String e : adj) {
                    ArrayList<String> copy = (ArrayList<String>) curList.clone();
                    copy.add(e);
                    stk.add(copy);
                }
            }
        }
        return results;
    }
    
    private boolean almostSame(String str, String end) {
        int diff = 0;
        for (int i = 0; i < end.length(); i++) {
            if (str.charAt(i) != end.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
//        String start = "hot";
//        String end = "dog";
//        String[] arr = {"hot","cog","dog","tot","hog","hop","pot","dot"};
//        String start = "hit";
//        String end = "cog";
//        String[] arr = {"hot","dot","dog","lot","log"};
//        String start = "leet";
//        String end = "code";
//        String[] arr = {"lest","leet","lose","code","lode","robe","lost"};
//        String start = "cet";
//        String end = "ism";
//        String[] arr = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
        String start = "nape";
        String end = "mild";
        String[] arr = {"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"};
//        String start = "red";
//        String end = "tax";
//        String[] arr = {"ted","tex","red","tax","tad","den","rex","pee"};
        Set<String> dict = new HashSet<String>();
        for (String e : arr)
            dict.add(e);
        List<List<String>> results = new WordLadderII().findLadders(start, end, dict);
        for (List<String> list : results) {
            System.out.println(list.size());
            for (String e : list)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}
