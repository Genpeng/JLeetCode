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
public class Solution3 {
    public List<String> topKFrequent(String[] words, int k) {
        // 统计单词的词频
        // 时间复杂度：O(n)
        Map<String, Integer> wordFreq = new HashMap<>(16);
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        // 维护一个大小为k的最小堆，遍历上面得到的map，
        // 将单词添加到堆中，当堆中元素的数目大于k时，弹出堆顶元素
        // 时间复杂度：O(m * log(k))，其中m表示不重复单词的数目
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (String word : wordFreq.keySet()) {
            pq.add(new Pair(word, wordFreq.get(word)));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // 弹出堆中所有（k个）元素，并将它们的顺序进行反转
        // 时间复杂度：O(k * log(k))
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().word);
        }
        Collections.reverse(result);
        return result;
    }

    private class Pair implements Comparable<Pair> {
        String word;
        int freq;

        public Pair(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair other) {
            return this.freq == other.freq ? other.word.compareTo(this.word) : this.freq - other.freq;
        }
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println((new Solution3()).topKFrequent(words, k));
    }
}
