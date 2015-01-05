package solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * 
 * @author Dongliang Yu
 *
 */
public class CloneGraph {
    
    private Map<Integer, UndirectedGraphNode> map;
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null; // never forget to check null
        map = new HashMap<Integer, UndirectedGraphNode>();
        return clone(node);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(newNode.label, newNode); // put first to avoid self loop problem
        for (UndirectedGraphNode neighbor : node.neighbors)
            newNode.neighbors.add(clone(neighbor));
        return newNode;
    }
    
    /* use a queue
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        while (queue.size() > 0) {
            UndirectedGraphNode cur = queue.poll();
            if (!map.containsKey(cur.label))
                map.put(cur.label, new UndirectedGraphNode(cur.label));
            for (UndirectedGraphNode e : cur.neighbors) {
                if (!map.containsKey(e.label)) {
                    queue.offer(e);
                    map.put(e.label, new UndirectedGraphNode(e.label));
                }
                map.get(cur.label).neighbors.add(map.get(e.label));
                
            }
        }
        return map.get(node.label);
    }
    */
}
