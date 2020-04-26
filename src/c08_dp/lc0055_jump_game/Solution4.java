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
public class Solution4 {
    /**
     * Approach 4: Greedy Algorithm
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Result of Submission:
     * Runtime: 1 ms, faster than 98.68% of Java online submissions for Jump Game.
     * Memory Usage: 41.5 MB, less than 29.06% of Java online submissions for Jump Game.
     * 
     * @param A int[], an input array of non-negative integers
     * @return boolean, true if and only if you can reach the last index
     */
    public boolean canJump(int[] A) {
        int L = A.length, leftmost = L - 1; // `leftmost` represents the leftmost index which can reach last index
        for (int i = L - 2; i >= 0; --i) {
            if (i + A[i] >= leftmost) {
                leftmost = i;
            }
        }
        return leftmost == 0;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 1, 0, 4};
        Solution4 solu = new Solution4();
        double t0 = System.nanoTime();
        boolean ans = solu.canJump(A);
        double t1 = System.nanoTime();
        System.out.format("[INFO] Time consumed: %f ms\n", (t1 - t0) / 1000000.0);
        System.out.println(ans);
    }
}