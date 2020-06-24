package exm.algo.array;

import java.util.Arrays;

public class NearestThreeSum {

    public static void main(String[] args) {
        int[] arr = {-1,2,1,-4};
        System.out.println(threeSumClosest(arr, 1));
    }

    /**
     *
     给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     示例：
     输入：nums = [-1,2,1,-4], target = 1
     输出：2
     解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     */
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return -1;
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; ) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum > target) {
                    while (right < left && nums[right] == nums[--right]);
                } else {
                    while (right < left && nums[left] == nums[++left]);
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[++i]);
        }
        return res;
    }
}