package exm.algo.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumSquares {

    public static void main(String[] args) {
        System.out.println(numSquares_db(12));
    }


    /**
     * desc: 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * 示例 1:
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     *
     * 示例 2:
     * 输入: n = 13
     * 输出: 2
     * 解释: 13 = 4 + 9.
     *
     * 链接：https://leetcode-cn.com/problems/perfect-squares
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        if (n < 0) {
            return -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        int result = 1;
        while (!queue.isEmpty()) {
            int i = queue.size();
            // 遍历当前层节点，将下一层节点依次放入, temp为 0 时返回level
            while (i > 0) { // 重复bfs了部分节点, 效率降低
                int curr = queue.poll();
                int temp = curr;
                int offset = 1;
                while (temp > 0) {
                    temp = curr - offset * offset;
                    if (temp == 0) {
                        return result;
                    }
                    if (temp < 0)  break;
                    queue.offer(temp);
                    offset++;
                }
                i--;
            }
            result++;
        }
        return result;
    }

    // dp
    // 转移方程 dp[n] = min( dp[n], dp[n - offset * offset] + 1 )  dp数组初始时，dp[n] = n，即初始为最坏情况
    public static int numSquares_db(int n) {
        if (n < 0) {
            return -1;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}
