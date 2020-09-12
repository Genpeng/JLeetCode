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
public class Solution1 {
    /**
     * Approach 1: Recursive (DFS)
     * Time Complexity: O(2 ^ n)
     * Space Complexity: O(n)
     *
     * Time Complexity analysis can refer to:
     * https://leetcode.com/articles/jump-game/
     *
     * Result of Submission:
     * Time Limit Exceeded
     *
     * @param A int[], an input array of non-negative integers
     * @return boolean, true if and only if you can reach the last index
     */
    public boolean canJump(int[] A) {
        return canJump(A, 0);
    }

    private boolean canJump(int[] A, int startIndex) {
        if (startIndex == A.length - 1) {
            return true;
        }
        int rightmost = Math.min(startIndex + A[startIndex], A.length - 1);
        for (int i = rightmost; i > startIndex; --i) {
            if (canJump(A, i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 1, 0, 4};
        Solution1 solu = new Solution1();
        double t0 = System.nanoTime();
        boolean ans = solu.canJump(A);
        double t1 = System.nanoTime();
        System.out.format("[INFO] Time consumed: %f ms\n", (t1 - t0) / 1000000.0);
        System.out.println(ans);
    }
}