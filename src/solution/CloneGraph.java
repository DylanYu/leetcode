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
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        storeToMap(node, map);
        return mapToGraph(node, map);
    }
    
    private void storeToMap(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (node == null) return;
        if (map.containsKey(node.label)) return;
        map.put(node.label, node);
        for (UndirectedGraphNode e : node.neighbors)
            storeToMap(e, map);
    }
    
    private UndirectedGraphNode mapToGraph(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        Map<Integer, UndirectedGraphNode> newMap = new HashMap<Integer, UndirectedGraphNode>();
        Set<Integer> keyset = map.keySet(); // no need to cast
        for (int e : keyset)
            newMap.put(e, new UndirectedGraphNode(e));
        for (int e : keyset) {
            UndirectedGraphNode source = map.get(e);
            UndirectedGraphNode dst = newMap.get(e);
            for (UndirectedGraphNode neighbor : source.neighbors)
                dst.neighbors.add(newMap.get(neighbor.label));
        }
        return newMap.get(node.label);
    }
}
