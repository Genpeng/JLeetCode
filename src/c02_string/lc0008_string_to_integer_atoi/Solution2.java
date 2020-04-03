package c02_string.lc0008_string_to_integer_atoi;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 8 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character
 * is found. Then, starting from this character, takes an optional initial plus or minus sign followed by
 * as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored
 * and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters,
 * no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 * - Only the space character ' ' is considered as whitespace character.
 * - Assume we are dealing with an environment which could only store integers within
 *   the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of
 *   representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 *
 * Example 1:
 * Input: "42"
 * Output: 42
 *
 * Example 2:
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 *
 * Example 3:
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 *
 * Example 4:
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 *
 * Example 5:
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
 * ==========================================================================================================
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Deterministic Finite Automaton (DFA)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Reference:
     * https://leetcode-cn.com/problems/string-to-integer-atoi/solution/zi-fu-chuan-zhuan-huan-zheng-shu-atoi-by-leetcode-/
     *
     * @param str String, an input string
     * @return int, the corresponding integer
     */
    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        for (char c : str.toCharArray()) {
            automaton.nextState(c);
        }
        return (int) (automaton.sign * automaton.base);
    }

    class Automaton {
        private String state;
        private Map<String, String[]> table;
        public int sign;
        public long base;

        public Automaton() {
            this.state = "start";
            this.table = generateTable();
            this.sign = 1;
            this.base = 0;
        }

        private Map<String, String[]> generateTable() {
            Map<String, String[]> table = new HashMap<>();
            table.put("start", new String[] {"start", "signed", "in_number", "end"});
            table.put("signed", new String[] {"end", "end", "in_number", "end"});
            table.put("in_number", new String[] {"end", "end", "in_number", "end"});
            table.put("end", new String[] {"end", "end", "end", "end"});
            return table;
        }

        private int getCol(char c) {
            if (c == ' ') {
                return 0;
            } else if (c == '+' || c == '-') {
                return 1;
            } else if (c >= '0' && c <= '9') {
                return 2;
            } else {
                return 3;
            }
        }

        public void nextState(char c) {
            state = table.get(state)[getCol(c)];
            if (state.equals("in_number")) {
                base = base * 10 + c - '0';
                base = sign == 1 ? Math.min(base, Integer.MAX_VALUE) : Math.min(base, - (long) Integer.MIN_VALUE);
            } else if (state.equals("signed")) {
                sign = c == '+' ? 1 : -1;
            }
        }
    }

    public static void main(String[] args) {
        String s = "    -42";
        Solution2 solution = new Solution2();
        System.out.println(solution.myAtoi(s));
    }
}