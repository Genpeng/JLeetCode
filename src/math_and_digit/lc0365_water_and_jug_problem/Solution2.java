package math_and_digit.lc0365_water_and_jug_problem;

import java.util.*;

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
public class Solution2 {
    /**
     * Approach 2: DFS
     * Time complexity：O(xy)
     * Space complexity: O(xy)
     *
     * @param x int, the capacity of jug x
     * @param y int, the capacity of jug y
     * @param z int, the litres of water to measure
     * @return boolean, true if the litres of water can be measured by using two jugs
     */
    public boolean canMeasureWaterV1(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }
        Stack<State> stack = new Stack<>();
        Set<State> seen = new HashSet<>();
        State start = new State(0, 0);
        stack.push(start);
        seen.add(start); // 在生成下一层状态的时候加入到集合中
        while (!stack.isEmpty()) {
            State curr = stack.pop();
            if (curr.x == z || curr.y == z || curr.x + curr.y == z) {
                return true;
            }
            List<State> nextStates = generateNextStates(curr.x, curr.y, x, y);
            for (State state : nextStates) {
                if (!seen.contains(state)) {
                    stack.push(state);
                    seen.add(state);
                }
            }
        }
        return false;
    }

    /**
     * Approach 2: DFS
     * Time complexity：O(xy)
     * Space complexity: O(xy)
     *
     * @param x int, the capacity of jug x
     * @param y int, the capacity of jug y
     * @param z int, the litres of water to measure
     * @return boolean, true if the litres of water can be measured by using two jugs
     */
    public boolean canMeasureWaterV2(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (z > x + y) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();
        stack.push(0);
        seen.add(0);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (curr + x <= x + y && seen.add(curr + x)) {
                stack.push(curr + x);
            }
            if (curr + y <= x + y && seen.add(curr + y)) {
                stack.push(curr + y);
            }
            if (curr - x >= 0 && seen.add(curr - x)) {
                stack.push(curr - x);
            }
            if (curr - y >= 0 && seen.add(curr - y)) {
                stack.push(curr - y);
            }
            if (seen.contains(z)) {
                return true;
            }
        }
        return false;
    }

    private List<State> generateNextStates(int currX, int currY, int x, int y) {
        List<State> nextStates = new LinkedList<>();
        if (currX == 0) {
            nextStates.add(new State(x, currY));
        }
        if (currY == 0) {
            nextStates.add(new State(currX, y));
        }
        if (currX == x) {
            nextStates.add(new State(0, currY));
        }
        if (currY == y) {
            nextStates.add(new State(currX, 0));
        }
        int moveSize;
        if (currX > 0) {
            moveSize = Math.min(currX, y - currY);
            nextStates.add(new State(currX - moveSize, currY + moveSize));
        }
        if (currY > 0) {
            moveSize = Math.min(currY, x - currX);
            nextStates.add(new State(currX + moveSize, currY - moveSize));
        }
        return nextStates;
    }

    class State {
        public int x, y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State other = (State) o;
            return x == other.x && y == other.y;
        }

        @Override
        public String toString() {
            return String.format("(%s, %s)", x, y);
        }
    }

    public static void main(String[] args) {
        int x = 3, y = 5, z = 4;
        Solution2 solution = new Solution2();
        System.out.println(solution.canMeasureWaterV1(x, y, z));
    }
}