package c07_math_and_digit.lc0365_water_and_jug_problem;

/**
 * This is the solution of No. 365 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/water-and-jug-problem/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available.
 * You need to determine whether it is possible to measure exactly z litres using these two jugs.
 *
 * If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
 *
 * Operations allowed:
 * 1. Fill any of the jugs completely with water.
 * 2. Empty any of the jugs.
 * 3. Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
 *
 * Example 1: (From the famous "Die Hard" example)
 * Input: x = 3, y = 5, z = 4
 * Output: True
 *
 * Example 2:
 * Input: x = 2, y = 6, z = 5
 * Output: False
 * ==========================================================================================================
 *
 * Tags: math;bfs;dfs;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution3 {
    /**
     * Approach 3: Math
     * Time complexity：O(log(min(x, y)))
     * Space complexity: O(1)
     *
     * @param x int, the capacity of jug x
     * @param y int, the capacity of jug y
     * @param z int, the litres of water to measure
     * @return boolean, true if the litres of water can be measured by using two jugs
     */
    public boolean canMeasureWater(int x, int y, int z) {
        return z == 0 || (long) (x + y) >= z && z % gcd(x, y) == 0;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int x = 3, y = 5, z = 4;
        Solution3 solution = new Solution3();
        System.out.println(solution.canMeasureWater(x, y, z));
    }
}