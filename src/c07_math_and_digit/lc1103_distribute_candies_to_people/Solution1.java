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
public class Solution1 {
    /**
     * Approach 1: Intuition (my first version, deprecated)
     * 时间复杂度：O(max(sqrt(n_candies), n_people))
     * 空间复杂度：O(1)
     *
     * @param nCandies int, the number of candies
     * @param nPeople int, the number of people
     * @return int[], an array that represents the final distribution of candies
     */
    public int[] distributeCandiesV0(int nCandies, int nPeople) {
        int[] ans = new int[nPeople];
        int i = 0, currNum = 1;
        while (nCandies > 0) {
            if (nCandies >= currNum) {
                ans[i] += currNum;
                nCandies -= currNum;
                ++currNum;
                i = (i + 1) % nPeople;
            } else {
                ans[i] += nCandies;
                break;
            }
        }
        return ans;
    }

    /**
     * Approach 1: Intuition
     * 时间复杂度：O(sqrt(num_people))
     * 空间复杂度：O(1)
     * <p>
     * Runtime: 1 ms, faster than 92.81% of Java online submissions for Distribute Candies to People.
     * Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Distribute Candies to People.
     *
     * @param nCandies int, the number of candies
     * @param nPeople int, the number of people
     * @return int[], an array that represents the final distribution of candies
     */
    public int[] distributeCandiesV1(int nCandies, int nPeople) {
        int[] ans = new int[nPeople];
        // the index of times, so `i + 1` represents the number of candies currently being given,
        // and `i % n` is the index of people
        int i = 0;
        while (nCandies > 0) {
            ans[i % nPeople] += Math.min(nCandies, ++i);
            nCandies -= i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int nCandies = 7, nPeople = 4;
        Solution1 solution = new Solution1();
        int[] ans = solution.distributeCandiesV1(nCandies, nPeople);
        System.out.println(Arrays.toString(ans));
    }
}