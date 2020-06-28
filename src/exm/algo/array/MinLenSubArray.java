package exm.algo.array;

import java.util.Arrays;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 */
public class MinLenSubArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(minSubArrayLen2(11, arr));
    }

    // 设置滑动窗口
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int len = nums.length;
        int res = Integer.MAX_VALUE;
        int left = 0, right = 0, sum = 0;
        while (right < len) {
            sum += nums[right];
            while (sum >= s) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    // 前缀和 + 二分查找
    public static int minSubArrayLen2(int s, int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int len = nums.length;
        // 前缀和数据
        int[] sums = new int[len + 1];
        int res = Integer.MAX_VALUE;

        for (int i = 1; i <= len; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < len; i++) {
            int target = sums[i] + s;
            // nums数组元素皆为正数，所以sums数组递增，可以二分搜索
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= len) {
                res = Math.min(res, bound - i);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
