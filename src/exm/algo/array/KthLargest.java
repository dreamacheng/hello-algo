package exm.algo.array;

import java.util.Arrays;
import java.util.Random;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 */
public class KthLargest {

    private static final Random random = new Random();

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
//        int[] arr = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest2(arr, 2));
    }

    // force
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < 1) return -1;
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 快排减治
    public static int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length < 1) return -1;
        int target = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (true) {
            int pivot = partition(nums, left, right);
            if (pivot < target) {
                left = pivot + 1;
            } else if (pivot > target) {
                right = pivot - 1;
            } else {
                return nums[target];
            }
        }
    }

    public static int partition(int[] arr, int left, int right) {
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            int temp = arr[randomIndex];
            arr[randomIndex] = arr[right];
            arr[right] = temp;
        }
        int start = left;
        int end = right;
        int pivot = arr[end];
        while (start < end) {
            while (start < end && arr[start] <= pivot) {
                start++;
            }
            while (start < end && arr[end] >= pivot) {
                end--;
            }
            if (start < end) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
        }
        arr[right] = arr[start];
        arr[start] = pivot;
        return start;
    }

    // 小顶堆

}
