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
        int L = A.length;
        State[] dp = new State[L];
        dp[L-1] = State.GOOD;
        for (int i = 0; i < L-1; ++i) {
            dp[i] = State.UNKNOWN;
        }
        for (int i = L-2; i >= 0; --i) {
            int rightmost = Math.min(i+A[i], L-1);
            for (int j = rightmost; j > i; --j) {
                if (dp[j] == State.GOOD) {
                    dp[i] = State.GOOD;
                    break;
                }
            }
        }
        return dp[0] == State.GOOD;
    }

    enum State {
        GOOD, BAD, UNKNOWN;
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