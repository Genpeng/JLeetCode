package c01_array.lc1160_find_words_that_can_be_formed_by_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 1160 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * You are given an array of strings words and a string chars.
 *
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 *
 * Return the sum of lengths of all good strings in words.
 *
 * Example 1:
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 *
 * Example 2:
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation:
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 *
 * Note:
 * - 1 <= words.length <= 1000
 * - 1 <= words[i].length, chars.length <= 100
 * - All strings contain lowercase English letters only.
 * ==========================================================================================================
 *
 * Tags: array;hash table;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution {
    /**
     * Approach 1: Hash Table
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param words String[], a string array
     * @param chars String, a string
     * @return int, the sum of lengths of all good strings in words
     */
    public int countCharactersV1(String[] words, String chars) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : chars.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        for (String word : words) {
            if (canBeFormed(word, counts)) {
                ans += word.length();
            }
        }
        return ans;
    }

    private boolean canBeFormed(String word, Map<Character, Integer> counts) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > counts.getOrDefault(c, 0)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach 1: Hash Table
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * Runtime: 3 ms, faster than 97.56% of Java online submissions for Find Words That Can Be Formed by Characters.
     * Memory Usage: 42.1 MB, less than 100.00% of Java online submissions for Find Words That Can Be Formed by Characters.
     *
     * @param words String[], a string array
     * @param chars String, a string
     * @return int, the sum of lengths of all good strings in words
     */
    public int countCharactersV2(String[] words, String chars) {
        int[] charCounts = new int[26];
        for (char c : chars.toCharArray()) {
            ++charCounts[c - 'a'];
        }
        int ans = 0;
        for (String word : words) {
            if (canBeFormed(word, charCounts)) {
                ans += word.length();
            }
        }
        return ans;
    }

    private boolean canBeFormed(String word, int[] charCounts) {
        int[] counts = new int[26];
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (++counts[idx] > charCounts[idx]) {
                return false;
            }
        }
        return true;
    }
}