//Design a data structure that follows the constraints of a Least Recently Used 
//(LRU) cache. 
//
// Implement the LRUCache class: 
//
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity. 
//
// int get(int key) Return the value of the key if the key exists, otherwise ret
//urn -1. 
// void put(int key, int value) Update the value of the key if the key exists. O
//therwise, add the key-value pair to the cache. If the number of keys exceeds the
// capacity from this operation, evict the least recently used key. 
// 
//
// Follow up: 
//Could you do get and put in O(1) time complexity? 
//
// 
// Example 1: 
//
// 
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// At most 3 * 104 calls will be made to get and put. 
// 
// Related Topics Design 
// 👍 8696 👎 354

package leetcode.editor.en;

import java.util.HashMap;
import java.util.Objects;

public class LruCache {
    public static void main(String[] args) {
        String[][] operatings = {
           {"LRUCache","put","put","put","put","get","get"}
        };

        int[][][] inputs = {
           {{2},{2,1},{1,1},{2,3},{4,1},{1},{2}}
        };

        Integer[][] outputs = {
           {null,null,null,null,null,-1,3}
        };

        int n = 0;
        String[] operating = operatings[n];
        int[][] input = inputs[n];
        LRUCache obj = new LruCache().new LRUCache(2);
        for (int i = 0; i < operating.length; i++) {
            String operation = operating[i];
            switch (operation) {
                case "LRUCache":
                    obj.capacity = input[i][0];
                    System.out.print("null");
                    break;
                case "put":
                    obj.put(input[i][0], input[i][1]);
                    System.out.print("null");
                    break;
                case "get": System.out.print(obj.get(input[i][0])); break;
                default:
            }
            if (i != operating.length - 1) {
                System.out.print(",");
            }
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private class Node {
            Node prev;
            Node next;
            int key;
            int value;
            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        private Node head;
        private Node tail;
        private HashMap<Integer, Node> elements;
        private int capacity;

        public LRUCache(int capacity) {
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            join(this.head, this.tail);
            elements = new HashMap<>(capacity);
            this.capacity = capacity;
        }

        public void join(Node node1, Node node2) {
            node1.next = node2;
            node2.prev = node1;
        }

        public int get(int key) {
            Node node = elements.get(key);
            if (Objects.isNull(node)) {
                return -1;
            }
            join(node.prev, node.next);
            Node temp = this.head.next;
            join(this.head, node);
            join(node, temp);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if (elements.containsKey(key)) {
                Node duplicateNode = elements.get(key);
                join(duplicateNode.prev, duplicateNode.next);
            } else if (elements.size() >= capacity) {
                Integer lruKey = tail.prev.key;
                Node lruNode = elements.remove(lruKey);
                join(lruNode.prev, tail);
            }
            Node temp = this.head.next;
            join(this.head, node);
            join(node, temp);
            elements.put(key, node);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}