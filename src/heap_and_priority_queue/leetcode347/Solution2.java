package heap_and_priority_queue.leetcode347;

import java.util.*;

/**
 * This is the solution of No. 347 problem in the LeetCode,
 * which uses the priority queue class in the java standard library,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/11/11
 */
public class Solution2 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 统计元素的频率
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
//        PriorityQueue<Integer> pq = new PriorityQueue<>(
//                (a, b) -> map.get(a) - map.get(b)
//        );
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }

        // 取出最小堆中的元素
        List<Integer> ret = new ArrayList<>();
        while (!pq.isEmpty()) {
            ret.add(pq.remove());
        }

        return ret;
    }

    private static void printList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); ++i) {
            if (i < list.size() - 1) {
                sb.append(list.get(i)).append(",").append(" ");
            } else {
                sb.append(list.get(i));
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        Solution2 solution = new Solution2();
        printList(solution.topKFrequent(nums, k));
    }
}
