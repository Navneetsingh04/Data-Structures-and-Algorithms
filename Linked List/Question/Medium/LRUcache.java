/*
L.C: 146. LRU Cache

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:
LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.


Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 
Constraints:
1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.
*/

import java.util.HashMap;
import java.util.Map;

public class LRUcache{
    class Node{
        int key,val;
        Node prev,next;
        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;
    Map<Integer,Node> map = new HashMap<>();
    public LRUcache(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    public void addNode(Node newNode){
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next =newNode;
        temp.prev = newNode;
    }
    public void deleteNode(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }
    public int get(int key){
        if(map.containsKey(key)){
            Node resNode = map.get(key);
            int ans = resNode.val;

            map.remove(key);
            deleteNode(resNode);
            addNode(resNode);
            map.put(key, head.next);
            return ans;
        }
        return -1;
    }
    public void put(int key,int value){
        if(map.containsKey(key)){
            Node curr = map.get(key);
            map.remove(key);
            deleteNode(curr);
        }
        if(map.size() == capacity){
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new Node(key,value));
        map.put(key,head.next);
    }
    public static void main(String[] args) {
        LRUcache lruCache = new LRUcache(2);
        lruCache.put(1, 1); 
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3); 
        System.out.println(lruCache.get(2)); 
        lruCache.put(4, 4); 
        System.out.println(lruCache.get(1)); 
        System.out.println(lruCache.get(3)); 
        System.out.println(lruCache.get(4));
    }
}