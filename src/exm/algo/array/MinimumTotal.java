package exm.algo.array;

import java.util.ArrayList;
import java.util.List;

public class MinimumTotal {

    /**
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     *
     * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
     *
     *  
     *
     * 例如，给定三角形：
     *
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/triangle
     */
    // 自顶向下，从右至左
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) throw new RuntimeException("fucking illegal input");
        int rest = Integer.MAX_VALUE;
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> curr = triangle.get(i);
            for (int j = curr.size() - 1; j >= 0; j--) {
                if (j == 0) {
                    dp[j] += curr.get(j);
                } else if (j == curr.size() - 1) {
                    dp[j] = curr.get(j) + dp[j-1];
                } else {
                    dp[j] = Math.min(dp[j], dp[j-1]) + curr.get(j);
                }
            }
        }
        for (int i : dp) {
            rest = rest > i ? i : rest;
        }
        return rest;
    }
}
