package c07_math_and_digit.lc0009_palindrome_number;

/**
 * This is the solution of No. 9 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/palindrome-number/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 * Input: 121
 * Output: true
 *
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Follow up:
 * - Coud you solve it without converting the integer to a string?
 * ==========================================================================================================
 *
 * Tags: math;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Reverse half of the integer
     * Reverse the second half of the integer and compare it with the first half
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * where N represents the number of digits
     *
     * Result of Submission:
     * Runtime: 6 ms, faster than 100.00% of Java online submissions for Palindrome Number.
     * Memory Usage: 40.4 MB, less than 5.02% of Java online submissions for Palindrome Number.
     *
     * @param x int, an integer
     * @return boolean, true if an integer is a palindrome
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            // push into new integer
            rev = rev * 10 + x % 10;
            // pop from old integer
            x /= 10;
        }
        return x == rev || x == rev / 10;
    }

    public static void main(String[] args) {
        int x = 12321;
        Solution1 solution = new Solution1();
        System.out.println(solution.isPalindrome(x));
    }
}