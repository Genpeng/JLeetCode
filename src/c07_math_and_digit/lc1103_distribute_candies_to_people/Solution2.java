package c07_math_and_digit.lc1103_distribute_candies_to_people;

import java.util.Arrays;

/**
 * This is the solution of No. 1103 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/distribute-candies-to-people/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * We distribute some number of candies, to a row of n = num_people people in the following way:
 * <p>
 * We then give 1 candy to the first person, 2 candies to the second person, and so on until
 * we give n candies to the last person.
 * <p>
 * Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies
 * to the second person, and so on until we give 2 * n candies to the last person.
 * <p>
 * This process repeats (with us giving one more candy each time, and moving to the start of the row
 * after we reach the end) until we run out of candies.  The last person will receive
 * all of our remaining candies (not necessarily one more than the previous gift).
 * <p>
 * Return an array (of length num_people and sum candies) that represents the final distribution of candies.
 * <p>
 * Example 1:
 * Input: candies = 7, num_people = 4
 * Output: [1,2,3,1]
 * Explanation:
 * On the first turn, ans[0] += 1, and the array is [1,0,0,0].
 * On the second turn, ans[1] += 2, and the array is [1,2,0,0].
 * On the third turn, ans[2] += 3, and the array is [1,2,3,0].
 * On the fourth turn, ans[3] += 1 (because there is only one candy left), and the final array is [1,2,3,1].
 * <p>
 * Example 2:
 * Input: candies = 10, num_people = 3
 * Output: [5,2,3]
 * Explanation:
 * On the first turn, ans[0] += 1, and the array is [1,0,0].
 * On the second turn, ans[1] += 2, and the array is [1,2,0].
 * On the third turn, ans[2] += 3, and the array is [1,2,3].
 * On the fourth turn, ans[0] += 4, and the final array is [5,2,3].
 * <p>
 * Constraints:
 * - 1 <= candies <= 10^9
 * - 1 <= num_people <= 1000
 * ==========================================================================================================
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Math (arithmetic progression)
     * 时间复杂度：O(n_people)
     * 空间复杂度：O(1)
     * 推导参考：
     * https://leetcode-cn.com/problems/distribute-candies-to-people/solution/fen-tang-guo-ii-by-leetcode-solution/
     * <p>
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Distribute Candies to People.
     * Memory Usage: 37 MB, less than 100.00% of Java online submissions for Distribute Candies to People.
     *
     * @param nCandies int, the number of candies
     * @param nPeople int, the number of people
     * @return int[], an array that represents the final distribution of candies
     */
    public int[] distributeCandies(int nCandies, int nPeople) {
        // the number of people received complete candies
        int p = (int) (Math.sqrt(2 * nCandies + 0.25) - 0.5);
        int nRemaining = nCandies - (int) ((p + 1) * p * 0.5);
        int nRow = p / nPeople, nCol = p % nPeople;
        int[] ans = new int[nPeople];
        for (int i = 0; i < nPeople; ++i) {
            ans[i] = (i + 1) * nRow + (int) ((nRow - 1) * nRow * 0.5 * nPeople);
            if (i < nCol) {
                ans[i] += (i + 1 + nRow * nPeople);
            }
        }
        ans[nCol] += nRemaining;
        return ans;
    }

    public static void main(String[] args) {
        int nCandies = 7, nPeople = 4;
        Solution2 solution = new Solution2();
        int[] ans = solution.distributeCandies(nCandies, nPeople);
        System.out.println(Arrays.toString(ans));
    }
}