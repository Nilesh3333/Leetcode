package Amazon;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUcache146 {
    public void main(String[] args) {
        LRUCache obj = new LRUCache(5);
    }
/*Complexity Analysis

    Time complexity: O(1)O(1)O(1) for both get and put.

    For get:
        Check if a key is in a hash map. This costs O(1)O(1)O(1).
        Get a node associated with a key. This costs O(1)O(1)O(1).
        Call remove and add. Both methods cost O(1)O(1)O(1).

    For put:
        Check if a key is in a hash map. This costs O(1)O(1)O(1).
        If it is, we get a node associated with a key and call remove. Both cost O(1)O(1)O(1).
        Create a new node and insert it into the hash map. This costs O(1)O(1)O(1).
        Call add. This method costs O(1)O(1)O(1).
        If the capacity is exceeded, we call remove and delete from the hash map. Both cost O(1)O(1)O(1).

    Space complexity: O(capacity)O(\text{capacity})O(capacity)

    We use extra space for the hash map and for our linked list. Both cannot exceed a size of capacity.
*/

    class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class LRUCache {
        int capacity;
        Map<Integer, ListNode> dic;
        ListNode head;
        ListNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            dic = new HashMap<>();
            head = new ListNode(-1, -1);
            tail = new ListNode(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!dic.containsKey(key)) {
                return -1;
            }

            ListNode node = dic.get(key);
            remove(node);
            add(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (dic.containsKey(key)) {
                ListNode oldNode = dic.get(key);
                remove(oldNode);
            }

            ListNode node = new ListNode(key, value);
            dic.put(key, node);
            add(node);

            if (dic.size() > capacity) {
                ListNode nodeToDelete = head.next;
                remove(nodeToDelete);
                dic.remove(nodeToDelete.key);
            }
        }

        public void add(ListNode node) {
            ListNode previousEnd = tail.prev;
            previousEnd.next = node;
            node.prev = previousEnd;
            node.next = tail;
            tail.prev = node;
        }

        public void remove(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
    /*public class LRUCache {
        int capacity;
        LinkedHashMap<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new LinkedHashMap<>();
        }

        public int get(int key) {
            if(map.containsKey(key)){
                int value = map.remove(key);
                map.put(key,value);
                return value;
            }
            return -1;
        }
        public void put(int key, int value) {
            if(map.containsKey(key)) {
                map.remove(key);
            }else if(map.size() + 1 > capacity) {
                map.remove(map.keySet().iterator().next());
            }
            map.put(key, value);
        }
    }*/
}
