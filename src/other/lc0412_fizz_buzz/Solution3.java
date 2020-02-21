package other.lc0412_fizz_buzz;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
public class Solution3 {
    /**
     * 解法三：字符串拼接，改进扩展性
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param n int, an integer
     * @return list of string, the string representation of numbers from 1 to n
     */
    public List<String> fizzBuzz(int n) {
        List<String> res = new LinkedList<>();
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");
        for (int i = 1; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int k : map.keySet()) {
                if (i % k == 0) {
                    sb.append(map.get(k));
                }
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