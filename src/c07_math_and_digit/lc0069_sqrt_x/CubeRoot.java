package c07_math_and_digit.lc0069_sqrt_x;

/**
 * 这是华为机试题的题目，编号为：HJ107，题目链接如下：
 * https://www.nowcoder.com/practice/caf35ae421194a1090c22fe223357dca?tpId=37&tqId=21330&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=undefined&tags=&title=
 *
 * 题目描述如下：
 * ==========================================================================================================
 * 计算一个浮点数的立方根，不使用库函数。
 * 保留一位小数。
 *
 * 数据范围：
 * ∣val∣≤20
 *
 * 输入描述：
 * 待求解参数，为double类型（一个实数）
 *
 * 输出描述：
 * 输出参数的立方根。保留一位小数。
 *
 * 示例1
 * 输入：
 * 19.9
 * 输出：
 * 2.7
 *
 * 示例2
 * 输入：
 * 2.7
 * 输出：
 * 1.4
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: math;
 *
 * @author  Lukas (xgp1227atgmail.com)
 */
public class CubeRoot {
    public double cubeRootV1(double x) {
        // 解法1：二分法
        // 时间复杂度：O(log(x))
        // 空间复杂度：O(1)

        // 一种写法
        if (x == 0.0) {
            return x;
        }
        double li, ri;
        if (x < 0) {
            li = x - 1.0;
            ri = 0.0;
        } else {
            li = 0.0;
            ri = x + 1.0; // 这是因为当 0 < x < 1 时，立方根的值有可能大于 x
        }
        while (ri-li > 1e-6) {
            double mi = (li + ri) / 2;
            if (mi*mi*mi <= x) {
                li = mi;
            } else {
                ri = mi;
            }
        }
        return (li + ri) / 2;

        // 另一种写法
//        if (x == 0.0) {
//            return x;
//        }
//        double li, ri;
//        if (x < 0) {
//            li = x - 1.0;
//            ri = 0.0;
//        } else {
//            li = 0.0;
//            ri = x + 1.0; // 这是因为当 0 < x < 1 时，立方根的值有可能大于 x
//        }
//        while (li <= ri) {
//            double mi = (li + ri) / 2;
//            if (mi*mi*mi <= x) {
//                li = mi + 0.01;
//            } else {
//                ri = mi - 0.01;
//            }
//        }
//        return ri;
    }

    public double cubeRootV2(double x) {
        // 解法2：牛顿迭代法
        // 时间复杂度：O(log(x))
        // 空间复杂度：O(1)

        // 立方根：
        // f(x) = x^3 - C
        // f(x0) = f'(x0) * (x - x0) + f(x0)
        //       = 3 * x0^2 * (x - x0) + x0^3 - C
        // 更新公式：
        // 令 f(x0) + f'(x0) * (x-x0) = 0，则有 x <- x0 - f(x0)/f'(x0)
        // x1 <- x0 - (x0^3 - C) / (3 * x0^2) = (2*x0 + C/x0^2) / 3

        // 一种写法
        if (x == 0.0) {
            return x;
        }
        double guess = x;
        while (Math.abs(guess*guess*guess - x) > 1e-6) {
            guess = (2 * guess + x/guess/guess) / 3;
        }
        return guess;

        // 另一种写法
//        if (x == 0.0) {
//            return x;
//        }
//        double x0 = x;
//        while (true) {
//            double x1 = (2 * x0 + x/x0/x0) / 3;
//            if (Math.abs(x1-x0) < 1e-6) {
//                break;
//            }
//            x0 = x1;
//        }
//        return x0;
    }
}
