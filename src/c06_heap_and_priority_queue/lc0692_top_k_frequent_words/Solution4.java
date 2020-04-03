package c06_heap_and_priority_queue.lc0692_top_k_frequent_words;

import java.util.*;

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
public class Solution4 {
    public List<String> topKFrequent(String[] words, int k) {
        // 统计单词的词频
        // 时间复杂度：O(n)
        Map<String, Integer> wordFreq = new HashMap<>(16);
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        // 使用桶排序将单词按照词频进行分组
        // 时间复杂度：O(m)
        List<String>[] bucket = new List[words.length + 1];
        for (String word : wordFreq.keySet()) {
            int freq = wordFreq.get(word);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(word);
        }

        // 取出 top k 词频的单词（备注：词频相同的单词按照字母顺序排列）
        // 时间复杂度为 O(n * log(n))，具体地，可以参考对于波波老师的提问：
        // https://coding.imooc.com/learn/questiondetail/91771.html
        List<String> result = new ArrayList<>();
        for (int i = words.length; i > 0 && result.size() < k; --i) {
            if (bucket[i] != null) {
                if (bucket[i].size() > 1) {
                    Collections.sort(bucket[i]);
                }
                result.addAll(bucket[i]);
            }
        }
        return result.subList(0, k);
    }
}
