package c02_string.lc0049_group_anagrams;

import java.util.*;

/**
 * This is the solution of No. 49 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/group-anagrams/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of strings, group anagrams together.
 *
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * Note:
 * - All inputs will be in lowercase.
 * - The order of your output does not matter.
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: string;hash table;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * 解法一：哈希表，key为排序后的字符串
     * 时间复杂度：O(N * K * log(K))，其中N表示数组元素的数目，K表示数组中字符串的最大长度
     * 空间复杂度：O(N)
     *
     * @param strs String[], the array of strings
     * @return List<List<String>>, list of anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> ans = new HashMap<>(16);
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(str);
        }
        return new ArrayList<>(ans.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println((new Solution1()).groupAnagrams(strs));
    }
}