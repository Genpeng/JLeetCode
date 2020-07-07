package c09_design.lc1429_first_unique_number;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. xxx problem in the LeetCode,
 * the website of the problem is as follow:
 * xxx
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 *
 * Implement the FirstUnique class:
 * - FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * - int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
 * - void add(int value) insert value to the queue.
 *
 * Example 1:
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
 * [[[2,3,5]],[],[5],[],[2],[],[3],[]]
 * Output:
 * [null,2,null,2,null,3,null,-1]
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([2,3,5]);
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(5);            // the queue is now [2,3,5,5]
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(2);            // the queue is now [2,3,5,5,2]
 * firstUnique.showFirstUnique(); // return 3
 * firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
 * firstUnique.showFirstUnique(); // return -1
 *
 * Example 2:
 * Input:
 * ["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
 * [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
 * Output:
 * [null,-1,null,null,null,null,null,17]
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
 * firstUnique.showFirstUnique(); // return -1
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
 * firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
 * firstUnique.showFirstUnique(); // return 17
 *
 * Example 3:
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique"]
 * [[[809]],[],[809],[]]
 * Output:
 * [null,809,null,-1]
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([809]);
 * firstUnique.showFirstUnique(); // return 809
 * firstUnique.add(809);          // the queue is now [809,809]
 * firstUnique.showFirstUnique(); // return -1
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^8
 * - 1 <= value <= 10^8
 * - At most 50000 calls will be made to showFirstUnique and add.
 * ==========================================================================================================
 *
 * Tags: design;
 *
 * TODO: fix the bug!!!
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class FirstUnique {
    private Map<Integer, Node> num2Node;
    private DoublyLinkedList uniques;

    public FirstUnique(int[] nums) {
        num2Node = new HashMap<>();
        uniques = new DoublyLinkedList();
        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        return uniques.peekFirst();
    }

    public void add(int num) {
        Node node;
        if (num2Node.containsKey(num) && num2Node.get(num) != null) {
            node = num2Node.get(num);
            uniques.remove(node);
        } else {
            node = uniques.addLast(num);
            num2Node.put(num, node);
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
        }

        Node addLast(int val) {
            Node node = new Node(val);
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            ++size;
            return node;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            --size;
        }

        boolean isEmpty() {
            return size == 0;
        }

        int peekFirst() {
            return isEmpty() ? -1 : head.next.val;
        }
    }

    class Node {
        int val;
        Node prev, next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        FirstUnique firstUnique = new FirstUnique(new int[] {809});
        System.out.println(firstUnique.showFirstUnique());  // return 809
        firstUnique.add(809);                               // the queue is now [809,809]
        System.out.println(firstUnique.showFirstUnique());  // return -1
    }
}