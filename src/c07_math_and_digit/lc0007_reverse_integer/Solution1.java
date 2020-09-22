package c07_math_and_digit.lc0007_reverse_integer;

/**
 * This is the solution of No. 7 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/reverse-integer/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 * Input: 123
 * Output: 321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 *
 * Note:
 * - Assume we are dealing with an environment which could only store integers within
 *   the 32-bit signed integer range: [−2 ^ 31,  2 ^ 31 − 1]. For the purpose of this problem,
 *   assume that your function returns 0 when the reversed integer overflows.
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: math;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Simulation
     * Imagine an integer is a stack, and we can use another stack (integer) to
     * store the popped digits
     *
     * Complexity Analysis:
     * Time Complexity: O(log(N))
     * Space Complexity: O(1)
     *
     * @param x int, the input integer
     * @return int, the reverse integer
     */
    public int reverseV1(int x) {
        int rev = 0;
        while (x != 0) { // !stack.isEmpty()
            // pop from the old integer
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            // push into the new integer
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /**
     * Approach 1: Imagine an integer is a stack, and we can use another stack (integer) to store the popped bits
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param x int, the input integer
     * @return int, the reverse integer
     */
    public int reverseV2(int x) {
        int prevRev = 0, rev = 0;
        while (x != 0) {
            // pop from the old integer
            int pop = x % 10;
            x /= 10;
            // push into the new integer
            rev = rev * 10 + pop;
            if ((rev - pop) / 10 != prevRev) {
                return 0;
            }
            prevRev = rev;
        }
        return rev;
    }

    public static void main(String[] args) {
        int x = 21474;
        Solution1 solu = new Solution1();
        System.out.println(solu.reverseV1(x));
        System.out.println(solu.reverseV2(x));
    }
}