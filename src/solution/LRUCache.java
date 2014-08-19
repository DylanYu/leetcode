package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should 
 * support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the 
 * cache, otherwise return -1.
 * 
 * set(key, value) - Set or insert the value if the key is not already present. When the cache 
 * reached its capacity, it should invalidate the least recently used item before inserting a 
 * new item.
 * 
 * @author Dongliang Yu
 *
 */
public class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int capacity;
    private int size;
    
    public LRUCache(int capacity) {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        this.size = 0;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            MoveToHead(cur);
            return cur.value;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.value = value;
            MoveToHead(cur);
        } else {
            if (size >= capacity) {
                if (head.next == tail) return; // capacity is 0, error
                Node min = tail.prev;
                delete(min);
                map.remove(min.key);
                size--;
            }
            Node cur = new Node(key, value);
            addAtHead(cur);
            map.put(key, cur);
            size++;
        }
    }
    
    private void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void addAtHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    private void MoveToHead(Node node) {
        delete(node);
        addAtHead(node);
    }
}
