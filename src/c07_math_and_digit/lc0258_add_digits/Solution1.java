package c07_math_and_digit.lc0258_add_digits;

/**
 * This is the solution of No. 258 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/add-digits/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * Example:
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 * Since 2 has only one digit, return it.
 * ==========================================================================================================
 * <p>
 * Difficulty: Easy
 * Tags: math;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Iteration
     *
     * Complexity Analysis:
     * Time Complexity: O(log(n))
     * Space Complexity: O(1)
     *
     * @param num int, a non-negative integer
     * @return int, digital root
     */
    public int addDigits(int num) {
        while (num > 9) {
            num = getNext(num);
        }
        return num;
    }

    private int getNext(int num) {
        int ans = 0;
        while (num != 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.addDigits(38) == 2);
    }
}