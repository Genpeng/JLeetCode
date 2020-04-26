package c08_dp.lc0055_jump_game;

import java.util.Arrays;

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
public class Solution2 {
    /**
     * Approach 2: Recursive with memoization
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(n)
     *
     * Result of Submission:
     * Runtime: 1919 ms, faster than 5.01% of Java online submissions for Jump Game.
     * Memory Usage: 46.9 MB, less than 5.13% of Java online submissions for Jump Game.
     * 
     * @param A int[], an input array of non-negative integers
     * @return boolean, true if and only if you can reach the last index
     */
    public boolean canJump(int[] A) {
        int L = A.length;
        State[] memo = new State[L];
        memo[L-1] = State.GOOD;
        for (int i = 0; i < L-1; ++i) {
            memo[i] = State.UNKNOWN;
        }
        return canJumpFromPosition(A, 0, memo);
    }

    private boolean canJumpFromPosition(int[] A, int idx, State[] memo) {
        if (memo[idx] != State.UNKNOWN) {
            return memo[idx] == State.GOOD;
        }
        int rightmost = Math.min(idx+A[idx], A.length-1);
        for (int i = rightmost; i > idx; --i) {
            if (canJumpFromPosition(A, i, memo)) {
                memo[idx] = State.GOOD;
                return true;
            }
        }
        memo[idx] = State.BAD;
        return false;
    }

    enum State {
        GOOD, BAD, UNKNOWN;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 1, 0, 4};
        Solution2 solu = new Solution2();
        double t0 = System.nanoTime();
        boolean ans = solu.canJump(A);
        double t1 = System.nanoTime();
        System.out.format("[INFO] Time consumed: %f ms\n", (t1 - t0) / 1000000.0);
        System.out.println(ans);
    }
}