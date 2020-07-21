package exm.algo.tree;

public class NumTrees {

    /**
     *
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     *
     * 示例:
     *
     * 输入: 3
     * 输出: 5
     * 解释:
     * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
     *
     * 1         3     3      2      1
     * \       /     /      / \      \
     * 3     2     1      1   3      2
     * /     /       \                 \
     * 2     1         2                 3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees/
     *
     * 方法一： dp
     *  G(n): 序列为n 能组成的不同二叉搜索数的个数   G(0) = 1, G(1) = 1, G(n) = ΣF(i, n);
     *  F(i, n): 根节点为 i 序列长度为 n 的不同二叉搜索树个数 F(i, n) = G(i-1) * G(n-i);
     *  G(n) = ΣG(i-1)*G(n-i);
     */
    public int numTrees(int n) {
        if (n < 0) return -1;
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

}
