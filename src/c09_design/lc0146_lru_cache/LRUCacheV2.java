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
 * Difficulty: Medium
 * Tags: design;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class LRUCacheV2 {
    // 解题思路：
    // 这道题需要我们设计一个缓存的数据结构，使得这个数据结构满足读（get）和写（put）的时间复杂度
    // 都是 O(1) 的，同时，当缓存的容量（capacity）满了的时候，将最近最少使用的元素删除。为了
    // 删除元素的时候能够满足要求，很容易想到用一个"队列"形式的数据结构来存放数据，最近最少使用的
    // 元素就排在队列的末尾，而最近使用到的元素就排列在队列的队首，即入队会从队首入，出队会从队尾出，
    // 因此双向链表就是一个自然的选择。但是，链表的查询是 O(N) 的时间复杂度，不满足题目的要求。
    // 所以为了使得这个数据结构的读操作的时间复杂度也是 O(1) 的，我们用一个 map 来保存元素在队列中
    // 的位置（指针）。

    private int capacity; // 不需要 size，因为 cache 元素的数目就是 LRU 元素的数目
    private Map<Integer, Node> key2Node;
    private DoublyLinkedList cache;

    public LRUCacheV2(int capacity) {
        this.capacity = capacity;
        key2Node = new HashMap<>(capacity);
        cache = new DoublyLinkedList();
    }

    public int get(int key) {
        Node node = key2Node.get(key);
        if (node == null) {
            return -1;
        }
        cache.moveToHead(node);
        return node.val;
    }

    public void put(int key, int val) {
        if (key2Node.containsKey(key)) {
            Node node = key2Node.get(key);
            node.val = val;
            cache.moveToHead(node);
        } else {
            if (cache.size >= capacity) {
                key2Node.remove(cache.removeLast().key);
            }
            Node node = new Node(key, val);
            key2Node.put(key, node);
            cache.addFirst(node);
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            ++size;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            --size;
        }

        void moveToHead(Node node) {
            remove(node);
            addFirst(node);
        }

        Node removeLast() {
            if (isEmpty()) {
                return null;
            }
            Node node = tail.prev;
            remove(node);
            return node;
        }

        boolean isEmpty() {
            return size == 0;
        }
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