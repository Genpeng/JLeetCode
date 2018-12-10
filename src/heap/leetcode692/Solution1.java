package heap.leetcode692;

import java.util.*;

/**
 * This is the solution of No. 692 problem in the LeetCode by using sort algorithm,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/top-k-frequent-words/
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/12/05
 */
public class Solution1 {
    public List<String> topKFrequent(String[] words, int k) {
        // 1. 统计单词的词频
        //    时间复杂度为 O(n)
        Map<String, Integer> wordFreq = new HashMap<>(16);
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        // 2. 对所有的单词按照词频（词频相同，按照字母顺序）进行排序
        //    时间复杂度为 O(N * log(N))
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordFreq.entrySet());
//        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
//                return e1.getValue().equals(e2.getValue()) ?
//                        e1.getKey().compareTo(e2.getKey()) : e2.getValue() - e1.getValue();
//            }
//        });
        Collections.sort(entries, (e1, e2) -> e1.getValue().equals(e2.getValue()) ?
                e1.getKey().compareTo(e2.getKey()) : e2.getValue() - e1.getValue());

        // 3. 返回前k个单词
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            result.add(entries.get(i).getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 1;
        System.out.println((new Solution1()).topKFrequent(words, k));
    }
}
