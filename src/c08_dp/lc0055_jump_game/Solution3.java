package c08_dp.lc0055_jump_game;

/**
 * This is the solution of No. 55 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/jump-game/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position. Determine if you are
 * able to reach the last index.
 *
 * Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 * ==========================================================================================================
 *
 * Tags: dp;greedy algorithm;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution3 {
    /**
     * Approach 3: Dynamic Programming
     * 用一个数组 dp 保存输入数组 A 中每个位置是否可以到达最后一个元素（1 表示可以到达），然后反向填充数组 dp，
     * 因为前面的元素的判断需要利用到后面的元素。最后，判断数组 dp 的第一个位置是否为 1 即可。
     *
     * Complexity Analysis:
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(n)
     *
     * Result of Submission:
     * Runtime: 377 ms, faster than 21.31% of Java online submissions for Jump Game.
     * Memory Usage: 44.2 MB, less than 7.69% of Java online submissions for Jump Game.
     * 
     * @param A int[], an input array of non-negative integers
     * @return boolean, true if and only if you can reach the last index
     */
    public boolean canJump(int[] A) {
        int n = A.length;
        int[] dp = new int[n];  // -1 表示无法到达，0 表示未知，1 表示可以到达
        dp[n-1] = 1;
        for (int i = n - 2; i >= 0; --i) {
            int rightmost = Math.min(i + A[i], n-1);
            for (int j = rightmost; j > i; --j) {
                if (dp[j] == 1) {
                    dp[i] = 1;
                    break;
                }
            }
            if (dp[i] != 1) {
                dp[i] = -1;
            }
        }
        return dp[0] == 1;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 1, 0, 4};
        Solution3 solu = new Solution3();
        double t0 = System.nanoTime();
        boolean ans = solu.canJump(A);
        double t1 = System.nanoTime();
        System.out.format("[INFO] Time consumed: %f ms\n", (t1 - t0) / 1000000.0);
        System.out.println(ans);
    }
}