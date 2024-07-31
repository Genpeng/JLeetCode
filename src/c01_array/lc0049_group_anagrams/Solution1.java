package c01_array.lc0049_group_anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the solution of No. 49 problem in the LeetCode,
 * the website of the problem is as follows:
 * https://leetcode.com/problems/group-anagrams
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * <p>
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 * <p>
 * Constraints:
 * - 1 <= strs.length <= 10^4
 * - 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: array;hash table;
 *
 * @author Lukas (xgp1227atgmail.com)
 */
public class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 解法1：哈希表
        // 时间复杂度：O(n * L)
        // 空间复杂度：O(n * L)

        List<List<String>> ans = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return ans;
        }
        int n = strs.length;
        Map<String, List<String>> map = new HashMap<>(n);
        for (String s : strs) {
            String key = encodeV2(s);
            List<String> vals = map.getOrDefault(key, new ArrayList<>());
            vals.add(s);
            map.put(key, vals);
        }
        return new ArrayList<>(map.values());
    }

    public String encodeV1(String s) {
        // 时间复杂度：O(L)
        // 空间复杂度：O(1)
        int[] count = new int[26];
        int L = s.length();
        for (int i = 0; i < L; ++i) {
            ++count[s.charAt(i) - 'a'];
        }
        StringBuilder sb = new StringBuilder();
        for (int x : count) {
            sb.append(x).append('|');
        }
        return sb.toString();
    }

    public String encodeV2(String s) {
        // 时间复杂度：O(L)
        // 空间复杂度：O(1)
        int[] count = new int[26];
        int L = s.length();
        for (int i = 0; i < L; ++i) {
            ++count[s.charAt(i)-'a'];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; ++i) {
            if (count[i] > 0) {
                sb.append((char) (i + 'a')).append(count[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"bdddddddddd", "bbbbbbbbbbc"};
        Solution1 solu = new Solution1();
        List<List<String>> ans = solu.groupAnagrams(strs);
        System.out.println(ans);
    }
}