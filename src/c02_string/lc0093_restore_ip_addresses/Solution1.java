package c02_string.lc0093_restore_ip_addresses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This is the solution of No. 93 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/restore-ip-addresses/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string s containing only digits, return all possible valid IP addresses that can be obtained
 * from s. You can return them in any order.
 *
 * A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by
 * single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses
 * and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 *
 * Example 1:
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 *
 * Example 2:
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 *
 * Example 3:
 * Input: s = "1111"
 * Output: ["1.1.1.1"]
 *
 * Example 4:
 * Input: s = "010010"
 * Output: ["0.10.0.10","0.100.1.0"]
 *
 * Example 5:
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 * Constraints:
 * - 0 <= s.length <= 3000
 * - s consists of digits only.
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: string;backtracking;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Backtracking with pruning
     *
     * Reference:
     * [1] Notability 上这道题的树形图
     *
     * Result of Submission:
     * Runtime: 1 ms, faster than 99.56% of Java online submissions for Restore IP Addresses.
     * Memory Usage: 37.5 MB, less than 99.05% of Java online submissions for Restore IP Addresses.
     *
     * @param s String, a string s containing only digits
     * @return List<String>, all possible valid IP addresses
     */
    public List<String> restoreIpAddresses(String s) {
        final int L = s.length();
        List<String> ips = new LinkedList<>();
        if (L < 4 || L > 12) {
            return ips;
        }
        int[] path = new int[4];
        dfs(s, 4, L, 0, path, 0, ips);
        return ips;
    }

    private void dfs(String s, int remainNum, int remainLen, int start, int[] path, int idx, List<String> ips) {
        if (remainNum == 0) {
            if (remainLen == 0) {
                StringBuilder ip = new StringBuilder();
                for (int num : path) {
                    ip.append(num).append('.');
                }
                ip.deleteCharAt(ip.length() - 1);
                ips.add(ip.toString());
            }
            // remainNum == 0 && remainLen > 0，剪枝条件3
            return;
        }
        if (s.charAt(start) == '0') {
            path[idx] = 0;
            dfs(s, remainNum - 1, remainLen - 1, start+1, path, idx+1, ips);
            return;
        }
        int currNum = 0;
        for (int i = 1; i < 4 && start + i <= s.length(); ++i) {
            currNum = currNum * 10 + (s.charAt(start+i-1) - '0');
            if (remainLen-i < remainNum-1 || remainLen-i > (remainNum-1) * 3) { // 剪枝条件1
                continue;
            }
            if (currNum > 255) { // 剪枝条件2
                continue;
            }
            path[idx] = currNum;
            dfs(s, remainNum-1, remainLen-i, start+i, path, idx+1, ips);
        }
    }

    private static final int SEG_COUNT = 4;
    private List<String> ans = new ArrayList<>();

    /**
     * 解法1：回溯（backtracking）
     *
     * 复杂度分析：
     * - 时间复杂度：O(3^4 * L)
     * - 空间复杂度：O(4)
     * 其中，L 表示字符串的长度
     *
     * @param s String, a string s containing only digits
     * @return List<String>, all possible valid IP addresses
     */
    public List<String> restoreIpAddressesV2(String s) {
        int[] segments = new int[SEG_COUNT];
        dfsV2(s, 0, segments, 0);
        return ans;
    }

    private void dfsV2(String s, int start, int[] segments, int segIdx) {
        if (segIdx == SEG_COUNT) {
            if (start == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    sb.append(segments[i]);
                    if (i != SEG_COUNT-1) {
                        sb.append('.');
                    }
                }
                ans.add(sb.toString());
            }
            return;
        }

        if (start == s.length()) {
            return;
        }

        if (s.charAt(start) == '0') {
            segments[segIdx] = 0;
            dfsV2(s, start+1, segments, segIdx+1);
            return;
        }

        int addr = 0;
        for (int i = start; i < s.length(); ++i) {
            addr = addr * 10 + s.charAt(i) - '0';
            if (addr > 0 && addr <= 255) {
                dfsV2(s, i+1, segments, segIdx+1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.restoreIpAddressesV2("0000"));
    }
}