package c01_array.lc0089_gray_code;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No. 89 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/gray-code/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 * A gray code sequence must begin with 0.
 *
 * Example 1:
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 *
 * Example 2:
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 *              A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
 *              Therefore, for n = 0 the gray code sequence is [0].
 * ==========================================================================================================
 *
 * Tags: array;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1
     *
     * Complexity Analysis:
     * Time Complexity: O(2^N)
     * Space Complexity: O(1)
     *
     * @param n int, the number of bits
     * @return List<Integer>, the sequence of gray code
     */
    public List<Integer> grayCode(int n) {
        List<Integer> codes = new ArrayList<>();
        codes.add(0);
        for (int i = 0; i < n; ++i) {
            int size = codes.size(), addNum = 1 << i;
            for (int j = size - 1; j >= 0; --j) {
                codes.add(codes.get(j) + addNum);
            }
        }
        return codes;
    }
}