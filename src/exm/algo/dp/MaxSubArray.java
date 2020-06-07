package exm.algo.dp;

public class MaxSubArray {

    /**
     * desc: 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * 要求时间复杂度为O(n)。
     * 示例1:
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        // 子问题：
        // f(k) = nums[0..k) 中以 nums[k-1] 结尾的最大子数组和
        // 原问题 = max{ f(k) }, 0 <= k <= N

        // f(0) = 0
        // f(k) = max{ f(k-1), 0 } + nums[k-1]
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int N = nums.length;
        int[] dp = new int[N+1];
        dp[0] = 0;

        int res = Integer.MIN_VALUE;
        for (int k = 1; k <= N; k++) {
            dp[k] = Math.max(dp[k-1], 0) + nums[k-1];
            res = Math.max(res, dp[k]);
        }
        return res;
    }

    // 空间优化
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
