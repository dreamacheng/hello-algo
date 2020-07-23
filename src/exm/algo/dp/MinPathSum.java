package exm.algo.dp;

public class MinPathSum {

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(arr));
    }
    /**
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *
     * 示例:
     *
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-path-sum
     * @param grid
     * @return
     */
    // dp => 使用MAX_VALUE 处理边界
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[r+1][c+1];
        for (int i = 0; i <= r; i++) {
            if (i== 1) continue;
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= c; i++) {
            if (i== 1) continue;
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                dp[i][j] = grid[i-1][j-1] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[r][c];
    }

    // 原地数组dp
    public static int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) grid[i][j] += grid[i][j-1];
                else if (j == 0) grid[i][j] += grid[i-1][j];
                else grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[r-1][c-1];
    }


}
