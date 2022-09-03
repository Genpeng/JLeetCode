package c01_array.lc0202_happy_number;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 202 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/happy-number/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * - Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * - Those numbers for which this process ends in 1 are happy.
 *
 * Return true if n is a happy number, and false if not.
 *
 * Example 1:
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * Example 2:
 * Input: n = 2
 * Output: false
 *
 * Constraints:
 * 1 <= n <= 231 - 1
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: fast & slow pointers;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * 判断一个整数是否为快乐数
     *
     * 什么是快乐数？
     * 计算一个正整数每一位的平方和，如果一直重复这个过程，可以到达 1，则是快乐数；否则，不是快乐数。
     *
     * 解题思路：Hash Table
     *
     * @param n int, a positive integer
     * @return boolean, true if input integer is a happy number
     */
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNextNum(n);
        }
        return n == 1;
    }

    public int getNextNum(int n) {
        int s = 0;
        while (n != 0) {
            int remainder = n % 10;
            s += remainder * remainder;
            // update to next iteration
            n /= 10;
        }
        return s;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.isHappy(19));
    }
}