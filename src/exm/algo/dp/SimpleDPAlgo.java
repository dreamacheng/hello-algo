package exm.algo.dp;


public class SimpleDPAlgo {

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(maxMoney2(arr));
    }

    /**
     * description：LeetCode 198. House Robber
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     * eg:
     *  input: [2, 2, 5, 4]
     *  output: 7
     *
     *  f(n) = Max(f(n-2) + arr[n-1], f(n-1) )
     */
    public static int maxMoney (int[] arr) {
        int length = arr.length;
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length + 1];

        dp[0] = 0;
        dp[1] = arr[0];
        for (int i = 2; i < length + 1; i ++) {
            dp[i] = Math.max(dp[i-2] + arr[i-1], dp[i-1]);
        }

        return dp[length];
    }
    // 空间优化
    public static int maxMoney2 (int[] arr) {
        int prev = 0;
        int curr = 0;

        for (int i : arr) {
            // 循环开始时 prev 表示 dp[i-2], curr 表示 dp[i-1]
            // dp[i] = Math.max(dp[i-2] + arr[i-1], dp[i-1]);
            int temp = Math.max(prev + i, curr);
            prev = curr;
            curr = temp;

            // 循环结束 prev 表示 dp[i-1], curr 表示 dp[i]
        }
        return curr;
    }
}
