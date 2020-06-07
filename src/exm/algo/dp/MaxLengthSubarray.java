package exm.algo.dp;

public class MaxLengthSubarray {

    /**
     * DESC: 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
     * 示例 1:
     * 输入:
     * A: [1,2,3,2,1]
     * B: [3,2,1,4,7]
     * 输出: 3
     * 解释:
     * 长度最长的公共子数组是 [3, 2, 1]。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        // 子问题：
        // f(i, j) = s[0..i) 和 t[0..j) 中以 s[i-1] 和 t[j-1] 结尾的最长公共子数组
        // 原问题 = max{ f(i, j) }, 0 <= i <= m, 0 <= j <= n

        // f(0, *) = 0
        // f(*, 0) = 0
        // f(i, j) = max:
        //           f(i-1, j-1) + 1, if s[i-1] == t[j-1]
        //           0              , if s[i-1] != t[j-1]
        if (A == null || B == null || A.length < 1 || B.length < 1) {
            return -1;
        }
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m+1][n+1];

        int res = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (A[i-1] == B[j-1]) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = 0;
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }


    // 反向遍历，条件分支优化
    public int findLength2(int[] A, int[] B) {
        int res = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i+1][j+1] + 1;
                    if (res < memo[i][j]) {
                        res = memo[i][j];
                    }
                }
            }
        }
        return res;
    }


}
