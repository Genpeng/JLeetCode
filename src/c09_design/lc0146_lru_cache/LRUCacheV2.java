package c09_design.lc0146_lru_cache;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 146 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/lru-cache/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 *                   it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * - Could you do both operations in O(1) time complexity?
 *
 * Example:
 * LRUCache cache = new LRUCache(2);
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);      // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);      // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);      // returns -1 (not found)
 * cache.get(3);      // returns 3
 * cache.get(4);      // returns 4
 * ==========================================================================================================
 *
 * Tags: design;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class LRUCacheV2 {
    private int size;
    private int capacity;
    private Map<Integer, Node> elems;
    private Node head;
    private Node tail;

    public LRUCacheV2(int capacity) {
        this.capacity = capacity;
        size = 0;
        elems = new HashMap<>(capacity);
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
    }

    public void put(int key, int val) {
        Node node = elems.get(key);
        if (node == null) {
            Node newNode = new Node(key, val);
            elems.put(key, newNode);
            addFirst(newNode);
            ++size;
            if (size > capacity) {
                Node removeNode = removeLast();
                elems.remove(removeNode.key);
                --size;
            }
        } else {
            node.val = val;
            moveToHead(node);
        }
    }

    public int get(int key) {
        Node node = elems.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.val;
        }
    }

    private void addFirst(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    private void moveToHead(Node node) {
        remove(node);
        addFirst(node);
    }

    private Node removeLast() {
        Node node = tail.prev;
        remove(node);
        return node;
    }

    class Node {
        int key, val;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCacheV2 cache = new LRUCacheV2(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 1
        cache.put(3, 3);
        System.out.println(cache.get(2)); // -1
        cache.put(4, 4);
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}