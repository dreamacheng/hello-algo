package exm.algo.array;

import java.util.Arrays;

public class NearestThreeSum {

    public static void main(String[] args) {
        int[] arr = {1,1,-1,-1,3};
        System.out.println(threeSumClosest(arr, -1));
    }

    /**
     *
     给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     示例：
     输入：nums = [-1,2,1,-4], target = 1
     输出：2
     解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

     3 <= nums.length <= 10^3
     -10^3 <= nums[i] <= 10^3
     -10^4 <= target <= 10^4
     */
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return -1;
        Arrays.sort(nums);
        // target最大值，使用Integer.MAX_VALUE当target为负数时会越界，程序出错
        int res = 10000;
        for (int i = 0; i < nums.length - 2; ) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum > target) {
                    while (left < right && nums[right] == nums[--right]);
                } else {
                    while (left < right && nums[left] == nums[++left]);
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[++i]);
        }
        return res;
    }
}