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
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution {
    /**
     * 解法：Revert half of the number
     * 思路：对 `x` 的后半部分取反，并与前半部分进行比较
     * 时间复杂度：O(log(n))
     * 空间复杂度：O(1)
     *
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
            // push the digit into new rev
            rev = rev * 10 + x % 10;
            // pop the digit from x
            x /= 10;
        }
        return x == rev || x == rev / 10;
    }

    public static void main(String[] args) {
        int x = 12321;
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(x));
    }
}