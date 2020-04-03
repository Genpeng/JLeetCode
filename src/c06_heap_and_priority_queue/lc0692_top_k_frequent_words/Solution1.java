package c06_heap_and_priority_queue.lc0692_top_k_frequent_words;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This is the solution of No. 692 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/top-k-frequent-words/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency,
 * then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 *
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 *
 * Note:
 * - You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * - Input words contain only lowercase letters.
 *
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/04/20
 */
public class Solution1 {
    public List<String> topKFrequent(String[] words, int k) {
        // 统计单词的词频
        // 时间复杂度：O(n)
        Map<String, Integer> wordFreq = new HashMap<>(16);
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        // 对所有的单词按照词频（词频相同，按照字母顺序）进行排序
        // 时间复杂度：O(m * logm)，其中m表示不重复字符串的数目
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

        // 返回前k个单词
        // 时间复杂度：O(k)
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            result.add(entries.get(i).getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println((new Solution1()).topKFrequent(words, k));
    }
}
