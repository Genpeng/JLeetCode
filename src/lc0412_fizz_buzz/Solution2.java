package lc0412_fizz_buzz;

import java.util.LinkedList;
import java.util.List;

/**
 * This is the solution of No. 412 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/fizz-buzz/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Write a program that outputs the string representation of numbers from 1 to n.
 *
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 * Example:
 *
 * n = 15,
 *
 * Return:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/06/26
 */
public class Solution2 {
    /**
     * 解法二：字符串拼接
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param n int, an integer
     * @return list of string, the string representation of numbers from 1 to n
     */
    public List<String> fizzBuzz(int n) {
        List<String> res = new LinkedList<>();
        for (int i = 1; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            boolean divisibleBy3 = i % 3 == 0;
            boolean divisibleBy5 = i % 5 == 0;
            if (divisibleBy3) {
                sb.append("Fizz");
            }
            if (divisibleBy5) {
                sb.append("Buzz");
            }
            String s = sb.toString();
            if (s.length() == 0) {
                res.add(String.valueOf(i));
            } else {
                res.add(s);
            }
        }
        return res;
    }
}