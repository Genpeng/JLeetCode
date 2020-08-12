package c09_design.lc0460_lfu_cache;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 460 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/lfu-cache/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity,
 *                   it should invalidate the least frequently used item before inserting a new item.
 *                   For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency),
 *                   the least recently used key would be evicted.
 *
 * Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted.
 * This number is set to zero when the item is removed.
 *
 * Follow up:
 * - Could you do both operations in O(1) time complexity?
 *
 * Example:
 * LFUCache cache = new LFUCache(2);
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.get(3);       // returns 3.
 * cache.put(4, 4);    // evicts key 1.
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * ==========================================================================================================
 *
 * Difficulty: Hard
 * Tags: design;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class LFUCache {
    private int capacity, size, minFreq;
    private Map<Integer, Node> key2Node;
    private Map<Integer, DoublyLinkedList> freq2List;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        key2Node = new HashMap<>();
        freq2List = new HashMap<>();
    }

    public int get(int key) {
        Node node = key2Node.get(key);
        if (node == null) {
            return -1;
        }
        update(node);
        return node.val;
    }

    public void put(int key, int val) {
        if (capacity <= 0) {
            return;
        }
        if (key2Node.containsKey(key)) {
            Node node = key2Node.get(key);
            node.val = val;
            update(node);
        } else {
            // 备注：这里一定要先删除元素，再添加新的元素
            Node node = new Node(key, val);
            if (size == capacity) {
                DoublyLinkedList oldList = freq2List.get(minFreq);
                key2Node.remove(oldList.removeLast().key);
                --size;
            }
            minFreq = 1;
            key2Node.put(key, node);
            DoublyLinkedList list = freq2List.getOrDefault(node.freq, new DoublyLinkedList());
            list.addFirst(node);
            freq2List.put(node.freq, list);
            ++size;
        }
    }

    private void update(Node node) {
        DoublyLinkedList oldList = freq2List.get(node.freq);
        oldList.remove(node);
        if (node.freq == minFreq && oldList.size == 0) {
            ++minFreq;
        }
        ++node.freq;
        DoublyLinkedList newList = freq2List.getOrDefault(node.freq, new DoublyLinkedList());
        newList.addFirst(node);
        freq2List.put(node.freq, newList);
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

        Node removeLast() {
            if (size == 0) {
                return null;
            }
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    class Node {
        int key, val, freq;
        Node prev, next;
        Node(int key, int val) {
            this(key, val, 1);
        }

        Node(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3.
        cache.put(4, 4); // evicts key 1.
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}