package c02_string.lcxxxx_perform_string_shifts;

/**
 * This is the solution of No. xxx problem in the LeetCode,
 * the website of the problem is as follow:
 * xxx
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 *
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 *
 * Example 1:
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 *
 * Example 2:
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 *
 * Constraints:
 * 1 <= s.length <= 100
 * s only contains lower case English letters.
 * 1 <= shift.length <= 100
 * shift[i].length == 2
 * 0 <= shift[i][0] <= 1
 * 0 <= shift[i][1] <= 100
 * ==========================================================================================================
 *
 * Tags: string;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Merge all shift operations and execute only once
     * Time Complexity: O(N + L)
     * Space Complexity: O(L)
     * where N represents the number of shift operations, and L is the length of the string
     *
     * @param s String, the input string
     * @param shifts int[][], a matrix, where shift[i] = [direction, amount]
     * @return String, the rotated string
     */
    public String stringShift(String s, int[][] shifts) {
        int left = 0;
        for (int[] shift : shifts) {
            if (shift[0] == 0) {
                left += shift[1];
            } else {
                left -= shift[1];
            }
        }
        left = left % s.length();
        if (left == 0) {
            return s;
        }
        left = left > 0 ? left : s.length() + left;
        return s.substring(left) + s.substring(0, left);
    }

    /**
     * Left rotate a string `s` by `offset` elements.
     *
     * @param s String, the input string
     * @param offset int, the left shift steps
     * @return String, the rotated string
     */
    public String rotateLeft(String s, int offset) {
        offset = offset % s.length();
        if (offset == 0) {
            return s;
        } else if (offset < 0) {
            return rotateLeft(s, s.length() + offset);
        } else {
            return s.substring(offset) + s.substring(0, offset);
        }
    }

    /**
     * Left rotate a string by `offset` elements, where the string represents by a char array.
     *
     * Reference:
     * https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/
     *
     * @param ca char[], the input string
     * @param offset int, the left shift steps
     */
    public void rotateLeft(char[] ca, int offset) {
        if (ca == null || ca.length == 0 || ca.length == 1) {
            return;
        }
        int L = ca.length;
        offset = offset % L;
        if (offset < 0) {
            rotateLeft(ca, L + offset);
        } else if (offset > 0) {
            reverse(ca, 0, offset - 1);
            reverse(ca, offset, L - 1);
            reverse(ca, 0, L - 1);
        }
    }

    /**
     * Right rotate a string `s` by `offset` elements.
     *
     * @param s String, the input string
     * @param offset int, the right shift steps
     * @return String, the rotated string
     */
    public String rotateRight(String s, int offset) {
        offset = offset % s.length();
        if (offset == 0) {
            return s;
        } else if (offset < 0) {
            return rotateLeft(s, offset);
        } else {
            return rotateLeft(s, s.length() - offset);
        }
    }

    public void reverse(char[] ca, int i, int j) {
        for (; i < j; ++i, --j) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }

    public static void main(String[] args) {
        String s = "love";
        int offset = 5;
        Solution2 solu = new Solution2();
        System.out.println(solu.rotateRight(s, offset));
    }
}