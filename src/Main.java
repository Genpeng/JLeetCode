import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] a = {2, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(leastCombinationTimes(a));
    }

    public static int knapsack(int W, int[] w, int[] v) {
        final int n = w.length;
        int[][] dp = new int[n+1][W+1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= W; ++j) {
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }

    /**
     * HJ16 购物单
     *
     * @param money
     * @param n
     * @param prices
     * @param values
     * @param info
     * @param f1
     * @param f2
     * @return
     */
    public static int maxValue(int money, int n, int[] prices, int[] values, int[] info, int[] f1, int[] f2) {
        int[][] dp = new int[n+1][money+1];
        for (int i = 1; i <= n; ++i) {
            int p1 = -1, v1 = -1;
            int p2 = -1, v2 = -1;
            int p3 = -1, v3 = -1;
            if (f1[i] != 0) {
                p1 = prices[i] + prices[f1[i]];
                v1 = values[i] + values[f1[i]];
            }
            if (f2[i] != 0) {
                p2 = prices[i] + prices[f2[i]];
                v2 = values[i] + values[f2[i]];
            }
            if (f1[i] != 0 && f2[i] != 0) {
                p3 = p1 + p2 - prices[i];
                v3 = v1 + v2 - values[i];
            }
            for (int j = 1; j <= money; ++j) {
                dp[i][j] = dp[i-1][j];
                if (info[i] == 0) {
                    if (j >= prices[i]) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-prices[i]] + values[i]);
                        if (p1 != -1 && j >= p1) {
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][j-p1] + v1);
                        }
                        if (p2 != -1 && j >= p2) {
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][j-p2] + v2);
                        }
                        if (p3 != -1 && j >= p3) {
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][j-p3] + v3);
                        }
                    }
                }
            }
        }
        return dp[n][money];
    }

    /**
     * HJ54 表达式求值
     * 给定一个字符串描述的算术表达式，计算出结果值。
     * 输入字符串长度不超过 100 ，合法的字符包括 ”+, -, *, /, (, )” ， ”0-9” 。
     *
     * @param string
     * @return
     */
    public static int calc(String string) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = string.toCharArray();
        int num = 0;
        char sign = '+';
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c == '(') {
                int j = i + 1;
                int count = 1;
                while (count > 0) {
                    if (chars[j] == ')') {
                        count--;
                    }
                    if (chars[j] == '(') {
                        count++;
                    }
                    j++;
                }
                num = calc(string.substring(i + 1, j - 1));
                i = j - 1;
            }
            if (!Character.isDigit(c) || i == n - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-1 * num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    /**
     * 2048 最少的合成次数
     * https://blog.csdn.net/weixin_43260719/article/details/112323119
     *
     * @param a
     * @return
     */
    public static int leastCombinationTimes(int[] a) {
        int count = 0;
        while (a[9] < 2) {
            int i = 8;
            while (i >= 0 && a[i] < 2) {
                --i;
            }
            a[i] -= 2;
            ++a[i+1];
            ++count;
        }
        return ++count;
    }
}
