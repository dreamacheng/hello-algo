package exm.algo.array;

import exm.algo.sort.QuickSort;
import sun.java2d.pipe.AAShapePipe;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        threeSum(arr);
    }


    /**
     * desc: 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * 来源：力扣（LeetCode） 15
     * 链接：https://leetcode-cn.com/problems/3sum
     * @param nums
     * @return
     * 排序 + 双指针
     * 利用升序数组缩减遍历空间
     * i： 当前下标 ， left： i+1下标，right： len -1下标
     * 当 nums[i] > 0 时，由于数组为升序，不再有sum为0的组合，直接break
     * 当 nums[i] + nums[left] + nums[right] > 0，应减小最大值，right--，并去重，while (left < right && nums[right] == nums[--right])
     * 当 nums[i] + nums[left] + nums[right] < 0，应增大最小值，left++,并去重，while (left < right && nums[left] == nums[++left])
     * 当前遍历值去重，while (i < len - 2 && nums[i] == nums[++i])
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0,len = nums.length; i < len - 2; ) {
            if (nums[i] > 0) {
                break;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]}));
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);
                } else if (sum < 0) {
                    while (left < right && nums[left] == nums[++left]);
                } else {
                    while (left < right && nums[right] == nums[--right]);
                }
            }
            while (i < len - 2 && nums[i] == nums[++i]);
        }
        return result;
    }


}
