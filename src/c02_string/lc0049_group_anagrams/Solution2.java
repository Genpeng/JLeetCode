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
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/04/30
 */
public class Solution2 {
    /**
     * 解法二：哈希表，key为统计字符次数的字符串
     * 时间复杂度：O(N * K)，其中N表示数组元素的数目，K表示数组中字符串的最大长度
     * 空间复杂度：O(N)
     *
     * @param strs String[], the array of strings
     * @return List<List<String>>, list of anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> ans = new HashMap<>();
        for (String str : strs) {
            // 统计每个字符串的词频
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                ++count[c - 'a'];
            }
            // 构造每个字符串的编码字符串
            StringBuilder sb = new StringBuilder();
            for (int n : count) {
                sb.append("#");
                sb.append(n);
            }
            String key = sb.toString();
            // 按照编码字符串的不同对字符串进行分组
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(str);
        }
        return new ArrayList<>(ans.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println((new Solution2()).groupAnagrams(strs));
    }
}