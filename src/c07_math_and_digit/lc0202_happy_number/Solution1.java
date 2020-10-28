package c07_math_and_digit.lc0202_happy_number;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 202 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/happy-number/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until
 * the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 *
 * Example:
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: hash table;two pointers;math;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Hash Table
     * 7 -> 49 -> 97 -> 130 -> 10 -> 1
     *
     * Complexity Analysis:
     * Time Complexity: xx
     * Space Complexity: xx
     *
     * Result of Submission:
     * Runtime: 1 ms, faster than 86.72% of Java online submissions for Happy Number.
     * Memory Usage: 36.2 MB, less than 10.56% of Java online submissions for Happy Number.
     *
     * @param n int, a positive integer
     * @return boolean, true if and only if the number `n` is "happy"
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = getNext(n);
        }
        return true;
    }

    private int getNext(int n) {
        int s = 0;
        while (n > 0) {
            int d = n % 10;
            s += d * d;
            // update to next iteration
            n /= 10;
        }
        return s;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.isHappy(7) == true);
        System.out.println(solu.isHappy(19) == true);
    }
}