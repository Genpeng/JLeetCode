package c02_string.lc0043_multiply_strings;

/**
 * This is the solution of No. 43 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/multiply-strings/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2,
 * also represented as a string.
 *
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 * Note:
 * - The length of both num1 and num2 is < 110.
 * - Both num1 and num2 contain only digits 0-9.
 * - Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * - You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * ==========================================================================================================
 *
 * Tags: string;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1
     *
     * Complexity Analysis:
     * Time Complexity: O(m + n)
     * Space Complexity: O(m + n)
     *
     * References:
     * [1] https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
     *
     * Result of Submission:
     * Runtime: 3 ms, faster than 96.03% of Java online submissions for Multiply Strings.
     * Memory Usage: 38.2 MB, less than 23.33% of Java online submissions for Multiply Strings.
     *
     * @param num1 String, one integer
     * @param num2 String, the other integer
     * @return String, the product of two integers
     */
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] prod = new int[m + n];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                int p1 = i + j, p2 = i + j + 1;
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + prod[p2];
                prod[p1] += sum / 10;
                prod[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : prod) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        Solution1 solu = new Solution1();
        System.out.println(solu.multiply(num1, num2));
    }
}